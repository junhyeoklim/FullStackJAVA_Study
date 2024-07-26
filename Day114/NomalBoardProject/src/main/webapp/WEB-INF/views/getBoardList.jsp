<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<h1>글 목록</h1>
	<hr>

	<form action="getBoardList" method="post">
		<table border="1">
			<tr>
				<td><select name="searchCondition">
						<option value="TITLE">제목</option>
						<option value="CONTENT">내용</option>
				</select> <input type="text" name="searchKeyword">
					<button type="submit">검색</button></td>
			</tr>
		</table>
	</form>



	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>

		<c:forEach items="${boardList }" var="board">
			<tr>
				<td>${board.seq}</td>
				<td>${board.title }</td>
				<td>${board.writer }</td>
				<td><fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${board.regDate}"/></td>
				<td>${board.cnt }</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="insertBoardPage">새글 등록</a>
</body>
</html>