package com.springbook.view.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.common.PageVO;
import com.springbook.view.controller.Controller;

public class ListBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        
        ArrayList<BoardVO> list = dao.listBoard(pageVO);
        ArrayList<BoardVO> noticeList = dao.getNoticeBoards();
        
        request.setAttribute("noticeList", noticeList);
        request.setAttribute("list", list);
        request.setAttribute("pagingInfo", pageVO);

        return "User_View/BoardListView"; // 뷰 이름 반환
    }
}
