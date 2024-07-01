<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시물 상세보기</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:import url="../source/jsp/bootStrapLink.jsp" />
<link rel="icon" href="${contextPath}/source/ico/company.ico" />
<link rel="stylesheet" href="${contextPath}/source/css/defaultStyle.css?after">
<link rel="stylesheet" href="${contextPath}/source/css/companyList.css?after">
<link rel="stylesheet" href="${contextPath}/source/css/boardListView.css?after">
<link rel="stylesheet" href="${contextPath}/source/css/menubar.css?after">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

<style>
    .comment { position: relative; }
    .comment-actions { position: absolute; right: 0; top: 0; }
    .reply-form { margin-left: 20px; margin-top: 10px; }
</style>

</head>
<body>
    <c:choose>
        <c:when test="${not empty sessionScope.dto}">
            <c:import url="../source/jsp/Menubar.jsp" />
            <div class="content-wrapper">
                <article class="board-article">
                    <div class="container">
                        <c:if test="${not empty board}">
                            <h1>${board.title}</h1>
                            <div>${board.content}</div>
                            <p>작성자: ${board.s_name}</p>
                            <p>작성일: ${board.createTime}</p>
                            <p>조회수: ${board.views}</p>

                            <h2>댓글</h2>
                            <div id="comments-container">
                                <c:forEach var="comment" items="${comments}">
                                    <div class="comment">
                                        <p>${comment.userName} : ${comment.content}</p>
                                        <p>작성일: ${comment.createTime}</p>
                                        <div class="comment-actions">
                                            <button class="reply-btn" data-comment-id="${comment.comment_Id}">답글</button>
                                        </div>
                                        <div class="reply-form-container"></div>
                                    </div>
                                </c:forEach>
                            </div>

                            <h2>댓글 작성</h2>
                            <form id="comment-form">
                                <input type="hidden" name="b_id" value="${board.b_id}">
                                <label for="userName">이름:</label>
                                <input type="text" id="userName" name="userName" required><br>
                                <label for="content">내용:</label>
                                <textarea id="content" name="content" rows="4" cols="50" required></textarea><br>
                                <button type="submit" class="btn btn-primary">댓글 작성</button>
                            </form>
                        </c:if>
                    </div>
                </article>
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

    <script>
        // 페이지 로드 시 쿠키 삭제하여 새로고침 시 조회수 증가 방지
        document.addEventListener('DOMContentLoaded', function() {
            const b_id = "<%= request.getParameter("id") %>";
            document.cookie = "viewed_" + b_id + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
        });

        $('#comment-form').submit(function(e) {
            e.preventDefault();
            $.ajax({
                type: 'POST',
                url: '${contextPath}/addComment.jsp',
                data: $(this).serialize(),
                success: function(response) {
                    if (response.status === 'success') {
                        location.reload(); // 댓글 추가 후 페이지 새로고침
                    } else {
                        alert('댓글 추가에 실패했습니다.');
                    }
                },
                error: function() {
                    alert('댓글 추가 중 오류가 발생했습니다.');
                }
            });
        });

        $(document).on('click', '.reply-btn', function() {
            const commentId = $(this).data('comment-id');
            
            const replyFormHtml = `
                <div class="reply-form">
                    <form class="reply-form-inner">
                        <input type="hidden" name="b_id" value="${board.b_id}">
                        <input type="hidden" name="parentCommentId" id="parentCommentId" value="">
                        <label for="replyUserName">이름:</label>
                        <input type="text" name="userName" required><br>
                        <label for="replyContent">내용:</label>
                        <textarea name="content" rows="4" cols="50" required></textarea><br>
                        <button type="submit" class="btn btn-primary">대댓글 작성</button>
                    </form>
                </div>
            `;
            const parentComment = $(this).closest('.comment');
            const existingReplyForm = parentComment.find('.reply-form');
            if (existingReplyForm.length) {
                existingReplyForm.remove();
            }
            parentComment.append(replyFormHtml);
            document.getElementById('parentCommentId').value = commentId;
        });

        $(document).on('submit', '.reply-form-inner', function(e) {
            e.preventDefault();
            const formData = $(this).serialize();

            $.ajax({
                type: 'POST',
                url: '${contextPath}/addReply.jsp',
                data: formData,
                dataType: 'json', // JSON 응답을 기대함
                success: function(response) {
                    if (response.status === 'success') {
                        location.reload(); // 대댓글 추가 후 페이지 새로고침
                    } else {
                        alert('대댓글 추가에 실패했습니다.');
                    }
                },
                error: function(xhr, status, error) {
                    console.error('Error:', error); // 오류 메시지를 콘솔에 출력
                    alert('대댓글 추가 중 오류가 발생했습니다.');
                }
            });
        });

        $('.edit-btn').click(function() {
            alert('수정 기능은 아직 구현되지 않았습니다.');
        });

        $('.delete-btn').click(function() {
            if (confirm('댓글을 삭제하시겠습니까?')) {
                alert('삭제 기능은 아직 구현되지 않았습니다.');
            }
        });
    </script>
</body>
</html>
