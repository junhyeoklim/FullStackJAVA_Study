package com.test.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test3Servlet() {
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
		
		String start = getInitParameter("start");
		String end = getInitParameter("end");
		
		int startNum = Integer.parseInt(start);
		int endNum = Integer.parseInt(end);
		int sum = 0;
		
		for(int i = startNum; i<=endNum; i++) {
			sum += i;
		}
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("합은 : " + sum);		
		out.println("</body>");
		out.println("</html>");
	}

}
