<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

	<jsp:useBean id="person" class="ch04.com.dto.Person" scope="request"/>
	<jsp:setProperty property="id" name="person" value="20182005"/>
	<jsp:setProperty property="name" name="person" value="홍길동"/>
	
	<p>아이디 : <jsp:getProperty property="id" name="person"/> </p>
	
	<p>이름 : <jsp:getProperty property="name" name="person"/></p>
</body>
</html>