package board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.dao.BoardDAO;
import company.dto.CompanyDTO;

public class InsertBoardCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        CompanyDTO dto = (CompanyDTO) session.getAttribute("dto");
        String userDepartment = dto.getS_department();
        int userId = dto.getS_id();
        
		BoardDAO board = BoardDAO.getBoardDAO();
		long b_id = 0;
		
			
        try {
            b_id = board.insertPost(title, content, userId, userDepartment);
            System.out.println("Inserted post ID: " + b_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
