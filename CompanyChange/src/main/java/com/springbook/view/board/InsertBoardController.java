package com.springbook.view.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.salary.CompanyVO;
import com.springbook.view.controller.Controller;

public class InsertBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        CompanyVO VO = (CompanyVO) session.getAttribute("VO");
        String userDepartment = VO.getS_department();
        String userName = VO.getS_name();
        int userId = VO.getS_id();

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        boolean is_notice = Boolean.parseBoolean(request.getParameter("is_notice"));

        BoardDAO board = BoardDAO.getBoardDAO();
        long b_id = 0;

        try {
            if (userName.equals("admin")) {
                b_id = board.insertPost(title, content, userName, userId, is_notice);
            } else {
                b_id = board.insertPost(title, content, userName, userId, userDepartment);
                System.out.println("Inserted post ID: " + b_id);
            }

            // 게시글 ID를 JSON 형식으로 반환
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("b_id", b_id);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonResponse.toString());

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("status", "error");
            jsonResponse.addProperty("message", "게시물 등록에 실패했습니다.");
            response.getWriter().write(jsonResponse.toString());
        }
        return null; // AJAX 요청이므로 뷰 네비게이션이 필요 없음
    }
}
