package com.springbook.view.board;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.CommentVO;
import com.springbook.biz.board.FileVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class ViewBoardController {

    @RequestMapping("/viewBoard.do")
    public String handleRequest(@RequestParam("category") String category,
                                @RequestParam("b_id") long b_id,
                                Model model) throws IOException {
        BoardDAO dao = BoardDAO.getBoardDAO();

        try {
            BoardVO board = dao.getBoard(b_id, category);
            ArrayList<CommentVO> comments = dao.getCommentsByPostId(b_id);
            ArrayList<FileVO> files = dao.getFilesByBoardId(b_id); // 파일 목록 가져오기

            model.addAttribute("board", board);
            model.addAttribute("comments", comments);
            model.addAttribute("files", files); // 파일 목록 속성 추가
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "BoardView"; // 뷰 이름 반환
    }
}
