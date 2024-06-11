<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="icon" href="source/company.ico" />
<link rel="stylesheet" href="source/css/login.css?after">
<script src="source/js/jquery.js"></script>
</head>
<body>
	<div id="login" class="login_wrap">
		<div class="log_inr">
			<form method="post" action="loginOK.do" onsubmit="return check()" >
				<fieldset>
					<div class="login_inp">
						<div class="input_box">
							<label for="name" class="lab_login"></label>
							<input type="text" name="name" id="name" class="inp_txt" placeholder="이름">
						</div>
						<div class="input_box">
							<label for="id" class="lab_login"></label>
							<input type="password" name="id" id="id" class="inp_txt" placeholder="사원 번호">			
						</div>
						
						<div class="login_set">
							<input type="submit" value="로그인" class="btn_inout login">
							<div class="a_container"><a	href="/Company/Admin_View/list.do">임시 리스트 확인 페이지</a></div> 
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
<script src="source/js/login.js"></script>
</body>
</html>