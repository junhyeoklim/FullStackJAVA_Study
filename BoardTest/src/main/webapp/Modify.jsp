<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

	<c:set var="birth" value="${sessionScope.udto.birth}"/>

	<form method="post" action="#" onsubmit="return passCheck()">
	<label for="name">이름</label><br>
	<input type="text" name="name" id="name" value="${sessionScope.udto.name}"><br>
	
	<label for="id">아이디</label><br>
	<input type="text" name="id" id="id" value="${sessionScope.udto.id}"><br>
	
	<label for="nickname">NickName</label><br>
	<input type="text" name="nickname" id="nickname" value="${sessionScope.udto.nickName}"><br>
	
	<label for="pwd">비밀번호</label><br>
	<input type="password" name="pwd" id="pwd" ><br>
	
	<label for="cpwd">비밀번호 재확인</label><br>
	<input type="password" name="cpwd" id="cpwd"><span class="error-msg"></span><br>
	
	<label for="email">이메일</label><br>
	<input type="email" name="email" id="email" value="${sessionScope.udto.email}"><br>
	
	<label>주소</label><br>
	<c:import url="address.jsp"/><br>
	
	<label for="year">생년월일</label><br>
	<input type="number" name="year" id="year" value="${fn:substring(birth,0,4)}">
	
	<select name="month" id="birth">
        <c:forEach var="i" begin="1" end="12">
            <c:set var="month" value="${i < 10 ? '0' + i : i}"/> <!-- 3항 연산자 쓰는 이유 : 01 02 03 .. 이런식으로 저장 되어 있는 월 값을 받아 오기 위해서  -->
            <option value="${month}" <c:if test="${fn:substring(birth, 4, 6) == month}">selected</c:if>>${i}</option>
        </c:forEach>
	</select>
	<input type="number" name="date" id="date" value="${fn:substring(birth,6,8)}"><br> 
	
	<label for="phone">전화번호</label><br>
	<input type="text" name="phone" id="phone" value="${sessionScope.udto.phone}"><br>
	
	<label>성별구분</label><br>
	<input type="radio" name="sex" value="male" id="male" <c:if test="${sessionScope.udto.sex eq 'male'}"> <c:out value="checked"/></c:if>><label for="male">남</label>
	<input type="radio" name="sex" value="female" id="female" <c:if test="${sessionScope.udto.sex eq 'female'}"> <c:out value="checked"/></c:if>><label for="female">여</label><br>
	
	<div>
		<input type="submit" value="회원정보수정">
		<input type="reset" value="취소">
	</div>
	</form>
	
	<script src="js/register.js"></script>
</body>
</html>