package test.board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    private static final String driverPath = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
    private static final String id = "root";
    private static final String pwd = "1234";

    private Connection getConnection() throws Exception {
        Class.forName(driverPath);
        return DriverManager.getConnection(url, id, pwd);
    }

    public long insertPost(String title, String content, int s_id, String s_department) throws Exception {
        long generatedId = 0;
        try (Connection conn = getConnection()) {
            String sql = "INSERT INTO board (post_num, title, content, s_id, s_department, createTime, updateTime, views, commentCnt) VALUES ((SELECT IFNULL(MAX(post_num), 0) + 1 FROM board AS subquery), ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, title);
                pstmt.setString(2, content);
                pstmt.setInt(3, s_id);
                pstmt.setString(4, s_department);
                pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
                pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
                pstmt.setLong(7, 0);
                pstmt.setInt(8, 0);
                pstmt.executeUpdate();

                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        generatedId = rs.getLong(1);
                    }
                }
            }
        }
        System.out.println("Generated post ID in DAO: " + generatedId);
        return generatedId;
    }

    public void deletePost(int postNum) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(url, id, pwd);

            String deleteQuery = "DELETE FROM board WHERE post_num = ?";
            pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1, postNum);
            pstmt.executeUpdate();
            pstmt.close();

            String updateQuery = "UPDATE board SET post_num = post_num - 1 WHERE post_num > ?";
            pstmt = conn.prepareStatement(updateQuery);
            pstmt.setInt(1, postNum);
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
    }

    public Board getBoardById(long b_id) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Board board = null;

        try {
            conn = DriverManager.getConnection(url, id, pwd);

            String selectQuery = "SELECT * FROM board WHERE b_id = ?";
            pstmt = conn.prepareStatement(selectQuery);
            pstmt.setLong(1, b_id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                board = new Board();
                board.setBId(rs.getLong("b_id"));
                board.setPostNum(rs.getInt("post_num"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setSId(rs.getInt("s_id"));
                board.setSDepartment(rs.getString("s_department"));
                board.setCreateTime(rs.getTimestamp("createTime"));
                board.setUpdateTime(rs.getTimestamp("updateTime"));
                board.setViews(rs.getLong("views"));
                board.setCommentCnt(rs.getInt("commentCnt"));
            }
        } finally {
            if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
        return board;
    }

    public void increaseViewCount(long b_id) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(url, id, pwd);

            String updateQuery = "UPDATE board SET views = views + 1 WHERE b_id = ?";
            pstmt = conn.prepareStatement(updateQuery);
            pstmt.setLong(1, b_id);
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
    }

    public void insertComment(long b_id, String userName, String content, Long parentCommentId) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(url, id, pwd);

            String insertQuery = "INSERT INTO comment (b_id, user_name, content, parent_comment_id) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setLong(1, b_id);
            pstmt.setString(2, userName);
            pstmt.setString(3, content);
            if (parentCommentId == null) {
                pstmt.setNull(4, Types.BIGINT);
            } else {
                pstmt.setLong(4, parentCommentId);
            }
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
    }

    public List<Comment> getCommentsByPostId(long b_id) throws Exception {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Comment> comments = new ArrayList<>();

        try (Connection conn = getConnection()) {

            String selectQuery = "SELECT * FROM comment WHERE b_id = ? ORDER BY createTime ASC";
            pstmt = conn.prepareStatement(selectQuery);
            pstmt.setLong(1, b_id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Comment comment = new Comment();
                comment.setCommentId(rs.getLong("comment_id"));
                comment.setBId(rs.getLong("b_id"));
                comment.setUserName(rs.getString("user_name"));
                comment.setContent(rs.getString("content"));
                comment.setCreateTime(rs.getTimestamp("createTime"));
                comment.setUpdateTime(rs.getTimestamp("updateTime"));
                comment.setParentCommentId(rs.getLong("parent_comment_id"));
                comments.add(comment);
            }
        } finally {
            if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
        }
        return comments;
    }

    public List<Board> getAllBoards() throws Exception {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Board> boards = new ArrayList<>();

        try (Connection conn = getConnection()) {

            String selectQuery = "SELECT * FROM board ORDER BY post_num ASC";
            pstmt = conn.prepareStatement(selectQuery);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Board board = new Board();
                board.setBId(rs.getLong("b_id"));
                board.setPostNum(rs.getInt("post_num"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setSId(rs.getInt("s_id"));
                board.setSDepartment(rs.getString("s_department"));
                board.setCreateTime(rs.getTimestamp("createTime"));
                board.setUpdateTime(rs.getTimestamp("updateTime"));
                board.setViews(rs.getLong("views"));
                board.setCommentCnt(rs.getInt("commentCnt"));
                boards.add(board);
            }
        } finally {
            if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
        }
        return boards;
    }

    public void updateComment(long commentId, String content) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(url, id, pwd);

            String updateQuery = "UPDATE comment SET content = ?, updateTime = CURRENT_TIMESTAMP WHERE comment_id = ?";
            pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1, content);
            pstmt.setLong(2, commentId);
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
    }

    public void deleteComment(long commentId) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(url, id, pwd);

            String deleteQuery = "DELETE FROM comment WHERE comment_id = ?";
            pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setLong(1, commentId);
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
    }
    public List<String> getImagesByPostId(long b_id) throws Exception {
        List<String> imageUrls = new ArrayList<>();
        try (Connection conn = getConnection()) {
            String sql = "SELECT filepath FROM board_images WHERE b_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setLong(1, b_id);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        imageUrls.add(rs.getString("filepath"));
                    }
                }
            }
        }
        return imageUrls;
    }
}



