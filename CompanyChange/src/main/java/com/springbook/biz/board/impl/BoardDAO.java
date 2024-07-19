package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.FileVO;
import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.common.PageVO;

@Repository("boardDAO")
public class BoardDAO {
    private static BoardDAO boardDAO = new BoardDAO();
    private final String TABLE_BOARD = "board";
    private final String TABLE_NOTICE = "notice_board";
    private static Connection conn;

    private BoardDAO() {
        conn = JDBCUtil.getConnection();
    }

    public static BoardDAO getBoardDAO() {
        return boardDAO;
    }

    public long insertPost(String title, String content, String userName, int s_id, String s_department) throws Exception {
        long generatedId = 0;
        String sql = "INSERT INTO "+TABLE_BOARD+" (post_num, title, content, s_name ,s_id, s_department, views, commentCnt) VALUES ((SELECT IFNULL(MAX(post_num), 0) + 1 FROM board AS subquery), ?, ?, ?, ?, ?, ?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, userName);
            pstmt.setInt(4, s_id);
            pstmt.setString(5, s_department);
            pstmt.setLong(6, 0);
            pstmt.setInt(7, 0);
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    generatedId = rs.getLong(1);
                }
            }
        }
        return generatedId;
    }

    public long insertPost(String title, String content, String userName, int s_id, boolean is_notice) throws Exception {
        long generatedId = 0;
        String sql = null;

        if(is_notice) {
            sql = "INSERT INTO "+TABLE_NOTICE+" (post_num, title, content, s_name ,views, commentCnt) VALUES ((SELECT IFNULL(MAX(post_num), 0) + 1 FROM notice_board AS subquery), ?, ?, ?, ?, ?)";
        }
        else
            sql = "INSERT INTO "+TABLE_BOARD+" (post_num, title, content, s_name ,s_id,views, commentCnt) VALUES ((SELECT IFNULL(MAX(post_num), 0) + 1 FROM board AS subquery), ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, userName);
            
            if(!is_notice) {
                pstmt.setInt(4, s_id);
                pstmt.setLong(5, 0);
                pstmt.setInt(6, 0);
            }
            else {
                pstmt.setLong(4, 0);
                pstmt.setInt(5, 0);
            }
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    generatedId = rs.getLong(1);
                }
            }
        }
        return generatedId;
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
            conn.setAutoCommit(false); // 트랜잭션 시작

            // 파일 삭제
            try (PreparedStatement deleteFilesPstmt = conn.prepareStatement(deleteFilesSql)) {
                deleteFilesPstmt.setInt(1, b_id);
                deleteFilesPstmt.setString(2, isNotice ? "notice" : "board");
                deleteFilesPstmt.executeUpdate();
            }

            // 게시물 삭제
            try (PreparedStatement deletePostPstmt = conn.prepareStatement(deletePostSql)) {
                deletePostPstmt.setInt(1, b_id);
                int affectedRows = deletePostPstmt.executeUpdate();

                if (affectedRows > 0) {
                    // 변수 초기화
                    try (Statement resetStmt = conn.createStatement()) {
                        resetStmt.execute(resetNumSql);
                    }

                    // post_num 순서대로 업데이트
                    try (Statement updateStmt = conn.createStatement()) {
                        updateStmt.executeUpdate(updateSql);
                    }
                    conn.commit(); // 트랜잭션 커밋
                    return true;
                }
            } catch (SQLException e) {
                conn.rollback(); // 예외 발생 시 롤백
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.setAutoCommit(true); // 자동 커밋 모드로 복귀
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean updatePost(long b_id, String title, String content, boolean isNotice) {
        String sql;
        if (isNotice) {
            sql = "UPDATE notice_board SET title = ?, content = ? WHERE b_id = ?";
        } else {
            sql = "UPDATE board SET title = ?, content = ? WHERE b_id = ?";
        }

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setLong(3, b_id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void increaseViewCount(long b_id, String category) {
        String sql = null;

        if(category.equals("nomal"))
            sql = "UPDATE board SET views = views + 1 WHERE b_id = ?";
        else if(category.equals("notice"))
            sql = "UPDATE notice_board SET views = views + 1 WHERE b_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, b_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<BoardVO> listBoard(PageVO pageVO) {
        ArrayList<BoardVO> list = new ArrayList<>();
        String sql = "SELECT * FROM board ORDER BY post_num DESC LIMIT ?, ?";
        String countSql = "SELECT COUNT(*) FROM board";
        ResultSet rs = null;

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             PreparedStatement countPstmt = conn.prepareStatement(countSql)) {

            // Set parameters for the main query
            pstmt.setInt(1, (pageVO.getCurrentPage() - 1) * pageVO.getRecordsPerPage());
            pstmt.setInt(2, pageVO.getRecordsPerPage());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardVO board = new BoardVO();
                board.setB_id(rs.getLong("b_id"));
                board.setPost_num(rs.getInt("post_num"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setS_id(rs.getInt("s_id"));
                board.setS_name(rs.getString("s_name"));
                board.setCreateTime(rs.getString("createTime"));
                board.setUpdateTime(rs.getString("updateTime"));
                board.setViews(rs.getLong("views"));
                board.setCommentCnt(getCommentCount(board.getB_id()));
                list.add(board);
            }

            // Get the total number of records
            rs.close();
            rs = countPstmt.executeQuery();
            if (rs.next()) {
                pageVO.setNoOfRecords(rs.getInt(1));
            }
            pageVO.setNoOfPages((int) Math.ceil(pageVO.getNoOfRecords() * 1.0 / pageVO.getRecordsPerPage()));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return list;
    }

    public ArrayList<FileVO> getFilesByBoardId(long b_id) {
        ArrayList<FileVO> files = new ArrayList<>();
        String sql = "SELECT * FROM file WHERE b_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, b_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    FileVO file = new FileVO();
                    file.setF_id(rs.getLong("f_id"));
                    file.setB_id(rs.getLong("b_id"));
                    file.setS_id(rs.getInt("s_id"));
                    file.setUser_type(rs.getString("user_type"));
                    file.setFile_name(rs.getString("file_name"));
                    file.setFile_path(rs.getString("file_path"));
                    file.setUploadTime(rs.getString("uploadTime"));
                    file.setBoard_type(rs.getString("board_type"));
                    files.add(file);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return files;
    }

    public ArrayList<BoardVO> searchBoard(PageVO pageVO, String kindOfSearch, String searchKeyword) {
        ArrayList<BoardVO> list = new ArrayList<>();
        String sql = "";

        if ("searchTitle".equals(kindOfSearch)) {
            sql = "SELECT SQL_CALC_FOUND_ROWS * FROM board WHERE title LIKE ? ORDER BY post_num DESC LIMIT ?, ?";
        } else if ("searchTitleAndContents".equals(kindOfSearch)) {
            sql = "SELECT SQL_CALC_FOUND_ROWS * FROM board WHERE title LIKE ? OR content LIKE ? ORDER BY post_num DESC LIMIT ?, ?";
        } else if ("searchId".equals(kindOfSearch)) {
            sql = "SELECT SQL_CALC_FOUND_ROWS * FROM board WHERE s_name LIKE ? ORDER BY post_num DESC LIMIT ?, ?";
        }

        ResultSet rs = null;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            if ("searchTitleAndContents".equals(kindOfSearch)) {
                pstmt.setString(1, "%" + searchKeyword + "%");
                pstmt.setString(2, "%" + searchKeyword + "%");
                pstmt.setInt(3, (pageVO.getCurrentPage() - 1) * pageVO.getRecordsPerPage());
                pstmt.setInt(4, pageVO.getRecordsPerPage());
            } else {
                pstmt.setString(1, "%" + searchKeyword + "%");
                pstmt.setInt(2, (pageVO.getCurrentPage() - 1) * pageVO.getRecordsPerPage());
                pstmt.setInt(3, pageVO.getRecordsPerPage());
            }

            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardVO board = new BoardVO();
                board.setB_id(rs.getLong("b_id"));
                board.setPost_num(rs.getInt("post_num"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setS_id(rs.getInt("s_id"));
                board.setS_name(rs.getString("s_name"));
                board.setCreateTime(rs.getString("createTime"));
                board.setUpdateTime(rs.getString("updateTime"));
                board.setViews(rs.getLong("views"));
                board.setCommentCnt(getCommentCount(board.getB_id()));
                list.add(board);
            }

            rs.close();
            rs = pstmt.executeQuery("SELECT FOUND_ROWS()");

            if (rs.next()) {
                pageVO.setNoOfRecords(rs.getInt(1));
            }
            pageVO.setNoOfPages((int) Math.ceil(pageVO.getNoOfRecords() * 1.0 / pageVO.getRecordsPerPage()));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return list;
    }

    public ArrayList<BoardVO> getNoticeBoards() {
        ArrayList<BoardVO> boards = new ArrayList<>();
        String sql = "SELECT * FROM notice_board ORDER BY post_num DESC";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                BoardVO board = new BoardVO();
                board.setB_id(rs.getLong("b_id"));
                board.setPost_num(rs.getInt("post_num"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setS_name(rs.getString("s_name"));
                board.setCreateTime(rs.getString("createTime"));
                board.setUpdateTime(rs.getString("updateTime"));
                board.setViews(rs.getLong("views"));
                board.setCommentCnt(getCommentCount(board.getB_id()));
                boards.add(board);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return boards;
    }

    public BoardVO getBoard(long boardId, String category) {
        String sql = null;
        BoardVO board = null;
        if (category.equals("notice")) {
            sql = "SELECT * FROM notice_board WHERE b_id = ?";
        } else {
            sql = "SELECT * FROM board WHERE b_id = ?";
        }

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, boardId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    board = new BoardVO();
                    board.setB_id(rs.getLong("b_id"));
                    board.setPost_num(rs.getInt("post_num"));
                    board.setTitle(rs.getString("title"));
                    board.setContent(rs.getString("content"));
                    board.setS_name(rs.getString("s_name"));
                    if (category.equals("nomal")) {
                        board.setS_id(rs.getInt("s_id"));
                        board.setS_department(rs.getString("s_department"));
                    }
                    board.setCreateTime(rs.getString("createTime"));
                    board.setUpdateTime(rs.getString("updateTime"));
                    board.setViews(rs.getLong("views"));
                    board.setCommentCnt(getCommentCount(boardId));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return board;
    }

    public int getCommentCount(long b_id) {
        String sql = "SELECT COUNT(*) FROM comment WHERE b_id = ? AND is_deleted = FALSE";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, b_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
