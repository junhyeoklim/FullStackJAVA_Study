package com.test.retest;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestSend
 */
@WebServlet("/RequestSend")
public class RequestSend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestSend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String data1 = new String("java!");
		//문자열 데이터를 작성한다.
		Vector<String> data2 = new Vector<String>();
		//Vector 객체를 생성하고
		data2.add("c");		
		data2.add("c++");
		//두개의 문자열을 추가한다.
		
		request.setAttribute("data1", data1);
		//request scope에 data1 이라는 이름으로 문자열 데이터를 저장한다.
		request.setAttribute("data2", data2);
		//request scope에 data2 라는 이름으로 Vector 데이터를 저장한다.
		
		ServletContext context = this.getServletContext();
		//ServletContext 객체를 생성한 후
		RequestDispatcher dispatcher = context.getRequestDispatcher("/RequestReceive?data3=string&data4=ok");
		//forward를 위한 RequestDispatcher 객체를 생성한다. 
		//객체 생성시 주소줄에 Query String으로 data3=string&data4=ok 라는 문자열을 넣어 준다.(문자열만 가능하다.)
		dispatcher.forward(request, response);
		//Servlet01_02 라는 주소로 forward 이동한다.
		//forward 이동은 sendRedirect와는 다르게 저장된 모든 값을 가지고 이동한다.
	}

}
