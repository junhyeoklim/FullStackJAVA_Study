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
		color : black;
	}
	.word{
		color: gray;
	}	
</style>
<script>
	var req = new XMLHttpRequest();
	
	req.onreadystatechange = function a(){
		console.log(this.readyState, this.status);
		if(this.readyState == 4 && this.status == 200){
			console.log(this.response);
			var data = JSON.parse(this.response);
			for(var i in data){
				var t = document.querySelector(".template").cloneNode(true);
				// 자식 노드 역시 복제가 필요한 경우라면 true를 사용합니다. 
				// 기본값은 false로 자식 노드는 복사하지 않습니다.
				// class template 의 자식노드까지 복사
				//t.removeAttribute("id");
				t.children[0].innerText = data[i].id;
				t.children[1].innerText = data[i].msg;
				document.body.appendChild(t);
			}
		}
	}
	
	req.open("get", "../msg.do");
	req.send();
</script>
</head>
<body>
	<p class="template">
		<span class="character">주인공</span> : <span class="word">명대사</span>
	</p>
</body>
</html>