	$('#cpwd').on('input',errorMessage);
	
	$('#year,#date').on('input',function(){
		console.log(typeof $(this).attr('id'))
		if($(this).attr('id') == 'year'){
			if($(this).val()>3)
				$(this).val($(this).val().substring(0,4))
		}
		else{
			if($(this).val()>2)
				$(this).val($(this).val().substring(0,2))
		}
	});


	
	function errorMessage(){
		
		let pwd = $('#pwd');
		console.log(pwd.val());
		console.log(pwd.val() != $(this).val());
		if(!isNull($(this).val()) && pwd.val() != $(this).val()){
			$('#msg').removeClass('success-msg');
			$('#msg').addClass('error-msg');
			$('#msg').text("비밀번호가 일치하지 않습니다.");
		}		
		else if(pwd.val() == $(this).val()){
			$('#msg').removeClass('error-msg');
			$('#msg').addClass('success-msg');
			$('#msg').text("비밀번호가 일치합니다.");
		}
		else if(isNull($(this).val()))
			$('#msg').text("");
		
	}
	
	function isNull(num){
		if(num == null || num == "" || num == undefined)
				return true;
		return false;
	}

	
	function passCheck(){
		let pwd = $('#pwd');
		let cpwd = $('#cpwd');
		
		if(pwd.val() != cpwd.val()){
			alert("비밀번호 확인");					
			cpwd.val("");
			$('.error-msg').text("");
			cpwd.focus();
			return false
		}
		else
			return true
	}
	
	