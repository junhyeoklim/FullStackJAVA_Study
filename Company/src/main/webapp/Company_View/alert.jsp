<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="../js/jquery.js"></script>
<script>
	$(function () {
		let flag = $('#flag').text();		
		
		if(flag == "true"){			
			alert("어서오세요!");
			location.href = "list.do";
		}
		else{
			alert("사원 이름이 존재하지 않습니다!");			
			location.href = 'loginUI.jsp';
		}
		
	})
</script>
</head>
<body>
	<% String flag = request.getParameter("flag"); %>
	<span id="flag" hidden><%= flag %></span>
</body>
</html>