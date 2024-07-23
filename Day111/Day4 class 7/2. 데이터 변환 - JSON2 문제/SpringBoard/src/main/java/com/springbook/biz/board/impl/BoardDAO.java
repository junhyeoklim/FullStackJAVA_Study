package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

// DAO(Data Access Object)
@Repository("boardDAO")
public class BoardDAO {
	
	// CRUD 기능의 메소드 구현
	// 글 등록	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		final String SQL = "INSERT INTO board (title, writer, content) values(?, ?, ?)";
		try(Connection conn = JDBCUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL))
		{
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		final String SQL = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
		try(Connection conn = JDBCUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL))
		{
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getSeq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		final String SQL = "DELETE FROM BOARD WHERE SEQ=?";
		try(Connection conn = JDBCUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL))
		{
			pstmt.setInt(1,  vo.getSeq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		BoardVO board = null;
		final String SQL = "SELECT * FROM BOARD WHERE SEQ=" + vo.getSeq();
		
		try(Connection conn = JDBCUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				ResultSet rs = pstmt.executeQuery())
		{
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}
	
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		String searchKeyword = vo.getSearchKeyword();
		
		String sqlT = "SELECT * FROM BOARD WHERE TITLE LIKE '%" + searchKeyword +"%' ORDER BY SEQ DESC";
		String sqlC = "SELECT * FROM BOARD WHERE CONTENT LIKE '%" + searchKeyword + "%' ORDER BY SEQ DESC";
		String sql = null;
		if(vo.getSearchCondition().equals("TITLE")) sql = sqlT;
		else if(vo.getSearchCondition().equals("CONTENT")) sql = sqlC;		
		System.out.println("sql" + sql);
		
		try(Connection conn = JDBCUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery())
		{
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
	}
}