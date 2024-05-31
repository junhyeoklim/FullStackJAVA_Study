package board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class WriteOKCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			BoardDAO dao = BoardDAO.getBoardDAO();
			BoardDTO dto = new BoardDTO();
			dto.setName(request.getParameter("name"));
			dto.setTitle(request.getParameter("title"));
			dto.setContents(request.getParameter("contents"));
			dao.writeOKDAO(dto);
	}

	
}
