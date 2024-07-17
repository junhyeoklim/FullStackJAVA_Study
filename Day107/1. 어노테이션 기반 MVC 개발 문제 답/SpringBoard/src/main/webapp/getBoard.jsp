<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
</head>
<body>
<h1>글 상세</h1>
<a href="logout.do">Log-out</a>
<hr>
<form action="updateBoard.do" method="post">
	<input name="seq" type="hidden" value="${board.seq}" />
	<table border="1">
		<tr>
			<td>제목</td>
			<td><input name="title" type="text" value="${board.title}"/></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${board.writer}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content" cols="40" rows="10">${board.content}</textarea></td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>${board.regDate}</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${board.cnt}</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="글 수정"/></td>
		</tr>
	</table>
	<hr>
	<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard.do?seq=${board.seq}">글삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.do">글목록</a>
</form>
</body>
</html>