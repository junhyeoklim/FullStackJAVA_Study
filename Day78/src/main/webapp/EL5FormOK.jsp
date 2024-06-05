<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>

이름 : <%=request.getParameter("name") %><br>
성별 : <%=request.getParameter("gender") %><br>
취미 : 
<%
	String[] hobby = request.getParameterValues("hobby");
	for(int i=0;i<hobby.length;i++)
	{
		out.print(hobby[i] + " ");
	}
%>

<hr>

</body>
</html>