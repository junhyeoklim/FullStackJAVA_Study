<%@ page import="company.dto.CompanyDTO"%>
<%@ page import="java.util.ArrayList"%>
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
<c:import url="../assets/jsp/bootStrapLink.jsp" />
<link rel="icon" href="${contextPath}/assets/ico/company.ico" />
<link rel="stylesheet" href="${contextPath}/assets/css/defaultStyle.css?after">
<link rel="stylesheet" href="${contextPath}/assets/css/modify.css?after">
<link rel="stylesheet" href="${contextPath}/assets/css/menubar.css?after">
<script type="text/javascript" src="${contextPath}/assets/js/jquery.js"></script>
</head>
<body>
    <c:choose>
        <c:when test="${sessionScope.dto.s_name == 'admin' }">
            <c:import url="/assets/jsp/ChartMenubar.jsp" />
            <div class="container mt-5">
                <h2 class="text-center mb-4">사원 정보 변경</h2>
                <c:forEach var="dto" items="${list}">
                    <form method="post" action="${contextPath}/modifyOK.do">
                        <div class="card">
                            <div class="card-body">
                                <div class="form-group">
                                    <label for="name">이름</label>
                                    <input type="text" class="form-control" name="name" id="name" required value="${dto.s_name}">
                                </div>
                                <div class="form-group">
                                    <label>생년월일</label>
                                    <div class="form-row">
                                        <div class="col">
                                            <input type="number" class="form-control" name="year" id="year" value="${fn:substring(dto.s_birth,0,4)}" placeholder="년(4자리)">
                                        </div>
                                        <div class="col">
                                            <select name="month" id="birth" class="form-control">
                                                <option selected disabled>월</option>
                                                <c:forEach var="i" begin="1" end="12" step="1">
                                                    <c:set var="month" value="${i}" />
                                                    <option value="${month}"
                                                        <c:if test="${fn:substring(dto.s_birth, 4, 6) == month}">selected</c:if>>
                                                        <c:choose>
                                                            <c:when test="${i <10}">0${month}</c:when>
                                                            <c:otherwise>${month}</c:otherwise>
                                                        </c:choose>
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col">
                                            <input type="number" class="form-control" name="date" id="date" value="${fn:substring(dto.s_birth,6,8)}" placeholder="일">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>성별</label>
                                    <div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gender" id="male" value="male" disabled <c:if test="${dto.s_gender == 'male'}">checked</c:if>>
                                            <label class="form-check-label" for="male">남</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gender" id="female" value="female" disabled <c:if test="${dto.s_gender == 'female'}">checked</c:if>>
                                            <label class="form-check-label" for="female">여</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>부서</label>
                                    <select id="department-box" name="department-box" class="form-control">
                                        <option disabled selected>선택</option>
                                        <option value="경영" <c:if test="${dto.s_department == '경영'}">selected</c:if>>경영</option>
                                        <option value="인사" <c:if test="${dto.s_department == '인사'}">selected</c:if>>인사</option>
                                        <option value="개발" <c:if test="${dto.s_department == '개발'}">selected</c:if>>개발</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>직급</label>
                                    <select name="rank" class="form-control">
                                        <option selected disabled>선택</option>
                                        <c:set var="list" value="사원,주임,대리,과장,차장,부장" />
                                        <c:forEach var="rank" items="${list}">
                                            <option value="${rank}" <c:if test="${rank == dto.s_rank}">selected</c:if>>${rank}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="email">이메일</label>
                                    <input type="email" class="form-control" name="email" id="email" required value="${dto.s_mail}">
                                </div>
                                <div class="form-group">
                                    <label for="phone">전화번호</label>
                                    <input type="number" class="form-control" name="phone" id="phone" required value="${dto.s_phoneNumber}">
                                </div>
                                <input type="number" name="id" value="${dto.s_id}" hidden/>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary">등록</button>
                                    <button type="button" class="btn btn-secondary" id="back">취소</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <c:redirect url="/login.do"/>
        </c:otherwise>
    </c:choose>
    <span id="contextPath" hidden>${contextPath}</span>
    <script type="text/javascript" src="${contextPath}/assets/js/register.js"></script>
</body>
</html>
