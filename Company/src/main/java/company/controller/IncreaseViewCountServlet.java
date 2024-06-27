package company.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import test.board.BoardDao;

@WebServlet("/IncreaseViewCountServlet")
public class IncreaseViewCountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public IncreaseViewCountServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String b_idParam = request.getParameter("b_id");
        String redirect = request.getParameter("redirect");

        if (b_idParam != null) {
            try {
                long b_id = Long.parseLong(b_idParam);
                BoardDao boardDao = new BoardDao();
                boardDao.increaseViewCount(b_id);
                response.sendRedirect(redirect != null ? redirect : "viewPost.jsp?b_id=" + b_id);
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("errorPage.jsp"); // 에러 페이지로 리디렉션
            }
        } else {
            response.sendRedirect("errorPage.jsp"); // 에러 페이지로 리디렉션
        }
    }
}
