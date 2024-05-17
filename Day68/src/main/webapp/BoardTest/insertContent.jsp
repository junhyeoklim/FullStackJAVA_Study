<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="boardController.JDBCConnector"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>InsertContent</title>
</head>
<body>
	<%!
		Connection con = JDBCConnector.getCon();
		int result = 0;
		String sql = "INSERT INTO board(title,user,pwd,mail,content) VALUES(?,?,?,?,?)";
	%>
	
	<%
		String title = request.getParameter("title");		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
	
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setString(1, title);
			pstmt.setString(2, name);
			pstmt.setString(3, pwd);
			pstmt.setString(4, email);
			pstmt.setString(5, content);
			
			result = pstmt.executeUpdate();
			
			if(result > 0)
			{
				System.out.println("게시글 입력 성공!");
				response.sendRedirect("board.jsp");
			}
			else
			{
				System.out.println("게시글 입력 실패..");
				response.sendRedirect("write.html");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	%>
</body>
</html>