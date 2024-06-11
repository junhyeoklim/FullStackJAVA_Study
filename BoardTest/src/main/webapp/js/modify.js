	$('#year,#date').on('input',function(){
		console.log(typeof $(this).attr('id'))
		if($(this).attr('id') == 'year'){
			if($(this).val()>3)
				$(this).val($(this).val().substring(0,4))
		}
		else{
			if($(this).val()>2)
				$(this).val($(this).val().substring(0,2))
		}
	});