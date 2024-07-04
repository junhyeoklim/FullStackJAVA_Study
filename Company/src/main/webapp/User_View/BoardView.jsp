<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<c:import url="/assets/jsp/bootStrapLink.jsp" />
<link rel="icon" href="${contextPath}/assets/ico/company.ico" />
<link rel="stylesheet"
	href="${contextPath}/assets/css/defaultStyle.css?after">
<link rel="stylesheet"
	href="${contextPath}/assets/css/companyList.css?after">
<link rel="stylesheet"
	href="${contextPath}/assets/css/boardView.css?after">
<link rel="stylesheet"
	href="${contextPath}/assets/css/menubar.css?after">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
    margin: 0;
    padding: 0;
}
textarea, pre {
    font-family: Arial, sans-serif; /* 원하는 글꼴로 설정 */
}
.container {
    margin-top: 20px; /* Menubar와의 여백 조절 */
}

.board-content {
    margin-bottom: 15px; /* board-content와 comment-section 사이 여백 조절 */
}

.comment, .reply, .edit-comment, .reply-form {
    position: relative;
    margin-left: calc(var(--depth, 0) * 20px);
    padding: 5px;
    border: 1px solid #ddd;
    border-radius: 5px;
    margin-bottom: 10px;
}

.comment-header, .edit-comment-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 5px;
    border-bottom: 1px solid #ddd;
}

.comment-body {
    padding: 5px;
}

.comment-actions, .reply-actions {
    display: flex;
    gap: 5px;
}

.btn-custom {
    border-radius: 20px;
    background-color: #4CAF50; /* 기본 버튼 색상 */
    color: #fff;
    padding: 5px 10px;
    border: none;
}

.btn-custom:hover {
    background-color: #45a049; /* 호버 시 버튼 색상 */
}

.btn-container {
    display: flex;
    gap: 5px;
}

.edit-form-header {
    padding: 5px;
    border-bottom: 1px solid #ddd;
}

.edit-container, .comment-container {
    display: flex;
    flex-direction: column;
    border: 1px solid #ddd;
    border-radius: 5px;
    padding: 10px;
    margin-bottom: 10px;
    position: relative;
}

.edit-container textarea, .comment-container textarea {
    width: 100%;
    border: none;
    resize: none;
    padding: 10px;
    box-sizing: border-box;
}

.edit-container button, .comment-container button {
    bottom: 10px;
    right: 10px;
}

.edit-container textarea:focus, .comment-container textarea:focus {
    caret-color: auto;
    outline: none;
}

.comment-form-section {
    margin-top: 20px;
}

.submit-button {
    display: flex;
    justify-content: flex-end;
    width: 100%;
    box-sizing: border-box;
    padding: 0 10px 10px 10px;
}

.btn-submit {
    visibility: hidden;
}

.submit-button button {
    flex-shrink: 0;
}

.comment-section {
    border-top: 1px solid #ddd;
    border-bottom: 1px solid #ddd;
    margin-bottom: 30px;
    padding: 10px 0;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.comment-section h2 {
    margin: 0;
}

.create-post-button {
    background-color: #2196F3;
    color: white;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    border-radius: 20px;
    border: none;
}

.create-post-button:hover {
    background-color: #0b7dda;
}

.post-header {
    padding: 10px 10px;
    border-top: 1px solid black;
    border-bottom: 1px solid black;
    background-color: #dcdcdc;
}

.post-title {
    font-size: 18px; /* 적당한 크기로 줄임 */
    display: flex;
    align-items: center;
    padding: 2.5px 0;
}

.notice-label {
    background-color: black;
    color: white;
    padding: 2px 8px;
    margin-right: 10px;
    border-radius: 5px;
}

.post-meta {
    display: flex;
    justify-content: space-between;
    align-items: center;
    border-bottom: 1px solid #ddd;
    padding: 10px 0;
    margin-bottom: 30px;
}

.post-author {
    font-weight: bold;
}

.post-info span {
    background-color: #f0f0f0;
    padding: 5px 10px;
    border-radius: 5px;
}

/* 로딩 애니메이션 */
.loader {
    border: 4px solid #f3f3f3; /* Light grey */
    border-top: 4px solid #3498db; /* Blue */
    border-radius: 50%;
    width: 20px;
    height: 20px;
    animation: spin 1s linear infinite;
    margin: auto;
}

@keyframes spin {
    0% { transform: rotate(0deg); }
    100% { transform: rotate(360deg); }
}

/* 버튼의 로딩 상태 스타일 */
.button-container.loading,
.submit-button.loading,
.comment-header.loading {
    position: relative;
}

.button-container.loading .btn-submit,
.submit-button.loading .btn-submit,
.comment-header.loading .btn-submit {
    visibility: hidden;
}

.button-container.loading .loader,
.submit-button.loading .loader,
.comment-header.loading .loader {
    display: block;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}

</style>
</head>
<body>
	<c:choose>
		<c:when test="${not empty sessionScope.dto}">
			<c:import url="/assets/jsp/Menubar.jsp" />
			<div class="content-wrapper selectable">
				<article class="board-article">
					<div class="container">
						<c:if test="${not empty board}">
							<div class="board-content">
								<div class="post-header">
									<div class="post-title">
										<c:choose>
											<c:when test="${param.category eq 'notice'}">
												<span class="notice-label">공지</span>
											</c:when>
										</c:choose>
										${board.title}
									</div>
								</div>
								<div class="post-meta">
									<div class="post-author">
										작성자:
										<c:choose>
											<c:when test="${board.s_name eq 'admin'}">관리자</c:when>
											<c:otherwise>${board.s_name}</c:otherwise>
										</c:choose>
									</div>
									<div class="post-info">
										<span>댓글 ${board.commentCnt}</span> | <span>조회수
											${board.views}</span> | <span>작성일 ${board.createTime}</span>
									</div>
								</div>
								<div class="board-content">
									<div>${board.content}</div>
								</div>
							</div>
						</c:if>
						<div class="comment-section">
							<h2>댓글 [${board.commentCnt}]</h2>
							<a href="${contextPath}/Newboard.board" class="create-post">글쓰기</a>
						</div>

						<div id="comments-container">
							<c:forEach var="comment" items="${comments}">
								<div class="comment" data-comment-id="${comment.comment_Id}"
									style="--depth: ${comment.depth}">
									<c:choose>
										<c:when test="${comment.is_deleted}">
											<p>삭제된 댓글입니다</p>
										</c:when>
										<c:otherwise>
											<div class="comment-header">
												<div>
													<c:choose>
														<c:when test="${comment.userName eq 'admin'}">관리자</c:when>
														<c:otherwise>${comment.userName}</c:otherwise>
													</c:choose>
												</div>
												<div>
													${comment.createTime} |
													<c:if test="${comment.s_id == sessionScope.dto.s_id}">
														<button class="delete-btn btn-custom"
															data-comment-id="${comment.comment_Id}">삭제</button>
														<button class="edit-btn btn-custom"
															data-comment-id="${comment.comment_Id}"
															data-comment-depth="${comment.depth}">수정</button>
													</c:if>
													<button class="reply-btn btn-custom"
														data-comment-id="${comment.comment_Id}"
														data-comment-depth="${comment.depth}">답글</button>
												</div>
											</div>
											<div class="comment-body selectable">
												<pre style="white-space: pre-wrap;">${fn:escapeXml(comment.content)}</pre>
											</div>
										</c:otherwise>
									</c:choose>
								</div>
							</c:forEach>
						</div>

						<div class="comment-form-section">
							<div class="comment-container">
								<div class="comment-form-container">
									<div class="comment-header">
										<c:choose>
											<c:when test="${sessionScope.dto.s_name eq 'admin'}">관리자</c:when>
											<c:otherwise>${sessionScope.dto.s_name}</c:otherwise>
										</c:choose>
									</div>
									<form id="comment-form">
										<input type="hidden" name="b_id" value="${board.b_id}">
										<input type="hidden" id="userName" name="userName"
											value="${sessionScope.dto.s_name}" required>
										<div class="comment-container comment-focus">
											<textarea id="content" name="content" rows="4" cols="50"
												required></textarea>
											<div>
												<div class="button-container"></div>
												<div class="submit-button">
													<button type="submit" class="btn-submit btn-custom">댓글
														작성</button>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</article>
			</div>
		</c:when>
		<c:otherwise>
			<c:redirect url="/login.do" />
		</c:otherwise>
	</c:choose>

	<span id="s_name" hidden>${sessionScope.dto.s_name}</span>
	<!-- jQuery 로드 -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<!-- Bootstrap JS 로드 -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<script>
    function autoResizeTextarea(textarea) {
        textarea.style.height = 'auto';
        textarea.style.height = textarea.scrollHeight + 'px';
    }

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
            const parentComment = $(this).closest('.comment, .reply');
            const existingReplyForm = parentComment.next('.reply-form');

            // 기존에 열린 폼을 닫기
            const currentForm = $('.reply-form');
            if (currentForm.length && currentForm.is(existingReplyForm)) {
                currentForm.remove();
                return;
            }
            $('.reply-form').remove();
            $('.edit-comment').remove();

            const commentId = $(this).data('comment-id');
            const depth = $(this).data('comment-depth');
            const replyFormHtml = `
                <div class="reply-form">
                    <form class="reply-form-inner">
                        <input type="hidden" name="b_id" value="${board.b_id}">
                        <input type="hidden" name="parentCommentId" class="parentCommentId" value="">
                        <input type="hidden" name="userName" value="${sessionScope.dto.s_name}">
                        <div class="edit-comment-header">
                            <div>${sessionScope.dto.s_name == 'admin' ? '관리자' : sessionScope.dto.s_name}</div>
                        </div>
                        <div class="comment-container comment-focus">
                            <textarea name="content" rows="4" cols="50" required></textarea>
                            <div>
                                <div class="button-container"></div>
                                <div class="submit-button">
                                    <button type="submit" class="btn-submit btn-custom">대댓글 작성</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            `;

            const replyForm = $(replyFormHtml).attr('style', '--depth:' + (depth + 1));
            parentComment.after(replyForm);
            parentComment.next('.reply-form').find('.parentCommentId').val(commentId);
            parentComment.next('.reply-form').find('.reply-author').text(s_name);
            parentComment.next('.reply-form').find('textarea').on('input', function() {
                autoResizeTextarea(this);
            });
            parentComment.next('.reply-form').find('textarea').focus(); // 텍스트 영역 포커스
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

        $(document).on('click', '.edit-btn', function() {
            const parentComment = $(this).closest('.comment, .reply');
            const existingEditForm = parentComment.next('.edit-comment');

            // 기존에 열린 폼을 닫기
            const currentForm = $('.edit-comment');
            if (currentForm.length && currentForm.is(existingEditForm)) {
                currentForm.remove();
                return;
            }
            $('.reply-form').remove();
            $('.edit-comment').remove();

            const commentId = $(this).data('comment-id');
            if (!commentId) {
                alert('댓글 ID를 찾을 수 없습니다.');
                return;
            }

            const commentContent = parentComment.find('.comment-body pre').html(); // 개행 문자를 포함한 HTML 내용 가져오기
            const depth = $(this).data('comment-depth');

            const editFormHtml = `
                <div class="edit-comment">
                    <div class="edit-comment-header">
                        <div>${sessionScope.dto.s_name == 'admin' ? '관리자' : sessionScope.dto.s_name}</div>
                    </div>
                    <form class="edit-form-inner">
                        <input type="hidden" name="commentId" class="commentId" value="">
                        <div class="comment-container comment-focus">
                            <textarea name="content" id="editContent" rows="4" cols="50" required></textarea>
                            <div>
                                <div class="button-container"></div>
                                <div class="submit-button">
                                    <button type="submit" class="btn-submit btn-custom">수정 완료</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            `;

            const editForm = $(editFormHtml).attr('style', '--depth:' + depth);
            parentComment.after(editForm);
            parentComment.next('.edit-comment').find('.commentId').val(commentId);
            const textarea = parentComment.next('.edit-comment').find('#editContent');
            textarea.val(commentContent); // 개행 문자를 포함한 내용을 설정하기 위해 val() 사용
            autoResizeTextarea(textarea[0]); // 텍스트 영역의 크기를 자동으로 조정
            textarea.on('input', function() {
                autoResizeTextarea(this);
            });
            textarea.focus();
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

        $(document).on('click', '.delete-btn', function() {
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

        $(document).on('click', '.button-container', function() {
            const textarea = $(this).closest('.comment-container').find('textarea');
            textarea.focus();
        });

        // 이벤트 리스너를 document에 추가하여 모든 textarea에서 작동하도록 설정
        $(document).on('focus', 'textarea', function() {
            $(this).closest('.comment-container').find('.btn-submit').css('visibility', 'visible');
        });

        $(document).on('blur', 'textarea', function() {
            const container = $(this).closest('.comment-container');
            setTimeout(function() {
                if (!container.find('textarea').is(':focus')) {
                    container.find('.btn-submit').css('visibility', 'hidden');
                }
            }, 100);
        });

        $(document).on('input', 'textarea', function() {
            autoResizeTextarea(this);
        });

        $(document).on('click', '.comment-container', function() {
            $(this).find('textarea').focus();
        });
    });
    </script>
</body>
</html>
