<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<form method="post" action="../ErrorServlet">
		<div>
			<div><input type="text" name="num1"></div>
			<div><input type="text" name="num2"></div>
			<input type="submit" value="나누기">
		</div>
	</form>
</body>
</html>