<%@ page import="com.springbook.biz.salary.CompanyVO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>사원 목록</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:import url="/assets/jsp/bootStrapLink.jsp" />
<link rel="icon" href="${contextPath}/assets/ico/company.ico" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="${contextPath}/assets/css/defaultStyle.css?after">
<link rel="stylesheet" href="${contextPath}/assets/css/companyList.css?after">
<script src="${contextPath}/assets/js/jquery.js"></script>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.vo.s_name == 'admin' }">
			<c:import url="/assets/jsp/ChartMenubar.jsp" />
			<div class="container mt-5">
				<h2 class="text-center mb-4">사원 목록</h2>
				<div class="card mb-4">
					<div class="card-header">
						<form class="form-inline" method="post" action="${contextPath}/companyList.do">
							<div class="form-group mr-3">
								<label for="select-box" class="mr-2">검색</label>
								<select id="select-box" name="select-box" class="form-control">
									<option disabled selected>선택</option>
									<option value="1">이름</option>
									<option value="2">직급</option>
									<option value="3">부서</option>
								</select>
							</div>
							<div class="form-group mr-3">
								<input type="text" class="form-control" placeholder="Search" aria-label="Search" name="search" id="search">
							</div>
							<button type="submit" class="btn btn-outline-success">검색</button>
						</form>
					</div>
				</div>
				<div class="row">
					<c:forEach var="vo" items="${requestScope.list}">
						<div class="col-md-4 mb-4">
							<div class="card h-100">
								<div class="card-body">
									<h5 class="card-title">${vo.s_name}</h5>
									<p class="card-text">
										<strong>부서:</strong> ${vo.s_department}<br>
										<strong>직급:</strong> ${vo.s_rank}<br>
										<strong>이메일:</strong> ${vo.s_mail}<br>
										<strong>전화번호:</strong> ${vo.s_phoneNumber}
									</p>
								</div>
								<div class="card-footer text-center">
									<a href="${contextPath}/modify.do?s_id=${vo.s_id}" class="btn btn-primary">수정</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="text-center">
					<a href="${contextPath}/register.do" class="btn btn-outline-secondary">등록</a>
				</div>
				<c:import url="/assets/jsp/companyPagination.jsp"/>
			</div>
		</c:when>
		<c:otherwise>
			<c:redirect url="/login.do" />
		</c:otherwise>
	</c:choose>
	<span id="contextPath" hidden>${contextPath}</span>
	<script src="${contextPath}/assets/js/list.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
