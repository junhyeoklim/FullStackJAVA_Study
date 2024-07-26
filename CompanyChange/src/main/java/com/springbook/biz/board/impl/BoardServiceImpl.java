package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAOSpring boardDAO;

    @Override
    public void insertBoard(BoardVO vo) {
        boardDAO.insertBoard(vo);
    }

    @Override
    public void updateBoard(BoardVO vo) {
        boardDAO.updateBoard(vo);
    }

    @Override
    public void deleteBoard(long b_id) {
        boardDAO.deleteBoard(b_id);
    }

    @Override
    public BoardVO getBoard(long b_id) {
        return boardDAO.getBoard(b_id);
    }

    @Override
    public List<BoardVO> getBoardList() {
        return boardDAO.getBoardList();
    }

    @Override
    public boolean deletePost(long b_id, boolean isNotice) {
        return boardDAO.deletePost(b_id, isNotice);
    }
}
