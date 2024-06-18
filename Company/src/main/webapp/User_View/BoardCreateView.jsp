<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<c:import url="../source/jsp/bootStrapLink.jsp" />
<link rel="icon" href="../source/ico/company.ico" />
<link rel="stylesheet" href="../source/css/boardcreateView.css?after">
<link rel="stylesheet" href="../source/css/defaultStyle.css?after">
<link rel="stylesheet" href="../source/css/companyList.css?after">
<link rel="stylesheet" href="../source/css/menubar.css?after">
<script src="../source/js/jquery.js"></script>
<script src="../source/js/boardcreateView.js"></script>
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
                                    <textarea placeholder="제목을 입력해 주세요." class="textarea_input" style="height: 48px;"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="SmartEditor" class="CafeEditor">
                        <div class="se-wrap se-dnd-wrap">
                            <div class="se-dnd-wrap">
                                <header class="se-header se-header-type-basic">
                                    <div class="se-header-inbox se-l-document-toolbar">
                                        <ul class="se-toolbar se-document-toolbar se-toolbar-flexible">
                                            <li class="se-toolbar-item se-toolbar-item-image">
                                                <button type="button" id="imageUploadButton" title="사진 추가" class="se-image-toolbar-button se-document-toolbar-basic-button se-text-icon-toolbar-button __se-sentry">
                                                    <span class="se-toolbar-icon"></span>
                                                    <span class="se-toolbar-label" aria-hidden="true">사진</span>
                                                    <span class="se-toolbar-tooltip">사진 추가</span>
                                                </button>
                                                <input type="file" id="imageUpload" accept="image/*" style="display: none;">
                                            </li>
                                        </ul>
                                    </div>
                                </header>
                                <div class="se-container">
                                    <article class="se-components-wrap" contenteditable="true">
                                        <div class="se-component-content">
                                            <div class="se-drop-indicator">
                                                <p class="se-text-paragraph se-text-paragraph-align-left" style="line-height: 1.6;">
                                                    <span class="se-ff-system se-fs15" style="color: rgb(0,0,0);"></span>
                                                    <span class="se-placeholder __se_placeholder se-ff-system se-fs15 se-placeholder-focused">내용을 입력하세요.</span>
                                                </p>
                                            </div>
                                        </div>
                                    </article>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>