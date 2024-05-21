<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="board.dao.JDBCConnector"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="js/jquery.js"></script>
<script>
	$(function(){
		
		let flag = $('#flag').text();
		
		if(flag == 'true'){
			alert("게시글이 삭제되었습니다!");
			location.href = 'boardList.jsp';
		}
		else{
			alert("해당되는 게시글이 존재하지 않습니다.")
			history.back();
		}
			
		
	})
</script>
</head>
<body>
	<%! Connection con = JDBCConnector.getCon(); %>
	<%
		int result = 0;	
		int cnt = 1;
		boolean flag = false;
		String changeNo = "UPDATE board SET no = ?";		
		String no = request.getParameter("no");
		String sql = "DELETE FROM board WHERE no='"+no+"'";
		String selectSql = "SELECT * FROM board"; 
		
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);
			PreparedStatement update = con.prepareStatement(changeNo);
			PreparedStatement select = con.prepareStatement(selectSql);
			ResultSet rs = select.executeQuery();){
			
			result = pstmt.executeUpdate();
			
			if(result > 0){
				flag = true;
/* 				while(rs.next()){
					update.setInt(1, cnt);
					update.executeUpdate();
					cnt++;
				} */
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	%>
	
	<span id="flag" hidden><%= flag %></span>
</body>
</html>