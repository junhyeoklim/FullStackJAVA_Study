<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="${contextPath}/assets/css/defaultStyle.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

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
        color: white !important;
        display: flex;
        align-items: center;
    }
    .user-ion {
        font-size: 1.5rem;
        margin-left: 5px;
    }
   .dropdown-toggle::after {
        display: none;
    }
        .user-info span {
        margin-right: 5px;
        font-size: 1rem;
    }
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${contextPath}/chart.do">ERP 시스템</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="#">대시보드</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextPath}/list.do">사원 관리</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">부서 관리</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">급여 관리</a>
            </li>
        </ul>
        <ul class="nav navbar-nav ml-auto mr-2">
            <li class="nav-item dropdown user-info">
                <a class="nav-link dropdown-toggle user-menu-link" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
                    관리자
                    <ion-icon name="settings-outline" class="user-ion"></ion-icon>
                </a>
                <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown" id="user-dropdown-menu">
                    <li><a class="dropdown-item" href="${contextPath}/BoardList.board">게시판</a></li>
                    <li><a class="dropdown-item" href="${contextPath}/logout.do">로그아웃</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>

<script>
$(document).ready(function() {
    $('#userDropdown').on('click', function(e) {
        e.stopPropagation();
        $('.dropdown-menu').not($(this).next('.dropdown-menu')).removeClass('show');
        $(this).next('.dropdown-menu').toggleClass('show');
    });

    $(document).on('click', function(e) {
        if (!$(e.target).closest('.dropdown-menu').length) {
            $('.dropdown-menu').removeClass('show');
        }
    });
});
</script>
</body>
</html>
