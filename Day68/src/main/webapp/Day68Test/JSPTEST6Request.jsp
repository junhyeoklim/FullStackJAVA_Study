<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSPTEST6Request</title>
<style type="text/css">
	#submit{
		text-align: center;
	}
</style>
</head>
<body>
	<form action="JSPTEST6Pass.jsp">
		<table border="1">
			<tr>
				<td><label for="name">이름</label></td>
				<td><input type="text" name="name" id="name" required></td>
			</tr>
			
			<tr>
				<td><label for="age">나이</label></td>
				<td><input type="number" name="age" id="age" required></td>
			</tr>
			
			<tr>
				<td colspan="2" id="submit"><input type="submit" value="전송"></td>
			</tr>
		</table>
	</form>
</body>
</html>