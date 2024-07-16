package com.springbook.view.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.springbook.biz.board.CommentVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.salary.CompanyVO;
import com.springbook.view.controller.Controller;

public class InsertCommentController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        CompanyVO user = (CompanyVO) session.getAttribute("VO"); // 세션에서 사용자 정보를 가져옴

        if (user == null) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            Gson gson = new Gson();
            String jsonResponse = gson.toJson(new Response("error", "User not logged in"));
            response.getWriter().write(jsonResponse);
            return null; // AJAX 요청이므로 뷰 네비게이션이 필요 없음
        }

        long b_id = Long.parseLong(request.getParameter("b_id"));
        String content = request.getParameter("content").trim();
        String parentCommentIdParam = request.getParameter("parentCommentId");
        Long parentCommentId = parentCommentIdParam == null || parentCommentIdParam.isEmpty() ? null : Long.parseLong(parentCommentIdParam);

        CommentVO comment = new CommentVO();
        comment.setB_Id(b_id);
        comment.setS_id(user.getS_id()); // 사용자 ID 설정
        comment.setUserName(user.getS_name()); // 사용자 이름을 설정
        comment.setContent(content);
        comment.setParentCommentId(parentCommentId);
        comment.setIs_deleted(false); // 초기값 설정

        BoardDAO dao = BoardDAO.getBoardDAO();
        dao.insertComment(comment);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(new Response("success"));
        response.getWriter().write(jsonResponse);
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
