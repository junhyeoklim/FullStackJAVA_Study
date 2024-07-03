<%@page import="company.dto.CompanyDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
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
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:import url="/source/jsp/bootStrapLink.jsp" />
<link rel="icon" href="${contextPath}/source/ico/company.ico" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${contextPath}/source/css/defaultStyle.css?after">
<link rel="stylesheet"
	href="${contextPath}/source/css/companyList.css?after">
<script src="${contextPath}/source/js/jquery.js"></script>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.dto.s_name == 'admin' }">
			<c:import url="/source/jsp/ChartMenubar.jsp" />
			<div class="content-wrapper clearfix">
				<div class="container-fluid board-article">
					<table border="1" id="main">
						<caption>사원 목록</caption>
						<tr>
							<td>부서</td>
							<td>이름</td>
							<td>직급</td>
							<td>이메일</td>
							<td>전화번호</td>
						</tr>
						<c:forEach var="dto" items="${requestScope.list}">
							<tr>
								<td>${dto.s_department}</td>
								<td><a href="${contextPath}/modify.do?s_id=${dto.s_id}">${dto.s_name}</a></td>
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
							<form class="d-flex" method="post"
								action="${contextPath}/search.do">
								<select id="select-box" name="select-box">
									<option disabled selected>선택</option>
									<option value="1">이름</option>
									<option value="2">직급</option>
									<option value="3">부서</option>
								</select> <input type="text" class="form-control me-2"
									placeholder="Search" aria-label="Search" name="search"
									id="search"> <input type="submit"
									class="btn btn-outline-success" id="sbtn" value="검색">
							</form>
						</div>
					</nav>

					<nav class="pagination-wrapper">
						<ul class="pagination justify-content-center">
							<c:if test="${requestScope.pagingInfo.currentPage > 1}">
								<li class="page-item"><a class="page-link"
									href="<c:url value='list.do'>
                                        <c:param name='page' value='1'/>
                                        <c:if test='${not empty requestScope.selectBox}'>
                                            <c:param name='select-box' value='${requestScope.selectBox}'/>
                                        </c:if>
                                        <c:if test='${not empty requestScope.search}'>
                                            <c:param name='search' value='${requestScope.search}'/>
                                        </c:if>
                                    </c:url>">&lt;&lt;</a>
								</li>
								<li class="page-item"><a class="page-link"
									href="<c:url value='list.do'>
                                        <c:param name='page' value='${requestScope.pagingInfo.currentPage - 1}'/>
                                        <c:if test='${not empty requestScope.selectBox}'>
                                            <c:param name='select-box' value='${requestScope.selectBox}'/>
                                        </c:if>
                                        <c:if test='${not empty requestScope.search}'>
                                            <c:param name='search' value='${requestScope.search}'/>
                                        </c:if>
                                    </c:url>">&lt;</a>
								</li>
							</c:if>
							<c:set var="startPage"
								value="${requestScope.pagingInfo.currentPage - 4 > 0 ? requestScope.pagingInfo.currentPage - 4 : 1}" />
							<c:set var="endPage"
								value="${startPage + 9 <= requestScope.pagingInfo.noOfPages ? startPage + 9 : requestScope.pagingInfo.noOfPages}" />
							<c:forEach begin="${startPage}" end="${endPage}" var="i">
								<li
									class="page-item ${requestScope.pagingInfo.currentPage == i ? 'active' : ''}">
									<a class="page-link"
									href="<c:url value='list.do'>
                                        <c:param name='page' value='${i}'/>
                                        <c:if test='${not empty requestScope.selectBox}'>
                                            <c:param name='select-box' value='${requestScope.selectBox}'/>
                                        </c:if>
                                        <c:if test='${not empty requestScope.search}'>
                                            <c:param name='search' value='${requestScope.search}'/>
                                        </c:if>
                                    </c:url>">${i}</a>
								</li>
							</c:forEach>
							<c:if
								test="${requestScope.pagingInfo.currentPage < requestScope.pagingInfo.noOfPages}">
								<li class="page-item"><a class="page-link"
									href="<c:url value='list.do'>
                                        <c:param name='page' value='${requestScope.pagingInfo.currentPage + 1}'/>
                                        <c:if test='${not empty requestScope.selectBox}'>
                                            <c:param name='select-box' value='${requestScope.selectBox}'/>
                                        </c:if>
                                        <c:if test='${not empty requestScope.search}'>
                                            <c:param name='search' value='${requestScope.search}'/>
                                        </c:if>
                                    </c:url>">&gt;</a>
								</li>
								<li class="page-item"><a class="page-link"
									href="<c:url value='list.do'>
                                        <c:param name='page' value='${requestScope.pagingInfo.noOfPages}'/>
                                        <c:if test='${not empty requestScope.selectBox}'>
                                            <c:param name='select-box' value='${requestScope.selectBox}'/>
                                        </c:if>
                                        <c:if test='${not empty requestScope.search}'>
                                            <c:param name='search' value='${requestScope.search}'/>
                                        </c:if>
                                    </c:url>">&gt;&gt;</a>
								</li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<c:redirect url="/login.do" />
		</c:otherwise>
	</c:choose>
	<span id="contextPath" hidden>${contextPath}</span>
	<script src="${contextPath}/source/js/list.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
