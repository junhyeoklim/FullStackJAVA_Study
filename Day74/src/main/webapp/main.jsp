<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<script src='js/jquery.js'></script>
<script>
function check(){
	
	let id = $('#id').val();
	let pwd = $('#pwd').val();
	let flag = $('#plag').val();
	
	console.log(isWhat(flag));
	
	
	if(isWhat(id) || isWhat(pwd)){
		console.log(typeof pwd);
		console.log(pwd);
		alert("아이디 또는 비밀번호를 입력 해주세요!");
		id.val("");
		pwd.val("");
		id.focus();
		return false;
	}
	else if(isWhat(flag)){
		/* 이 기능을 erro로 빼버리자  */
		alert("회원정보가 존재하지 않습니다!");
	}
	else
		return true;
	
		
		
}

function isWhat(name){
    if (name === null) return true; 
    if (typeof name === 'string' && name === '') return true;
    if (typeof name === 'undefined') return true;
    
    return false;
}

</script>
<style type="text/css">
body {
	user-select: none;
}
</style>

</head>
<body>
	<% String id = (String)session.getAttribute("id");  
		if(id == null)
		{
	%>
	<span id="flag" hidden><%= request.getParameter("flag") %></span>
	<form name="myForm" action="LoginOK" onsubmit="return check()" method="post">
		<table>
			<tr>
				<td><label for="id">아이디 :</label></td>
				<td><input type="text" name="id" id="id"></td>
			</tr>

			<tr>
				<td><label for="pwd">비밀번호 : </label></td>
				<td><input type="password" name="pwd" id="pwd"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" id="submit" value="로그인">
					<a href="memberRegister.html">회원가입</a></td>
			</tr>			
		</table>
		
	</form>
	
	<% 
		}

		else{
	%>
	<%=id %>님 환영합니다.<br>
	<a href="#">로그아웃</a>
	<a href="memberModify.jsp?id=<%= id %>">개인정보수정</a>
	<%} %>
</body>
</html>