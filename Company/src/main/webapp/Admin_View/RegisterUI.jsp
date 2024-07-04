<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>사원등록</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:import url="/assets/jsp/bootStrapLink.jsp" />
<link rel="icon" href="${contextPath}/assets/ico/company.ico" />
<link rel="stylesheet" href="${contextPath}/assets/css/defaultStyle.css?after">
<link rel="stylesheet" href="${contextPath}/assets/css/register.css?after">
<link rel="stylesheet" href="${contextPath}/assets/css/menubar.css?after">
<script type="text/javascript" src="${contextPath}/assets/js/jquery.js"></script>
</head>
<body>
	<c:import url="/assets/jsp/ChartMenubar.jsp"/>
	<form method="post" action="${contextPath}/registerOK.do">
		<table border="1" id="register">
			<caption>사원 정보 입력</caption>
			<tr>
				<td><label for="name">이름</label></td>
				<td><input type="text" class="form-control" name="name" id="name" required></td>
			</tr>
			<tr>
				<td><label for="year">생년월일</label></td>
				<td><input type="number" class="form-control" name="year" id="year"> <select
					name="month" id="birth">
						<option selected disabled>선택</option>
						<c:forEach var="i" begin="1" end="12" step="1">
							<option value="<fmt:formatNumber value='${i}' pattern='00'/>">
								<fmt:formatNumber value="${i}" pattern="00" />
							</option>
						</c:forEach>
				</select> <input type="number" class="form-control" name="date" id="date"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" name="gender" id="male" value="male"
					required><label for="male">남</label> <input type="radio"
					name="gender" id="female" value="female" required><label
					for="female">여</label></td>
			</tr>
			<tr>
				<td><label>부서</label></td>
				<td><select id="select-box" name="dpartment-box">
						<option disabled selected>선택</option>
						<option value="경영">경영</option>
						<option value="인사">인사</option>
						<option value="개발">개발</option>
				</select></td>
			</tr>

			<tr>
				<td>직급</td>
				<td><select name="rank">
						<option selected disabled>선택</option>
						<c:set var="list" value="사원,주임,대리,과장,차장,부장" />
						<c:forEach var="rank" items="${list}">
							<option value="${rank }">${rank }</option>
						</c:forEach>
				</select></td>
			</tr>


			<tr>
				<td><label for="first">이메일</label></td>
				<td>
					<div class="container">
						<div class="mail">
							<input type="text" class="form-control" name="first" id="first" required
								placeholder="이메일 입력"> @ <input type="text" name="second"
								class="form-control cursor" id="second" required readonly> <select
								id="selectBox">
								<option selected disabled>선택</option>
								<option value="1">naver.com</option>
								<option value="2">gmail.com</option>
								<option value="3">daum.net</option>
								<option value="4">직접입력</option>
							</select>
						</div>
					</div>
					<div class="error-msg"></div>
				</td>

			</tr>

			<tr>
				<td><label for="phone">전화번호</label></td>
				<td colspan="2"><input type="number" class="form-control" name="phone" id="phone"
					required placeholder="'-'없이 번호만 입력"></td>
			</tr>

			<tr>
				<td colspan="2" id="footer"><input type="submit" id="btn"
					value="등록"> <input type="button" id="back" value="취소"></td>
			</tr>
		</table>
	</form>
	<span id="contextPath" hidden>${contextPath}</span>
	<script type="text/javascript" src="${contextPath}/assets/js/register.js"></script>
</body>
</html>