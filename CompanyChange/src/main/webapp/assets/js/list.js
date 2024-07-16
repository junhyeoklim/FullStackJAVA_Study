
let contextPath = $('#contextPath').text();
$('#search').on(
				'keyup',
				function(e) {
					if (e.keyCode == 13) {
						location.href = contextPath+"/search.do";
					}
	});
	
$('#btn').on('click',()=>{
		location.href = contextPath+"/register.do";
});