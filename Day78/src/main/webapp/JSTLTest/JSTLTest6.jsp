<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL Test6</title>
</head>
<body>
	<% pageContext.setAttribute("nameList", new String[] {"홍길동", "임꺽정", "일지매", "주먹대장", "똘이장군"}); %>
	<!-- 
		다음과 같이 실행결과가 나오게 하시오.
		실행결과
		● 일지매
		● 주먹대장	
	 -->
	 
</body>
</html>