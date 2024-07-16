package com.springbook.view.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.common.PageVO;
import com.springbook.view.controller.Controller;

public class SearchBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        BoardDAO dao = BoardDAO.getBoardDAO();
        PageVO pageVO = new PageVO();

        try {
            if (request.getParameter("page") != null) {
                String pageStr = request.getParameter("page").replaceAll("[^\\d]", "");
                pageVO.setCurrentPage(Integer.parseInt(pageStr));
            } else {
                pageVO.setCurrentPage(1);
            }
        } catch (NumberFormatException e) {
            pageVO.setCurrentPage(1);
        }

        pageVO.setRecordsPerPage(10);

        String select = request.getParameter("kindOfSearch");
        String keyword = request.getParameter("searchKeyword");
        
        if (keyword.equals("관리자"))
            keyword = "admin";
        
        ArrayList<BoardVO> list = null;

        if (select != null && keyword != null && !keyword.isEmpty()) {
            keyword = keyword.replaceAll("'", "''");
            list = dao.searchBoard(pageVO, select, keyword);
        } else {
            list = dao.listBoard(pageVO);
        }

        ArrayList<BoardVO> noticeList = dao.getNoticeBoards();

        request.setAttribute("noticeList", noticeList);
        request.setAttribute("list", list);
        request.setAttribute("pagingInfo", pageVO);
        request.setAttribute("kindOfSearch", select);
        request.setAttribute("searchKeyword", keyword);

        return "searchBoard"; // 뷰 이름 반환
    }
}
