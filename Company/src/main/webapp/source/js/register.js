
let selectBox = $("#selectBox");
let regular =  /^[A-Za-z]/;
let contextPath = $('#contextPath').text();
/*취소 버튼을 눌렀을 경우 뒤로 가는 기능*/
$('#back').click(function (){
	location.href = contextPath+"/list.do";
});


/*이메일 입력시 영문을 제외한 입력이 들어왔을때 보여줄 경고문구*/
$('#first,#second').on('input',function (){
	if(Number(selectBox.val()) == 4){
		if(regular.test($(this).val()) || isNull($(this).val()))
			$('.error-msg').text('');
		else
			$('.error-msg').text('영문으로 입력 해주세요');
	}
	else{
		if(regular.test($('#first').val()) || isNull($(this).val()))
			$('.error-msg').text('');
		else if(!regular.test($('#first').val()) && !isNull($(this).val()))
			$('.error-msg').text('영문으로 입력 해주세요');
			
	}
		
	
});

/*이메일 뒷 부분 */
selectBox.on("change",function () {
    let check = Number($(this).val())
    
	$("#second").attr("readonly",true);	
	$("#second").addClass('cursor');
	
    switch (check) {
        case 1:		 
         $("#second").val("naver.com");
            break;    
        case 2:		 
         $("#second").val("gmail.com");  
            break;
        case 3:		 
         $("#second").val("daum.com");
            break;
        case 4:
		 $("#second").attr("readonly",false);
		 $("#second").removeClass('cursor');
         $("#second").val("").focus();
            break;
    }          
});

/*휴대폰 번호,나이,생년월일 입력 자리수 제한*/
$('#age ,#phone,#year,#date').on('input',function(){
		console.log(typeof $(this).attr('id'))
		if($(this).attr('id') == 'age'){
			if($(this).val()>3)
				$(this).val($(this).val().substring(0,3))
		}
		else if($(this).attr('id') == 'year'){
				if($(this).val()>3)
					$(this).val($(this).val().substring(0,4))
		}
		else if($(this).attr('id') == 'date'){
			if($(this).val()>2)
				$(this).val($(this).val().substring(0,2))
		}
		else{
			if($(this).val()>11)
				$(this).val($(this).val().substring(0,11))
		}
	});




/*Null 값 체크*/
function isNull(num){
	if(num == "" || num == null || num == undefined)
		return true;
	return false;
}


