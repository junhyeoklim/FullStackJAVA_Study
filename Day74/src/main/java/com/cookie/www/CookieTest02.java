package com.cookie.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTest02
 */
@WebServlet("/CookieTest02")
public class CookieTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTest02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String check = request.getParameter("remember");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		URLEncoder.encode(id,"UTF-8");
		
		Cookie cookie = new Cookie(id,pwd);
		if(check != null && check.equals("true")) {			
			cookie.setMaxAge(60 * 60 * 24 * 365);
			response.addCookie(cookie);
		}
		else {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
			
		
		PrintWriter out = response.getWriter();
		out.print(check+"<br>");
		out.print(request.getParameter("id")+"님 환영합니다.(1234)<br>");
		out.print("<a href='CookieTest01'>CookieTest01 페이지</a>");
		
	}

}
