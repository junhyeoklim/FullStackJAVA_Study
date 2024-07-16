package com.springbook.view.board;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class IncreaseViewCountController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String b_idParam = request.getParameter("b_id");
        String category = request.getParameter("category");
        String redirect = request.getParameter("redirect");

        if (b_idParam != null) {
            try {
                long b_id = Long.parseLong(b_idParam);
                BoardDAO dao = BoardDAO.getBoardDAO();
                BoardVO board = dao.getBoard(b_id, category);
                
                dao.increaseViewCount(b_id, category);
                request.setAttribute("board", board);
                
                if (redirect != null) {
                    response.sendRedirect(redirect + "&b_id=" + b_id);
                } else {
                    response.sendRedirect(request.getContextPath() + "/User_View/view.board?b_id=" + b_id);
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/errorPage.jsp");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/errorPage.jsp");
        }
        return null; // AJAX 요청이므로 뷰 네비게이션이 필요 없음
    }
}
