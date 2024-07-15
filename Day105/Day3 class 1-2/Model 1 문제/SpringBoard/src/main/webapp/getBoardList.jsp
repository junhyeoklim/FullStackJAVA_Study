<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.first{
		font-weight: bold;
		text-align: center;
	}
	.table{
		margin-top: 10px;
	}
</style>
</head>
<body>
	<h1>글 목록</h1>
	<b>테스트님 환영합니다... <a href="#">Log-out</a></b>
	
	<table border="1">
		<tr>
			<td>
				<select id="category" name="category">
					<option value="title">제목</option>
				</select>
				<input type="text" name="text">
				<button type="submit">검색</button>
			</td>
		</tr>
	</table>
	
	<table border="1" class="table">
		<tr>
			<td class="first">번호</td>
			<td class="first">제목</td>
			<td class="first">작성자</td>
			<td class="first">등록일</td>
			<td class="first">조회수</td>		
		</tr>
		<tr>
			<td colspan="5"><%="대충 목록 불러오는 부분" %>
			</td>
		</tr>
	</table>
	
	<a href="insertBoard.jsp">새글 등록</a>
</body>
</html>