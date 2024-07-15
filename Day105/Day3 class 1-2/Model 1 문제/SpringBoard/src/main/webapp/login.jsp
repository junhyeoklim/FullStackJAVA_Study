<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h1>로그인</h1>
	<hr>

	<form action="#">
		<table border="1">
			<tr>
				<td><label for="id">아이디</label></td>
				<td><input id="id" name="id" type="text"></td>
			</tr>

			<tr>
				<td><label for="pwd">비밀번호</label></td>
				<td><input type="password" id="pwd" name="pwd"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<button type="submit">로그인</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>