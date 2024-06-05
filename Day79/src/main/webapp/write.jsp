<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko-kr">
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="writeOK.do">
		<table border="1">
			<tr>
				<td>이름</td><td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>제목</td><td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>내용</td><td><textarea name="contents" cols="100" rows="15"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="입력"> <a href="list.do">목록</a></td>
			</tr>
		</table>
	</form>
</body>
</html>