package board.command;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
        String boardId = request.getParameter("id");

        if (category != null && boardId != null) {
            try {
                long b_id = Long.parseLong(boardId);

                // 쿠키를 사용하여 조회수 증가 제어
                boolean incrementViewCount = true;
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("viewed_" + b_id)) {
                            incrementViewCount = false;
                            break;
                        }
                    }
                }

                if (incrementViewCount) {
                    dao.increaseViewCount(b_id, category);
                    Cookie cookie = new Cookie("viewed_" + b_id, "true");
                    cookie.setMaxAge(10); // 5분 동안 유지
                    response.addCookie(cookie);
                }

                BoardDTO board = dao.getBoard(b_id, category);
                ArrayList<CommentDTO> comments = dao.getCommentsByPostId(b_id);

                request.setAttribute("board", board);
                request.setAttribute("comments", comments);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Handle invalid id format
            } catch (Exception e) {
                e.printStackTrace();
                // Handle other exceptions
            }
        }
    }
}
