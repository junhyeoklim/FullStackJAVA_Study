package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController{

	@RequestMapping(value="/insertBoard.do")
	public void insertBoard(BoardVO vo) {
		System.out.println("글 등록 처리");
		
//		// 1. 사용자 입력 정보 추출
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
//		
//		// 2. DB 연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
	}
}