<%@page import="test.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String commentIdParam = request.getParameter("comment_id");
    String content = request.getParameter("content");

    if (commentIdParam != null && content != null) {
        try {
            long commentId = Long.parseLong(commentIdParam);
            BoardDao boardDao = new BoardDao();
            boardDao.updateComment(commentId, content);
            response.sendRedirect("viewPost.jsp?b_id=" + request.getParameter("b_id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            out.println("Invalid format.");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("An error occurred while editing the comment.");
        }
    } else {
        out.println("Missing required parameters.");
    }
%>