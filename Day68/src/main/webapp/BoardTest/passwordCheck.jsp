<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
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
		
		$("#btn").on("click", function (){
			let userpwd = $("#userpwd").text();
			let inputpwd = $("#pwd").val();
			let btnNum = $("#btnNum").text();	
			let no = $("#no").text();
			
			if(userpwd == inputpwd && btnNum == 1)
				location.href = "updateUI.jsp?no="+no;	
			else if(userpwd == inputpwd && btnNum == 2)
				location.href = "deleteContent.jsp?no="+no;	
		});
		
		
		
	})
	
</script>

<style type="text/css">
	body{
		user-select: none;
	}
</style>
</head>
<body>
	<%! 
		Connection con = JDBCConnector.getCon();
		String userpwd = "";
	%>
	<%
		String btnNum = request.getParameter("btnNum");
		String no = request.getParameter("no");
		String selecSql = "SELECT * FROM board WHERE no="+no+"";
		
		try(PreparedStatement pstmt = con.prepareStatement(selecSql);
			ResultSet rs = pstmt.executeQuery();
			){
			
			while(rs.next()){
				userpwd = rs.getString("pwd");
			}
			out.print(userpwd);
			out.print(no);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	%>
	
	<div id="check">
		<label for="pwd">비밀번호</label>
		<input type="password" name="pwd" id="pwd">
	</div>
	
		<input type="button" id="btn" value="확인">
		<span id="userpwd" hidden><%= userpwd %></span>
		<span id="btnNum" hidden><%= btnNum %></span>
		<span id="no" hidden><%= no %></span>
</body>
</html>