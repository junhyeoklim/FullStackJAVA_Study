let selectBox = $("#selectBox");
let regular =  /^[A-Za-z]/;

$('#first,#second').on('keyup',function (){
	console.log($(this).val());
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
         $("#second").val("").focus();
            break;
    }          
});


function isNull(num){
	if(num == "" || num == null || num == undefined)
		return true;
	return false;
}
