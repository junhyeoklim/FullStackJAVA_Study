package com.springbook.view.board;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class UpdateBoardController{

	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(BoardVO vo ,BoardDAO boardDAO) {

		boardDAO.updateBoard(vo);

		return "getBoardList.do";
	}

}

