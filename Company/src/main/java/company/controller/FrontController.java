package company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.command.Command;
import company.command.InsertCommand;
import company.command.ListCommand;
import company.command.SearchListCommand;


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

	public void doAction(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");


		String commandName = request.getServletPath();
		final String folderName = "/Company_View";
		String viewPage = null;
		Command command = null;	


		if(commandName.equals(folderName+"/list.do")) {
			command = new ListCommand();
			command.excute(request, response);
			viewPage = "CompanyList.jsp";
		
		}
		else if(commandName.equals(folderName+"/search.do")) {
			command = new SearchListCommand();
			command.excute(request, response);
			viewPage = "CompanyList.jsp";
		}
		else if(commandName.equals(folderName+"/register.do")) {
			viewPage = "registerUI.jsp";
		}
		else if(commandName.equals(folderName+"/registerOK.do")) {
			command = new InsertCommand();
			command.excute(request, response);
			viewPage = folderName+"/list.do";
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
