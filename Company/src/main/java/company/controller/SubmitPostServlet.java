package company.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.board.BoardDao;

@WebServlet("/SubmitPostServlet")
@MultipartConfig
public class SubmitPostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SubmitPostServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String title = request.getParameter("title");
        String content = request.getParameter("content");

        // 텍스트 내용만 삽입
        BoardDao boardDao = new BoardDao();
        long b_id;
        try {
            b_id = boardDao.insertPost(title, content, 1, "컴퓨터공학");
            System.out.println("Inserted post ID: " + b_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.getWriter().write("success");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
}
