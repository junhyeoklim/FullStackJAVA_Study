<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>	
	<c:choose>
		<c:when test="${empty sessionScope.udto.id}">
			<form method="post" action="loginOK.do" onsubmit="return blankCheck()">
				<div>
					<label for="id">아이디:</label> <input type="text" name="id" id="id">
				</div>
				<div>
					<label for="pwd">비밀번호:</label> <input type="password" name="pwd"
						id="pwd">
				</div>
				<input type="submit" value="로그인">
			</form>
			<a href="register.do">회원가입</a>
		</c:when>
		
		<c:otherwise>
			${sessionScope.udto.id} 님<br>
			<a href="logout.do">로그아웃</a><br>
			<a href="modify.do">회원정보 수정</a><br>
			<a href="#">게시판</a><br>
		</c:otherwise>
	</c:choose>
<script type="text/javascript" src="js/login.js"></script>
</body>
</html>