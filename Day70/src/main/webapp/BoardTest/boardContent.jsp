<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="board.dao.JDBCConnector"%>
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
	$(function(){
		
		$('footer > button').on('click',btnCheck);
		
		
		
		function btnCheck(){
			let value = Number($(this).val());
			let no = $('#no').text();
			switch(value)
			{
				case 0:
					location.href = 'boardList.jsp';
					break;				
				case 1:					
				case 2:
					location.href = 'pwdCheck.jsp?value='+value+'&no='+no;
					break;
			}
		}
	})
</script>

<style type="text/css">
	body{
		user-select: none;
	}
	table{
		margin: 0 auto;		
	}
	table td:first-of-type {
		width:100px;
	}
	textarea{
		caret-color: transparent;
		color: sliver;
		resize: none;
	}
	footer{
		width: 200px;		
	 	margin: 0 auto;
	 	text-align: center;
	}
</style>
</head>
<body>
	<%! 
		Connection con = JDBCConnector.getCon();
		String title = "";
		String user = "";
		String date = "";
		String content = "";
		int cnt = 0;
	%>
	
	<table border="1">
		<caption>내용보기</caption>		
		<%
			String no = request.getParameter("no");
			String sql = "SELECT * FROM board WHERE no='"+no+"'";
			String updateCnt = "UPDATE board SET cnt = ? WHERE no = ?";
			
			try(PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement update = con.prepareStatement(updateCnt);
				ResultSet rs = pstmt.executeQuery();)
			{
				while(rs.next()){					
					title = rs.getString("title");
					user = rs.getString("user");
					date = rs.getString("sys_date");
					content = rs.getString("content");
					cnt = rs.getInt("cnt");
				}
				
				cnt++;
				
				update.setInt(1, cnt);
				update.setString(2, no);
				update.executeUpdate();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		%>
		<tr>
			<td>제목</td>
			<td><%= title %></td>
		</tr>
		
		<tr>
			<td>이름</td>
			<td><%= user %></td>
		</tr>
		
		<tr>
			<td>작성일</td>
			<td><%= date %></td>
		</tr>
		
		<tr>
			<td colspan="2"><textarea cols="50" rows="10" readonly disabled><%= content %></textarea></td>
		</tr>
	</table>
		<footer>			
			<button type="button" value="0">목록</button>
			<button type="button" value="1">수정</button>
			<button type="button" value="2">삭제</button>
		</footer>
		<span id="no" hidden><%= no %></span>		
</body>
</html>