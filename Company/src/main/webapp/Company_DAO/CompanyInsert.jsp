<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="company.dao.JDBCConnector"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<%! Connection con = JDBCConnector.getCon();
		String sql = "";
		int result = 0;
	%>
	
	<%
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String rank = request.getParameter("rank");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		
		sql = "INSERT INTO salary_man(s_name,s_department,s_rank,s_mail,s_phoneNumber) VALUES(?,?,?,?,?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setString(1, name);
			pstmt.setString(2, department);
			pstmt.setString(3, rank);
			pstmt.setString(4, mail);
			pstmt.setString(5, phone);
			
			result = pstmt.executeUpdate();
			
			if(result > 0)
				response.sendRedirect("../Company_View/CompanyList.jsp");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	%>
</body>
</html>