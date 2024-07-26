<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<h1>글 등록</h1>
	<hr>

	<form action="insertBoard" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td><label for="title">제목</label></td>
				<td><input type="text" name="title" id="title"></td>
			</tr>

			<tr>
				<td><label for="writer">작성자</label></td>
				<td><input type="text" name="writer" id="writer"></td>
			</tr>
			
			<tr>
				<td><label for="content">내용</label></td>
				<td><textarea name="content" id="content" cols="40" rows="10"></textarea></td>
			</tr>
			
			<tr>
				<td>업로드</td>
				<td><input type="file" name="uploadFile"></td>
			</tr>
			
			<tr>
				<td colspan="2"><button type="submit">새글 등록</button></td>
			</tr>
		</table>
	</form>
	<a href="getBoardList">글 목록 가기</a>
</body>
</html>