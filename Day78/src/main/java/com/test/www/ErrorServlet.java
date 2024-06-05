package com.test.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ErrorServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	public void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");

		PrintWriter out = response.getWriter();

		try {
			int value1 = Integer.parseInt(num1);
			int value2 = Integer.parseInt(num2);

			out.print(value1 / value2);

		} catch (NumberFormatException e) {
			response.sendError(510, "정수를 입력하지 않은 오류!");
			return;
		}
	}

}
