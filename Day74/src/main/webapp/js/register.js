let result = [];
let selectBox = $("#selectBox");
let flag = false;

selectBox.on("change",function () {
    let check = Number($(this).val())
    flag = true;
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
         $("#second").val("").focus();
            break;
    }          
});

$('#btn').on('click',function(){
	console.log("test");
	console.log($("#second").val());
	if(flag){
		let name = $('#name').val();
		let department = $('#department').val();
		let rank = $('#rank').val();
		let mail = $('#first').val().concat("@"+$('#second').val());		
		let phone = $('#phone').val();
		
		location.href = '../Company_DAO/CompanyInsert.jsp?name='+name
		+"&department="+department
		+"&rank="+rank
		+"&mail="+mail
		+"&phone="+phone;
	}
});