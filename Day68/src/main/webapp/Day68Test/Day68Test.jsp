<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Day68Test</title>
	<script src="js/jquery.js"></script>
	<script>
		$(function () {
			
		$("#check").on("keyup",pwdChekc)

		function pwdChekc() {
			let pw1 = $("#pwd").val();
			let check = $("#check").val();


			
			if (!checkNull(check) && pw1 != check) {
				console.log(pw1);
				console.log(check);
				$("#show").text("비밀번호가 일치 하지 않습니다.");
				$("#show").addClass("warning");				
			}
			else{
				$("#show").text("");				
			}
		}
		
		
		function checkNull(val){
			if(val == null || val == undefined || val == "")
				return true;			
			return false;
		}
		
	})
	</script>
<style type="text/css">
table, tr, td { border : 1px solid black;}
body {
	user-select: none;
}
tr > td:first-child{width:30%;}
tr > td:last-child{width:70%;}
table {
	margin: 0 auto;
	width: 800px;
}

.warning {
	color: red;
}
#submit {
	text-align: center;
}
</style>
</head>
<body>
	<!-- 1번 문제 -->
	<%-- <table border="1">
		<caption>구구단</caption>
		<%
		
			for(int x = 2;x<=9; x++)
			{
		%>
				<tr>
		<%
				for(int y = 1;y<=9;y++)
				{
					out.print("<td>"+x+"*"+y+"="+(x*y)+"</td>");		
				}
		%>
				</tr>
		<%
			}
		 %>
	</table> --%>


	<!-- 2~3번 문제 -->
	<%-- <%!
		int i=1;
		String str = "ABCDE";
		public int sum(int num1,int num2){
			return num1+num2;
		}
	%>
	
	
	
	
	<%
		out.print(i+"<br>");
		out.print(str+"<br>");
		out.print(sum(10,20)+"<br>");
	%>
	
	<%= i %>
	<%= str %>
	<%= sum(10,20) %> --%>



	<!-- 4번 문제 -->
	<%-- <% 
		int[] iArr = {10,20,30};
		out.print(Arrays.toString(iArr));
		
	%> --%>


	<!-- 5번 문제 -->
	<form action="JSPTest5Result.jsp">
		<table border="1">
			<caption>회원가입</caption>

			<tr>
				<td><label for="name">이름</label></td>
				<td><input type="text" name="name" id="name" required></td>
			</tr>

			<tr>
				<td><label for="id">아이디</label></td>
				<td><input type="text" name="id" id="id" required></td>
			</tr>

			<tr>
				<td><label for="pwd">비밀번호</label></td>
				<td><input type="password" name="pwd" id="pwd" required></td>
			</tr>

			<tr>
				<td><label for="check">비밀번호 확인</label></td>
				<td><input type="password" name="check" id="check" required><span
					id="show"></span></td>
			</tr>

			<tr>
				<td><label for="email">이메일</label></td>
				<td><input type="email" name="email" id="email" required></td>
			</tr>

			<tr>
				<td>취미</td>
				<td><input type="checkbox" name="hobby" value="reading" id="book"><label
					for="book">독서</label> <input type="checkbox" name="hob" value="cooking" id="cook"><label
					for="cook">요리</label> <input type="checkbox" name="hob" value="running"
					id="running"><label for="running">조깅</label> <input
					type="checkbox" name="hob" value="swimming" id="swimming"><label
					for="swimming">수영</label> <input type="checkbox" name="hob" value="sleeping"
					id="sleeping"><label for="sleeping">취침</label></td>
			</tr>

			<tr>
				<td>전공</td>
				<td><input type="radio" name="major" value="Korean" id="korean"><label
					for="korean">국어</label> <input type="radio" name="major" value = "English"
					id="english"><label for="english">영어</label> <input
					type="radio" name="major" value="Math" id="math"><label for="math">수학</label>
					<input type="radio" name="major" value="Design" id="design"><label
					for="design">디자인</label></td>
			</tr>

			<tr>
				<td><label for="phone">전화번호</label></td>
				<td><select name="phone" id="phone">
						<option selected disabled>선택</option>
						<option value="SKT">SKT</option>
						<option value="KT">KT</option>
						<option value="LG U+">LG U+</option>
				</select></td>
			</tr>

			<tr >
				<td colspan="2" id="submit"><input type="submit" value="전송"> <input
					type="reset" value="초기화"></td>
			</tr>

		</table>

	</form>
</body>
</html>