<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NullPointerError 화면</title>
</head>
<body>
	<!-- 타이틀 시작 -->
	<table border="1">
		<tr><td><b>NullPointerError 에러 화면입니다.</b></td></tr>
	</table>
	
	<!-- 에러 메시지 -->
	<table border="1">
		<tr>
			<td>Message : ${exception.message}</td>
		</tr>
	</table>
</body>
</html>