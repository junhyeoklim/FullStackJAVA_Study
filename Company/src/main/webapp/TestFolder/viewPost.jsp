<%@page import="java.util.ArrayList"%>
<%@page import="java.io.File"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="test.board.CommentHelper"%>
<%@page import="test.board.Comment"%>
<%@page import="java.util.List"%>
<%@page import="test.board.Board"%>
<%@page import="test.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%
    String b_idParam = request.getParameter("b_id");
    BoardDao boardDao = new BoardDao();

    Board board = null;
    List<Comment> comments = null;

    if (b_idParam != null) {
        try {
            long b_id = Long.parseLong(b_idParam);
            board = boardDao.getBoardById(b_id);
            comments = boardDao.getCommentsByPostId(b_id);
            request.setAttribute("boardContent", board.getContent());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            out.println("Invalid b_id format.");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("An error occurred while retrieving the board and comments.");
        }
    } else {
        out.println("b_id parameter is missing.");
    }
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시물 상세보기</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style>
        .comment { position: relative; }
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
<%
    if (board != null) {
%>
    <div class="container">
        <h1><%= board.getTitle() %></h1>
        <div><%= board.getContent() %></div>
        <p>작성자: <%= board.getSDepartment() %></p>
        <p>작성일: <%= board.getCreateTime() %></p>
        <p>조회수: <%= board.getViews() %></p>

        <h2>댓글</h2>
        <div id="comments-container">
            <%
                if (comments != null) {
                    out.println(CommentHelper.generateCommentsHtml(comments, 0, 0));
                }
            %>
        </div>

        <h2>댓글 작성</h2>
        <form id="comment-form">
            <input type="hidden" name="b_id" value="<%= b_idParam %>">
            <label for="userName">이름:</label>
            <input type="text" id="userName" name="userName" required><br>
            <label for="content">내용:</label>
            <textarea id="content" name="content" rows="4" cols="50" required></textarea><br>
            <button type="submit" class="btn btn-primary">댓글 작성</button>
        </form>
    </div>
<%
    }
%>
    <script>
        $('#comment-form').submit(function(e) {
            e.preventDefault();
            $.ajax({
                type: 'POST',
                url: 'addComment.jsp',
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
                        <input type="hidden" name="b_id" value="<%= b_idParam %>">
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
                url: 'addReply.jsp',
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
