<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:import url="../source/jsp/bootStrapLink.jsp" />
<link rel="icon" href="${contextPath}/source/ico/company.ico" />
<link rel="stylesheet" href="${contextPath}/source/css/defaultStyle.css?after">
<link rel="stylesheet" href="${contextPath}/source/css/companyList.css?after">
<link rel="stylesheet" href="${contextPath}/source/css/menubar.css?after">
<script src="${contextPath}/source/js/jquery.js"></script>
</head>
<body>
<c:import url="../source/jsp/Menubar.jsp"/>
</body>
</html>