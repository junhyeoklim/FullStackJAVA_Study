package board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import board.dao.BoardDAO;

public class DeleteBoardCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int b_id = Integer.parseInt(request.getParameter("b_id"));
        boolean isNotice = Boolean.parseBoolean(request.getParameter("isNotice"));
        BoardDAO dao = BoardDAO.getBoardDAO();
		boolean success = dao.deletePost(b_id, isNotice);
		
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();

        if (success) {
            String jsonResponse = gson.toJson(new Response("success"));
            response.getWriter().write(jsonResponse);
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            String jsonResponse = gson.toJson(new Response("error", "게시물 삭제에 실패했습니다."));
            response.getWriter().write(jsonResponse);
        }
    }

    class Response {
        private String status;
        private String message;

        public Response(String status) {
            this.status = status;
        }

        public Response(String status, String message) {
            this.status = status;
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}