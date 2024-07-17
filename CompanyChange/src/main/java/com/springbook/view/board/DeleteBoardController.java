package com.springbook.view.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.common.DeleteRequest;
import com.springbook.biz.common.Response;

@Controller
public class DeleteBoardController {

    @Autowired
    private BoardDAO boardDAO;

    @RequestMapping(value = "/deleteBoard.do", method = RequestMethod.POST)
    @ResponseBody
    public Response deleteBoard(@RequestBody DeleteRequest deleteRequest) {
        System.out.println("글 삭제 처리");

        int b_id = deleteRequest.getB_id();
        boolean isNotice = deleteRequest.isNotice();

        boolean success = boardDAO.deletePost(b_id, isNotice);

        if (success) {
            return new Response("success");
        } else {
            return new Response("error", "게시물 삭제에 실패했습니다.");
        }
    }
}
