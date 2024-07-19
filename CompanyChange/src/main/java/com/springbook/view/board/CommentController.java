package com.springbook.view.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbook.biz.board.CommentService;
import com.springbook.biz.board.CommentVO;
import com.springbook.biz.common.Response;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 댓글 등록
    @RequestMapping(value = "/insertComment.do", method = RequestMethod.POST)
    @ResponseBody
    public Response insertComment(@RequestBody CommentVO comment) {
        boolean success = commentService.insertComment(comment);
        if (success) {
            return new Response("success");
        } else {
            return new Response("error", "댓글 등록에 실패했습니다.");
        }
    }

    // 댓글 삭제
    @RequestMapping(value = "/deleteComment.do", method = RequestMethod.POST)
    @ResponseBody
    public Response deleteComment(@RequestParam("c_id") long c_id) {
        boolean success = commentService.deleteComment(c_id);
        if (success) {
            return new Response("success");
        } else {
            return new Response("error", "댓글 삭제에 실패했습니다.");
        }
    }

    // 댓글 수정
    @RequestMapping(value = "/updateComment.do", method = RequestMethod.POST)
    @ResponseBody
    public Response updateComment(@RequestBody CommentVO comment) {
        boolean success = commentService.updateComment(comment);
        if (success) {
            return new Response("success");
        } else {
            return new Response("error", "댓글 수정에 실패했습니다.");
        }
    }
}
