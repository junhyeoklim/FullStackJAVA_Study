<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"  %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<h1>글 목록</h1>
	
	<!-- 검색 시작 -->
	<form action="getBoardList" method="post">
		<table border="1">
			<tr>
				<td>
					<select name="searchCondition">
						<option value="TITLE">제목</option>
						<option value="CONTENT">내용</option>
					</select>
					<input name="searchKeyword" type="text" />
					<input type="submit" value="검색" />
				</td>
			</tr>
		</table>
	</form>
	<!--  검색 종료 -->
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		
		<c:forEach items="${boardList}" var="board" >		
			<tr>
				<td>${board.seq}</td>
				<td><a href="getBoard?seq=${board.seq}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td><fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${board.regDate}"/></td>
				<td>${board.cnt}</td>
			</tr>
		</c:forEach>
		
	</table>
	<br>
	<a href="insertBoardPage"> 새글 등록</a>
</body>
</html>