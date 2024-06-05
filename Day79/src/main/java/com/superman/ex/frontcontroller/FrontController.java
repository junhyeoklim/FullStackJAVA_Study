package com.superman.ex.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.superman.ex.command.Command;
import com.superman.ex.command.DeleteCommand;
import com.superman.ex.command.ListCommand;
import com.superman.ex.command.ModifyOKCommand;
import com.superman.ex.command.ReplyCommand;
import com.superman.ex.command.ReplyOKCommand;
import com.superman.ex.command.ViewCommand;
import com.superman.ex.command.WriteOKCommand;

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
		request.setCharacterEncoding("utf-8");
		String commandName = request.getServletPath();
		String viewPage = null;
		Command command = null;
		boolean flag = true;
		
		if(commandName.equals("/list.do")) {
			command = new ListCommand();
			command.excute(request, response);
			viewPage = "list.jsp";
			flag = false;
		} else if(commandName.equals("/write.do")) {
			viewPage = "write.jsp";
		} else if(commandName.equals("/writeOK.do")) {
			command = new WriteOKCommand();
			command.excute(request, response);
			viewPage = "list.do";
		} else if(commandName.equals("/view.do")) {
			command = new ViewCommand();
			command.excute(request, response);
			viewPage = "view.jsp";
			flag = false;
		} else if(commandName.equals("/modifyOK.do")) {
			command = new ModifyOKCommand();
			command.excute(request, response);
			viewPage = "list.do";
		} else if(commandName.equals("/reply.do")) {
			command = new ReplyCommand();
			command.excute(request, response);
			viewPage = "reply.jsp";
			flag = false;
		} else if(commandName.equals("/replyOK.do")) {
			command = new ReplyOKCommand();
			command.excute(request, response);
			viewPage = "list.do";
		} else if(commandName.equals("/delete.do")) {
			command = new DeleteCommand();
			command.excute(request, response);
			viewPage = "list.do";
		}
		if(flag) {
			response.sendRedirect(viewPage);
		} else{
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);			
		}
	}
}