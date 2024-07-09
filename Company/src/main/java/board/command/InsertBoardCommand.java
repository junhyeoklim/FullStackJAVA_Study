package board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import board.dao.BoardDAO;
import company.dto.CompanyDTO;

public class InsertBoardCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CompanyDTO dto = (CompanyDTO) session.getAttribute("dto");
        String userDepartment = dto.getS_department();
        String userName = dto.getS_name();
        int userId = dto.getS_id();

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
        }
    }
}