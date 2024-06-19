package board.dao;

import java.sql.Connection;

import common.db.JDBCConnector;

public class BoardDAO {
	private static BoardDAO boardDAO = new BoardDAO();
	private final String TABLE_NAME = "board";
	private static Connection con;
	
	private BoardDAO() {
		con = JDBCConnector.getCon();
	}
	
	public static BoardDAO getBoardDAO() {
		return boardDAO;
	}
}
