$('#search').on(
				'keyup',
				function(e) {
					if (e.keyCode == 13) {
						location.href = "search.do";
					}
	});
	
$('#btn').on('click',()=>{
		location.href = "register.do";
});