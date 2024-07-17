package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 처리");
		
    	// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
    	// 2. DB 연동 처리
    	BoardVO vo = new BoardVO();
    	BoardDAO boardDAO = new BoardDAO();
    	List<BoardVO> boardList = boardDAO.getBoardList(vo);		
    	
    	// 3. 검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴한다.
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("boardList", boardList);		// Model 정보 저장
    	mav.setViewName("getBoardList.jsp");		// View 정보 저장
    	return mav;							
	}
}