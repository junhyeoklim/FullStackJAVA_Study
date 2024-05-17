<%@page import="java.net.URLEncoder"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<%!String url = "jdbc:mysql://localhost:3306/simpleproject?serverTimezone=UTC";
	String driverPath = "com.mysql.cj.jdbc.Driver";
	String user = "root";
	String pwd = "1234";
	int result = 0;
	%>


	<%
	String sql = "INSERT INTO member(name,id,pw) VALUES(?,?,?)";
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String ps = request.getParameter("pwd");

	try (Connection conn = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);) {

		Class.forName(driverPath);
		System.out.println("드라이버 연결 성공");
		System.out.println("Connection 연결 성공");

		if (name != null && ps != null && id != null) {
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, ps);

			result = pstmt.executeUpdate();
		}
		if (result > 0) {
			System.out.println("데이터 입력 성공!");
			String value = URLEncoder.encode(name, "utf-8");
			response.sendRedirect("welcome.html");
		} else {
			response.sendRedirect("fail.html");
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	%>
</body>
</html>