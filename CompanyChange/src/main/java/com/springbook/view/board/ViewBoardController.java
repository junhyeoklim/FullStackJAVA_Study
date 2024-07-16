package com.springbook.view.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.CommentVO;
import com.springbook.biz.board.FileVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class ViewBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BoardDAO dao = BoardDAO.getBoardDAO();
        String category = request.getParameter("category");
        String boardId = request.getParameter("b_id");

        if (category != null && boardId != null) {
            try {
                long b_id = Long.parseLong(boardId);

                BoardVO board = dao.getBoard(b_id, category);
                ArrayList<CommentVO> comments = dao.getCommentsByPostId(b_id);
                ArrayList<FileVO> files = dao.getFilesByBoardId(b_id); // 파일 목록 가져오기

                request.setAttribute("board", board);
                request.setAttribute("comments", comments);
                request.setAttribute("files", files); // 파일 목록 속성 추가
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Category or boardId is null");
        }

        return "BoardView"; // 뷰 이름 반환
    }
}
