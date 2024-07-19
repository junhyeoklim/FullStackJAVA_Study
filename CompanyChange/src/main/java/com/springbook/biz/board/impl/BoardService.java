package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.file.impl.FileService;

@Service
public class BoardService {

    @Autowired
    private BoardDAOSpring boardDAO;

    @Autowired
    private FileService fileService;

    // 게시물 목록 조회
    public List<BoardVO> getBoardList() {
        return boardDAO.getBoardList();
    }

    // 게시물 상세 조회
    public BoardVO getBoard(long b_id) {
        return boardDAO.getBoard(b_id);
    }

    // 게시물 등록
    public void insertBoard(BoardVO board) {
        boardDAO.insertBoard(board);
    }

    // 게시물 수정
    public void updateBoard(BoardVO board) {
        boardDAO.updateBoard(board);
    }

    // 게시물 삭제 처리
    public boolean deletePost(int b_id, boolean isNotice) {
        return boardDAO.deletePost(b_id, isNotice);
    }
}
