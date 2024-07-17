package com.springbook.view.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.common.Constants;

@Controller
public class IncreaseViewCountController {

    @RequestMapping("/increaseViewCount.do")
    public void handleRequest(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam("b_id") long b_id,
                              @RequestParam("category") String category,
                              @RequestParam("redirect") String redirect) throws IOException {
        try {
            BoardDAO dao = BoardDAO.getBoardDAO();
            BoardVO board = dao.getBoard(b_id, category);

            dao.increaseViewCount(b_id, category);
            request.setAttribute("board", board);

            if (redirect != null) {
                response.sendRedirect(redirect + "&b_id=" + b_id);
            } else {
                response.sendRedirect(request.getContextPath() + Constants.ADMIN_VIEW +"/viewBoard.do?b_id=" + b_id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/errorPage.jsp");
        }
    }
}
