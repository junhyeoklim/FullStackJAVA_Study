package com.dao;

import java.sql.Connection;

public class CompanyDAO {
	
	private static Connection con;
	
	
	public CompanyDAO() {
		con = JDBCConnector.getCon();
	}
	
}
