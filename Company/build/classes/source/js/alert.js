		let uname = $('#uname');		
		
		if(!isNull(uname.text()) && uname.text() == 'admin'){
			alert("관리자 모드로 진입 하였습니다!");			
			/*location.href = "../Admin_View/list.do";*/
			location.href = "../User_View/BoardListView.jsp";
		}
		else if(!isNull(uname.text())){
			alert("로그인에 성공하였습니다!");
			location.href = "../User_View/BoardListView.jsp";
		}
		else if(isNull(uname.text())){
			alert("이름 또는 사원 번호가 틀렸습니다.");
			console.log(uname.text());			
			location.href = '../login.do';
		}
		
		function isNull(num){
			if(num == null || num == "" || num == undefined)
				return true;
			return false;
		}