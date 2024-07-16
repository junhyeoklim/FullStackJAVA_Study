package com.springbook.view.board;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class DeleteBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("글 삭제 처리");
        
        // 1. 사용자 입력 정보 추출
        int b_id = Integer.parseInt(request.getParameter("b_id"));
        boolean isNotice = Boolean.parseBoolean(request.getParameter("isNotice"));

        // 2. DB 연동 처리
        BoardDAO dao = BoardDAO.getBoardDAO();
        boolean success = dao.deletePost(b_id, isNotice);

        // 3. JSON 응답 생성
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        
        String jsonResponse;
        if (success) {
            jsonResponse = gson.toJson(new Response("success"));
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            jsonResponse = gson.toJson(new Response("error", "게시물 삭제에 실패했습니다."));
        }
        
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
