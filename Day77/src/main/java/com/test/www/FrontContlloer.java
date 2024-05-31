package com.test.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.command.Command;
import board.command.DeleteCommand;
import board.command.ListCommand;
import board.command.ModifyOKCommand;
import board.command.ReplyCommand;
import board.command.ReplyOKCommand;
import board.command.ViewCommand;
import board.command.WriteOKCommand;

/**
 * Servlet implementation class BoardDAO
 */
@WebServlet("*.do")
public class FrontContlloer extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public FrontContlloer() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		boolean flag = true;

		String commandName = request.getServletPath();
		final String folderName = "/Day77ReTest";
		String viewPage = null;
		Command command = null;	


		if(commandName.equals(folderName+"/list.do")) {
			command = new ListCommand();
			command.excute(request, response);
			viewPage = "list.jsp";
			flag = false;
		}
		else if(commandName.equals(folderName+"/writeOK.do")) {
			command = new WriteOKCommand();
			command.excute(request, response);
			viewPage = folderName+"/list.do";
		}
		else if(commandName.equals(folderName+"/write.do")) {
			viewPage = "write.jsp";
		}
		else if(commandName.equals(folderName+"/view.do")) {
			command = new ViewCommand();
			command.excute(request, response);
			viewPage = "view.jsp";
			flag = false;
		}
		else if(commandName.equals(folderName+"/modifyOK.do")) {
			command = new ModifyOKCommand();
			command.excute(request, response);
			viewPage = folderName+"/list.do";
		}
		else if(commandName.equals(folderName+"/reply.do")) {
			command = new ReplyCommand();
			command.excute(request, response);
			viewPage = "reply.jsp";
			flag = false;
		}
		else if(commandName.equals(folderName+"/replyOK.do")) {
			command = new ReplyOKCommand();
			command.excute(request, response);
			viewPage = folderName+"/list.do";
		}
		else if(commandName.equals(folderName+"/delete.do")) {
			command = new DeleteCommand();
			command.excute(request, response);
			viewPage = folderName+"/list.do";
		}
		if(flag)
			response.sendRedirect(viewPage);
		else {		
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
}
