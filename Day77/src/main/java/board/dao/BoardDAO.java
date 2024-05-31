package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO boardDAO = new BoardDAO();
	private String CONNECTION_POOL_RESOURCE_NAME = "jdbc/testdb";
	private final String TABLE_NAME = "mvcboard";
	private DataSource dataSource;	
	
	private BoardDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/" + CONNECTION_POOL_RESOURCE_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDAO getBoardDAO() {
		return boardDAO;
	}
	
	public BoardDTO getBoardDTO(int no) {
		final String sql = "SELECT * FROM " + TABLE_NAME + " WHERE no = " + no;
		BoardDTO dto = new BoardDTO();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			if(rs.next())
			{
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				dto.setHit(rs.getInt("hit"));
				dto.setWtime(rs.getString("wtime"));
				dto.setGroupNum(rs.getInt("groupNum"));
				dto.setStepnum(rs.getInt("stepNum"));
				dto.setIndentnum(rs.getInt("indentNum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		return dto;
	}
	
	public void increaseHit(int no) {
		final String sql = 
				"UPDATE " + TABLE_NAME + " SET HIT=HIT+1 WHERE no=" + no;
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql) ) 
		{
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getCurrentNum(BoardDTO dto) {	
		final String sql = "SELECT MAX(NO) FROM " + TABLE_NAME + " WHERE NAME = '" + dto.getName() + "'";
		int curNum = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) 
		{
			if(rs.next()) curNum = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return curNum;
	}
	
	public void updateGroupNum(int curNum) {	
		final String sql = "UPDATE " + TABLE_NAME + " SET GROUPNUM = ? WHERE NO = ?";
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql))
		{
			ps.setInt(1, curNum);
			ps.setInt(2, curNum);
			result = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void writeOKDAO(BoardDTO dto) {	
		final String sql = 
				"INSERT INTO " + TABLE_NAME + " (NAME, TITLE, CONTENTS) values(?, ?, ?)";
		int curNum = 0;
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql))
		{
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContents());
			result = ps.executeUpdate();
			curNum = getCurrentNum(dto);
			updateGroupNum(curNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifyOK(BoardDTO dto) {
		final String sql = 
				"UPDATE " + TABLE_NAME + " SET NAME=?, TITLE=?, CONTENTS=?, WTIME=NOW() WHERE no=?";
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql))
		{
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContents());
			ps.setInt(4, dto.getNo());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStepNum(BoardDTO dto) {
		final String sql = 
				"UPDATE " + TABLE_NAME + " SET STEPNUM=STEPNUM+1 WHERE GROUPNUM=? AND STEPNUM>=?";
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql))
		{
			ps.setInt(1, dto.getGroupNum());
			ps.setInt(2, dto.getStepnum()+1);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public BoardDTO replyDAO(int no) {
		BoardDTO dto = getBoardDTO(no);
		return dto;
	}
	
	public void replyOKDAO(BoardDTO dto) {
		final String sql = 
				"INSERT INTO " + TABLE_NAME + " (NAME, TITLE, CONTENTS, GROUPNUM, STEPNUM, INDENTNUM) values(?, ?, ?, ?, ?, ?)";
		updateStepNum(dto);
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql))
		{
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContents());
			ps.setInt(4, dto.getGroupNum());
			ps.setInt(5, dto.getStepnum()+1);
			ps.setInt(6, dto.getIndentnum()+1);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void deleteDAO(int no) {
		final String sql =
				"DELETE FROM " + TABLE_NAME + " WHERE no=?";
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql))
		{
			ps.setInt(1, no);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BoardDTO> listDAO(){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		final String sql = "SELECT * FROM " + TABLE_NAME + " order by GROUPNUM DESC, STEPNUM ASC";

		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery())
		{
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				dto.setHit(rs.getInt("hit"));
				dto.setWtime(rs.getString("wtime"));
				dto.setGroupNum(rs.getInt("groupNum"));
				dto.setStepnum(rs.getInt("stepNum"));
				dto.setIndentnum(rs.getInt("indentNum"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public BoardDTO viewDAO(int no) {
		increaseHit(no);
		BoardDTO dto = getBoardDTO(no);
		return dto;
	}

}
