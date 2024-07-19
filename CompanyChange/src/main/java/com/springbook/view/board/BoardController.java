package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardService;
import com.springbook.biz.common.DeleteRequest;
import com.springbook.biz.common.Response;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시물 목록 조회
    @RequestMapping("/listBoard.do")
    public String listBoard(Model model) {
        List<BoardVO> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "listBoard";
    }

    // 게시물 상세 조회
    @RequestMapping("/getBoard.do")
    public String getBoard(@RequestParam("b_id") long b_id, Model model) {
        BoardVO board = boardService.getBoard(b_id);
        model.addAttribute("board", board);
        return "viewBoard";
    }

    // 게시물 등록 폼
    @RequestMapping(value = "/createBoardView.do", method = RequestMethod.GET)
    public String createBoardView() {
        return "createBoard";
    }

    // 게시물 등록
    @RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
    public String insertBoard(BoardVO board, HttpSession session) {
        boardService.insertBoard(board);
        return "redirect:listBoard.do";
    }

    // 게시물 수정 폼
    @RequestMapping(value = "/modifyBoardView.do", method = RequestMethod.GET)
    public String modifyBoardView(@RequestParam("b_id") long b_id, Model model) {
        BoardVO board = boardService.getBoard(b_id);
        model.addAttribute("board", board);
        return "modifyBoard";
    }

    // 게시물 수정
    @RequestMapping(value = "/updateBoard.do", method = RequestMethod.POST)
    public String updateBoard(BoardVO board, HttpSession session) {
        boardService.updateBoard(board);
        return "redirect:listBoard.do";
    }

    // 기존 게시물 삭제
    @RequestMapping(value = "/deleteBoard.do", method = RequestMethod.POST)
    public String deleteBoard(@RequestParam("b_id") long b_id) {
        boardService.deleteBoard(b_id);
        return "redirect:listBoard.do";
    }

    // 게시물 삭제 처리
    @RequestMapping(value = "/deleteBoardPost.do", method = RequestMethod.POST)
    @ResponseBody
    public Response deleteBoardPost(@RequestBody DeleteRequest deleteRequest) {
        long b_id = deleteRequest.getB_id();
        boolean isNotice = deleteRequest.isNotice();

        boolean success = boardService.deletePost(b_id, isNotice);

        if (success) {
            return new Response("success");
        } else {
            return new Response("error", "게시물 삭제에 실패했습니다.");
        }
    }
}
