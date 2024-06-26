<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시글 작성</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/summernote-bs4.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/summernote-bs4.css" rel="stylesheet">
</head>
<body>
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

    <script>
        $(document).ready(function() {
            $('#summernote').summernote({
                height: 300,
                callbacks: {
                    onImageUpload: function(files) {
                        for (var i = 0; i < files.length; i++) {
                            sendFile(files[i]);
                        }
                    }
                }
            });

            function sendFile(file) {
                var data = new FormData();
                data.append('file', file);
                $.ajax({
                    url: '/Company/UploadImageServlet',
                    type: 'POST',
                    data: data,
                    contentType: false,
                    processData: false,
                    success: function(url) {
                        // 이미지 삽입 전 <br> 태그 추가
                        var range = $('#summernote').summernote('createRange');
                        range.pasteHTML('<br>'); // <br> 태그 삽입
                        $('#summernote').summernote('insertImage', url);
                    },
                    error: function(data) {
                        console.log(data);
                    }
                });
            }

            $('#submit').on('click', function() {
                var title = $('#title').val();
                var content = $('#summernote').summernote('code');

                if (title === "" || content === "") {
                    alert("제목과 내용을 입력해 주세요.");
                    return;
                }

                $.ajax({
                    type: 'POST',
                    url: '/Company/SubmitPostServlet',
                    data: {
                        title: title,
                        content: content
                    },
                    success: function(response) {
                        window.location.href = 'boardList.jsp';
                    },
                    error: function(xhr, status, error) {
                        console.log(xhr.responseText);
                        alert('게시글 작성에 실패했습니다: ' + error);
                    }
                });
            });
        });
    </script>
</body>
</html>


