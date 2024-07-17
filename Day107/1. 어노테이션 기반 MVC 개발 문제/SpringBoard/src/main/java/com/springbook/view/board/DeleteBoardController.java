package com.springbook.view.board;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController {

	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
    	
    	boardDAO.deleteBoard(vo);
    	
		return "getBoardList.do";
	}

}

