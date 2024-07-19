package com.springbook.biz.comment.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.CommentVO;

import java.util.ArrayList;

@Service
public class CommentService {

    @Autowired
    private CommentDAO commentDAO;

    // 댓글 등록
    public void insertComment(CommentVO comment) {
        commentDAO.insertComment(comment);
    }

    // 댓글 삭제
    public boolean deleteComment(long c_id) {
        return commentDAO.deleteComment(c_id);
    }

    // 댓글 수정
    public void updateComment(long commentId, String content) {
        commentDAO.updateComment(commentId, content);
    }

    // 게시물 ID로 댓글 조회
    public ArrayList<CommentVO> getCommentsByPostId(long b_id) {
        return commentDAO.getCommentsByPostId(b_id);
    }
}
