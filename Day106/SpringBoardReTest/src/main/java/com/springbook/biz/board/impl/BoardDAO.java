package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

public class BoardDAO {



	public void insertBoard(BoardVO vo) {
		String sql = "INSERT INTO board(title,writer,content) VALUES(?,?,?)";


		try(Connection conn = JDBCUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateBoard(BoardVO vo) {
		String sql = "UPDATE board SET title=?, content=? WHERE seq = ?";

		try(Connection conn = JDBCUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);)		
		{
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getSeq());
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBoard(BoardVO vo) {
		String sql = "DELETE FROM board WHERE seq = ?";
				
		
		try(Connection conn = JDBCUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BoardVO getBoard(BoardVO vo) {
		BoardVO board = null;
		String sql = "SELECT * FROM board WHERE seq = ?";


		try(Connection conn = JDBCUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setInt(1, vo.getSeq());

			try(ResultSet rs = pstmt.executeQuery();){

				if(rs.next()) {
					board = new BoardVO();
					board.setSeq(rs.getInt("seq"));
					board.setTitle(rs.getString("title"));
					board.setWriter(rs.getString("writer"));
					board.setContent(rs.getString("content"));
					board.setRegDate(rs.getDate("regdate"));
					board.setCnt(rs.getInt("cnt"));
				}

			}
			catch (Exception e) {
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}
	
	
	public List<BoardVO> getBoardList(BoardVO vo){
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		String sql = "SELECT * FROM board ORDER by seq desc";
		
		try(Connection conn = JDBCUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();)
		{
		
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				boardList.add(board);
			}
		}
		catch (Exception e) {
		}
		return boardList;	
	}
}
