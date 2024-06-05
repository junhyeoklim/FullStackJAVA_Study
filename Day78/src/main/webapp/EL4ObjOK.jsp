<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	%>
	
	아이디 : <%= id %> <br />
	비밀번호 : <%= pw %>
	
	<hr />
	
	applicationScope : <%= application.getAttribute("application_name") %><br />
	sessionScope : <%= session.getAttribute("session_name") %><br />
	pageScope : <%= pageContext.getAttribute("page_name") %><br />
	requestScope : <%= request.getAttribute("request_name") %><br />
	
	<hr />
	
	context 초기화 파라미터<br />
	<%= application.getInitParameter("companyName") %> <br />
	<%= application.getInitParameter("companyTel") %> <br />
	<%= application.getInitParameter("companyEmail") %> <br />
	
</body>
</html>