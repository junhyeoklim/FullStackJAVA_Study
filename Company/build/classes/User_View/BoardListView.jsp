<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>사원 게시판</title>
<c:import url="../source/jsp/bootStrapLink.jsp" />
<link rel="icon" href="../source/ico/company.ico" />
<c:import url="../source/jsp/Menubar.jsp"/>
<link rel="stylesheet" href="../source/css/defaultStyle.css?after">
<link rel="stylesheet" href="../source/css/companyList.css?after">
<link rel="stylesheet" href="../source/css/boardView.css?after">
<link rel="stylesheet" href="../source/css/menubar.css?after">
</head>
<body>
    <div class="content-wrapper">
        <article class="board-article">
            <div class="board-article-list">
                <table>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${list}">
                            <tr>
                                <td>${dto.no }</td>
                                <td><a href="view.do?no=${dto.no}&id=${dto.id}">${dto.title}</a></td>
                                <td>${dto.id}</td>
                                <td>${dto.hit}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <!-- 글작성 버튼 -->
                <div class="create-post-wrapper">
                    <a href="newboard.do" class="create-post">글작성</a>
                </div>
                
                <!-- 검색 폼 -->
                <form class="search-form" method="post" action="#">
                    <select name="kindOfSearch" id="kindOfSearch" class="search-select">
                        <option value="searchTitle">제목</option>
                        <option value="searchTitleAndContents">제목 + 내용</option>
                        <option value="searchId">작성자</option>
                    </select>
                    <input type="text" name="searchKeyword" class="search-input" placeholder="검색어 입력">
                    <input type="submit" class="search-button" value="검색">
                </form>
                <!-- 페이지네이션 -->
                <div class="pagination">
                    <c:set var="curPage" value="${param.curPage }" />
                    <c:if test="${curPage eq null }">
                        <c:set var="curPage" value="0" />
                    </c:if>
                    <c:forEach var="i" begin="0" end="${totalPage}" step="1">
                        <c:choose>
                            <c:when test="${i eq curPage}">
                                <span>${i+1}</span>
                            </c:when>
                            <c:when test="${i ne curPage}">
                                <a href="list.do?curPage=${i}">${i+1}</a>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </div>
            </div>
        </article>
        <aside class="sidebar">
            <!-- 우측 상단 일정표/달력 -->
            <div class="calendar">
                <h2>일정표/달력</h2>
                <!-- 여기 달력이나 일정표 코드를 추가하세요 -->
            </div>
            <!-- 우측 하단 구내 식당 메뉴 -->
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
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>


