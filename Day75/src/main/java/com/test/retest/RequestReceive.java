package com.test.retest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RequestReceive")
public class RequestReceive extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RequestReceive() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String data1 = (String)request.getAttribute("data1");
		//request scope에 data1이라는 이름으로 저장된 문자열 데이터 추출
		Vector<String> data2 = (Vector<String>) request.getAttribute("data2");
		//request scope에 data2라는 이름으로 저장된 Vector 데이터 추출
		String data3 = request.getParameter("data3");
		//Query String으로 넘어온 data3이라는 이름의 문자열
		String data4 = request.getParameter("data4");
		//Query String으로 넘어온 data4라는 이름의 문자열
		
		response.setContentType("text/html;charset=utf-8");
		//출력 객체에 대한 Encoding 처리
		response.setCharacterEncoding("utf-8");		
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		
		out.println("data1 = " + data1 + "<br/>");
		
		out.println("data2 = ");
		for(int i = 0; i < data2.size(); ++i) {
			out.println(data2.get(i) + "&nbsp;&nbsp;");
		}
		//Vector 속에 들어 있는 모든 데이터 출력...
		//Generic으로 인해 String 형변환 필요 없이 출력 가능...
		
		out.println("<br/>");
		out.println("data3 = " + data3 + "<br/>");
		out.println("data4 = " + data4 + "<br/>");
		
		out.println("</body>");
		out.println("</html>");
	}

}
