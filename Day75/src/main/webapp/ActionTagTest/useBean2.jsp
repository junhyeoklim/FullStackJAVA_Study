<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<jsp:useBean id="calc" class="ch04.com.dto.Calculator"/>
	<p>5의 3 제곱 : <%= calc.process(5) %></p>
</body>
</html>