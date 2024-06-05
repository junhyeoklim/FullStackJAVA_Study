package com.superman.ex.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.superman.ex.dao.BoardDAO;
import com.superman.ex.dto.BoardDTO;

public class ViewCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getBoardDAO();
		BoardDTO dto = dao.viewDAO(Integer.parseInt(request.getParameter("num")));
		request.setAttribute("dto", dto);
	}
}