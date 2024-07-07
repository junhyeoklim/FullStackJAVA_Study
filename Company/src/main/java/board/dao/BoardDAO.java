package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.dto.BoardDTO;
import board.dto.CommentDTO;
import board.dto.FileDTO;
import common.db.JDBCConnector;
import common.dto.PageDTO;

public class BoardDAO {
	private static BoardDAO boardDAO = new BoardDAO();
	private final String TABLE_BOARD = "board";
	private final String TABLE_NOTICE = "notice_board";
	private final String TABLE_COMMENT = "comment";
	private final String TABLE_FILE = "file";
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
	public void insertFiles(List<FileDTO> fileList) throws SQLException {
	    String sql = "INSERT INTO file (b_id, s_id, user_type, file_name, file_path, board_type) VALUES (?, ?, ?, ?, ?, ?)";
	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        for (FileDTO file : fileList) {
	            pstmt.setLong(1, file.getB_id());
	            pstmt.setInt(2, file.getS_id());
	            pstmt.setString(3, file.getUser_type());
	            pstmt.setString(4, file.getFile_name());
	            pstmt.setString(5, file.getFile_path());
	            pstmt.setString(6, file.getBoard_type());
	            pstmt.addBatch();
	        }
	        pstmt.executeBatch();
	    }
	}


	public boolean deletePost(int b_id, boolean isNotice) {
	    String sql = null;
	    if (isNotice)
	        sql = "DELETE FROM " + TABLE_NOTICE + " WHERE b_id = ?";
	    else
	        sql = "DELETE FROM " + TABLE_BOARD + " WHERE b_id = ?";

	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, b_id);
	        int affectedRows = pstmt.executeUpdate();
	        return affectedRows > 0; // 삭제된 행의 수가 0보다 크면 true 반환
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false; // 예외 발생 시 false 반환
	}
	public boolean updatePost(long b_id, String title, String content, boolean isNotice) {
	    String sql;
	    if (isNotice) {
	        sql = "UPDATE " + TABLE_NOTICE + " SET title = ?, content = ? WHERE b_id = ?";
	    } else {
	        sql = "UPDATE " + TABLE_BOARD + " SET title = ?, content = ? WHERE b_id = ?";
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
        String sql = "UPDATE " + TABLE_COMMENT  + " SET content = ?, updateTime = CURRENT_TIMESTAMP WHERE comment_Id = ?";

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

    public ArrayList<CommentDTO> getCommentsByPostId(long b_id) {
        ArrayList<CommentDTO> comments = new ArrayList<>();
        String sql = "SELECT * FROM comment WHERE b_Id = ? ORDER BY orderNumber ASC, depth ASC";

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
    
    public ArrayList<BoardDTO> listBoard(PageDTO pageDTO) {
        ArrayList<BoardDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_BOARD + " ORDER BY post_num DESC LIMIT ?, ?";
        String countSql = "SELECT COUNT(*) FROM " + TABLE_BOARD;
        ResultSet rs = null;

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             PreparedStatement countPstmt = conn.prepareStatement(countSql)) {
            
            // Set parameters for the main query
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
                board.setCommentCnt(getCommentCount(board.getB_id()));
                list.add(board);
            }

            // Get the total number of records
            rs.close();
            rs = countPstmt.executeQuery();
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
    
    public ArrayList<FileDTO> getFilesByBoardId(long b_id) {
        ArrayList<FileDTO> files = new ArrayList<>();
        String sql = "SELECT * FROM file WHERE b_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, b_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    FileDTO file = new FileDTO();
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
				board.setCommentCnt(getCommentCount(board.getB_id()));
				boards.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return boards;
	}

	public BoardDTO getBoard(long boardId, String category) {
	    String sql = null;
	    BoardDTO board = null;
	    if (category.equals("notice")) {
	        sql = "SELECT * FROM notice_board WHERE b_id = ?";
	    } else {
	        sql = "SELECT * FROM board WHERE b_id = ?";
	    }

	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setLong(1, boardId);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                board = new BoardDTO();
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
