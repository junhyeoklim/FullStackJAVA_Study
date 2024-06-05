		function blankCheck() {
			let id = document.getElementById('id').value;
			let pwd = document.getElementById('pwd').value;

			if (id == null || id == "" || pwd == null || pwd == "") {
				alert("아이디 또는 비밀번호를 입력 하세요!");
				return false;
			} else
				return true
		}