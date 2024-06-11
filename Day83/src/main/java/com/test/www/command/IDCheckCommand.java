package com.test.www.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.www.dao.DAO;

public class IDCheckCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = DAO.getBoardDAO();
		int result = dao.checkId(request.getParameter("id"));
		request.setAttribute("result", result);
	}

}
