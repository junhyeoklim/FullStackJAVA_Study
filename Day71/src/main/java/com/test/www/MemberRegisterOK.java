package com.test.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.JDBCConnector;


@WebServlet("/MemberRegisterOK")
public class MemberRegisterOK extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberRegisterOK() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");

		int result1 = 0;
		int result2 = 0;

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String mail = request.getParameter("mail");
		String test = request.getParameter("pwdCheck");
		String[] hobby = request.getParameterValues("hobby");
		String phone = request.getParameter("first").concat(request.getParameter("second"));

		String userSql = "INSERT INTO user(id,name,pwd,sex,mail,phone) VALUES(?,?,?,?,?,?)";
		String hobbySql = "INSERT INTO hobby(id,hob) VALUES(?,?)";

		System.out.println(test);

		Connection con = JDBCConnector.getCon();

		try(PreparedStatement user = con.prepareStatement(userSql);
				PreparedStatement hob = con.prepareStatement(hobbySql);) {
			
			user.setString(1, id);
			user.setString(2, name);
			user.setString(3, pwd);
			user.setString(4, sex);
			user.setString(5, mail);
			user.setString(6, phone);
			/* result1 = user.executeUpdate(); */

			if(result1 > 0) {
				for(int i=0; i< hobby.length; i++) {
					hob.setString(1, id);
					hob.setString(2, hobby[i]);
					/* result2 = hob.executeUpdate(); */
					
				}


				
			}
			/*if(result1 > 0 && result2 > 0)
				response.sendRedirect("SignTest/main.jsp");*/

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
