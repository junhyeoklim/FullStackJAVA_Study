package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;


@Controller
public class GetBoardListController{

	@RequestMapping(value = "/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo,BoardDAO boardDAO,ModelAndView mav) {
		System.out.println("글 목록 검색 처리");
    	
    	// 3. 검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴한다.
    	mav.addObject("boardList", boardDAO.getBoardList(vo));		// Model 정보 저장
    	mav.setViewName("getBoardList.jsp");		// View 정보 저장
    	return mav;							
	}
}