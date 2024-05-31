<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<style>
tr > td:first-child{width:30%;}
tr > td:last-child{width:70%;}
.pwChkTxt{color:red;}
table, tr, td { border : 1px solid black;}
body {
	user-select: none;
}

table {
	margin: 0 auto;
	width: 800px;
}

#submit {
	text-align: center;
}
</style>
<script src="js/jquery.js"></script>
</head>
<body>
	<%--1번 문제
	<%!
		int i=1;
		String str = "ABCDE";
		public int sum(int num1, int num2){
			return num1+num2;
		}
	
	
	<% out.print(i+"<br>");%>
	<%= str%>
	<%= sum(10,20)%>
	--%>

	<%-- 	<%
		int[] iArr = {10,20,30};
		out.print(Arrays.toString(iArr));
	%> --%>
	
	<!-- 3번 문제  -->
	
	<form method="post" action="JSPTTest5Result.jsp">
		<table border=1>
			<caption>회원가입</caption>

			<tr>
				<td><label for="name">이름</label></td>
				<td><input type="text" name="name" id="name"
					required="required">
			</tr>

			<tr>
				<td><label for="id">아이디</label></td>
				<td><input type="text" name="id" id="id" required="required">
			</tr>

			<tr>
				<td><label for="pwd">비밀번호</label></td>
				<td><input type="password" name="pw" id="pwd"
					required="required">
			</tr>

			<tr>
				<td><label for="check">비밀번호 확인</label></td>
				<td><input type="password" name="check" id="check"
					required="required">
					<span class='pwChkTxt'></span>
				</td>
			</tr>

			<tr>
				<td><label for="email">이메일</label></td>
				<td><input type="email" name="mail" id="email"
					required="required">
			</tr>

			<tr>
				<td><label>취미</label>
				<td><input type="checkbox" id="book"><label for="book">독서</label>
					<input type="checkbox" id="cook"><label for="cook">요리</label>
					<input type="checkbox" id="jogging"><label for="jogging">조깅</label>
					<input type="checkbox" id="swimming"><label for="swimming">수영</label>
					<input type="checkbox" id="sleep"><label for="sleep">취침</label>
				</td>
			</tr>

			<tr>
				<td><label>전공</label></td>
				<td><input type="radio" name="major" id="korean"><label
					for="korean">국어</label> <input type="radio" name="major"
					id="english"><label for="english">영어</label> <input
					type="radio" name="major" id="math"><label for="math">수학</label>
					<input type="radio" name="major" id="design"><label
					for="design">디자인</label></td>
			</tr>
			<tr>
				<td><label for="aMobileCarrier">전화번호</label></td>
				<td><select id="aMobileCarrier">
						<option value="SKT">SKT</option>
						<option value="KT">KT</option>
						<option value="LG">LG</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" id="submit"><input type="submit" value="전송">
					<input type="reset" value="초기화"></td>
			</tr>
		</table>
	</form>
<script type="text/javascript">		
		
		
		$("#check").on("keyup",function (){
			let pw1 = $("#pwd").val();
			let check = $("#check").val();
			
			if(!vali(check) && pw1 != check)
			{
				console.log(pw1);
				console.log(check);
				$(".pwChkTxt").text("비밀번호가 일치하지 않습니다.");
			}
			else
				$(".pwChkTxt").text("");
		});

		
        function vali(val){
        	 
            if (val === null) return true; 
            if (typeof val === 'string' && val === '') return true;
            if (typeof val === 'undefined') return true;
            
            return false;

        }

</script>
</body>
</html>