package com.springbook.biz.board.impl;

import java.util.List;

import com.springbook.biz.board.BoardVO;

public interface BoardService {
    void insertBoard(BoardVO vo);
    void updateBoard(BoardVO vo);
    void deleteBoard(long b_id);
    BoardVO getBoard(long b_id);
    List<BoardVO> getBoardList();
    boolean deletePost(long b_id, boolean isNotice);
}
