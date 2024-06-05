<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL Test10</title>
</head>
<body>
	<!-- 
		0부터 3까지 2씩 증가하면서 출력하자.
		
		실행결과 :		
		0
		2				 
	-->
	<c:set var="sum"></c:set>
	<c:forEach var="no" begin="0" end="3" step="2">
		${sum += no}<br>
	</c:forEach>
</body>
</html>