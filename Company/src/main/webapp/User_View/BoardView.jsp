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
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="icon" href="${contextPath}/source/ico/company.ico" />
<link rel="stylesheet" href="${contextPath}/source/css/defaultStyle.css?after">
<title>Insert title here</title>
</head>
<body>
<c:import url="../source/jsp/Menubar.jsp" />
	<c:out value="여긴 게시판 보는 곳!"></c:out>
</body>
</html>