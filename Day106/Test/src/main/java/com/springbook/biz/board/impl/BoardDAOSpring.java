package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

// DAO(Data Access Object)
@Repository
public class BoardDAOSpring{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
		final String SQL = "INSERT INTO BOARD(TITLE, WRITER, CONTENT) VALUES(?,?,?)";
		jdbcTemplate.update(SQL, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
		final String SQL = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
		jdbcTemplate.update(SQL, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
		final String SQL = "DELETE FROM BOARD WHERE SEQ=?";
		jdbcTemplate.update(SQL, vo.getSeq());
	}
	
	// 글 상세 조회
//	public BoardVO getBoard(BoardVO vo) {
//		System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
//		final String SQL = "SELECT * FROM BOARD WHERE SEQ=?";
//		return getJdbcTemplate().queryForObject(SQL, new BoardRowMapper(), vo.getSeq());
//	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
		Object[] args = {vo.getSeq()};
		final String SQL = "SELECT * FROM BOARD WHERE SEQ=?";
		return jdbcTemplate.queryForObject(SQL, args, new BoardRowMapper());
	}
	
	// 글 목록 조회
//	public List<BoardVO> getBoardList(BoardVO vo){
//		System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");
//		String searchKeyword = vo.getSearchKeyword();
//		
//		String sqlT = "SELECT * FROM BOARD WHERE TITLE LIKE '%" + searchKeyword +"%' ORDER BY SEQ DESC";
//		String sqlC = "SELECT * FROM BOARD WHERE CONTENT LIKE '%" + searchKeyword + "%' ORDER BY SEQ DESC";
//
//		String sql = null;
//		if(vo.getSearchCondition().equals("TITLE")) sql = sqlT;
//		else if(vo.getSearchCondition().equals("CONTENT")) sql = sqlC;		
//		System.out.println("sql" + sql);		
//		
//		return jdbcTemplate.query(sql, new BoardRowMapper());
//	}
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");
		
		String sqlT = "SELECT * FROM BOARD WHERE TITLE LIKE CONCAT('%', ?, '%') ORDER BY SEQ DESC";
		String sqlC = "SELECT * FROM BOARD WHERE CONTENT LIKE CONCAT('%', ?, '%') ORDER BY SEQ DESC";

		Object[] args = {vo.getSearchKeyword()};
		if(vo.getSearchCondition().equals("TITLE"))
			return jdbcTemplate.query(sqlT, args, new BoardRowMapper());
		else if(vo.getSearchCondition().equals("CONTENT")) {
			return jdbcTemplate.query(sqlC, args, new BoardRowMapper());
		}
		
		return jdbcTemplate.query(sqlT, new BoardRowMapper());
	}
}