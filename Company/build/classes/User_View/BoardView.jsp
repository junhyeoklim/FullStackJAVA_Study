<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet"
	href="${contextPath}/source/css/defaultStyle.css?after">
<link rel="stylesheet"
	href="${contextPath}/source/css/companyList.css?after">
<link rel="stylesheet"
	href="${contextPath}/source/css/boardListView.css?after">
<link rel="stylesheet"
	href="${contextPath}/source/css/menubar.css?after">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.comment {
	position: relative;
}

.comment-actions {
	position: absolute;
	right: 0;
	top: 0;
}

.reply-form {
	margin-left: 20px;
	margin-top: 10px;
}
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
							<p>작성자: 
							<c:choose>
								<c:when test="${board.s_name eq 'admin'}">
								관리자
								</c:when>
								<c:otherwise>
								${board.s_name }
								</c:otherwise>
							</c:choose>
							</p>
							<p>작성일: ${board.createTime}</p>
							<p>조회수: ${board.views}</p>
							<h2>댓글</h2>
							<div id="comments-container">
								<c:forEach var="comment" items="${comments}">
									<div class="comment" data-comment-id="${comment.comment_Id}">
										<p>${comment.userName}: ${comment.content}</p>
										<p>작성일: ${comment.createTime}</p>
										<div class="comment-actions">
											<button class="reply-btn"
												data-comment-id="${comment.comment_Id}">답글</button>
											<c:if test="${comment.s_id == sessionScope.dto.s_id}">
												<button class="edit-btn"
													data-comment-id="${comment.comment_Id}">수정</button>
												<button class="delete-btn"
													data-comment-id="${comment.comment_Id}">삭제</button>
											</c:if>
										</div>
										<div class="reply-form-container"></div>
									</div>
								</c:forEach>
							</div>
							<h2>댓글 작성</h2>
							<form id="comment-form">
								<input type="hidden" name="b_id" value="${board.b_id}">
								<label for="userName">이름:</label> <input type="text"
									id="userName" name="userName" required><br> <label
									for="content">내용:</label>
								<textarea id="content" name="content" rows="4" cols="50"
									required></textarea>
								<br>
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
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<script>
        document.addEventListener('DOMContentLoaded', function() {
            $('#comment-form').submit(function(e) {
                e.preventDefault();
                $.ajax({
                    type: 'POST',
                    url: '${contextPath}/addComment.board',
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
                    url: '${contextPath}/addReply.board',
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
                const commentId = $(this).data('comment-id');
                console.log("Clicked commentId: ", commentId);  // 디버깅 로그 추가
                if (!commentId) {
                    alert('댓글 ID를 찾을 수 없습니다.');
                    return;
                }

                const commentContent = $(this).closest('.comment').find('p').eq(1).text();
                const editFormHtml = `
                    <div class="edit-form">
                        <form class="edit-form-inner">
                            <input type="hidden" name="commentId" id="commentId" value="">
                            <label for="editContent">내용:</label>
                            <textarea name="content" id="editContent" rows="4" cols="50" required>${commentContent}</textarea><br>
                            <button type="submit" class="btn btn-primary">수정 완료</button>
                        </form>
                    </div>
                `;
                const parentComment = $(this).closest('.comment');
                const existingEditForm = parentComment.find('.edit-form');
                if (existingEditForm.length) {
                    existingEditForm.remove();
                }
                parentComment.append(editFormHtml);
                document.getElementById('commentId').value = commentId;  // 여기서 직접 값을 설정
            });

            $(document).on('submit', '.edit-form-inner', function(e) {
                e.preventDefault();
                const formData = $(this).serialize();

                console.log("Form Data: ", formData);  // 폼 데이터 출력

                $.ajax({
                    type: 'POST',
                    url: '${contextPath}/editComment.board',
                    data: formData,
                    dataType: 'json',
                    success: function(response) {
                        console.log(response);  // 서버 응답을 콘솔에 출력
                        if (response.status === 'success') {
                            location.reload(); // 댓글 수정 후 페이지 새로고침
                        } else {
                            alert('댓글 수정에 실패했습니다.');
                            console.log(response.message);  // 오류 메시지를 콘솔에 출력
                        }
                    },
                    error: function(xhr, status, error) {
                        console.error('Error:', error);
                        console.error('Response:', xhr.responseText);  // 서버 응답을 콘솔에 출력
                        alert('댓글 수정 중 오류가 발생했습니다.');
                    }
                });
            });

            $('.delete-btn').click(function() {
                const commentId = $(this).data('comment-id');
                if (confirm('댓글을 삭제하시겠습니까?')) {
                    $.ajax({
                        type: 'POST',
                        url: '${contextPath}/deleteComment.board',
                        data: { commentId: commentId },
                        dataType: 'json',
                        success: function(response) {
                            if (response.status === 'success') {
                                location.reload(); // 댓글 삭제 후 페이지 새로고침
                            } else {
                                alert('댓글 삭제에 실패했습니다.');
                            }
                        },
                        error: function(xhr, status, error) {
                            console.error('Error:', error);
                            alert('댓글 삭제 중 오류가 발생했습니다.');
                        }
                    });
                }
            });
        });
    </script>
</body>
</html>
