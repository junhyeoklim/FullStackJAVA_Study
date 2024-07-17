package com.springbook.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController{

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 목록 검색 처리");
		
    	mav.addObject("boardList", boardDAO.getBoardList(vo));		// Model 정보 저장
    	mav.setViewName("getBoardList.jsp");						// View 정보 저장
    	return mav;							
	}
}


/*
	getBoardList() 메소드는 세 개의 매개변수를 선언했는데, 첫 번째가 사용자 입력값을 받기 위한 BoardVO 클래스이고,
	두 번째가 DB 연동 처리를 위한 BoardDAO 클래스이다. 그리고 마지막으로 검색 결과와 화면 정보를 저장하여 리턴하기 위한
	ModelAndView를 매개변수로 선언하여 컨테이너가 생성하도록 처리했다.

*/