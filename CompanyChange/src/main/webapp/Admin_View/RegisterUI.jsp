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
	<div class="container mt-5">
		<div class="card">
			<div class="card-header text-center">
				<h2>사원 정보 입력</h2>
			</div>
			<div class="card-body">
				<form method="post" action="${contextPath}/registerOK.do">
					<div class="form-group">
						<label for="name">이름</label>
						<input type="text" class="form-control" name="name" id="name" required>
					</div>
					<div class="form-group">
						<label for="year">생년월일</label>
						<div class="form-row">
							<div class="col">
								<input type="number" class="form-control" name="year" id="year" placeholder="년(4자리)">
							</div>
							<div class="col">
								<select name="month" id="birth" class="form-control">
									<option selected disabled>월</option>
									<c:forEach var="i" begin="1" end="12" step="1">
										<option value="<fmt:formatNumber value='${i}' pattern='00'/>">
											<fmt:formatNumber value="${i}" pattern="00" />
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="col">
								<input type="number" class="form-control" name="date" id="date" placeholder="일">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label>성별</label>
						<div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="gender" id="male" value="male" required>
								<label class="form-check-label" for="male">남</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="gender" id="female" value="female" required>
								<label class="form-check-label" for="female">여</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="department">부서</label>
						<select id="department" name="department-box" class="form-control">
							<option disabled selected>선택</option>
							<option value="경영">경영</option>
							<option value="인사">인사</option>
							<option value="개발">개발</option>
						</select>
					</div>
					<div class="form-group">
						<label for="rank">직급</label>
						<select name="rank" id="rank" class="form-control">
							<option selected disabled>선택</option>
							<c:set var="list" value="사원,주임,대리,과장,차장,부장" />
							<c:forEach var="rank" items="${list}">
								<option value="${rank}">${rank}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="first">이메일</label>
						<div class="input-group">
							<input type="text" class="form-control" name="first" id="first" required placeholder="이메일 입력">
							<div class="input-group-append">
								<span class="input-group-text">@</span>
							</div>
							<input type="text" name="second" class="form-control cursor" id="second" required readonly>
							<div class="input-group-append">
								<select id="selectBox" class="form-control select-spacing">
									<option selected disabled>선택</option>
									<option value="1">naver.com</option>
									<option value="2">gmail.com</option>
									<option value="3">daum.net</option>
									<option value="4">직접입력</option>
								</select>
							</div>
						</div>
						<div class="error-msg mt-2"></div>
					</div>
					<div class="form-group">
						<label for="phone">전화번호</label>
						<input type="number" class="form-control" name="phone" id="phone" required placeholder="'-'없이 번호만 입력">
					</div>
					<div class="form-group text-center">
						<input type="submit" class="btn btn-primary" value="등록">
						<input type="button" class="btn btn-secondary" id="back" value="취소">
					</div>
				</form>
			</div>
		</div>
	</div>
	<span id="contextPath" hidden>${contextPath}</span>
	<script type="text/javascript" src="${contextPath}/assets/js/register.js"></script>
</body>
</html>
