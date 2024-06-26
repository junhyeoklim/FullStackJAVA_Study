<%@page import="test.board.CommentHelper"%>
<%@page import="test.board.Comment"%>
<%@page import="java.util.List"%>
<%@page import="test.board.Board"%>
<%@page import="test.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String b_idParam = request.getParameter("b_id");
    BoardDao boardDao = new BoardDao();

    Board board = null;
    List<Comment> comments = null;

    if (b_idParam != null) {
        try {
            long b_id = Long.parseLong(b_idParam);
            boardDao.increaseViewCount(b_id);
            board = boardDao.getBoardById(b_id);
            comments = boardDao.getCommentsByPostId(b_id);
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
        <p><%= board.getContent() %></p>
        <p>작성자: <%= board.getSDepartment() %></p>
        <p>작성일: <%= board.getCreateTime() %></p>
        <p>조회수: <%= board.getViews() %></p>

        <h2>댓글</h2>
        <%
            if (comments != null) {
                out.println(CommentHelper.generateCommentsHtml(comments, 0, 0));
            }
        %>

        <h2>댓글 작성</h2>
        <form action="addComment.jsp" method="post">
            <input type="hidden" name="b_id" value="<%= b_idParam %>">
            <label for="userName">이름:</label>
            <input type="text" id="userName" name="userName" required><br>
            <label for="content">내용:</label>
            <textarea id="content" name="content" rows="4" cols="50" required></textarea><br>
            <button type="submit" class="btn btn-primary">댓글 작성</button>
        </form>

        <!-- <h2>대댓글 작성</h2> -->
<%--         <div id="replyForm" style="display:none;">
            <form action="addReply.jsp" method="post">
                <input type="hidden" id="reply_b_id" name="b_id" value="<%= b_idParam %>">
                <input type="hidden" id="parentCommentId" name="parentCommentId" value="">
                <label for="replyUserName">이름:</label>
                <input type="text" id="replyUserName" name="userName" required><br>
                <label for="replyContent">내용:</label>
                <textarea id="replyContent" name="content" rows="4" cols="50" required></textarea><br>
                <button type="submit" class="btn btn-primary">대댓글 작성</button>
            </form>
        </div> --%>
    </div>
<%
    }
%>
    <script>
        document.querySelectorAll('.reply-btn').forEach(button => {
            button.addEventListener('click', function() {
                const commentId = this.getAttribute('data-comment-id');
                console.log(commentId);
                const replyFormHtml = `
                    <div class="reply-form">
                        <form action="addReply.jsp" method="post">
                            <input type="hidden" name="b_id" value="<%= b_idParam %>">
                            <input type="hidden" name="parentCommentId" id="parentCommentId"  value="">
                            <label for="replyUserName">이름:</label>
                            <input type="text" name="userName" required><br>
                            <label for="replyContent">내용:</label>
                            <textarea name="content" rows="4" cols="50" required></textarea><br>
                            <button type="submit" class="btn btn-primary">대댓글 작성</button>
                        </form>
                    </div>
                `;
                const parentComment = this.closest('.comment');
                // 이전에 열린 답글 폼이 있으면 닫기
                const existingReplyForm = document.querySelector('.reply-form');
                if (existingReplyForm) {
                        existingReplyForm.remove();
                    }
                // 현재 댓글 아래에 답글 폼 추가
                parentComment.insertAdjacentHTML('afterend', replyFormHtml);
                document.getElementById('parentCommentId').value = commentId;
           		
            });
        });
        
        document.querySelectorAll('.edit-btn').forEach(button => {
            button.addEventListener('click', function() {
                const commentId = this.getAttribute('data-comment-id');
                // TODO: Implement comment edit functionality
                alert('수정 기능은 아직 구현되지 않았습니다.');
            });
        });

        document.querySelectorAll('.delete-btn').forEach(button => {
            button.addEventListener('click', function() {
                const commentId = this.getAttribute('data-comment-id');
                if (confirm('댓글을 삭제하시겠습니까?')) {
                    // TODO: Implement comment delete functionality
                    alert('삭제 기능은 아직 구현되지 않았습니다.');
                }
            });
        });
    </script>
</body>
</html>