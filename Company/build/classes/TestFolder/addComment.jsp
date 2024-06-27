<%@page import="test.board.BoardDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    response.setContentType("application/json; charset=UTF-8");

    String b_idParam = request.getParameter("b_id");
    String userName = request.getParameter("userName");
    String content = request.getParameter("content");

    if (b_idParam != null && userName != null && content != null) {
        try {
            long b_id = Long.parseLong(b_idParam);
            BoardDao boardDao = new BoardDao();
            boardDao.insertComment(b_id, userName, content, null);
            response.getWriter().write("{\"status\":\"success\"}");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"status\":\"error\", \"message\":\"Invalid format.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"status\":\"error\", \"message\":\"An error occurred while adding the comment.\"}");
        }
    } else {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.getWriter().write("{\"status\":\"error\", \"message\":\"Missing required parameters.\"}");
    }
%>
