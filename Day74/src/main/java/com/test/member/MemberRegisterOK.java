package com.test.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import memeber.dao.JDBCConnector;

/**
 * Servlet implementation class MemberRegisterOK
 */
@WebServlet("/MemberRegisterOK")
public class MemberRegisterOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRegisterOK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");		
		
		Connection con = JDBCConnector.getCon();
		
		int result = 0;
		
		String user = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String mail = request.getParameter("mail");
		String[] hobby = request.getParameterValues("hobby");
		String firstPhone = request.getParameter("first");
		String secondPhone = request.getParameter("second");
		
		String userSql = "INSERT INTO user VALUES(?,?,?,?,?,?,?)";
		String hobbySql = "INSERT INTO hobby(id,hob) VALUES(?,?)";
		
		try(PreparedStatement uinsert = con.prepareStatement(userSql);
				PreparedStatement hinsert = con.prepareStatement(hobbySql);) {
			
			uinsert.setString(1, id);
			uinsert.setString(2, user);
			uinsert.setString(3, pwd);
			uinsert.setString(4, sex);
			uinsert.setString(5, mail);
			uinsert.setString(6, secondPhone);
			uinsert.setString(7, firstPhone);
			
			
			result = uinsert.executeUpdate();
			
			if(result > 0) {
				for(int i =0; i< hobby.length;i++) {
				
					hinsert.setString(1,id);
					hinsert.setString(2, hobby[i]);
					hinsert.executeUpdate();					
				}
			
				response.sendRedirect("main.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
