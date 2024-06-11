<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
	.character{
		color: black;
	}
	
	.word{
		color: gray;
	}
</style>
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$.ajax({
			url : "../msg.do",
			type : "post",
			dataType : "json",
			success : function(data){
				for(let i in data){
					let t = document.querySelector(".template").cloneNode(true);
					
					t.children[0].innerText = data[i].id;
					t.children[1].innerText = data[i].msg;
					document.body.appendChild(t);
				}
			},
			error : function(){
				alert("서버요청실패");
			}
		});
	});
</script>
</head>
<body>
	<p class="template">
		<span class="character">주인공</span> : <span class="word">명대사</span>
	</p>
</body>
</html>