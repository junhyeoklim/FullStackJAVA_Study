let selectBox = $("#selectBox");

selectBox.on("change",function () {
    let check = Number($(this).val())

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

