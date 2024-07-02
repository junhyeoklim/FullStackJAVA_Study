package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import board.dto.BoardDTO;
import board.dto.CommentDTO;
import common.db.JDBCConnector;
import common.dto.PageDTO;

public class BoardDAO {
	private static BoardDAO boardDAO = new BoardDAO();
	private final String TABLE_BOARD = "board";
	private final String TABLE_NOTICE = "notice_board";
	private final String TABLE_COMMENT = "comment";
	private static Connection conn;

	private BoardDAO() {
		conn = JDBCConnector.getCon();
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
		System.out.println("Generated post ID in DAO: " + generatedId);
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
		System.out.println("Generated post ID in DAO: " + generatedId);
		return generatedId;
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


	public void increaseViewCount(long b_id, String category) {
		String sql = null;
		
		if(category.equals("nomal"))
		 sql = "UPDATE " + TABLE_BOARD + " SET views = views + 1 WHERE b_id = ?";
		else if(category.equals("notice"))
		 sql = "UPDATE " + TABLE_NOTICE + " SET views = views + 1 WHERE b_id = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, b_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertComment(CommentDTO comment) {
	    String sql = "INSERT INTO comment (b_id, s_id, user_name, content, parent_comment_id, is_deleted) VALUES (?, ?, ?, ?, ?, ?)";

	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setLong(1, comment.getB_Id());
	        pstmt.setInt(2, comment.getS_id());
	        pstmt.setString(3, comment.getUserName());
	        pstmt.setString(4, comment.getContent());
	        if (comment.getParentCommentId() == null) {
	            pstmt.setNull(5, java.sql.Types.BIGINT);
	        } else {
	            pstmt.setLong(5, comment.getParentCommentId());
	        }
	        pstmt.setBoolean(6, comment.isIs_deleted());
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

    public void updateComment(long commentId, String content) {
        String sql = "UPDATE " + TABLE_COMMENT  + " SET content = ?, updateTime = CURRENT_TIMESTAMP WHERE comment_Id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, content);
            pstmt.setLong(2, commentId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteComment(long commentId) {
        String sql = "UPDATE comment SET is_deleted = TRUE WHERE comment_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, commentId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<CommentDTO> getCommentsByPostId(long b_id) {
        ArrayList<CommentDTO> comments = new ArrayList<>();
        String sql = "SELECT * FROM comment WHERE b_Id = ? ORDER BY createTime ASC";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, b_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    CommentDTO comment = new CommentDTO();
                    comment.setComment_Id(rs.getLong("comment_id"));
                    comment.setB_Id(rs.getLong("b_id"));
                    comment.setS_id(rs.getInt("s_id"));
                    comment.setUserName(rs.getString("user_name"));
                    comment.setContent(rs.getString("content"));
                    comment.setCreateTime(rs.getString("createTime"));
                    comment.setUpdateTime(rs.getString("updateTime"));
                    comment.setParentCommentId(rs.getLong("parent_comment_id"));
                    comment.setIs_deleted(rs.getBoolean("is_deleted"));
                    comments.add(comment);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }
    
	public ArrayList<BoardDTO> listBoard(PageDTO pageDTO) {
		ArrayList<BoardDTO> list = new ArrayList<>();
		String sql = "SELECT SQL_CALC_FOUND_ROWS * FROM " + TABLE_BOARD + " ORDER BY post_num DESC LIMIT ?, ?";
		ResultSet rs = null;

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, (pageDTO.getCurrentPage() - 1) * pageDTO.getRecordsPerPage());
			pstmt.setInt(2, pageDTO.getRecordsPerPage());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setB_id(rs.getLong("b_id"));
				board.setPost_num(rs.getInt("post_num"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setS_id(rs.getInt("s_id"));
				board.setS_name(rs.getString("s_name"));
				board.setCreateTime(rs.getString("createTime"));
				board.setUpdateTime(rs.getString("updateTime"));
				board.setViews(rs.getLong("views"));
				board.setCommentCnt(rs.getInt("commentCnt"));
				list.add(board);
			}
			rs.close();
			rs = pstmt.executeQuery("SELECT FOUND_ROWS()");

			if (rs.next()) {
				pageDTO.setNoOfRecords(rs.getInt(1));
			}
			pageDTO.setNoOfPages((int) Math.ceil(pageDTO.getNoOfRecords() * 1.0 / pageDTO.getRecordsPerPage()));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
		}

		return list;
	}

	public ArrayList<BoardDTO> searchBoard(PageDTO pageDTO, String kindOfSearch, String searchKeyword) {
		ArrayList<BoardDTO> list = new ArrayList<>();
		String sql = "";

		if ("searchTitle".equals(kindOfSearch)) {
			sql = "SELECT SQL_CALC_FOUND_ROWS * FROM " + TABLE_BOARD + " WHERE title LIKE ? ORDER BY post_num DESC LIMIT ?, ?";
		} else if ("searchTitleAndContents".equals(kindOfSearch)) {
			sql = "SELECT SQL_CALC_FOUND_ROWS * FROM " + TABLE_BOARD + " WHERE title LIKE ? OR content LIKE ? ORDER BY post_num DESC LIMIT ?, ?";
		} else if ("searchId".equals(kindOfSearch)) {
			sql = "SELECT SQL_CALC_FOUND_ROWS * FROM " + TABLE_BOARD + " WHERE s_name LIKE ? ORDER BY post_num DESC LIMIT ?, ?";
		}

		ResultSet rs = null;

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			if ("searchTitleAndContents".equals(kindOfSearch)) {
				pstmt.setString(1, "%" + searchKeyword + "%");
				pstmt.setString(2, "%" + searchKeyword + "%");
				pstmt.setInt(3, (pageDTO.getCurrentPage() - 1) * pageDTO.getRecordsPerPage());
				pstmt.setInt(4, pageDTO.getRecordsPerPage());
			} else {
				pstmt.setString(1, "%" + searchKeyword + "%");
				pstmt.setInt(2, (pageDTO.getCurrentPage() - 1) * pageDTO.getRecordsPerPage());
				pstmt.setInt(3, pageDTO.getRecordsPerPage());
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setB_id(rs.getLong("b_id"));
				board.setPost_num(rs.getInt("post_num"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setS_id(rs.getInt("s_id"));
				board.setS_name(rs.getString("s_name"));
				board.setCreateTime(rs.getString("createTime"));
				board.setUpdateTime(rs.getString("updateTime"));
				board.setViews(rs.getLong("views"));
				board.setCommentCnt(rs.getInt("commentCnt"));
				list.add(board);
			}

			rs.close();
			rs = pstmt.executeQuery("SELECT FOUND_ROWS()");

			if (rs.next()) {
				pageDTO.setNoOfRecords(rs.getInt(1));
			}
			pageDTO.setNoOfPages((int) Math.ceil(pageDTO.getNoOfRecords() * 1.0 / pageDTO.getRecordsPerPage()));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
		}

		return list;
	}

	public ArrayList<BoardDTO> getNoticeBoards() {
		ArrayList<BoardDTO> boards = new ArrayList<>();
		String sql = "SELECT * FROM " + TABLE_NOTICE + " ORDER BY post_num DESC";

		try (PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setB_id(rs.getLong("b_id"));
				board.setPost_num(rs.getInt("post_num"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setS_name(rs.getString("s_name"));
				board.setCreateTime(rs.getString("createTime"));
				board.setUpdateTime(rs.getString("updateTime"));
				board.setViews(rs.getLong("views"));
				board.setCommentCnt(rs.getInt("commentCnt"));
				boards.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return boards;
	}

	public BoardDTO getBoard(long boardId,String category) {
		String sql = null;
		BoardDTO board = null;
		if(category.equals("notice")) {
			sql = "SELECT * FROM "+TABLE_NOTICE+" WHERE b_id="+boardId;
		}
		else if(category.equals("nomal")) {
			sql = "SELECT * FROM "+TABLE_BOARD+" WHERE b_id="+boardId;
		}

		try(PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while(rs.next()) {
				board = new BoardDTO();
				board.setB_id(rs.getLong("b_id"));
				board.setPost_num(rs.getInt("post_num"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setS_name(rs.getString("s_name"));
				if(category.equals("nomal")) {
					board.setS_id(rs.getInt("s_id"));
					board.setS_department(rs.getString("s_department"));
				}
				board.setCreateTime(rs.getString("createTime"));
				board.setUpdateTime(rs.getString("updateTime"));
				board.setViews(rs.getLong("views"));
				board.setCommentCnt(rs.getInt("commentCnt"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return board;
	}
}
