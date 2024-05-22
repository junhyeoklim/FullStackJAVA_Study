package com.test.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletTest() {
        super();
        
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();	
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='#' method='post'>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>이름</td>");
		out.println("<td><input type='text' name='name'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>아이디</td>");
		out.println("<td><input type='text' name='id'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>비밀번호</td>");
		out.println("<td><input type='password' name='password'></td>");
		out.println("</tr>");		
		out.println("<tr>");
		out.println("<td>취미</td>");
		out.println("<td>");
		out.println("<input type='checkbox' name='hobby' value='독서'> 독서");
		out.println("<input type='checkbox' name='hobby' value='요리'> 요리");
		out.println("<input type='checkbox' name='hobby' value='조깅'> 조깅");
		out.println("<input type='checkbox' name='hobby' value='수영'> 수영");
		out.println("<input type='checkbox' name='hobby' value='취침'> 취침");		
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("전공");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='radio' name='major' value='국어'> 국어");
		out.println("<input type='radio' name='major' value='영어' checked> 영어");
		out.println("<input type='radio' name='major' value='수학'> 수학");
		out.println("<input type='radio' name='major' value='디자인'> 디자인");
		out.println("</td");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("프로토콜");
		out.println("</td>");
		out.println("<td>");
		out.println("<select name='protocol'>");
		out.println("<option>http</option>");
		out.println("<option selected>ftp</option>");
		out.println("<option>smtp</option>");
		out.println("<option>pop</option>");
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2'>");
		out.println("<input type='submit' value='전송'> ");
		out.println("<input type='reset' value='초기화'> ");
		out.println("</td>");		
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
