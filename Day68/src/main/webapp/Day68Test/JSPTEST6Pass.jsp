<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSPTEST6Pass</title>
</head>
<body>
	<%
		String age = request.getParameter("age");
		String name = request.getParameter("name");
		
		out.print("이름 : "+name+"<br>");
		out.print("나이 : "+age+"<br>");
		
		if(Integer.parseInt(age) >= 20)
			out.print("성인입니다. 주류구매가 가능 합니다.");
		else
		{
			String value = URLEncoder.encode(name, "utf-8");
			response.sendRedirect("JSPTEST6PassJspNg.jsp?name="+value+"&age="+age);
		}
	%>
</body>
</html>