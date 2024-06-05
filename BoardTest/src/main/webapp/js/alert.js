		let id = $('#id');
		let register = $('#check');
		
		if(isNull(id.text()) && isNull(register.text())){
			console.log(id.text());
			alert("아이디 또는 비밀번호를 확인 해주세요!");
			id.text("");
			location.href = "login.do";
		}
		else if(isNull(id.text()) && register.text() == 'ok'){
			alert("회원가입이 완료되었습니다!");
			register.text("");
			location.href = "login.do";
		}
		else if(!isNull(id.text())){
			id.text("");
			location.href = "Login.jsp";
		}

		

			
		
		function isNull(num){
			if(num === null || num ==="" || num === undefined)
				return true;
			return false
		}