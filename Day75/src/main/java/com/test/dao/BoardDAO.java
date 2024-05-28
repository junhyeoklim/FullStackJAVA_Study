package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	private static final String url = "jdbc:mysql://localhost:3306/hellodb?serverTimezone=UTC";
	private static final String user = "root";
	private static final String pwd = "1234";
	private static final String driverPath = "com.mysql.cj.jdbc.Driver";
	private static Connection con;
	private static BoardDAO dao;

	public static BoardDAO getDAO() {
		if(dao == null) {
			try {
				Class.forName(driverPath);
				con = DriverManager.getConnection(url,user,pwd);			

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		return dao;
	}

	public int insertBoardDAO(BoardDTO dto) {

		int result = 0;
		String sql = "INSERT INTO board(title,user,pwd,mail,content) VALUES(?,?,?,?,?)";

		try(PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getUser());
			pstmt.setString(3, dto.getPwd());
			pstmt.setString(4, dto.getMail());
			pstmt.setString(5, dto.getContent());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return result;
	}
	public ArrayList<BoardDTO> selectBoard()
	{
		String sql = "SELECT no, title, user, sys_date, cnt FROM board ORDER BY no DESC";
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) 
		{
			
			while(rs.next())
			{
				BoardDTO dto = new BoardDTO();				
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setUser(rs.getString("user"));
				dto.setDate(rs.getString("sys_date"));
				dto.setCnt(rs.getInt("cnt"));
				list.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		return list;		
	}
}
