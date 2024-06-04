<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<script>
		function blankCheck() {
			let id = document.getElementById('id').value;
			let pwd = document.getElementById('pwd').value;

			if (id == null || id == "" || pwd == null || pwd == "") {
				alert("아이디 또는 비밀번호를 입력 하세요!");
				return false;
			} else
				return true
		}
	</script>

	<c:choose>
		<c:when test="${empty requestScope.dto.id}">
			<form method="post" action="#" onsubmit="return blankCheck()">
				<div>
					<label for="id">아이디:</label> <input type="text" name="id" id="id">
				</div>
				<div>
					<label for="pwd">비밀번호:</label> <input type="password" name="pwd"
						id="pwd">
				</div>
				<input type="submit" value="로그인">
			</form>
			<a href="#">회원가입</a>
		</c:when>
		
		<c:otherwise>

		</c:otherwise>
	</c:choose>
</body>
</html>