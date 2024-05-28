package com.superman.www.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.superman.www.dao.BoardDAO;
import com.superman.www.dto.BoardDTO;

public class ListCommand implements Command {
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BoardDAO dao = BoardDAO.getBoardDAO();
		ArrayList<BoardDTO> list = dao.listDAO();
		request.setAttribute("list", list);
	}
}
