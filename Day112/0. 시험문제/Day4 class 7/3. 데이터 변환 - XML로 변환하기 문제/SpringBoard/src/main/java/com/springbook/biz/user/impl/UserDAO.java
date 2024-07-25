package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

// DAO(Data Access Object)
@Repository("userDAO")
public class UserDAO{
	
	// CRUD 기능의 메소드 구현
	// 회원 등록
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		final String SQL = "SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";
		try(Connection conn = JDBCUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL))
		{
			System.out.println("===> JDBC로 getUser() 기능 처리");
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					user = new UserVO();
					user.setId(rs.getString("ID"));
					user.setPassword(rs.getString("password"));
					user.setName(rs.getString("name"));
					user.setRole(rs.getString("role"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}