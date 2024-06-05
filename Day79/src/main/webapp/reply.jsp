<%@page import="com.superman.ex.dto.BoardDTO"%>
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
<%
	BoardDTO dto = (BoardDTO)request.getAttribute("dto");
%>
	<form method="post" action="replyOK.do">
		<table border="1">
			<tr>
				<td>번호</td><td><%=dto.getNum()%></td>
			</tr>
			<tr>
				<td>조회수</td><td><%=dto.getHit() %></td>
			</tr>
			<tr>
				<td>이름</td><td><input type="text" name="name" autofocus/></td>
			</tr>
			<tr>
				<td>제목</td><td><input type="text" name="title" value="re: <%=dto.getTitle()%>"/></td>
			</tr>
			<tr>
				<td>내용</td><td><textarea name="contents" cols="100" rows="15">&#10&#13<%="re:" + dto.getContents() %></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="답변"> 
					<a href="list.do">목록</a>
				</td>
			</tr>
		</table>
		<input type="hidden" name="num" value="<%=dto.getNum()%>" />
		<input type="hidden" name="groupNum" value="<%=dto.getGroupNum() %>" />
		<input type="hidden" name="stepNum" value="<%=dto.getStepNum() %>" />
		<input type="hidden" name="indentNum" value="<%=dto.getIndentNum() %>" />
	</form>
	
	<!-- 
	&#10;     Line feed 
	&#13;     Carriage Return
	
	Line Feed (LF)

	아스키 코드: 16진수로 0A
	기능: 커서를 현재 행의 다음 행으로, 즉 아래로 내리기

	Carriage Return (CR)

	아스키 코드: 16진수로 0D
	기능: 커서를 현재 행의 맨 좌측으로 옮기기
-->
</body>
</html>