package board.command;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import board.dto.CommentDTO;

public class ViewBoardCommand implements Command {

    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BoardDAO dao = BoardDAO.getBoardDAO();
        String category = request.getParameter("category");
        String boardId = request.getParameter("b_id");

        if (category != null && boardId != null) {
            try {
                long b_id = Long.parseLong(boardId);

                BoardDTO board = dao.getBoard(b_id, category);
                ArrayList<CommentDTO> comments = dao.getCommentsByPostId(b_id);

                request.setAttribute("board", board);
                request.setAttribute("comments", comments);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Category or boardId is null");
        }
    }
}
