package com.test.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import user.dao.JDBCConnector;

/**
 * Servlet implementation class LoginOK
 */
@WebServlet("/LoginOK")
public class LoginOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginOK() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String check = request.getParameter("flag");
		String sql = "SELECT id,pwd FROM user WHERE pwd='"+pwd+"' AND id='"+id+"'";
		boolean flag = false;
		
		Connection con = JDBCConnector.getCon();
		
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while(rs.next()) {
				flag = true;
			}
				
			if(flag)
			{
				session.setAttribute("id", request.getParameter("id"));
				response.sendRedirect("SignTest/main.jsp");
			}
			else {
				session.setAttribute("check", request.getParameter("flag"));
				response.sendRedirect("SignTest/main.jsp");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
