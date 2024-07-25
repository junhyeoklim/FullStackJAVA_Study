<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="memberRegister.do">
		<table>
			<tr>
				<td><label for="id">아이디</label></td><td><input type="text" name="id" id="id"/><span id="idCheckMsg"></span>
			</tr>
			<tr>
				<td><label for="password">비밀번호</label></td><td><input type="password" name="password" id="password"/>
			</tr>
			<tr>
				<td><label for="name">이름</label></td><td><input type="text" name="name" id="name"/>
			</tr>
			<tr>
				<td><label for="role">Role</label></td><td><input type="text" name="role" id="role"/>
			</tr>
		</table>
	</form>
	
	<script src="js/jquery-3.6.0.min.js"></script>
	<script>
		$('#id').on('focusout', function(){
			let id = $('#id').val();

			$.ajax({
				url : "idCheck.do",		// 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
				type:  "post",			// HTTP 요청방식 (get/post)
				data: {"id": id},			// HTTP 요청과 함께 서버로 보낼 데이터
				dataType: 'text',		// 서버에서 보내줄 데이터의 타입
				// 성공적으로 값을 서버로 보냈을 경우 처리하는 코드
				success: function(result){
					if(result == 0){
						$("#idCheckMsg").html('사용할 수 없는 아이디 입니다.');
					} else{
						$("#idCheckMsg").html('사용할 수 있는 아이디 입니다.');
					}
				},
				error:function(){
					alert("서버요청실패");
				}
			})
		})
	</script>	
</body>
</html>