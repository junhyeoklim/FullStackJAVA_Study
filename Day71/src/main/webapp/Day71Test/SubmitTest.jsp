<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<script src="../js/jquery.js"></script>
<script>
	$(function (){
		$('#stn').on('click',function(){
			let name = $('#name').val();
			
			if(check(name)){
				alert('이름을 입력 하세요!');
				history.back();
			}
			else
				location.href = 'SubmitTestOK.jsp?name='+name;
		});
		
		
		function check(name){
            if (name === null) return true; 
            if (typeof name === 'string' && name === '') return true;
            if (typeof name === 'undefined') return true;
            
            return false;
		}
	})
</script>
</head>
<body>
	<label for="name">이름</label>
	<input type="text" name="name" id="name">
	<input type="submit" id="stn">
</body>
</html>