<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<h1>회원가입</h1>

	<form action="memberInputOK.jsp">
		<table>
			<tr>
				<td><label for="name">이름 : </label></td>
				<td><input type="text" id="name" name="name"></td>
			</tr>

			<tr>
				<td><label for="id">아이디 : </label></td>
				<td><input type="text" id="id" name="id"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="전송"></td>
			</tr>
		</table>
	</form>
</body>
</html>