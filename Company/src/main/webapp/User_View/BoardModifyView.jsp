<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <meta charset="UTF-8">
    <title>게시글 수정</title>
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
    <script src="${contextPath}/assets/js/boardmodifyView.js"></script>
    <style>
        .file-item {
            margin-bottom: 10px;
            margin-left: 10px;
            margin-right: 10px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .file-header {
            display: flex;
            align-items: center;
            padding: 5px 10px;
            background-color: #F7F7F9;
            border-bottom: solid 1px #E6E6EA;
            position: sticky;
            top: 0;
            z-index: 1;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .file-header .file-info {
            flex-grow: 1;
            margin-left: 10px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .file-size-header {
            margin-left: auto;
            margin-right: 10px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .file-list-container {
            max-width: 50em;
            margin-top: 10px;
            border: solid 1px #E6E6EA;
            width: 100%;
        }

        #fileCount {
            margin-left: 10px;
            font-weight: bold;
        }

        .hidden-file-input {
            display: none;
        }

        .form-check, .btn-create-submit {
            margin-top: 10px;
        }

        .btn-file-select, .btn-submit-post {
            background-color: #C0C0C0 !important;
            border: 1px solid #CED4DA;
            font-weight: bold !important;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .btn-file-select:hover, .btn-submit-post:hover {
            background-color: #A9A9A9 !important;
            border-color: #A9A9A9 !important;
        }

        .btn-submit-post {
            margin-top: 10px;
        }

        @media (max-width: 600px) {
            .file-list-container, .file-header, .file-item, .file-info, .file-size-header, .btn-file-select, .btn-submit-post, #fileCount {
                width: 100%;
                margin: 0;
                padding: 5px;
            }

            .file-header, .file-item {
                flex-direction: row;
                align-items: center;
                justify-content: space-between;
            }

            .file-size-header {
                margin-left: 0;
                margin-top: 5px;
            }

            .btn-file-select, .btn-submit-post {
                width: 100%;
                margin-top: 10px;
            }

            .file-info {
                flex-grow: 1;
                overflow: hidden;
                text-overflow: ellipsis;
                white-space: nowrap;
            }
        }
    </style>
</head>
<body>
<c:choose>
    <c:when test="${not empty sessionScope.dto}">
        <c:import url="/assets/jsp/Menubar.jsp" />
        <section class="container">
            <div class="WritingWrap">
                <div class="WritingHeader">
                    <h2 class="title">게시글 수정</h2>
                </div>
                <div class="WritingContent">
                    <div class="WritingEditor">
                        <div class="editer_wrap">
                            <div class="ArticleWritingTitle">
                                <div class="row">
                                    <div class="FlexableTextArea">
                                        <textarea id="title" placeholder="제목을 입력해 주세요."
                                                  class="textarea_input form-control" style="height: 48px;">${board.title}</textarea>
                                         <input type="hidden" id="b_id" value="${board.b_id}">
                                    </div>
                                </div>
                            </div>
                            <div class="mt-3 d-flex align-items-center">
                                <span>
                                    <button type="button" class="btn btn-file-select" id="fileSelectButton">파일 선택</button>
                                    <input type="file" id="fileAttachment" name="fileAttachment" class="hidden-file-input" multiple>
                                </span>
                                <c:choose>
                                    <c:when test="${empty files}">
                                        <span id="fileCount">선택된 파일 없음</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span id="fileCount">선택된 파일: ${fn:length(files)}개</span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div id="fileList" class="mt-3 file-list-container" style="max-height: 150px; overflow-y: auto;">
                                <div class="file-header">
                                    <button type="button" class="btn btn-danger btn-sm remove-all-files">x</button>
                                    <span class="file-info">파일명</span>
                                    <span class="file-size-header">용량</span>
                                </div>
                                <c:forEach var="file" items="${files}">
                                    <div class="file-item d-flex justify-content-between align-items-center mt-2">
                                        <div class="d-flex align-items-center">
                                            <button type="button" class="btn btn-danger btn-sm remove-file mr-2" data-filepath="${file.file_path}">x</button>
                                            <span class="file-info">${file.file_name}</span>
                                        </div>
                                        <span class="existing-file-size" data-filepath="${file.file_path}">계산 중...</span>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div id="SmartEditor" class="CafeEditor">
                            <span id="content" hidden>${fn:escapeXml(board.content)}</span>
                            <div id="summernote"></div>
                            <c:if test="${sessionScope.dto.s_name == 'admin'}">
                                <div class="form-check">
                                    <input type="checkbox" class="form-check-input" id="is_notice"
                                           name="is_notice" <c:if test="${param.category == 'notice'}">checked</c:if>> 
                                    <label for="is_notice" class="form-check-label">공지 사항으로 설정</label> 
                                    <input type="hidden" name="is_admin" value="true">
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
