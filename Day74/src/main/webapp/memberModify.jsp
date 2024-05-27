<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="memeber.dao.JDBCConnector"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<style type="text/css">
body {
	user-select: none;
}

#user {
	caret-color: transparent;
}

input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}
</style>
</head>
<body>
	<% 
		Connection con = JDBCConnector.getCon();
		String id = request.getParameter("id");
		String sex = "";
		String[] hobby = {};
		String user = "";		
		String mail = "";
		int firstPhone = 0;
		int secondPhone = 0;
		
		String userSql = "SELECT * FROM WHERE id='"+id+"'";
		
		try(PreparedStatement pstmt = con.prepareStatement(userSql);
			ResultSet rs = pstmt.executeQuery();
			) {
			
				while(rs.next()){
					sex = rs.getString("sex");
					user = rs.getString("user");
					mail = rs.getString("mail");
					firstPhone = rs.getInt("firstPhone");
					secondPhone = rs.getInt("secondPhone");
				}
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	%>
	<h1>회원정보수정</h1>

	<form action="#">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" disabled readonly id="user" name="user"></td>
			</tr>

			<tr>
				<td><label for="id">아이디</label></td>
				<td><input type="text" id="id" name="id"></td>
			</tr>

			<tr>
				<td><label for="pwd">비밀번호</label></td>
				<td><input type="password" id="pwd" name="pwd"></td>
			</tr>

			<tr>
				<td><label for="pwdc">비밀번호확인</label></td>
				<td><input type="password" id="pwdc" name="pwdc"></td>
			</tr>

			<tr>
				<td>성별</td>
				<td><input type="radio" name="sex" id="male" value="male"><label
					for="male">남</label> <input type="radio" name="sex" id="female"
					value="female"><label for="female">여</label></td>
			</tr>

			<tr>
				<td><label for="mail">이메일</label></td>
				<td><input type="email" id="mail" name="mail"></td>
			</tr>

			<tr>
				<td>취미</td>
				<td><input type="checkbox" name="hobby" id="swimming"
					value="swimming"><label for="swimming">수영</label> <input
					type="checkbox" name="hobby" id="baseball" value="baseball"><label
					for="baseball">야구</label> <input type="checkbox" name="hobby"
					id="movie" value="movie"><label for="movie">영화감상</label> <input
					type="checkbox" name="hobby" id="music" value="music"><label
					for="music">음악감상</label></td>
			</tr>

			<tr>
				<td>핸드폰</td>
				<td><select>
						<option value="" selected disabled>선택</option>
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
				</select> <input type="number" name="phone"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="정보수정"> <input
					type="reset" value="초기화"></td>
			</tr>
		</table>
	</form>
</body>
</html>