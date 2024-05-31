<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="boardController.JDBCConnector"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<script src="js/jquery.js"></script>
<script>
	$(function () {
		
		
		
		$("footer > button").on("click",btnCheck);		
		
		
			
		function btnCheck(){			
			if($(this).hasClass("board"))				
				location.href = "board.jsp";
			else if($(this).hasClass("submit"))
			{
				let no = $("#no").text();
				let title = $("#title").val();
				let content = $("#content").val();
				console.log(no);
				console.log(title);
				console.log(content);
				location.href = "updateContent.jsp?no="+no+"&title="+title+"&content="+content; 
			}
		};
	})
</script>
<style type="text/css">
	body{
		user-select: none;
	}
	textarea,input:not([type="submit"],[type="button"]){
		width: 90%;
	}
	table{
		margin: 0 auto;
		width: 280px;
		text-align: center;
	}
		footer{
		display: block;
		text-align:center;
	}
</style>
</head>
<body>
	<%! 
		Connection con = JDBCConnector.getCon();		
	%>
	<%
		String no = request.getParameter("no");
		String selectSql = "SELECT * FROM board WHERE no = '"+no+"'";		
		String user = "";
		String date = "";
		
		try(PreparedStatement select = con.prepareStatement(selectSql);			
			ResultSet rs = select.executeQuery();){
			
			while(rs.next())
			{
				user = rs.getString("user");
				date = rs.getString("create_date");
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	%>	
	<table border="1">
		<caption>수정하기</caption>
			<tr>
				<td><label for="title">제목</label></td>
				<td><input type="text" name="title" id="title"></td>
			</tr>
			
			<tr>
				<td>이름</td>
				<% out.print("<td>"+user+"</td>"); %>
			</tr>
			
			<tr>
				<td>작성일</td>
				<% out.print("<td>"+date+"</td>"); %>
			</tr>
			
			<tr>
				<td colspan="2"><textarea rows="10" cols="30" name="content" id="content"></textarea></td>
			</tr>
			
	</table>
		
	<footer>
		<button type="button" class="board" value="목록">목록</button>
		<button type="button" class="submit"  value="등록">등록</button>
		<span id="no" hidden><%=no %></span>
	</footer>
	
</body>
</html>