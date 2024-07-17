package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/springdb?serverTimezone=UTC", "root", "1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}