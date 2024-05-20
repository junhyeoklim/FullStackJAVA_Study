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
	$(function (){
		let flag = $("#flag").text();
		
		if(flag)
		{
			alert("게시글이 삭제 되었습니다!");
			location.href = "board.jsp";
		}
		else
			alert("삭제할려는 게시글을 다시 확인 해주세요!");
	})
	
</script>
</head>
<body>
	<%! Connection con = JDBCConnector.getCon(); %>
	
	
	<% 
		String no = request.getParameter("no");
		String sql = "DELETE FROM board WHERE no='"+no+"'";
		boolean flag = false;
	  	int result = 0;
		
	  	try(PreparedStatement pstmt = con.prepareStatement(sql);){
	  		
	  		result = pstmt.executeUpdate();
	  		
	  		if(result > 0)
	  			flag = true;
	  	}
	  	catch(SQLException e){
	  		e.printStackTrace();
	  		
	  	}
	%>
	<span id="flag" hidden><%= flag %></span>
</body>
</html>