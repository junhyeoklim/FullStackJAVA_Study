<%@page import="com.superman.www.dto.BoardDTO"%>
<%@page import="com.superman.www.dao.BoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.superman.www.*"%>
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판 목록</title>
</head>
<body>
<h3>목록</h3>
<%
	ArrayList<BoardDTO> list = (ArrayList<BoardDTO>)request.getAttribute("list");
	for(int i=0;list != null && i<list.size();i++)
	{
		BoardDTO dto = list.get(i);
		/* out.print("번호 " + dto.getNo()+"<br>"); */
		out.print("제목 " + dto.getTitle()+"<br>");
		out.print("작성자 " + dto.getName()+"<br>");
		out.print("작성일 " + dto.getWtime()+"<br>");
		out.print("조회수 " + dto.getRcnt()+"<br><br>");
	}
%>
<a href="write.do">글쓰기</a>
</body>
</html>