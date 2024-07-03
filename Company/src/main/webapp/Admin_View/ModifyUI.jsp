<%@page import="company.dto.CompanyDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>사원정보 변경</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:import url="../source/jsp/bootStrapLink.jsp" />
<link rel="icon" href="${contextPath}/source/ico/company.ico" />
<link rel="stylesheet"
	href="${contextPath}/source/css/defaultStyle.css?after">
<link rel="stylesheet" href="${contextPath}/source/css/modify.css?after">
<link rel="stylesheet"
	href="${contextPath}/source/css/menubar.css?after">
<script type="text/javascript" src="${contextPath}/source/js/jquery.js"></script>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.dto.s_name == 'admin' }">
			<c:import url="/source/jsp/ChartMenubar.jsp" />
			<c:forEach var="dto" items="${list}">
				<form method="post" action="${contextPath}/modifyOK.do">
					<table border="1" id="modify">
						<caption>사원정보변경</caption>
						<tr>
							<td><label for="name">이름</label></td>
							<td><input type="text" name="name" id="name" required
								value="${dto.s_name}"></td>
						</tr>
						<tr>
							<td><label>생년월일</label></td>
							<td><input type="number" name="year" id="year"
								value="${fn:substring(dto.s_birth,0,4)}"> <select
								name="month" id="birth">
									<option selected disabled>선택</option>
									<c:forEach var="i" begin="1" end="12" step="1">
										<c:set var="month" value="${i}" />
										<option value="${month}"
											<c:if test="${fn:substring(dto.s_birth, 4, 6) == month}">selected</c:if>>
											<c:choose>
												<c:when test="${i <10}">
											0${month}
										</c:when>
												<c:otherwise>
											${month}
										</c:otherwise>
											</c:choose>
										</option>
									</c:forEach>
							</select> <input type="number" name="date" id="date"
								value="${fn:substring(dto.s_birth,6,8)}"></td>
						</tr>
						<tr>
							<td>성별</td>
							<td><input type="radio" name="gender" id="male" value="male"
								disabled <c:if test="${dto.s_gender == 'male'}"> checked </c:if>>남
								<input type="radio" name="gender" id="female" value="female"
								disabled
								<c:if test="${dto.s_gender == 'female'}"> checked </c:if>>여
							</td>
						</tr>
						<tr>
							<td><label>부서</label></td>
							<td><select id="select-box" name="dpartment-box">
									<option disabled selected>선택</option>
									<option value="경영"
										<c:if test="${dto.s_department == '경영'}"> selected </c:if>>경영</option>
									<option value="인사"
										<c:if test="${dto.s_department == '인사'}"> selected </c:if>>인사</option>
									<option value="개발"
										<c:if test="${dto.s_department == '개발'}"> selected </c:if>>개발</option>
							</select></td>
						</tr>
						<tr>
							<td>직급</td>
							<td><select name="rank">
									<option selected disabled>선택</option>
									<c:set var="list" value="사원,주임,대리,과장,차장,부장" />
									<c:forEach var="rank" items="${list}">
										<option value="${rank}"
											<c:if test="${rank == dto.s_rank }">selected</c:if>>${rank }</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td><label for="email">이메일</label></td>
							<td>
								<div class="container">
									<div class="mail">
										<input type="email" name="email" id="email" required
											value="${dto.s_mail}">
									</div>
								</div>
							</td>

						</tr>

						<tr>
							<td><label for="phone">전화번호</label></td>
							<td colspan="2"><input type="number" name="phone" id="phone"
								required value="${dto.s_phoneNumber}"></td>
						</tr>

						<tr>
							<td colspan="2" id="footer"><input type="submit" id="btn"
								value="등록"> <input type="button" id="back" value="취소"></td>
						</tr>
					</table>
					<input type="number" name="id" value="${dto.s_id }" hidden/>
				</form>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<c:redirect url="/login.do"/>
		</c:otherwise>
	</c:choose>
	<span id="contextPath" hidden>${contextPath}</span>
	<script type="text/javascript" src="${contextPath}/source/js/register.js"></script>
</body>
</html>