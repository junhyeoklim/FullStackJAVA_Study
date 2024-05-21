<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="board.dao.JDBCConnector"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="js/jquery.js"></script>
<script>
	$(function(){
		
		
		$('#btn').on('click',function(){
			let value = Number($('#value').text());
			let pwd = Number($('#pwd').val());
			let upwd = Number($('#upwd').text());
			let no = $('#no').text();
			
			if(pwd == upwd){
			switch(value){
				case 1:
					location.href = 'boardUpdate.jsp?no='+no;
					break;
				case 2:
					location.href = 'boardDelete.jsp?no='+no;
				}
			}
			else
				alert('비밀번호가 일치하지 않습니다.');
		});
		
	})
</script>
<style>
body {
	user-select: none;
}
</style>
</head>

<body>

	<%! Connection con = JDBCConnector.getCon(); %>

	<% 
		String value = request.getParameter("value");
		String no = request.getParameter("no");
		String sql = "SELECT * FROM board WHERE no='"+no+"'";
		String pwd = "";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();){
			
			while(rs.next()){
				pwd = rs.getString("pwd");
			}
			out.print(pwd);	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	%>


	<div>
		<label for="pwd">비밀번호</label> <input type="password" id="pwd">
	</div>
	<input type="button" id="btn" value="확인">


	<span id="value" hidden><%= value %></span>
	<span id="no" hidden><%= no %></span>
	<span id="upwd" hidden><%= pwd %></span>
</body>
</html>