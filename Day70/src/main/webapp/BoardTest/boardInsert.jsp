<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="board.dao.JDBCConnector"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<%! 
		Connection con = JDBCConnector.getCon();
		int result = 0;
	%>
	
	<%
 		String title = request.getParameter("title");
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		String mail = request.getParameter("mail");
		String content = request.getParameter("content");
		String insert = request.getParameter("insert");
		String sql = "INSERT INTO board(title,user,pwd,mail,content) VALUES(?,?,?,?,?)";
		
		
		switch(Integer.parseInt(insert)){
			case 1:
				try(PreparedStatement pstmt = con.prepareStatement(sql);){
					pstmt.setString(1, title);
					pstmt.setString(2, user);
					pstmt.setString(3, pwd);
					pstmt.setString(4, mail);
					pstmt.setString(5, content);
					
					result = pstmt.executeUpdate();
					
					if(result > 0)
						response.sendRedirect("boardList.jsp");
				}
				catch(SQLException e){
					e.printStackTrace();
				}
				
				break;
			case 2:
				response.sendRedirect("boardList.jsp");
				break;
		}		

	%>
</body>
</html>