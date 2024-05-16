<%@page import="java.net.URLEncoder"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Input OK</title>
</head>
<body>
	<%!
		String url = "jdbc:mysql://localhost:3306/simpleproject?severTimezone=UTC";
		String driverPath = "com.mysql.cj.jdbc.Driver";
		String user = "root", pwd = "1234";
		int result = 0;
	%>
	
	<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pws = request.getParameter("pwd");
	
	
	
		String sql = "INSERT INTO member(name,id,pw) VALUES(?,?,?)";
		try(Connection conn = DriverManager.getConnection(url,user,pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);){
			
			Class.forName(driverPath);
			System.out.println("드라이버 연결 성공");
			System.out.println("Connection 연결 성공");
			
			if(name != null  && pws != null && id !=null){
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pws);
			
				result = pstmt.executeUpdate();
			}
			if(result > 0)
			{
				System.out.println("데이터 입력 성공!");
				String value = URLEncoder.encode(name, "utf-8");
				response.sendRedirect("welcome.jsp?name="+value);
			}
			else
			{
				System.out.println("데이터를 입력 해주세요");
			}
			
		}catch(ClassNotFoundException e){			
			e.printStackTrace();
		}			
		catch(SQLException e){			
			e.printStackTrace();
		}
		
	
	%>
	
</body>
</html>