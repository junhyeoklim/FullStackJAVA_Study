	$('#cpwd').on('keyup',errorMessage);

	function errorMessage(){
		let pwd = $('#pwd');

		if(!isNull($(this).val()) && pwd.val() != $(this).val()){
			$('.error-msg').text("비밀번호가 일치하지 않습니다.");
		}
		else if(pwd.val() == $(this).val() || isNull($(this).val()))
			$('.error-msg').text("");
		
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
	
	