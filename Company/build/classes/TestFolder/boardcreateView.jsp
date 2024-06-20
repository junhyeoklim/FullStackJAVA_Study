<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<c:import url="../source/jsp/bootStrapLink.jsp" />
<link rel="icon" href="../source/ico/company.ico" />
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/summernote-bs4.min.css" rel="stylesheet">
<link rel="stylesheet" href="../source/css/boardcreateView.css?after">
<link rel="stylesheet" href="../source/css/defaultStyle.css?after">
<link rel="stylesheet" href="../source/css/companyList.css?after">
<link rel="stylesheet" href="../source/css/menubar.css?after">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/summernote-bs4.min.js"></script>
</head>
<body>
<c:import url="../source/jsp/Menubar.jsp"/>
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
                                    <textarea id="title" placeholder="제목을 입력해 주세요." class="textarea_input" style="height: 48px;"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="SmartEditor" class="CafeEditor">
                        <div id="summernote"></div>
                        <button id="submit" class="btn btn-primary">제출</button>
                    </div>
                </div>
            </div>
        </div>
    </section>
<script src="boardcreateView.js"></script>
</body>
</html>
