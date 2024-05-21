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
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String sql = "UPDATE board SET title = ?, content= ? WHERE no ='"+no+"'";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			
			result = pstmt.executeUpdate();
			
			if(result > 0)
				response.sendRedirect("boardList.jsp");
			else
				response.sendRedirect("boardUpdate.jsp?no="+no);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	%>
</body>
</html>