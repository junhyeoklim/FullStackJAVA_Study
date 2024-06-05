package com.test.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/ErrorServlet")*/
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ErrorServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request, response);
	}

	public void actionDO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		PrintWriter out = response.getWriter();
		
		try {
			int value1 = Integer.parseInt(num1);
			int value2 = Integer.parseInt(num2);
			
			out.print(value1/value2);
			
		} catch (NumberFormatException e) {
			response.sendError(510,"정수형이 아닙니다!");			
		}
		catch(ArithmeticException e) {
			response.sendError(515, "0으로 나눌수 없습니다!");
			
		}
	}
}
