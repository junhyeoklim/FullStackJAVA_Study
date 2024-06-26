package company.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
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

        BoardDao boardDao = new BoardDao();
        try {
            long b_id = boardDao.insertPost(title, content, 1, "컴퓨터공학");

            // 로그로 b_id를 확인
            System.out.println("Inserted post ID: " + b_id);

            // 게시글 내용에서 이미지 경로 추출
            List<String> imageUrls = extractImageUrls(content);

            for (String imageUrl : imageUrls) {
                // 이미지 파일 이름 추출
                String fileName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);

                // 데이터베이스에 이미지 정보 저장
                boardDao.insertImage(b_id, fileName, imageUrl);
            }

            response.getWriter().write("success");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("failure: " + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private List<String> extractImageUrls(String content) {
        List<String> imageUrls = new ArrayList<>();
        int start = 0;
        while ((start = content.indexOf("<img", start)) != -1) {
            int srcStart = content.indexOf("src=\"", start) + 5;
            int srcEnd = content.indexOf("\"", srcStart);
            String imageUrl = content.substring(srcStart, srcEnd);
            imageUrls.add(imageUrl);
            start = srcEnd;
        }
        return imageUrls;
    }
}
