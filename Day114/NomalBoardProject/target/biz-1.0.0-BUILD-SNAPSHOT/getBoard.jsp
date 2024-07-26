<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h1>글 상세</h1>
	<hr>
	
	<form action="updateBoard" method="post">
		<input type="text" name="seq" value="${board.seq }" hidden>
		<table border="1">
			<tr>
				<td><label for="title">제목</label></td>
				<td><input type="text" name="title" id="title" value="${board.title}"></td>
			</tr>
						
			<tr>
				<td>작성자</td>
				<td>${board.writer }</td>
			</tr>
			
			<tr>
				<td><label for="content">내용</label></td>
				<td><textarea name="content" id="content" cols="40" rows="10">${board.content }</textarea></td>
			</tr>

			
			<tr>
				<td>등록일</td>
				<td></td>
			</tr>
			
			<tr>
				<td>조회수</td>
				<td>${board.cnt }</td>
			</tr>
			
			<tr>
				<td colspan="2"><button type="submit">글 수정</button></td>
			</tr>
		</table>
	</form>
	<hr>
	
	<a href="insertBoardPage">글 등록</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard?seq=${board.seq}">글 삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList">글 목록</a>
	
</body>
</html>