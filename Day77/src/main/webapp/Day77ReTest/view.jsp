<%@page import="board.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<% BoardDTO dto = (BoardDTO)request.getAttribute("dto"); %>
	
	<form method = "post" action="modifyOK.do">
				<table border="1">
			<tr>
				<td>번호</td><td><%=dto.getNo() %></td>
			</tr>
			<tr>
				<td>조회수</td><td><%=dto.getHit() %></td>
			</tr>
			<tr>
				<td>이름</td><td><input type="text" name="name" value="<%=dto.getName() %>" /></td>
			</tr>
			<tr>
				<td>제목</td><td><input type="text" name="title" value="<%=dto.getTitle() %>" /></td>
			</tr>
			<tr>
				<td>내용</td><td><textarea name="contents" cols="100" rows="15" ><%=dto.getContents() %></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="hidden" name="no" value="<%=dto.getNo() %>">
					<input type="submit" value="수정"> 
					<a href="list.do">목록</a>
					<a href="delete.do?no=<%=dto.getNo() %>">삭제</a>
					<a href="reply.do?no=<%=dto.getNo() %>">답변</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>