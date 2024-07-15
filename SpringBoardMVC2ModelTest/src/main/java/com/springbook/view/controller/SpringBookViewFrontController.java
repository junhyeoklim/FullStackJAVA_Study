package com.springbook.view.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.command.BoardListCommand;
import com.springbook.biz.command.Command;
import com.springbook.biz.command.DeleteBoardCommand;
import com.springbook.biz.command.GetBoardCommand;
import com.springbook.biz.command.InsertBoardCommand;
import com.springbook.biz.command.LoginCommand;
import com.springbook.biz.command.UpdateBoardCommand;

public class SpringBookViewFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SpringBookViewFrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		
		String commandName = request.getServletPath();
		Command command = null;
		String viewPage = null;
		
		if(commandName.equals("/BoardList.do")) {
			command = new BoardListCommand();
			command.excute(request, response);
			viewPage = "getBoardList.jsp";
		}
		else if(commandName.equals("/getBoard.do"))
		{
			command = new GetBoardCommand();
			command.excute(request, response);
			viewPage = "getBoard.jsp";	
		}
		else if(commandName.equals("/login.do")) {
			command = new LoginCommand();
			command.excute(request, response);
            response.sendRedirect(request.getContextPath() + "/BoardList.do");
            return;
		}
		else if(commandName.equals("/insertBoard")) {
			viewPage = "insertBoard.jsp";
		}
		else if(commandName.equals("/insertBoardOK.do")) {
			command = new InsertBoardCommand();
			command.excute(request, response);
            response.sendRedirect(request.getContextPath() + "/BoardList.do");
            return;
		}
		else if(commandName.equals("/updateBoardOK.do")) {
			command = new UpdateBoardCommand();
			command.excute(request, response);
            response.sendRedirect(request.getContextPath() + "/BoardList.do");
            return;
		}
		else if(commandName.equals("/deleteBoardOK.do")) {
			command = new DeleteBoardCommand();
			command.excute(request, response);
            response.sendRedirect(request.getContextPath() + "/BoardList.do");
            return;
		}
		else if(commandName.equals("/logout.do")) {
			session.invalidate();
			viewPage = "login.jsp";
		}
		
        if (viewPage != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
            dispatcher.forward(request, response);
        }
	}
	
}
