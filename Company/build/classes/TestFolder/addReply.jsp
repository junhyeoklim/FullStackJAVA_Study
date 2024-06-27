<%@page import="test.board.BoardDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    response.setContentType("application/json; charset=UTF-8");

    String b_idParam = request.getParameter("b_id");
    String userName = request.getParameter("userName");
    String content = request.getParameter("content");
    String parentCommentIdParam = request.getParameter("parentCommentId");

    // 디버깅 메시지 제거
    System.out.println("b_idParam: " + b_idParam);
    System.out.println("userName: " + userName);
    System.out.println("content: " + content);
    System.out.println("parentCommentIdParam: " + parentCommentIdParam);

    if (b_idParam != null && userName != null && content != null && parentCommentIdParam != null && !parentCommentIdParam.isEmpty()) {
        try {
            long b_id = Long.parseLong(b_idParam);
            long parentCommentId = Long.parseLong(parentCommentIdParam);
            BoardDao boardDao = new BoardDao();
            boardDao.insertComment(b_id, userName, content, parentCommentId);
            response.getWriter().write("{\"status\":\"success\"}");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"status\":\"error\", \"message\":\"Invalid format.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"status\":\"error\", \"message\":\"An error occurred while adding the reply.\"}");
        }
    } else {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.getWriter().write("{\"status\":\"error\", \"message\":\"Missing required parameters.\"}");
    }
%>
