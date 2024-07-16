<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
		// 세션에 저장된 글 목록을 꺼낸다.
		List<BoardVO> boardList = (List)session.getAttribute("boardList");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<h1>글 목록</h1>
	<h3>테스트님 환영합니다...<a href="logout.do">Log-out</a></h3>
	
	<!-- 검색 시작 -->
	<form action="getBoardList.jsp" method="post">
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
		
		<% for(BoardVO board : boardList) { %>
		<tr>
			<td><%= board.getSeq() %></td>
			<td><a href="getBoard.do?seq=<%=board.getSeq() %>"> <%=board.getTitle() %></a></td>
			<td><%=board.getWriter() %></td>
			<td><%=board.getRegDate() %></td>
			<td><%=board.getCnt() %></td>
		</tr>
		<% } %>
	</table>
	<br>
	<a href="insertBoard.jsp"> 새글 등록</a>
</body>
</html>