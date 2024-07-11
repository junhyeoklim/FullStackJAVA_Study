package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		final String SQL = "SELECT * FROM BOARD ORDER BY SEQ DESC";
		
		try(Connection conn = JDBCUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL);
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

/*
DAO 클래스 이름은 BOARD 테이블 이름 뒤에 DAO만 추가하여 사용한다. 그리고 이 클래스 객체를 스프링 컨테이너가 생성할 수
있도록 클래스 선언부에 @Repository 어노테이션을 설정했다. 물론 @Component를 사용한다고 해서 문제가 발생하지는 않는다.
DAO 기능의 클래스에는 @Component보다 @Repository를 사용하는 것이 여러 이유에서 적합하다.

그리고 CRUD 기능의 메소드 이름 역시 일관성을 유지하는 차원에서 대부분 다음과 같은 규칙을 적용한다.

기능			메소드 이름
등록			insert테이블명
수정			update테이블명
삭제			delete테이블명
상세 조회		get테이블명(혹은 select테이블명)
목록 검색		get테이블명List(혹은 select테이블명List)
*/