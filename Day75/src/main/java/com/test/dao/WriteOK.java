package com.test.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WriteOK")
public class WriteOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteOK() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDTO dto = new BoardDTO();
		BoardDAO dao = new BoardDAO();
		int result = 0;
		dto.setTitle(request.getParameter("title"));
		dto.setUser(request.getParameter("user"));
		dto.setPwd(request.getParameter("pwd"));
		dto.setMail(request.getParameter("mail"));
		dto.setContent(request.getParameter("content"));
		result = dao.insertBoardDAO(dto);
		if(result > 0) response.sendRedirect("list.jsp");
	}

}
