<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
	아이디 : <%= request.getParameter("id") %>
	비밀번호 : <%= request.getParameter("pw") %>
</body>
</html>