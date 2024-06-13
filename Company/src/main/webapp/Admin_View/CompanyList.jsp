<%@page import="company.dto.CompanyDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="company.dao.JDBCConnector"%>
<%@page import="java.sql.Connection"%>
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
<c:import url="../source/jsp/bootStrapLink.jsp" />
<link rel="icon" href="../source/ico/company.ico" />
<link rel="stylesheet" href="../source/css/defaultStyle.css?after">
<link rel="stylesheet" href="../source/css/companyList.css?after">
<link rel="stylesheet" href="../source/css/menubar.css?after">
<script src="../source/js/jquery.js"></script>
</head>
<body>

	<c:import url="../source/jsp/Menubar.jsp"/>
	<%-- <c:import url="../source/jsp/Menubar.jsp"/> --%>

	<%-- <c:choose>
	<c:when test="${sessionScope.dto.s_name == 'admin' }"> --%>
	<%-- <c:import url="../source/sessionTest.jsp" /> --%>
	<div class="content-wrapper clearfix">
		<div class="containe-fluid board-article">
			<table border="1" id="main">
				<caption>사원 목록</caption>
				<tr>
					<td>부서</td>
					<td>이름</td>
					<td>직급</td>
					<td>이메일</td>
					<td>전화번호</td>
				</tr>
				<c:forEach var="dto" items="${list}">
					<tr>
						<td>${dto.s_department}</td>
						<td><a href="modify.do?name=${dto.s_name}">${dto.s_name}</a></td>
						<td>${dto.s_rank}</td>
						<td>${dto.s_mail}</td>
						<td>${dto.s_phoneNumber}</td>
					</tr>
				</c:forEach>

				<tr>
					<td colspan="5" id="footer"><input type="button"
						class="btn btn-outline-secondary" id="btn" value="등록"></td>
				</tr>
			</table>
			<nav class="navbar navbar-light bg-white" id="listsearch">
				<div class="container-fluid">
					<form class="d-flex" method="post" action="search.do">
						<select id="select-box" name="select-box">
							<option disabled selected>선택</option>
							<option value="1">이름</option>
							<option value="2">직급</option>
							<option value="3">부서</option>
						</select> <input type="text" class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search" name="search"
							id="search"> <input type="submit"
							class="btn btn-outline-success" id="sbtn" value="검색">
					</form>
				</div>
			</nav>

			<!-- 페이징 기능 JSTL로 바꾸기 -->
			<nav class="pagination-wrapper">
				<ul class="pagination justify-content-center">
					<!-- 특정 페이지 넘어가면 보일 이전 부분 -->
					<li class="page-item"><a class="page-link" href="#"
						title="최신글 보기"><span class="ion-chevron-left"> << </span></a></li>
					<li class="page-item"><a class="page-link" href="#"><span
							class="ion-chevron-left"><</span></a></li>

					<!-- 일반적으로 보이는 페이지 부분 -->
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>


					<!-- 끝 페이지로 넘어가면 사라질 부분  -->
					<li class="page-item"><a class="page-link" href="#"><span
							class="ion-chevron-right">></span></a></li>
					<li class="page-item"><a class="page-link" href="#"
						title="첫 글 보기"><span class="ion-chevron-right">>></span></a></li>
				</ul>
			</nav>
		</div>
	</div>
	<%-- 	</c:when>
	<c:otherwise>
		<c:redirect url="login.do"></c:redirect>
	</c:otherwise>
	</c:choose> --%>
	<script src="../source/js/list.js"></script>
</body>
</html>