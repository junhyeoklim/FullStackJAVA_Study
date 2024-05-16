<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
		<table border="1">
				<tr>
					<td>이름</td>
					<td><%=request.getParameter("name")%></td>
				</tr>
				<tr>
					<td>password</td>
					<td><%=request.getParameter("pwd")%></td>
				</tr>
			</table>
</body>
</html>