<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>AJAX ID Check</title>
</head>
<body>
	<form action="register.do" method="post">
		id : <input type="text" name="id" id="id"> 
		<span id="idCheckMsg"></span><br> 
		이름 : <input type="text" name="name">
	</form>
	<script src="js/jquery.js"></script>
	<script>
		$('#id').on('focusout', function(){
			let id = $('#id').val();

			$.ajax({
				url : "../idCheck.do",		// 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
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