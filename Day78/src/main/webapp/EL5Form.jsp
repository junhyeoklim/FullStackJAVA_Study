<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="EL5FormOK.jsp">
이름 : <input type="text" name="name"><br>
성별 : <input type="radio" name="gender" value="male" checked>남 <input type="radio" name="gender" value="female">여<br>
취미 : 	<input type="checkbox" name="hobby" value="swimming">수영
		<input type="checkbox" name="hobby" value="baseball">야구
		<input type="checkbox" name="hobby" value="soccer">축구
		<input type="checkbox" name="hobby" value="basketball">농구
<input type="submit" value="전송">
</form>
</body>
</html>