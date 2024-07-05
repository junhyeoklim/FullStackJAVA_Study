package board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import board.dao.BoardDAO;

public class UpdateBoardCommand implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long b_id = Long.parseLong(request.getParameter("b_id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        boolean isNotice = Boolean.parseBoolean(request.getParameter("is_notice"));

        BoardDAO dao = BoardDAO.getBoardDAO();
        boolean success = dao.updatePost(b_id, title, content, isNotice);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(new ResponseStatus(success ? "success" : "error"));
        response.getWriter().write(jsonResponse);
    }

    class ResponseStatus {
        private String status;

        public ResponseStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}