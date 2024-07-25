package com.springbook.biz.board.impl;

import static com.springbook.biz.common.Constants.BOARD_DELETE;
import static com.springbook.biz.common.Constants.BOARD_GET;
import static com.springbook.biz.common.Constants.BOARD_INSERT;
import static com.springbook.biz.common.Constants.BOARD_LIST;
import static com.springbook.biz.common.Constants.BOARD_UPDATE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.FileVO;

@Repository
public class BoardDAOSpring {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<BoardVO> getBoardList() {
        return jdbcTemplate.query(BOARD_LIST, new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
    }

    public BoardVO getBoard(long b_id) {
        return jdbcTemplate.queryForObject(BOARD_GET, new Object[]{b_id}, new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
    }

    public void insertBoard(BoardVO board) {
        jdbcTemplate.update(BOARD_INSERT, board.getPost_num(), board.getTitle(), board.getContent(), board.getS_name(), board.getS_id(), board.getS_department(), board.getCreateTime(), board.getUpdateTime(), board.getViews(), board.getCommentCnt(), board.isNotice());
    }

    public void updateBoard(BoardVO board) {
        jdbcTemplate.update(BOARD_UPDATE, board.getTitle(), board.getContent(), board.getS_name(), board.getS_id(), board.getS_department(), board.getUpdateTime(), board.getViews(), board.getCommentCnt(), board.isNotice(), board.getB_id());
    }

    public void deleteBoard(long b_id) {
        jdbcTemplate.update(BOARD_DELETE, b_id);
    }

    public boolean deletePost(int b_id, boolean isNotice) {
        String deletePostSql = null;
        String deleteFilesSql = "DELETE FROM file WHERE b_id = ? AND board_type = ?";
        String resetNumSql = "SET @num := 0";
        String updateSql = null;

        if (isNotice) {
            deletePostSql = "DELETE FROM notice_board WHERE b_id = ?";
            updateSql = "UPDATE notice_board SET post_num = @num := (@num+1) ORDER BY post_num";
        } else {
            deletePostSql = "DELETE FROM board WHERE b_id = ?";
            updateSql = "UPDATE board SET post_num = @num := (@num+1) ORDER BY post_num";
        }

        try {
            jdbcTemplate.update(deleteFilesSql, b_id, isNotice ? "notice" : "board");
            int affectedRows = jdbcTemplate.update(deletePostSql, b_id);
            if (affectedRows > 0) {
                jdbcTemplate.execute(resetNumSql);
                jdbcTemplate.execute(updateSql);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}