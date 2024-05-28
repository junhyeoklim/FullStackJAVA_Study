<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<jsp:useBean id="boardInputValue" class="com.superman.www.BoardInputValue"/>
	<jsp:setProperty property="name" name="boardInputValue"/>
	<jsp:setProperty property="id" name="boardInputValue"/>
	<jsp:setProperty property="password" name="boardInputValue"/>
	<jsp:setProperty property="age" name="boardInputValue"/>
	<jsp:setProperty property="email" name="boardInputValue"/>
	
	<p>name : <jsp:getProperty property="name" name="boardInputValue"/> </p>
	<p>id : <jsp:getProperty property="id" name="boardInputValue"/> </p>
	<p>password : <jsp:getProperty property="password" name="boardInputValue"/> </p>
	<p>age : <jsp:getProperty property="age" name="boardInputValue"/> </p>
	<p>email : <jsp:getProperty property="email" name="boardInputValue"/> </p>
</body>
</html>