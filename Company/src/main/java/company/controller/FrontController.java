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
import javax.servlet.http.HttpSession;

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

		HttpSession session = request.getSession();
		String commandName = request.getServletPath();
		final String afolderName = "/Admin_View";
		final String ufolderName = "/User_View";
		String viewPage = null;
		Command command = null;	

		
		PrintWriter out = response.getWriter();

		if(commandName.equals(afolderName+"/list.do") || commandName.equals(ufolderName+"/list.do")) {
			command = new ListCommand();
			command.excute(request, response);
			
			if(commandName.equals(afolderName+"/list.do"))
				viewPage = "CompanyList.jsp";
			else
				viewPage = "../Admin_View/CompanyList.jsp";
		}
		else if(commandName.equals(afolderName+"/search.do")) {
			command = new SearchListCommand();
			command.excute(request, response);
			viewPage = "CompanyList.jsp";
		}
		else if(commandName.equals(afolderName+"/register.do")) {
			viewPage = "RegisterUI.jsp";
		}
		else if(commandName.equals(afolderName+"/registerOK.do")) {
			command = new InsertCommand();
			command.excute(request, response);
			response.sendRedirect(request.getContextPath()+afolderName + "/list.do");
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
		else if(commandName.equals(afolderName+"/modify.do")) {
			 command = new SearchListCommand(); 
			 command.excute(request, response);
		     viewPage = "ModifyUI.jsp";
		}
		else if(commandName.equals(afolderName+"/modifyOK.do")) {
			command = new UpdateCommand();
			command.excute(request, response);
			response.sendRedirect(request.getContextPath()+afolderName + "/list.do");
			return;
		}
        else if(commandName.equals(ufolderName+"/chart.do")) {
            CompanyDAO dao = CompanyDAO.getCompanyDAO();
            ArrayList<CompanyDTO> list = dao.listDAO();
            Map<String, Object> dataMap = DataProcessor.processData(list);
            request.setAttribute("dataMap", dataMap);
            viewPage = "../Admin_View/chartEX.jsp";
        }
        else if(commandName.equals(ufolderName+"/newboard.do")) {
        	viewPage = "BoardCreateView.jsp";
        }
        else if(commandName.equals(ufolderName+"/logout.do") || commandName.equals(afolderName+"/logout.do") ) {
        	session.invalidate();
			response.sendRedirect(request.getContextPath()+"/LoginUI.jsp");
			return;
        }
		
		
		if(viewPage != null) { 
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); 
			dispatcher.forward(request,response); 
		}
		

	}

}
