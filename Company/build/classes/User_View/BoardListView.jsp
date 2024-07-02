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

<c:import url="/source/jsp/bootStrapLink.jsp" />
<link rel="icon" href="${contextPath}/source/ico/company.ico" />
<link rel="stylesheet" href="${contextPath}/source/css/defaultStyle.css?after">
<link rel="stylesheet" href="${contextPath}/source/css/companyList.css?after">
<link rel="stylesheet" href="${contextPath}/source/css/boardListView.css?after">
<link rel="stylesheet" href="${contextPath}/source/css/menubar.css?after">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
    <c:choose>
        <c:when test="${not empty sessionScope.dto}">
            <c:set var="today" value="<%= LocalDate.now() %>"/>
            <c:import url="/source/jsp/Menubar.jsp" />
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
                                    <span class="vcol col-author">작성자</span>
                                    <span class="vcol col-time">작성일</span>
                                    <span class="vcol col-view">조회수</span>
                                </div>
                            </div>
                        </div>
                        <c:forEach var="board" items="${noticeList}">
                            <a class="vrow column notice-board" href="${contextPath}/increaseViewCount.board?category=notice&b_id=${board.b_id}&redirect=${contextPath}/view.board?category=notice&b_id=${board.b_id}">
                                <div class="vrow-inner">
                                    <div class="vrow-top">
                                        <span class="vcol col-id"><b>공지</b></span>
                                        <span class="vcol col-title"><b>${board.title}</b></span>
                                    </div>
                                    <div class="vrow-bottom">
                                        <span class="vcol col-author">
                                        	<span class="user-info">
                                        		<span>관리자</span>
                                        	</span>
                                        </span>
                                        <span class="vcol col-time">
                                            ${fn:substring(board.createTime, 0, 10) == fn:substring(today, 0, 10) ? fn:substring(board.createTime, 11, 16) : fn:substring(board.createTime, 0, 10)}
                                        </span>
                                        <span class="vcol col-view">${board.views}</span>
                                    </div>
                                </div>
                            </a>
                        </c:forEach>
                        <c:forEach var="board" items="${list}">
                            <a class="vrow column" href="${contextPath}/increaseViewCount.board?category=nomal&b_id=${board.b_id}&redirect=${contextPath}/view.board?category=nomal&b_id=${board.b_id}">
                                <div class="vrow-inner">
                                    <div class="vrow-top">
                                        <span class="vcol col-id">${board.post_num}</span>
                                        <span class="vcol col-title">${board.title}</span>
                                    </div>
                                    <div class="vrow-bottom">
                                        <span class="vcol col-author">
                                        	<span class="user-info">
                                        		<span>
                                        			<c:choose>
                                        				<c:when test="${board.s_name eq 'admin'}">
                                        				관리자
                                        				</c:when>
                                        				<c:otherwise>
                                        				${board.s_name}
                                        				</c:otherwise>	 
                                        			</c:choose>
                                        		</span>
                                        	</span>
                                        </span>
                                        <span class="vcol col-time">
                                            ${fn:substring(board.createTime, 0, 10) == fn:substring(today, 0, 10) ? fn:substring(board.createTime, 11, 16) : fn:substring(board.createTime, 0, 10)}
                                        </span>
                                        <span class="vcol col-view">${board.views}</span>
                                    </div>
                                </div>
                            </a>
                        </c:forEach>
                    </div>
                    <div class="create-post-wrapper">
                        <a href="Newboard.board" class="create-post">글쓰기</a>
                    </div>

                    <form class="search-form" method="post" action="${contextPath}/Search.board">
                        <select name="kindOfSearch" id="kindOfSearch" class="search-select">
                            <option value="searchTitle">제목</option>
                            <option value="searchTitleAndContents">제목 + 내용</option>
                            <option value="searchId">작성자</option>
                        </select> 
                        <input type="text" name="searchKeyword" class="search-input" placeholder="검색어 입력"> 
                        <input type="submit" class="search-button" value="검색">
                    </form>

                    <nav class="pagination-wrapper">
                        <ul class="pagination justify-content-center">
                            <c:if test="${requestScope.pagingInfo.currentPage > 1}">
                                <li class="page-item">
                                    <a class="page-link" href="<c:url value='BoardList.board'>
                                        <c:param name='page' value='1'/>
                                        <c:if test='${not empty requestScope.kindOfSearch}'>
                                            <c:param name='kindOfSearch' value='${requestScope.kindOfSearch}'/>
                                        </c:if>
                                        <c:if test='${not empty requestScope.searchKeyword}'>
                                            <c:param name='searchKeyword' value='${requestScope.searchKeyword}'/>
                                        </c:if>
                                    </c:url>">&lt;&lt;</a>
                                </li>
                                <li class="page-item">
                                    <a class="page-link" href="<c:url value='BoardList.board'>
                                        <c:param name='page' value='${requestScope.pagingInfo.currentPage - 1}'/>
                                        <c:if test='${not empty requestScope.kindOfSearch}'>
                                            <c:param name='kindOfSearch' value='${requestScope.kindOfSearch}'/>
                                        </c:if>
                                        <c:if test='${not empty requestScope.searchKeyword}'>
                                            <c:param name='searchKeyword' value='${requestScope.searchKeyword}'/>
                                        </c:if>
                                    </c:url>">&lt;</a>
                                </li>
                            </c:if>
                            <c:set var="startPage" value="${requestScope.pagingInfo.currentPage - 4 > 0 ? requestScope.pagingInfo.currentPage - 4 : 1}" />
                            <c:set var="endPage" value="${startPage + 9 <= requestScope.pagingInfo.noOfPages ? startPage + 9 : requestScope.pagingInfo.noOfPages}" />
                            <c:forEach begin="${startPage}" end="${endPage}" var="i">
                                <li class="page-item ${requestScope.pagingInfo.currentPage == i ? 'active' : ''}">
                                    <a class="page-link" href="<c:url value='BoardList.board'>
                                        <c:param name='page' value='${i}'/>
                                        <c:if test='${not empty requestScope.kindOfSearch}'>
                                            <c:param name='kindOfSearch' value='${requestScope.kindOfSearch}'/>
                                        </c:if>
                                        <c:if test='${not empty requestScope.searchKeyword}'>
                                            <c:param name='searchKeyword' value='${requestScope.searchKeyword}'/>
                                        </c:if>
                                    </c:url>">${i}</a>
                                </li>
                            </c:forEach>
                            <c:if test="${requestScope.pagingInfo.currentPage < requestScope.pagingInfo.noOfPages}">
                                <li class="page-item">
                                    <a class="page-link" href="<c:url value='BoardList.board'>
                                        <c:param name='page' value='${requestScope.pagingInfo.currentPage + 1}'/>
                                        <c:if test='${not empty requestScope.kindOfSearch}'>
                                            <c:param name='kindOfSearch' value='${requestScope.kindOfSearch}'/>
                                        </c:if>
                                        <c:if test='${not empty requestScope.searchKeyword}'>
                                            <c:param name='searchKeyword' value='${requestScope.searchKeyword}'/>
                                        </c:if>
                                    </c:url>">&gt;</a>
                                </li>
                                <li class="page-item">
                                    <a class="page-link" href="<c:url value='BoardList.board'>
                                        <c:param name='page' value='${requestScope.pagingInfo.noOfPages}'/>
                                        <c:if test='${not empty requestScope.kindOfSearch}'>
                                            <c:param name='kindOfSearch' value='${requestScope.kindOfSearch}'/>
                                        </c:if>
                                        <c:if test='${not empty requestScope.searchKeyword}'>
                                            <c:param name='searchKeyword' value='${requestScope.searchKeyword}'/>
                                            </c:if>
                                        </c:url>">&gt;&gt;</a>
                                </li>
                            </c:if>
                        </ul>
                    </nav>
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
        </c:when>
        <c:otherwise>
            <c:redirect url="/login.do" />
        </c:otherwise>
    </c:choose>

    <!-- jQuery 로드 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Bootstrap JS 로드 -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
