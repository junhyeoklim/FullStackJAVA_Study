package com.springbook.view.board;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class UpdateBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long b_id = Long.parseLong(request.getParameter("b_id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        boolean isNotice = Boolean.parseBoolean(request.getParameter("is_notice"));

        BoardDAO dao = BoardDAO.getBoardDAO();
        boolean success = dao.updatePost(b_id, title, content, isNotice);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(new ResponseStatus(success ? "success" : "error"));
        response.getWriter().write(jsonResponse);
        return null; // AJAX 요청이므로 뷰 네비게이션이 필요 없음
    }

    class ResponseStatus {
        private String status;

        public ResponseStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
