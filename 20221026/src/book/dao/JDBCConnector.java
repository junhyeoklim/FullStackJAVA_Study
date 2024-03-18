package book.dao;
import	java.sql.Connection;
import	java.sql.DriverManager;
import	java.sql.SQLException;
import	java.sql.ResultSet;
import	java.sql.Statement;

public class JDBCConnector {
	private static final String driverPath = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
	private static final String id = "javauser";
	private static final String pwd = "mysql";
	private static Connection con;
// db연결후 문장객체 필요
	public static Connection getCon() {
		try {
			Class.forName(driverPath);
			System.out.println("Driver가 정상적으로 로드되었습니다.");
			con = DriverManager.getConnection(url,id,pwd);
			System.out.println("연결이 정상적으로 되었습니다.");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void rsTest()
	{
		try {
			//sql 문을 실행할 수 있는 문장객체 생성
			Statement stmt = con.createStatement();
			String sql = "select * from book";
			//sql문 실행(select문을 실행할 때는 executeQuery()메소드를 사용하여 실행: ResultSet(결과행의 집합) 반환)
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	
	public static void main(String[] args) {
		JDBCConnector dl = new JDBCConnector();
		dl.getCon();
		dl.rsTest();
	}

}
