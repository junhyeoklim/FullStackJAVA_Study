<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSPTEST6PassJspNg</title>
</head>
<body>
	<%
		String age = request.getParameter("age");
		String name = request.getParameter("name");
		
		out.print("이름 : "+name+"<br>");
		out.print("나이 : "+age+"<br>");
		
		out.print("미성년자 입니다. 주류구매가 불가능합니다.");
	%>
</body>
</html>