package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	// 글 등록
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 처리");
		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");
		
    	boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 상세 조회 처리");

		model.addAttribute("board", boardDAO.getBoard(vo));		// Model 정보 저장
		return "getBoard.jsp";		// View 이름 리턴
	}	
	
	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 목록 검색 처리");
		
		model.addAttribute("boardList", boardDAO.getBoardList(vo));		// Model 정보 저장
    	return "getBoardList.jsp";							
	}	

}