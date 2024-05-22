<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.mysql.cj.PreparedQuery"%>
<%@page import="java.sql.SQLException"%>
<%@page import="board.dao.JDBCConnector"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<%! Connection con = JDBCConnector.getCon(); %>
	<% 
		String sql = "SELECT COUNT(*) FROM board";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();){
			int cnt = 0;
			
			while(rs.next()){
				cnt = rs.getInt(1);
			}
			out.print(cnt);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	%>
</body>
</html>