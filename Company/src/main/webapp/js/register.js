
let selectBox = $("#selectBox");
let regular =  /^[A-Za-z]/;

$('#back').click(function (){
	location.href = "list.do";
});


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


function isNull(num){
	if(num == "" || num == null || num == undefined)
		return true;
	return false;
}


