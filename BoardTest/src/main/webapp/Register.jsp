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
	
</style>
</head>
<body>

	<form method="post" action="#" onsubmit="return passCheck()">
	<label for="name">이름</label><br>
	<input type="text" name="name" id="name"><br>
	
	<label for="id">아이디</label><br>
	<input type="text" name="id" id="id"><br>
	
	<label for="nickname">NickName</label><br>
	<input type="text" name="nickname" id="nickname"><br>
	
	<label for="pwd">비밀번호</label><br>
	<input type="password" name="pwd" id="pwd" required><br>
	
	<label for="cpwd">비밀번호 재확인</label><br>
	<input type="password" name="cpwd" id="cpwd"required><span class="error-msg"></span><br>
	
	<label>주소</label><br>
	<%@ include file="address.jsp" %><br>
	
	<label for="year">생년월일</label><br>
	<input type="number" name="year" id="year" required>
	<select name="month" id="birth">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
		<option value="8">8</option>
		<option value="9">9</option>
		<option value="10">10</option>
		<option value="11">11</option>
		<option value="12">12</option>
	</select>
	<input type="number" name="date" id="date"><br>
	
	<label for="phone">전화번호</label><br>
	<input type="number" name="phone" id="phone" required><br>
	
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