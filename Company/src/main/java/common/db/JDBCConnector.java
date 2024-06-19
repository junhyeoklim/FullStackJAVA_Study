package common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {
	private static final String driverPath = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/company?serverTimezone=UTC";
	private static final String id = "root";
	private static final String pwd = "1234";
	private static Connection con;


	public static Connection getCon()
		{

		try	{
		Class.forName(driverPath);		
		con = DriverManager.getConnection(url,id,pwd);		
		
	} catch (ClassNotFoundException e) {

		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}		
	return con;
}
	
}
