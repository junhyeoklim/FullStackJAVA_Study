package com.test.member;

import java.io.IOException;
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

import memeber.dao.JDBCConnector;

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
		
		Connection con = JDBCConnector.getCon();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String searchSql = "SELECT * FROM user WHERE id='"+id+"' AND pwd='"+pwd+"'";
		boolean flag = false;
		
		try(PreparedStatement pstmt = con.prepareStatement(searchSql);
			ResultSet rs = pstmt.executeQuery();) {
		
			while(rs.next()) {
				flag = true;
			}
			
			if(flag)
			{
				session.setAttribute("id", request.getParameter("id"));
				response.sendRedirect("main.jsp");
			}
			else				
				response.sendRedirect("main.jsp?flag="+false);
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
