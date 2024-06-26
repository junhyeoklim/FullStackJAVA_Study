<%@page import="test.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    String b_idParam = request.getParameter("b_id");
    String userName = request.getParameter("userName");
    String content = request.getParameter("content");

    if (b_idParam != null && userName != null && content != null) {
        try {
            long b_id = Long.parseLong(b_idParam);
            BoardDao boardDao = new BoardDao();
            boardDao.insertComment(b_id, userName, content, null);
            response.sendRedirect("viewPost.jsp?b_id=" + b_id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            out.println("Invalid format.");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("An error occurred while adding the comment.");
        }
    } else {
        out.println("Missing required parameters.");
    }
%>