let check = false;
		let select = 0;
		let where = 1;
		$('#btn').on('click', function() {			
			location.href = '../Company_View/registerUI.jsp';
		});

		$('#select-box').on('change', function() {
			check = true;
			select = Number($(this).val());
		});

		$('#sbtn').on(
				'click',
				function() {
					if (check) {
						check = false;
						let text = $('#search').val();
						console.log(select);
						location.href = '../Company_DAO/CompanySearch.jsp?select=' + select
								+ '&text=' + text+'&where='+where;
					} else {
						let text = $('#search').val();
						location.href = 'CompanyList.jsp?text=' + text;
					}
				});

		$('#search').on(
				'keyup',
				function(e) {
					if (e.keyCode == 13) {
						if (check) {
							check = false;
							let text = $('#search').val();
							console.log(select);
							location.href = '../Company_DAO/CompanySearch.jsp?select='
									+ select + '&text=' + text+'&where='+where;
						} else {
							let text = $('#search').val();
							location.href = 'CompanyList.jsp?text=' + text;
						}
					}
				});