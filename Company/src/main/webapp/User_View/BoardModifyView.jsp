<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:import url="../assets/jsp/bootStrapLink.jsp" />
<link rel="icon" href="${contextPath}/assets/ico/company.ico" />
<link rel="stylesheet" href="${contextPath}/assets/css/defaultStyle.css?after">
<link rel="stylesheet" href="${contextPath}/assets/css/companyList.css?after">
<link rel="stylesheet" href="${contextPath}/assets/css/menubar.css?after">
<script src="${contextPath}/assets/js/jquery.js"></script>
</head>
<body>
<c:import url="/assets/jsp/Menubar.jsp"/>
</body>
</html>