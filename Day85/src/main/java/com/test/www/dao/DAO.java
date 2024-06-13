package com.test.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.test.www.dto.DTO;

public class DAO {

	private static DAO dao = new  DAO();
	private DataSource dataSource;
	
	
	
	private DAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/testdb");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static DAO getDAO() {
		return dao;
	}
	
	public ArrayList<DTO> search(String userName){
		String sql = "SELECT * FROM user WHERE userName LIKE ?";
		ArrayList<DTO> list = new ArrayList<DTO>();
		
		try(Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, "%"+userName+"%");
			
		try(ResultSet rs = pstmt.executeQuery();){
			
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setUserName(rs.getString("userName"));
				dto.setUserAge(rs.getInt("userAge"));
				dto.setUserGender(rs.getString("userGender"));
				dto.setUserEmail(rs.getString("userEmail"));
				list.add(dto);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public int register(DTO dto) {
		
		String sql = "INSERT INTO user VALUES(?,?,?,?)";
		
		try(Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, dto.getUserName());
			pstmt.setInt(2, dto.getUserAge());
			pstmt.setString(3, dto.getUserGender());
			pstmt.setString(4, dto.getUserEmail());
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
