<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="company.dao.JDBCConnector"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>main</title>
<link rel="stylesheet" href="../css/styles.css">
<script src="../js/jquery.js"></script>

</head>
<body>
	<%!Connection con = JDBCConnector.getCon();%>
	
	<table border="1" id="main">
		<caption>사원 목록</caption>
		<tr>
			<td>이름</td>
			<td>부서</td>
			<td>직급</td>
			<td>이메일</td>
			<td>전화번호</td>
		</tr>
		<%
		String sql = "";

		String select = request.getParameter("select");
		String text = request.getParameter("text");
		

		if (select != null && text != "") {
			switch (Integer.parseInt(select)) {
			case 1:
				sql = "SELECT * FROM salary_man WHERE s_name='" + text + "'";
				break;
			case 2:
				sql = "SELECT * FROM salary_man WHERE s_rank='" + text + "'";
				break;
			case 3:
				sql = "SELECT * FROM salary_man WHERE s_department='" + text + "'";
				break;
			}
		} else
			sql = "SELECT * FROM salary_man";

		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				out.print("<tr>");
				out.print("<td>" + rs.getString("s_name") + "</td>");
				out.print("<td>" + rs.getString("s_department") + "</td>");
				out.print("<td>" + rs.getString("s_rank") + "</td>");
				out.print("<td>" + rs.getString("s_mail") + "</td>");
				out.print("<td>" + rs.getString("s_phoneNumber") + "</td>");
				out.print("</tr>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		%>

		<tr>
			<td colspan="5" id="footer">
			<input type="button" id="btn" value="등록"></td>
		</tr>
	</table>
	<footer>
		<select id='select-box'>
			<option disabled selected>선택</option>
			<option value="1">이름</option>
			<option value="2">직급</option>
			<option value="3">부서</option>
		</select> <input type="text" name="search" id="search"> <input
			type="button" id="sbtn" value="검색">
	</footer>
	<script src="../js/list.js"></script>
</body>
</html>