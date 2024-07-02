package board.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import test.board.BoardDao;

public class IncreaseViewCountCommand implements Command {

    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String b_idParam = request.getParameter("b_id");
        String category = request.getParameter("category");
        String redirect = request.getParameter("redirect");

        if (b_idParam != null) {
            try {
                long b_id = Long.parseLong(b_idParam);
                BoardDAO dao = BoardDAO.getBoardDAO();
                BoardDTO board = dao.getBoard(b_id, category);
                
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
    }
}
