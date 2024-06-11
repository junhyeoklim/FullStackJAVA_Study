<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<c:set var="mapTest" value="<%= new HashMap<String,String>() %>"></c:set>
<c:set target="${mapTest}" property="key1" value="value1"/>
<c:set target="${mapTest}" property="key2" value="value2"/>

<c:forEach var="map" items="${mapTest }">
	${map.key }
	${map.value }<br>
</c:forEach>
</body>
</html>