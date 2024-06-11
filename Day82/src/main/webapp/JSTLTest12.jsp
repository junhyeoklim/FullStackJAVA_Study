<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL Test12</title>
</head>
<body>
	<!--
		기본태그(core)의 url로 다음과 같은 태그를 만들자.
		그리고  JSTLTest12_1.jsp에서 넘어간 값을 출력하자.
		JSTLTest12_1.jsp?v1=20&v2=30&op=1
	-->
	<c:url var="calcUrl" value="JSTLTest12_1.jsp?v1=20&v2=30&op=1"></c:url>
	<a href="${calcUrl}">계산하기</a>
</body>
</html>