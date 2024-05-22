<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="../js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		let pwd = $('#pwd').val();


		$('#pwd').on('keyup',function(){
			let value = $(this).val();
			console.log();
			if(!isNum(pwd) && value.length < 1 || value.length > 10){
				console.log('dd');
				$('#check').text('incorrect password');
			}
			else if(isNum(pwd) || value >= 1 || value <= 10)
				$('#check').text('');
			else
				$('#check').text('good');
		});
		
		
		function isNum(value){
	        if (value === null) return true; 
	        if (typeof value === 'string' && value === '') return true;
	        if (typeof value === 'undefined') return true;
	        if (isNaN(value)) return true;
	        return false;
		}
		
	})
	
</script>
</head>
<body>
	<label for="pwd">PASSWORD : </label>
	<input type="password" name="pwd" id="pwd">
	<input type="submit" id="submit" value="제출">
	<p id="check"></p>
</body>
</html>