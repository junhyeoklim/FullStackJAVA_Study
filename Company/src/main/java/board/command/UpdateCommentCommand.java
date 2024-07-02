package board.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import board.dao.BoardDAO;

public class UpdateCommentCommand implements Command {

    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commentIdParam = request.getParameter("commentId");
        String content = request.getParameter("content");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();

        System.out.println("commentId: " + commentIdParam);  // 전달된 commentId 출력
        System.out.println("content: " + content);  // 전달된 content 출력

        if (commentIdParam == null || commentIdParam.isEmpty() || content == null || content.isEmpty()) {
            String jsonResponse = gson.toJson(new Response("error", "Comment ID or content is missing"));
            response.getWriter().write(jsonResponse);
            return;
        }

        try {
            long commentId = Long.parseLong(commentIdParam);
            BoardDAO dao = BoardDAO.getBoardDAO();
            dao.updateComment(commentId, content);
            String jsonResponse = gson.toJson(new Response("success"));
            response.getWriter().write(jsonResponse);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            String jsonResponse = gson.toJson(new Response("error", "Invalid comment ID format"));
            response.getWriter().write(jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
            String jsonResponse = gson.toJson(new Response("error", "Failed to update comment"));
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
