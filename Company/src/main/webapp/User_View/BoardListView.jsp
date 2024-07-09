<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>사원 게시판</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:import url="/assets/jsp/bootStrapLink.jsp" />
<link rel="icon" href="${contextPath}/assets/ico/company.ico" />
<link rel="stylesheet"
	href="${contextPath}/assets/css/defaultStyle.css?after">
<link rel="stylesheet"
	href="${contextPath}/assets/css/companyList.css?after">
<link rel="stylesheet"
	href="${contextPath}/assets/css/boardListView.css?after">
<link rel="stylesheet"
	href="${contextPath}/assets/css/menubar.css?after">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript" src="${contextPath}/assets/js/jquery.js"></script>
</head>
<body>
	<c:choose>
		<c:when test="${not empty sessionScope.dto}">
			<c:set var="today" value="<%=LocalDate.now()%>" />
			<c:import url="/assets/jsp/Menubar.jsp" />
			<div class="main-container">
				<div class="content-wrapper">
					<article class="board-article">
						<div class="board-article-list">
							<div class="vrow column head d-none d-md-flex">
								<div class="vrow-inner">
									<div class="vrow-top">
										<span class="vcol col-id">번호</span> 
										<span class="vcol col-title">제목</span>
									</div>
									<div class="vrow-bottom">
										<span class="vcol col-author">작성자</span> <span
											class="vcol col-time">작성일</span> <span class="vcol col-view">조회수</span>
									</div>
								</div>
							</div>
							<c:forEach var="board" items="${noticeList}">
								<a class="vrow column notice-board"
									href="${contextPath}/increaseViewCount.board?category=notice&b_id=${board.b_id}&redirect=${contextPath}/view.board?category=notice&b_id=${board.b_id}">
									<div class="vrow-inner">
										<div class="vrow-top">
											<span class="vcol col-id"><b>공지</b></span> <span
												class="vcol col-title"><b>${board.title}<span
													class="comment-count">[${board.commentCnt}]</span></b></span>
										</div>
										<div class="vrow-bottom">
											<span class="vcol col-author"> <span class="user-info">
													<span>관리자</span>
											</span>
											</span> <span class="vcol col-time">
												${fn:substring(board.createTime, 0, 10) == fn:substring(today, 0, 10) ? fn:substring(board.createTime, 11, 16) : fn:substring(board.createTime, 0, 10)}
											</span> <span class="vcol col-view">${board.views}</span>
										</div>
									</div>
								</a>
							</c:forEach>
							<c:forEach var="board" items="${list}">
								<a class="vrow column"
									href="${contextPath}/increaseViewCount.board?category=nomal&b_id=${board.b_id}&redirect=${contextPath}/view.board?category=nomal&b_id=${board.b_id}">
									<div class="vrow-inner">
										<div class="vrow-top">
											<span class="vcol col-id">${board.post_num}</span> <span
												class="vcol col-title">${board.title}<span
												class="comment-count">[${board.commentCnt}]</span></span>
										</div>
										<div class="vrow-bottom">
											<span class="vcol col-author"> <span class="user-info">
													<span> <c:choose>
															<c:when test="${board.s_name eq 'admin'}">
                                                        관리자
                                                        </c:when>
															<c:otherwise>
                                                        ${board.s_name}
                                                        </c:otherwise>
														</c:choose>
												</span>
											</span>
											</span> <span class="vcol col-time">
												${fn:substring(board.createTime, 0, 10) == fn:substring(today, 0, 10) ? fn:substring(board.createTime, 11, 16) : fn:substring(board.createTime, 0, 10)}
											</span> <span class="vcol col-view">${board.views}</span>
										</div>
									</div>
								</a>
							</c:forEach>
						</div>
						<div class="create-post-wrapper">
							<a href="${contextPath}/Newboard.board" class="create-post">글쓰기</a>
						</div>

						<form class="search-form" method="post"
							action="${contextPath}/Search.board">
							<select name="kindOfSearch" id="kindOfSearch"
								class="search-select">
								<option value="searchTitle">제목</option>
								<option value="searchTitleAndContents">제목 + 내용</option>
								<option value="searchId">작성자</option>
							</select> <input type="text" name="searchKeyword" class="search-input"
								placeholder="검색어 입력"> <input type="submit"
								class="search-button" value="검색">
						</form>

						<c:import url="/assets/jsp/boardPagenation.jsp" />

					</article>
					<aside class="sidebar">
						<div class="calendar">
							<h2>일정표/달력</h2>
						</div>
						<div class="menu">
							<h2>구내 식당 점심 메뉴</h2>
							<ul>
								<li>월요일: 메뉴1</li>
								<li>화요일: 메뉴2</li>
								<li>수요일: 메뉴3</li>
								<li>목요일: 메뉴4</li>
								<li>금요일: 메뉴5</li>
							</ul>
						</div>
					</aside>
				</div>
			</div>
			<div id="scrollbar-container">
				<div id="scrollbar"></div>
			</div>
		</c:when>
		<c:otherwise>
			<c:redirect url="/login.do" />
		</c:otherwise>
	</c:choose>
	<!-- Bootstrap JS 로드 -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
		document.addEventListener("DOMContentLoaded", function() {
		    const contentWrapper = document.querySelector(".content-wrapper");
		    const scrollbarContainer = document.getElementById("scrollbar-container");

		    // 화살표 키에 따른 스크롤 제어
		    document.addEventListener("keydown", function(event) {
		        const key = event.key;

		        switch (key) {
		            case "ArrowUp":
		                contentWrapper.scrollTop -= 30; // 위로 스크롤
		                event.preventDefault();
		                break;
		            case "ArrowDown":
		                contentWrapper.scrollTop += 30; // 아래로 스크롤
		                event.preventDefault();
		                break;
		            case "ArrowLeft":
		                if (contentWrapper.scrollWidth > contentWrapper.clientWidth) {
		                    contentWrapper.scrollLeft -= 30; // 왼쪽으로 스크롤
		                }
		                event.preventDefault();
		                break;
		            case "ArrowRight":
		                if (contentWrapper.scrollWidth > contentWrapper.clientWidth) {
		                    contentWrapper.scrollLeft += 30; // 오른쪽으로 스크롤
		                }
		                event.preventDefault();
		                break;
		        }
		    });
		});
	</script>
</body>
</html>
