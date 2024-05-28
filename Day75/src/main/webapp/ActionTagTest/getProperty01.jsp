<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<jsp:useBean id="person" class="ch04.com.dto.Person" scope="request"/>
	<jsp:getProperty property="id" name="person"/>
	<jsp:getProperty property="name" name="person"/>
</body>
</html>