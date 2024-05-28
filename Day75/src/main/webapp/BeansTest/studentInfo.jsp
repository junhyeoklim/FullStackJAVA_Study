<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<jsp:useBean id="student" class="com.superman.ex.Student" scope="page">
	<jsp:setProperty name="student" property="name"  value="홍길동"/>
	<jsp:setProperty name="student" property="age" value="10"/>
	<jsp:setProperty name="student" property="grade" value="3"/>
	<jsp:setProperty name="student" property="studentNum" value="28"/>
	
	<jsp:getProperty property="name" name="student" />
	<jsp:getProperty property="age" name="student" />
	<jsp:getProperty property="grade" name="student" />
	<jsp:getProperty property="studentNum" name="student" /> 
	</jsp:useBean>
	
</body>
</html>