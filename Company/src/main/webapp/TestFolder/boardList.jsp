<%@page import="test.board.Board"%>
<%@page import="java.util.List"%>
<%@page import="test.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    BoardDao boardDao = new BoardDao();
    List<Board> boards = null;
    try {
        boards = boardDao.getAllBoards(); // 모든 게시물을 가져오는 메서드를 구현해야 합니다.
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시물 목록</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>게시물 목록</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (boards != null) {
                        for (Board board : boards) {
                %>
                <tr>
                    <td><%= board.getPostNum() %></td>
                    <td><a href="viewPost.jsp?b_id=<%= board.getBId() %>"><%= board.getTitle() %></a></td>
                    <td><%= board.getSDepartment() %></td>
                    <td><%= board.getCreateTime() %></td>
                    <td><%= board.getViews() %></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
        <a href="writePost.jsp" class="btn btn-primary">게시물 작성</a>
    </div>
</body>
</html>