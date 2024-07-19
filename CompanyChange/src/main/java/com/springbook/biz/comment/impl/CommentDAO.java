package com.springbook.biz.comment.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.CommentVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("commentDAO")
public class CommentDAO {
    private static CommentDAO commentDAO = new CommentDAO();
    private static Connection conn;

    private CommentDAO() {
        conn = JDBCUtil.getConnection();
    }

    public static CommentDAO getCommentDAO() {
        return commentDAO;
    }

    public void insertComment(CommentVO comment) {
        String sql = "INSERT INTO comment (b_id, s_id, user_name, content, parent_comment_id, is_deleted, depth, orderNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, comment.getB_Id());
            pstmt.setInt(2, comment.getS_id());
            pstmt.setString(3, comment.getUserName());
            pstmt.setString(4, comment.getContent());
            if (comment.getParentCommentId() == null) {
                pstmt.setNull(5, java.sql.Types.BIGINT);
                comment.setDepth(0);
                comment.setOrderNumber(getNextOrderNumberForPost(comment.getB_Id()));
            } else {
                pstmt.setLong(5, comment.getParentCommentId());
                comment.setDepth(getCommentDepth(comment.getParentCommentId()) + 1);
                comment.setOrderNumber(getCommentOrderNumber(comment.getParentCommentId()));
            }
            pstmt.setBoolean(6, comment.isIs_deleted());
            pstmt.setInt(7, comment.getDepth());
            pstmt.setInt(8, comment.getOrderNumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateComment(long commentId, String content) {
        String sql = "UPDATE comment SET content = ?, updateTime = CURRENT_TIMESTAMP WHERE comment_Id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, content);
            pstmt.setLong(2, commentId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteComment(long commentId) {
        boolean hasChildren = false;

        String checkChildrenSql = "SELECT COUNT(*) FROM comment WHERE parent_comment_id = ?";
        String updateSql = "UPDATE comment SET is_deleted = TRUE WHERE comment_id = ?";
        String deleteSql = "DELETE FROM comment WHERE comment_id = ?";

        try (PreparedStatement checkStmt = conn.prepareStatement(checkChildrenSql)) {
            checkStmt.setLong(1, commentId);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next()) {
                    hasChildren = rs.getInt(1) > 0;
                }
            }

            if (hasChildren) {
                try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                    updateStmt.setLong(1, commentId);
                    updateStmt.executeUpdate();
                }
            } else {
                try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {
                    deleteStmt.setLong(1, commentId);
                    deleteStmt.executeUpdate();
                }
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<CommentVO> getCommentsByPostId(long b_id) {
        ArrayList<CommentVO> comments = new ArrayList<>();
        String sql = "SELECT * FROM comment WHERE b_Id = ? ORDER BY orderNumber ASC, depth ASC";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, b_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    CommentVO comment = new CommentVO();
                    comment.setComment_Id(rs.getLong("comment_id"));
                    comment.setB_Id(rs.getLong("b_id"));
                    comment.setS_id(rs.getInt("s_id"));
                    comment.setUserName(rs.getString("user_name"));
                    comment.setContent(rs.getString("content"));
                    comment.setCreateTime(rs.getString("createTime"));
                    comment.setUpdateTime(rs.getString("updateTime"));
                    comment.setParentCommentId(rs.getLong("parent_comment_id"));
                    comment.setIs_deleted(rs.getBoolean("is_deleted"));
                    comment.setDepth(rs.getInt("depth"));
                    comment.setOrderNumber(rs.getInt("orderNumber"));
                    comments.add(comment);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }

    private int getNextOrderNumberForPost(long b_id) throws SQLException {
        String sql = "SELECT MAX(orderNumber) FROM comment WHERE b_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, b_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) + 1;
                }
            }
        }
        return 0;
    }

    private int getCommentDepth(long parentCommentId) throws SQLException {
        String sql = "SELECT depth FROM comment WHERE comment_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, parentCommentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return 0;
    }

    private int getCommentOrderNumber(long parentCommentId) throws SQLException {
        String sql = "SELECT orderNumber FROM comment WHERE comment_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, parentCommentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return 0;
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
