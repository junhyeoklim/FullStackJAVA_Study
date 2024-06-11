<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL TEST 1</title>
</head>
<body>
	<!-- 기본 태그로 "Hello" 출력 -->
	<c:out value="Hello"/><br>
	<!-- 기본 태그로 username 이라는 변수를 선언하고 값을 "홍길동"을 준다. 저장영역은 session -->
	<c:set var="username" value="홍길동" scope="session"/><br>
	<!-- 기본 태그로 username을 출력한다. -->
	<c:out value="${sessionScope.username }"/>
	<hr>
	username 값을 슈퍼맨으로 변경<br>
	<!-- username의 값을 슈퍼맨으로 변경. 그리고 username 출력 -->
	<c:set var="username" value="슈퍼맨"/>
	<c:out value="${username }"/>
	<hr>
	username 제거
	<!-- 기본 태그로 username을 제거한다.그리고 username 출력 -->
	<c:remove var="username"/>
	${username }
</body>
</html>