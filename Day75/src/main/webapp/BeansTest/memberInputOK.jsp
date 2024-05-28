<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<jsp:useBean id="memberDTO" class="com.superman.www.MemberDTO"/>
	<jsp:setProperty property="name" name="memberDTO"/>
	<jsp:setProperty property="id" name="memberDTO"/>
	<p>이름 : <jsp:getProperty property="name" name="memberDTO"/> </p>
	<p>아이디 : <jsp:getProperty property="id" name="memberDTO"/> </p>
</body>
</html>