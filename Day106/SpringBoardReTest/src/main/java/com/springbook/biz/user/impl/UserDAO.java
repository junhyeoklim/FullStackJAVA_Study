package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {

	public UserVO getUser(UserVO vo)
	{
		UserVO user = null;
		String sql = "SELECT * FROM users WHERE id=? AND password=?";
		
		try(Connection conn = JDBCUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);)
		{
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			
			try(ResultSet rs = pstmt.executeQuery();){
				
				if(rs.next()) {
					user = new UserVO();
					user.setId(rs.getString("id"));
					user.setPassword(rs.getString("password"));
					user.setName(rs.getString("name"));
					user.setRole(rs.getString("role"));
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
}
