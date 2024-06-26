<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="width-1300">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="../source/css/defaultStyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script type="text/javascript" src="../source/js/chartMenu.js"></script>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
<script src="../source/js/menubar.js"></script>
<style>
	.navbar-collapse{
		/* width: 1300px; */
		text-align: left;
	}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-dark navbar-dark navbar-wrapper" id="menubar">
    <div class="container-fluid">
        <a class="navbar-brand" href="BoardListView.jsp">Main</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav" id="main-menu">
                <li class="nav-item"><a class="nav-link" href="BoardListView.jsp">(공사중)게시판</a></li>
                <li class="nav-item"><a class="nav-link" href="logout.do">(임시)로그아웃</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">Dropdown link</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <li><a class="dropdown-item" href="#">ee</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav ml-auto ml-lg-0">
                <li>
                    <a href="#" class="nav-link user-menu-link">
                        <ion-icon name="person-outline" class="user-ion"></ion-icon>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <!--
    	아이콘 관련 자료 : https://didyousee36sam.tistory.com/14
      -->
</nav>
<span id="uname" hidden>${sessionScope.dto.s_name}</span>
</body>
</html>
