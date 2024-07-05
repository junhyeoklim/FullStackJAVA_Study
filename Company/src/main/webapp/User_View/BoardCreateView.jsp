<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<meta charset="UTF-8">
<title>게시글 작성</title>
<c:import url="../assets/jsp/bootStrapLink.jsp" />
<link rel="icon" href="${contextPath}/assets/ico/company.ico" />
<link rel="stylesheet"
	href="${contextPath}/assets/css/boardcreateView.css?after">
<link rel="stylesheet"
	href="${contextPath}/assets/css/defaultStyle.css?after">
<link rel="stylesheet"
	href="${contextPath}/assets/css/companyList.css?after">
<link rel="stylesheet"
	href="${contextPath}/assets/css/menubar.css?after">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/summernote-bs4.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/summernote-bs4.css"
	rel="stylesheet">
<script src="${contextPath}/assets/js/boardcreateView.js"></script>
</head>
<body>
	<c:choose>
		<c:when test="${not empty sessionScope.dto}">
			<c:import url="/assets/jsp/Menubar.jsp" />
			<section class="container">
				<div class="WritingWrap">
					<div class="WritingHeader">
						<h2 class="title">게시글 작성</h2>
					</div>
					<div class="WritingContent">
						<div class="WritingEditor">
							<div class="editer_wrap">
								<div class="ArticleWritingTitle">
									<div class="row">
										<div class="FlexableTextArea">
											<textarea id="title" placeholder="제목을 입력해 주세요."
												class="textarea_input form-control" style="height: 48px;"></textarea>
										</div>
									</div>
								</div>
							</div>
							<div id="SmartEditor" class="CafeEditor">
								<div id="summernote"></div>
								<c:if test="${sessionScope.dto.s_name == 'admin'}">
									<div class="form-check">
										<input type="checkbox" class="form-check-input" id="is_notice"
											name="is_notice"> <label for="is_notice"
											class="form-check-label">공지 사항으로 설정</label> <input
											type="hidden" name="is_admin" value="true">
									</div>
								</c:if>
								<button id="submit" class="btn btn-primary">제출</button>
							</div>
						</div>
					</div>
				</div>
			</section>
		</c:when>
		<c:otherwise>
			<c:redirect url="/login.do" />
		</c:otherwise>
	</c:choose>
</body>
</html>