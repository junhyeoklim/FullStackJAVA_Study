package board.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import common.dto.PageDTO;

public class SearchBoardCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        BoardDAO dao = BoardDAO.getBoardDAO();
        PageDTO pageDTO = new PageDTO();

        try {
            if (request.getParameter("page") != null) {
                String pageStr = request.getParameter("page").replaceAll("[^\\d]", "");
                pageDTO.setCurrentPage(Integer.parseInt(pageStr));
            } else {
                pageDTO.setCurrentPage(1);
            }
        } catch (NumberFormatException e) {
            pageDTO.setCurrentPage(1);
        }

        pageDTO.setRecordsPerPage(10);

        String select = request.getParameter("kindOfSearch");
        String keyword = request.getParameter("searchKeyword");

        ArrayList<BoardDTO> list = null;

        if (select != null && keyword != null && !keyword.isEmpty()) {
            keyword = keyword.replaceAll("'", "''");
            list = dao.searchBoard(pageDTO, select, keyword);
        } else {
            list = dao.listBoard(pageDTO);
        }

        ArrayList<BoardDTO> noticeList = dao.getNoticeBoards();

        request.setAttribute("noticeList", noticeList);
        request.setAttribute("list", list);
        request.setAttribute("pagingInfo", pageDTO);
        request.setAttribute("kindOfSearch", select);
        request.setAttribute("searchKeyword", keyword);
    }
}
