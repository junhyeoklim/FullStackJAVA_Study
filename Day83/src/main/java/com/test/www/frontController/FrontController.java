package com.test.www.frontController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.www.command.Command;
import com.test.www.command.IDCheckCommand;
import com.test.www.command.MsgCommand;
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String commandName = request.getServletPath();
		Command command = null;
		PrintWriter out = null;
		System.out.println("name "+commandName);
		
		if(commandName.equals("/msg.do")) {
			command = new MsgCommand();
			command.excute(request, response);
			out = response.getWriter();
			System.out.println("출력 "+request.getAttribute("result"));
			out.print(request.getAttribute("result")+"");
		}
		else if(commandName.equals("/idCheck.do")) {
			command = new IDCheckCommand();
			command.excute(request, response);
			out = response.getWriter();
			System.out.println("result"+request.getAttribute("result"));
			out.write(request.getAttribute("result")+"");
		}
	}
}
