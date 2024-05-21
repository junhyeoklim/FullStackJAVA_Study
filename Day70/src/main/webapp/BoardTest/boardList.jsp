<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="board.dao.JDBCConnector"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<style type="text/css">
</style>
</head>
<body>
	<%!Connection con = JDBCConnector.getCon();
	int cnt = 0;
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
			String sql = "SELECT * FROM board ORDER BY no desc";

			try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					out.print("<tr>");
					out.print("<td>" + rs.getInt("no") + "</td>");
					out.print("<td><a href='boardContent.jsp?no=" + rs.getInt("no") + "'>" + rs.getString("title") + "</a></td>");
					out.print("<td><a href='#'>" + rs.getString("user") + "</a></td>");					
					out.print("<td>" + rs.getString("sys_date") + "</td>");
					out.print("<td>" + rs.getInt("cnt") + "</td>");
					out.print("</tr>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			%>
	</table>
	<footer>
		<a href="boardWrite.html">글쓰기</a>
	</footer>

</body>
</html>