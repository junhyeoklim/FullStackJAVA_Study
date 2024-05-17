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
<title>view Content</title>
<script src="js/jquery.js"></script>
<script>
	$(function () {
		
		
		
		$("footer > button").on("click",btnCheck);
			
			
		function btnCheck(){
			let btnNum;
			let no = $("#no").text();			
			
			if($(this).hasClass("board"))				
				location.href = "board.jsp";
			else if($(this).hasClass("delete") || $(this).hasClass("update"))
			{
				btnNum = $(this).val();
				location.href = "passwordCheck.jsp?btnNum="+btnNum+"&no="+no;
			}
		};
	})
</script>
<style type="text/css">
	body,textarea{
		user-select: none;
	}
	table{
		margin: 0 auto;
		width: 220px;
		text-align: center;
	}
	textarea{
		width: 90%;
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
				String sql = "SELECT * FROM board WHERE no ='"+no+"'";
				String updateCnt = "UPDATE board SET cnt = ? WHERE no = ?";
				
				try(PreparedStatement pstmt = con.prepareStatement(sql);
					PreparedStatement update = con.prepareStatement(updateCnt);
					 ResultSet rs = pstmt.executeQuery();)
				{
					while(rs.next())
					{
						title = rs.getString("title");
						user = rs.getString("user");
						date = rs.getString("create_date");
						content = rs.getString("content");
						cnt = rs.getInt("cnt");
					}
					
					out.print("<tr>");
					out.print("<span id='no' hidden>"+no+"</span>");
					out.print("<td>제목</td>");
					out.print("<td>"+title+"</td>");
					out.print("</tr>");
					
					out.print("<tr>");
					out.print("<td>이름</td>");
					out.print("<td>"+user+"</td>");
					out.print("</tr>");
					
					out.print("<tr>");
					out.print("<td>작성일</td>");
					out.print("<td>"+date+"</td>");
					out.print("</tr>");
					
					out.print("<tr>");					
					out.print("<td colspan='2'><textarea rows='10' cols='30' readonly>"+title+"</textarea></td>");
					out.print("</tr>");	
					
					cnt++;
					update.setInt(1,cnt);
					update.setString(2,no);
					update.executeUpdate();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			%>							
	</table>
	
	<footer>
		<button type="button" class="board" value="목록">목록</button>
		<button type="button" class="update" value="1">수정</button>
		<button type="button" class="delete" value="2">삭제</button>
	</footer>
	

</body>
</html>