<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="js/jquery.js"></script>
<style>
	body{
		user-select: none;
	}
	
input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}
.error-msg{
	margin-left: 10px;
	color: red;
}
.success-msg{
	margin-left: 10px;
	color: blue;
}
	
</style>
</head>
<body>

	<form method="post" action="registerOK.do" onsubmit="return passCheck()">
	<label for="name">이름</label><br>
	<input type="text" name="name" id="name"><br>
	
	<label for="id">아이디</label><br>
	<input type="text" name="id" id="id"><br>
	
	<label for="nickname">NickName</label><br>
	<input type="text" name="nickname" id="nickname"><br>
	
	<label for="pwd">비밀번호</label><br>
	<input type="password" name="pwd" id="pwd" ><br>
	
	<label for="cpwd">비밀번호 재확인</label><br>
	<input type="password" name="cpwd" id="cpwd"><span id="msg"></span><br>
	
	<label for="email">이메일</label><br>
	<input type="email" name="email" id="email"><br>
	
	<label>주소</label><br>
	<c:import url="address.jsp"/><br>
	
	<label for="year">생년월일</label><br>
	<input type="number" name="year" id="year" >
	<select name="month" id="birth">
		<c:forEach var="i" begin="1" end="12">
			<c:set var="month" value="${i}"/> 
			<c:choose>
			<c:when test="${month < 10}"> 
				<option value="0${month}">${i}</option>
			</c:when>
			<c:otherwise>
				<option value="${month}">${i}</option>
			</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
	<input type="number" name="date" id="date"><br>
	
	<label for="phone">전화번호</label><br>
	<input type="number" name="phone" id="phone" ><br>
	
	<label>성별구분</label><br>
	<input type="radio" name="sex" value="male" id="male"><label for="male">남</label>
	<input type="radio" name="sex" value="female" id="female"><label for="female">여</label><br>
	
	<div>
		<input type="submit" value="회원가입">
		<input type="reset" value="취소">
	</div>
	</form>
	
	<script src="js/register.js"></script>
</body>
</html>