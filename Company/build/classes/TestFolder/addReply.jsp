<%@page import="test.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    String b_idParam = request.getParameter("b_id");
    String userName = request.getParameter("userName");
    String content = request.getParameter("content");
    String parentCommentIdParam = request.getParameter("parentCommentId");

    // 디버깅 정보를 출력하여 파라미터 확인
    out.println("b_idParam: " + b_idParam + "<br>");
    out.println("userName: " + userName + "<br>");
    out.println("content: " + content + "<br>");
    out.println("parentCommentIdParam: " + parentCommentIdParam + "<br>");

    if (b_idParam != null && userName != null && content != null && parentCommentIdParam != null && !parentCommentIdParam.isEmpty()) {
        try {
            long b_id = Long.parseLong(b_idParam);
            long parentCommentId = Long.parseLong(parentCommentIdParam);
            BoardDao boardDao = new BoardDao();
            boardDao.insertComment(b_id, userName, content, parentCommentId);
            response.sendRedirect("viewPost.jsp?b_id=" + b_id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            out.println("Invalid format.");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("An error occurred while adding the reply.");
        }
    } else {
        out.println("Missing required parameters.");
    }
%>