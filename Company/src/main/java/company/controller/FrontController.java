package company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.command.Command;
import company.command.InsertCommand;
import company.command.ListCommand;
import company.command.LoginCommand;
import company.command.SearchListCommand;
import company.command.UpdateCommand;
import company.dao.CompanyDAO;
import company.dto.CompanyDTO;
import company.util.DataProcessor;


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
		response.setContentType("text/html;charset=UTF-8");

		String commandName = request.getServletPath();
		final String folderName = "/Admin_View";
		String viewPage = null;
		Command command = null;	

		
		PrintWriter out = response.getWriter();

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
			viewPage = "RegisterUI.jsp";
		}
		else if(commandName.equals(folderName+"/registerOK.do")) {
			command = new InsertCommand();
			command.excute(request, response);
			response.sendRedirect(request.getContextPath()+folderName + "/list.do");
			return;
		}
		else if(commandName.equals("/login.do")) {
			viewPage = "LoginUI.jsp";
		}
		else if(commandName.equals("/loginOK.do")) {
			command = new LoginCommand();
			command.excute(request, response);
			response.sendRedirect(request.getContextPath()+"/AlertView" + "/alert.jsp");
			return;
		}
		else if(commandName.equals(folderName+"/modify.do")) {
			 command = new SearchListCommand(); 
			 command.excute(request, response);
		     viewPage = "ModifyUI.jsp";
		}
		else if(commandName.equals(folderName+"/modifyOK.do")) {
			command = new UpdateCommand();
			command.excute(request, response);
			response.sendRedirect(request.getContextPath()+folderName + "/list.do");
			return;
		}
        else if(commandName.equals(folderName+"/chart.do")) {
            CompanyDAO dao = CompanyDAO.getCompanyDAO();
            ArrayList<CompanyDTO> list = dao.listDAO();
            Map<String, Object> dataMap = DataProcessor.processData(list);
            request.setAttribute("dataMap", dataMap);
            viewPage = "chartEX.jsp";
        }
		
		if(viewPage != null) { 
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); 
			dispatcher.forward(request,response); 
		}
		

	}

}
