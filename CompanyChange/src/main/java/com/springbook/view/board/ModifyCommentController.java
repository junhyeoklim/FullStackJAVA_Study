package com.springbook.view.board;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class ModifyCommentController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String commentIdParam = request.getParameter("commentId");
        String content = request.getParameter("content");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();

        System.out.println("commentId: " + commentIdParam);  // 전달된 commentId 출력
        System.out.println("content: " + content);  // 전달된 content 출력

        if (commentIdParam == null || content == null || content.isEmpty()) {
            String jsonResponse = gson.toJson(new Response("error", "Comment ID or content is missing"));
            response.getWriter().write(jsonResponse);
            return null; // AJAX 요청이므로 뷰 네비게이션이 필요 없음
        }

        try {
            long commentId = Long.parseLong(commentIdParam);
            BoardDAO dao = BoardDAO.getBoardDAO();
            dao.updateComment(commentId, content);
            String jsonResponse = gson.toJson(new Response("success"));
            response.getWriter().write(jsonResponse);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            String jsonResponse = gson.toJson(new Response("error", "Invalid comment ID format"));
            response.getWriter().write(jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
            String jsonResponse = gson.toJson(new Response("error", "Failed to update comment"));
            response.getWriter().write(jsonResponse);
        }
        return null; // AJAX 요청이므로 뷰 네비게이션이 필요 없음
    }

    class Response {
        private String status;
        private String message;

        public Response(String status) {
            this.status = status;
        }

        public Response(String status, String message) {
            this.status = status;
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
