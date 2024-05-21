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
	$(function (){
		
		$('#footer button').on('click',function() {
			
			let value = Number($(this).val());
			let no = $('#no').text();
			let title = $('#title').val();
			let content = $('#content').val();		

			
			switch(value){
			case 1:
				location.href = 'boardList.jsp';
				break;
			case 2:
				location.href = 'boardUpdateContent.jsp?no='
				+no+"&title="
				+title+"&content="
				+content;
				break;
			}
		});
		
		
	})
</script>
<style>
body {
	user-select: none;
}

textarea {
	color: sliver;
	resize: none;
}

table {
	margin: 0 auto;
}
</style>
</head>
<body>
	<%! 
		Connection con = JDBCConnector.getCon();
	%>

	<table>
		<caption>수정하기</caption>

		<tr>
			<td><label for="title">제목</label></td>
			<td><input type="text" name="title" id="title"></td>
		</tr>

		<% 
			String no = request.getParameter("no");
			String sql = "SELECT * FROM board WHERE no ='"+no+"'";
			try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
				
				while(rs.next()){
					out.print("<tr>");
					out.print("<td>이름</td>");
					out.print("<td>"+rs.getString("user")+"</td>");
					out.print("</tr>");
					out.print("<tr>");
					out.print("<td>작성일</td>");
					out.print("<td>"+rs.getString("sys_date")+"</td>");
					out.print("</tr>");
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		%>
		<tr>
			<td colspan="2"><textarea cols="50" rows="10" id="content"></textarea></td>
		</tr>

		<tr>
			<td colspan="2" id="footer">
				<button type="button" value="1">목록</button>
				<button type="button" value="2">등록</button>
			</td>
		</tr>
	</table>
	<span id="no" hidden><%= no %></span>
</body>
</html>