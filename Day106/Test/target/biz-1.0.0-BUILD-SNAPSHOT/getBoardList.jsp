<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"  %>    
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<h1><spring:message code="message.board.list.mainTitle"/></h1>
	<h3>${userName}<spring:message code="message.board.list.welcomeMsg"/><a href="logout.do">Log-out</a></h3>
	
	<!-- 검색 시작 -->
	<form action="getBoardList.do" method="post">
		<table border="1">
			<tr>
				<td>
					<select name="searchCondition">
<!-- 					<option value="TITLE">제목</option>
						<option value="CONTENT">내용</option> -->
						<c:forEach items="${conditionMap}" var="option">
							<option value="${option.value}">${option.key}</option>						
						</c:forEach>
					</select>
					<input name="searchKeyword" type="text" />
					<input type="submit" value="<spring:message code="message.board.list.search.condition.btn"/>" />
				</td>
			</tr>
		</table>
	</form>
	<!--  검색 종료 -->
	
	<table border="1">
		<tr>
			<th><spring:message code="message.board.list.table.head.seq"/></th>
			<th><spring:message code="message.board.list.table.head.title"/></th>
			<th><spring:message code="message.board.list.table.head.writer"/></th>
			<th><spring:message code="message.board.list.table.head.regDate"/></th>
			<th><spring:message code="message.board.list.table.head.cnt"/></th>
		</tr>
		
		<c:forEach items="${boardList}" var="board" >		
			<tr>
				<td>${board.seq}</td>
				<td><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td>${board.regDate}</td>
				<td>${board.cnt}</td>
			</tr>
		</c:forEach>
		
	</table>
	<br>
	<a href="insertBoard.jsp"><spring:message code="message.board.list.link.insertBoard"/></a>
</body>
</html>