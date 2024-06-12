package com.test.ajax.frontController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ajax.command.Command;
import com.test.ajax.command.UserRegisterCommand;
import com.test.ajax.command.UserSearchCommand;

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
		
		String commandName = request.getServletPath();
		String folderName = "/AJAXTest";
		Command command = null;
		PrintWriter out = null;
		
		if(commandName.equals(folderName+"/userSearch.do")) {
			command = new UserSearchCommand();
			command.excute(request, response);
			out = response.getWriter();
			out.write(request.getAttribute("result")+"");
		}
		else if(commandName.equals(folderName+"/userRegister.do")) {
			command = new UserRegisterCommand();
			command.excute(request, response);
			out = response.getWriter();
			out.write(request.getAttribute("result")+"");
		}
	}
}
