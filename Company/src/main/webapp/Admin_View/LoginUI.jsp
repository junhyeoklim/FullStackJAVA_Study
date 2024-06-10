<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="icon" href="../source/company.ico" />
<link rel="stylesheet" href="css/login.css?after">
<script src="js/jquery.js"></script>
</head>
<body>
	<div id="login" class="login_wrap">
		<div class="log_inr">
			<form method="post" action="loginOK.do" onsubmit="return check()" >
				<fieldset>
					<div class="login_inp">
						<div class="input_box">
							<label for="name">이름</label>
							<input type="text" name="name" id="name">
						</div>
						<div class="input_box">
							<label for="id">사원 번호</label>
							<input type="password" name="id" id="id">							
						</div>
						
						<div class="login_set">
							<input type="submit" value="로그인"> 
							<a	href="list.do">임시 리스트 확인 페이지</a>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
<script src="js/login.js"></script>
</body>
</html>