


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