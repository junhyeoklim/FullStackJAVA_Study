<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="${contextPath}/assets/js/jquery.js"></script>
</head>
<body>	
	<span id="uname" hidden>${sessionScope.dto.s_name}</span>
	<span id="update" hidden></span>
	<span id="contextPath" hidden>${contextPath}</span>
	<script src="${contextPath}/assets/js/alert.js"></script>
</body>
</html>