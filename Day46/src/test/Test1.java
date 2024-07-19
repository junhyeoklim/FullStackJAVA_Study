package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Test1 {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
		String id = "root", pwd = "1234";
		String driverPath = "com.mysql.cj.jdbc.Driver";
		
		String sql = null, name = null, title = null, contents = null;
		Scanner sc = new Scanner(System.in,"euc-kr");
		
		int menu = 0, result = 0;
		
		int no = 0,rCnt = 0;
		String wTime = null;
		ResultSet rs = null;
		
		sql = "INSERT INTO board(name,title,contents) VALUES(?,?,?)";
		
		try(Connection conn = DriverManager.getConnection(url,id,pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			Class.forName(driverPath);
			System.out.println("드라이버 로드");
			System.out.println("Connection 연결 성공");
			
			while(true)
			{
				System.out.println("메뉴를 선택하세요.");
				System.out.println("1. 쓰기");
				System.out.println("2. 조회");
				System.out.println("3. 종료");
				System.out.println("선택 : ");
				menu = sc.nextInt();
				sc.nextLine();
				
				switch (menu) {
				case 1: {
					System.out.println("이름을 입력하세요.");
					name = sc.nextLine();
					
					System.out.println("제목을 입력하세요.");
					title = sc.nextLine();
					
					System.out.println("내용을 입력하세요.");					
					contents = sc.nextLine();
					
					pstmt.setString(1, name);
					pstmt.setString(2, title);
					pstmt.setString(3, contents);
					
					result = pstmt.executeUpdate();
					
					if(result > 0)
					{
						System.out.println();
						System.out.println("데이터 삽입 성공");
						System.out.println();
					}
					break;
				}
				case 2: {
					sql =  "SELECT * FROM board ORDER BY no DESC";
					rs = pstmt.executeQuery(sql);
					
					while(rs.next())
					{
						System.out.println();
						no  = rs.getInt("no");
						name = rs.getString("name");
						title = rs.getString("title");
						contents = rs.getString("contents");
						wTime = rs.getString("wTime");
						rCnt = rs.getInt("rCnt");
						
						System.out.println("번호 "+no);
						System.out.println("이름 "+name);
						System.out.println("제목 "+title);
						System.out.println("내용 "+contents);
						System.out.println("시간 "+wTime);
						System.out.println("조회수  "+rCnt);
						
						System.out.println();
								
					}
					break;
				}
				case 3: {
					System.out.println("프로그램을 종료합니다.");
					return;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + menu);
				}
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
