<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="width-1300">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="${contextPath}/assets/css/defaultStyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
<script src="${contextPath}/assets/js/menubar.js"></script>

<style>
    .navbar-collapse {
        text-align: left;
    }
    .user-menu-link {
        margin-right: 10px;
        display: flex;
        align-items: center;
    }
    .navbar-wrapper .navbar-nav .user-info {
        color: white;
        display: flex;
        align-items: center;
    }
    .user-ion {
        font-size: 1.5rem;
        margin-left: 5px;
    }
    /* 드롭다운 화살표 숨기기 */
    .dropdown-toggle::after {
        display: none;
    }
</style>
</head>
<body>
<span id="uname" hidden>${sessionScope.vo.s_name}</span>
<nav class="navbar navbar-expand-lg bg-dark navbar-dark navbar-wrapper" id="menubar">
    <div class="container-fluid">
        <a class="navbar-brand" href="${contextPath}/listBoard.do">Main</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="nav navbar-nav ml-auto mr-2">
                <li class="nav-item dropdown user-info">
                    <c:if test="${not empty sessionScope.vo }">
                        <c:choose>
                            <c:when test="${sessionScope.vo.s_name eq 'admin' }">
                                관리자
                            </c:when>
                            <c:otherwise>
                                ${sessionScope.vo.s_name }
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                    <a class="nav-link dropdown-toggle user-menu-link" href="#" id="userDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <ion-icon name="settings-outline" class="user-ion"></ion-icon>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown" id="user-dropdown-menu">
                        <li><a class="dropdown-item" href="${contextPath}/logout.do">로그아웃</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
