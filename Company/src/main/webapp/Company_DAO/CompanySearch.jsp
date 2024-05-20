<%@page import="java.net.URLEncoder"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
	<%! 
		Connection con = JDBCConnector.getCon();
		String name = "";
	%>

	<% 
		String select = request.getParameter("select");
		String text = request.getParameter("text");
		String where  = request.getParameter("where");
		
		String sql = "";
		boolean flag = false;
		
		switch(Integer.parseInt(select))
		{
			case 1:				
				sql = "SELECT * FROM salary_man WHERE s_name='"+text+"'";
				break;
			case 2:
				sql = "SELECT * FROM salary_man WHERE s_rank='"+text+"'";
				break;
			case 3:
				sql = "SELECT * FROM salary_man WHERE s_department='"+text+"'";
				break;
		}
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();)
		{
			while(rs.next()){
				flag = true;
				break;
			}
			
			if(flag && Integer.parseInt(where) == 1){
				String value = URLEncoder.encode(text, "utf-8");
				response.sendRedirect("../Company_View/CompanyList.jsp?select="+select+"&text="+value);
			}
			else if(Integer.parseInt(where) == 0)
				response.sendRedirect("../Company_View/alert.jsp?flag="+flag);
			else{
				text = "";
				response.sendRedirect("../Company_View/CompanyList.jsp?text="+text);
			} 
			
			

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
	%>
</body>
</html>