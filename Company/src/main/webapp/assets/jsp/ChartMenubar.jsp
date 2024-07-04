<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="${contextPath}/assets/css/defaultStyle.css">
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${contextPath}/chart.do">ERP 시스템</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="#">대시보드</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${contextPath}/list.do">사원 관리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">부서 관리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">급여 관리</a>
        </li>
      </ul>
    </div>
  </nav>
</body>
</html>