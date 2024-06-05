<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL Test14</title>
</head>
<body>
	<!-- Map 선언 -->
	<c:set var="mapTest" value="<%=new HashMap<String, String>()%>" />
	
	<!--  
		기본태그(core)로 Map에 값 넣기
		mapTest에 키에 key1, 값에 value1을 넣는다.
		mapTest에 키에 key2, 값에 value2를 넣는다.
	-->
	
	<!-- mapTest의 키가 key1인것의 값을 출력하자. -->

	<!-- mapTest의 키가 key2인것의 값을 출력하자. -->

	<!-- 기본태그(core)의 반복문으로 mapTest의 키와 값을 출력하자. -->

</body>
</html>