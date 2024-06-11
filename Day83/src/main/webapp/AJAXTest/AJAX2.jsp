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
<title>Insert title here</title>
<script>
	let req = new XMLHttpRequest();
	req.onreadystatechange = function a(){
		console.log(this.readyState, this.status);
		
		if(this.readyState == 4 && this.status == 200){
			console.log(this.response);
		}
	}
	
	req.open("GET","data.txt");
	req.send();
	console.log(req.response);
</script>
</head>
<body>
AJAX
</body>
</html>