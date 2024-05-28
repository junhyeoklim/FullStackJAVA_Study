package com.test.retest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieTest02")
public class CookieTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CookieTest02() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String check = request.getParameter("check");
		Cookie cookie = new Cookie(id,pwd);
		
		PrintWriter out = response.getWriter();
		
		if(check != null && check.equals("true")) {
			cookie.setMaxAge(60*60*24*365);
			response.addCookie(cookie);
		}
		else {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		out.print(id+"님 환영합니다.(1234)<br>");
		out.print("<a href='CookieTest01'>CookieTest01 페이지</a>");
	}

}
