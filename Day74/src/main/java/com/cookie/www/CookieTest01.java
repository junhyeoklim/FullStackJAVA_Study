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


@WebServlet("/CookieTest01")
public class CookieTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CookieTest01() {
		super();

	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();	

		Cookie[] cookies = request.getCookies();
		boolean flag = false;
		String name = "";
		if(cookies != null) {
			flag = true;
			for(int i=0; i< cookies.length;i++) {
				name = cookies[0].getName();				
			}
		}

		out.print("<!doctype html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Cookie Test</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<form action='CookieTest02' method='post'>");
		out.print("<table>");
		out.print("<tr>");		
		out.print("<td><label for='id'>아이디</label></td>");
		out.print("<td><input type='text' id='id' name='id'");
			if(flag)
				out.print("value='"+name+"'");
		out.print("></td>");
		out.print("</tr>");
		out.print("<tr>");		
		out.print("<td><label for='pwd'>비밀번호</label></td>");
		out.print("<td><input type='password' id='pwd' name='pwd'></td>");
		out.print("</tr>");
		out.print("<tr>");		
		out.print("<td><input type='checkbox' name='remember' id='remember' value='true'");
			if(flag)
				out.print("checked");
		out.print("><label for='remember'>아이디 기억하기</label></td>");		
		out.print("</tr>");
		out.print("<tr>");		
		out.print("<td colspan='2'><input type='submit' value='로그인'></td>");		
		out.print("</tr>");
		out.print("</table>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");

	}

}
