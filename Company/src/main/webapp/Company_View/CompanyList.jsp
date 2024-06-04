<%@page import="company.dto.CompanyDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="company.dao.JDBCConnector"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>main</title>
<%@ include file="../source/bootStrapLink.jsp" %>
<link rel="stylesheet" href="css/defaultStyle.css?after">
<link rel="stylesheet" href="css/companyList.css?after">
<script src="js/jquery.js"></script>
</head>
<body>

	<%-- <%@ include file="sessionTest.jsp"%> --%>
	<%@ include file="Menubar.jsp" %>

	<table border="1" id="main">
		<caption>사원 목록</caption>
		<tr>
			<td>부서</td>
			<td>이름</td>
			<td>직급</td>
			<td>이메일</td>
			<td>전화번호</td>
		</tr>
	<c:forEach var="dto" items="${list}" >
		<tr>
			<td>${dto.s_department}</td>
			<td><a href="modify.do?name=${dto.s_name}">${dto.s_name}</a></td>
			<td>${dto.s_rank}</td>
			<td>${dto.s_mail}</td>
			<td>${dto.s_phoneNumber}</td>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="5" id="footer"><input type="button" class="btn btn-outline-secondary" id="btn"
				value="등록"></td>
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
					</select> <input type="text" class="form-control me-2" type="search" placeholder="Search"
							aria-label="Search" name="search" id="search"> <input
						type="submit" class="btn btn-outline-success" id="sbtn" value="검색">				
			</form>
		</div>
	</nav>
	<script src="js/list.js"></script>
</body>
</html>