package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {
	private static final String url = "jdbc:mysql://localhost:3306/hellodb?serverTimezone=UTC";
	private static final String user = "root";
	private static final String pwd = "1234";
	private static final String driverPath = "com.mysql.cj.jdbc.Driver";
	private static Connection con;
	
	
	public static Connection getCon() {
		
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
		
		return con;
	}
}
