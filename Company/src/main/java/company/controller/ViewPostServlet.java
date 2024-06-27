package company.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.board.Board;
import test.board.BoardDao;
import test.board.Comment;

@WebServlet("/viewPost")
public class ViewPostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewPostServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String b_idParam = request.getParameter("b_id");
        BoardDao boardDao = new BoardDao();

        Board board = null;
        List<Comment> comments = null;
        List<String> images = null;

        if (b_idParam != null) {
            try {
                long b_id = Long.parseLong(b_idParam);
                boardDao.increaseViewCount(b_id);
                board = boardDao.getBoardById(b_id);
                comments = boardDao.getCommentsByPostId(b_id);
                images = boardDao.getImagesByPostId(b_id); // 이미지 URL 가져오기
                List<String> preparedImageUrls = prepareImageUrls(board, images);
                request.setAttribute("preparedImageUrls", preparedImageUrls);
                request.setAttribute("boardContent", replacePlaceholdersWithImageUrls(board.getContent(), preparedImageUrls));
                request.setAttribute("board", board);
                request.setAttribute("comments", comments);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                request.setAttribute("error", "Invalid b_id format.");
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "An error occurred while retrieving the board and comments.");
            }
        } else {
            request.setAttribute("error", "b_id parameter is missing.");
        }

        request.getRequestDispatcher("/WEB-INF/jsp/viewPost.jsp").forward(request, response);
    }

    private List<String> prepareImageUrls(Board board, List<String> imageUrls) {
        List<String> preparedImageUrls = new ArrayList<>();
        for (int i = 0; i < imageUrls.size(); i++) {
            try {
                String decodedUrl = URLDecoder.decode(imageUrls.get(i), "UTF-8");
                decodedUrl = "/upload/" + new File(decodedUrl).getName();
                preparedImageUrls.add(decodedUrl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return preparedImageUrls;
    }

    private String replacePlaceholdersWithImageUrls(String content, List<String> imageUrls) {
        for (int i = 0; i < imageUrls.size(); i++) {
            String url = imageUrls.get(i);
            content = content.replace("[IMAGE-" + i + "]", "<img src='" + url + "' alt='Image' style='width: 1088px;'>");
        }
        return content;
    }
}
