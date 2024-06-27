package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import board.dto.BoardDTO;
import board.dto.CommentDTO;
import common.db.JDBCConnector;

public class BoardDAO {
    private static BoardDAO boardDAO = new BoardDAO();
    private final String TABLE_BOARD = "board";
    private final String TABLE_COMMENT = "comment";
    private final String TABLE_BOARD_IMAGES = "board_images";
    private static Connection conn;

    private BoardDAO() {
        conn = JDBCConnector.getCon();
    }

    public static BoardDAO getBoardDAO() {
        return boardDAO;
    }

    public long insertPost(String title, String content, int s_id, String s_department) throws Exception {
        long generatedId = 0;
            String sql = "INSERT INTO board (post_num, title, content, s_id, s_department, views, commentCnt) VALUES ((SELECT IFNULL(MAX(post_num), 0) + 1 FROM board AS subquery), ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, title);
                pstmt.setString(2, content);
                pstmt.setInt(3, s_id);
                pstmt.setString(4, s_department);
                pstmt.setLong(5, 0);
                pstmt.setInt(6, 0);
                pstmt.executeUpdate();

                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        generatedId = rs.getLong(1);
                    }
                }
            }
        System.out.println("Generated post ID in DAO: " + generatedId);
        return generatedId;
    }

    public void insertImage(long b_id, String filename, String filepath) {
        String sql = "INSERT INTO " + TABLE_BOARD_IMAGES + " (b_id, filename, filepath) VALUES (?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, b_id);
            pstmt.setString(2, filename);
            pstmt.setString(3, filepath);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePost(int postNum) {
        String deleteQuery = "DELETE FROM " + TABLE_BOARD + " WHERE post_num = ?";
        String updateQuery = "UPDATE " + TABLE_BOARD + " SET post_num = post_num - 1 WHERE post_num > ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
            pstmt.setInt(1, postNum);
            pstmt.executeUpdate();
            
            pstmt.close();
            
            try (PreparedStatement pstmtUpdate = conn.prepareStatement(updateQuery)) {
                pstmtUpdate.setInt(1, postNum);
                pstmtUpdate.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public BoardDTO getBoardById(long b_id) {
        BoardDTO board = null;
        String sql = "SELECT * FROM " + TABLE_BOARD + " WHERE b_id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, b_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    board = new BoardDTO();
                    board.setB_id(rs.getLong("b_id"));
                    board.setPost_num(rs.getInt("post_num"));
                    board.setTitle(rs.getString("title"));
                    board.setContent(rs.getString("content"));
                    board.setS_id(rs.getInt("s_id"));
                    board.setS_department(rs.getString("s_department"));
                    board.setCreateTime(rs.getTimestamp("createTime"));
                    board.setUpdateTime(rs.getTimestamp("updateTime"));
                    board.setViews(rs.getLong("views"));
                    board.setCommentCnt(rs.getInt("commentCnt"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return board;
    }

    public void increaseViewCount(long b_id) {
        String sql = "UPDATE " + TABLE_BOARD + " SET views = views + 1 WHERE b_id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, b_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertComment(CommentDTO comment) {
        String sql = "INSERT INTO " + TABLE_COMMENT + " (b_Id, userName, content, parentCommentId) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, comment.getB_Id());
            pstmt.setString(2, comment.getUserName());
            pstmt.setString(3, comment.getContent());
            if (comment.getParentCommentId() == null) {
                pstmt.setNull(4, java.sql.Types.BIGINT);
            } else {
                pstmt.setLong(4, comment.getParentCommentId());
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CommentDTO> getCommentsByPostId(long b_id) {
        List<CommentDTO> comments = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_COMMENT + " WHERE b_Id = ? ORDER BY createTime ASC";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, b_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    CommentDTO comment = new CommentDTO();
                    comment.setComment_Id(rs.getLong("comment_Id"));
                    comment.setB_Id(rs.getLong("b_Id"));
                    comment.setUserName(rs.getString("userName"));
                    comment.setContent(rs.getString("content"));
                    comment.setCreateTime(rs.getTimestamp("createTime"));
                    comment.setUpdateTime(rs.getTimestamp("updateTime"));
                    comment.setParentCommentId(rs.getLong("parentCommentId"));
                    comments.add(comment);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }

    public ArrayList<BoardDTO> getAllBoards() {
    	ArrayList<BoardDTO> boards = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_BOARD + " ORDER BY post_num ASC";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                BoardDTO board = new BoardDTO();
                board.setB_id(rs.getLong("b_id"));
                board.setPost_num(rs.getInt("post_num"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setS_id(rs.getInt("s_id"));
                board.setS_department(rs.getString("s_department"));
                board.setCreateTime(rs.getTimestamp("createTime"));
                board.setUpdateTime(rs.getTimestamp("updateTime"));
                board.setViews(rs.getLong("views"));
                board.setCommentCnt(rs.getInt("commentCnt"));
                boards.add(board);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return boards;
    }

    public void updateComment(long commentId, String content) {
        String sql = "UPDATE " + TABLE_COMMENT + " SET content = ?, updateTime = CURRENT_TIMESTAMP WHERE comment_Id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, content);
            pstmt.setLong(2, commentId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteComment(long commentId) {
        String sql = "DELETE FROM " + TABLE_COMMENT + " WHERE comment_Id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, commentId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
