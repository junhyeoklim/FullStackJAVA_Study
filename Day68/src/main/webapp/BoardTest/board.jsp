<%@page import="boardController.JDBCConnector"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Board</title>
</head>
<body>
	<%!
		Connection con = JDBCConnector.getCon();
		String selectCnt = "SELECT * FROM board ORDER BY no desc";
	%>
	<h1>목록</h1>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		<%
			try(PreparedStatement pstmt = con.prepareStatement(selectCnt);
				ResultSet rs = pstmt.executeQuery()){
				
				while(rs.next()){
					out.print("<tr>");
					out.print("<td>"+rs.getInt("no")+"</td>");
					out.print("<td><a href='viewContent.jsp?no="+rs.getInt("no")+"'>"+rs.getString("title")+"</a></td>");
					out.print("<td>"+rs.getString("user")+"</td>");
					out.print("<td>"+rs.getString("create_date")+"</td>");
					out.print("<td>"+rs.getInt("cnt")+"</td>");
					out.print("</tr>");
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		%>
	</table>
	<a href="write.html">글쓰기</a>
</body>
</html>