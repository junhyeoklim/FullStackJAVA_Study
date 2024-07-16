<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 세션에 저장된 게시글 정보를 꺼낸다.
	BoardVO board = (BoardVO)session.getAttribute("board");
%>

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
	<input name="seq" type="hidden" value="<%=board.getSeq() %>" />
	<table border="1">
		<tr>
			<td>제목</td>
			<td><input name="title" type="text" value="<%=board.getTitle() %>"/></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%=board.getWriter() %></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content" cols="40" rows="10"><%=board.getContent() %></textarea></td>
		</tr>
		<tr>
			<td>등록일</td>
			<td><%=board.getRegDate() %></td>
		</tr>
		<tr>
			<td>조회수</td>
			<td><%=board.getCnt() %></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="글 수정"/></td>
		</tr>
	</table>
	<hr>
	<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard.do?seq=<%=board.getSeq()%>">글삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.jsp">글목록</a>
</form>
</body>
</html>