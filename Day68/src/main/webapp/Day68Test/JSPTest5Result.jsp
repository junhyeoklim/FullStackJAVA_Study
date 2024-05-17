<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		String email = request.getParameter("email");
		String[] hobby = request.getParameterValues("hobby");
		String major = request.getParameter("major");
		String phone = request.getParameter("phone");
		
		out.print("이름 : " + name + "<br>");
		out.print("아이디 : " + id + "<br>");
		out.print("비밀번호 : " + pw + "<br>");
		out.print("이메일 : " + email + "<br>");
		out.print("취미 : " + Arrays.toString(hobby) + "<br>");
		out.print("전공 : " + major + "<br>");
		out.print("통신사 : " + phone + "<br>");
	%>
	
	
</body>
</html>