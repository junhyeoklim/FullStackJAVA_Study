<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<form action="writeOK.jsp">
		<table border="1">
			<tr>
				<td><label for="title">제목</label></td>
				<td><input type="text" name="title" id="title"></td>
			</tr>
		
			<tr>
				<td><label for="name">이름<label></td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
		
			<tr>
				<td><label for="pwd">비밀번호</label></td>
				<td><input type="password" name="pwd" id="pwd"></td>
			</tr>
		
			<tr>
				<td><label for="mail">E-mail</label></td>
				<td><input type="email" name="mail" id="mail"></td>
			</tr>
		
			<tr>
				<td>취미</td>
				<td>취미: 
				<input type="checkbox" name="hobby" value="swimming"><label for="swimming">수영</label>
				<input type="checkbox" name="hobby" value="baseball"><label for="baseball">야구</label>
				<input type="checkbox" name="hobby" value="sccoer"><label for="sccoer">축구</label>
				<input type="checkbox" name="hobby" value="baketball"><label for="baketball">농구</label>
				</td>
			</tr>
		
			<tr>
				<td colspan="2"><textarea rows="15" cols="70" name="content"></textarea></td>
			</tr>
		
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
					<input type="button" value="목록">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>