package com.test.ajax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.test.ajax.dto.UserDTO;

public class UserDAO {

	private DataSource dataSource;
	private static UserDAO dao = new UserDAO();
	
	private UserDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/testdb");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static UserDAO getUserDAO() {
		return dao;
	}
	
	public ArrayList<UserDTO> search(String userName){
		final String SEARCH_SQL = "SELECT * FROM user WHERE userName LIKE ?";
		ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
		
		try(Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SEARCH_SQL);) {
			pstmt.setString(1, "%" + userName + "%");
			
			try(ResultSet rs = pstmt.executeQuery();) {
				while(rs.next()) {
					UserDTO dto = new UserDTO();
					dto.setUserName(rs.getString("userName"));
					dto.setUserAge(rs.getInt("userAge"));
					dto.setUserGender(rs.getString("userGender"));
					dto.setUserEmail(rs.getString("userEmail"));
					userList.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} catch (SQLException e) {
			
		}
		
		return userList;
	}
	
	
	public int register(UserDTO user) {
		final String INSERT_USER_SQL = "INSERT INTO user VALUES(?,?,?,?)";
		
		try(Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(INSERT_USER_SQL)) {
			
			pstmt.setString(1, user.getUserName());
			pstmt.setInt(2, user.getUserAge());
			pstmt.setString(3, user.getUserGender());
			pstmt.setString(4, user.getUserEmail());
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
