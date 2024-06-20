
/*input이 focus 되면 label값 제거*/
$('#name,#id').on("focus",function(){
	console.log("test");
	if($(this).attr('id') == 'name'){
		$('#nameLabel').text("");
	}
	else
		$('#idLabel').text("");
});


function check(){
	let id = $('#id');
	let name = $('#name')
	if(isNull(id.val()) || isNull(name.val())){
		alert("이름 또는 번호를 입력 해주세요!");
		id.val("");
		name.val("");
		name.focus();
		return false;
	}
	else
		return true;
}




function isNull(num){
	if(num == null || num == "" || num == undefined)
		return true;
	return false;
		
}