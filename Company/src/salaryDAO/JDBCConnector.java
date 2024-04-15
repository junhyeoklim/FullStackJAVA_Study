package salaryDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCConnector {
	private static final String driverPath = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/company?serverTimezone=UTC";
	private static final String id = "root";
	private static final String pwd = "1234";
	private static Connection con;
	
	
	public static Connection getCon()
	{
		try {
			Class.forName(driverPath);
			System.out.println("Driver가 정상적으로 로드되었습니다.");
			con = DriverManager.getConnection(url,id,pwd);
			System.out.println("연결 성공!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return con;
	}
	
	
	public static void main(String[] args) {

		getCon();
	}
}
