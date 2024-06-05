<%@page import="com.superman.ex.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko-kr">
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>목록</title>
</head>
<body>

<%
	ArrayList<BoardDTO> list = (ArrayList<BoardDTO>)request.getAttribute("list");
%>
<table border="1">
	<tr>
		<td>번호</td><td>이름</td><td>제목</td><td>날짜</td><td>조회수</td>
	</tr>
<%
	for(int i=0;list != null && i<list.size();i++)
	{
		BoardDTO dto = list.get(i);
%>
	<tr>
		<td><%=dto.getNum() %></td>
		<td><%=dto.getName() %></td>
		<td>
			<%
				int indentNum = dto.getIndentNum();
				for(int j=0;j<indentNum;j++)
					out.println("-");
			%>
			<a href="view.do?num=<%=dto.getNum()%>"><%=dto.getTitle() %></a>
		</td>
		<td><%=dto.getWtime() %></td>
		<td><%=dto.getHit() %></td>
	</tr>	
<%
	}
%>
	<tr>
		<td colspan="5"><a href="write.do">글작성</a></td>
	</tr>
</table>
</body>
</html>