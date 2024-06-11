package com.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.command.Command;
import com.member.command.LoginCommand;
import com.member.command.ModifyCommand;
import com.member.command.RegisterCommand;

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
		String viewPage = null;
		Command command = null;

		

		PrintWriter out = response.getWriter();

		if(commandName.equals("/login.do")) {
			viewPage = "Login.jsp";
		}
		else if(commandName.equals("/loginOK.do")) {
			command = new LoginCommand();
			command.excute(request, response);
			viewPage = "alert.jsp";
		}
		else if(commandName.equals("/logout.do")) {
			request.getSession().invalidate();
			viewPage = "Login.jsp";
		}
		else if(commandName.equals("/register.do")){
			viewPage = "Register.jsp";
		}
		else if(commandName.equals("/registerOK.do")) {
			command = new RegisterCommand(); 
			command.excute(request, response);
			response.sendRedirect(request.getContextPath()+"/alert.jsp?check=ok");
			return;

		}
		else if(commandName.equals("/modify.do")) {
			viewPage = "Modify.jsp";
		}
		else if(commandName.equals("/modifyOK.do")) {
			command = new ModifyCommand();
			command.excute(request, response);
			response.sendRedirect(request.getContextPath()+"/alert.jsp?modify=ok");
			return;
		}




		if(viewPage != null) { RequestDispatcher dispatcher =
				request.getRequestDispatcher(viewPage); dispatcher.forward(request,
						response); }

	}

}
