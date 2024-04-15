package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCCOnnectTest {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
		String id = "root";
		String pwd = "1234";
		String sql = null;
		
		String name = null, title = null, contents = null;
		
		int menu = 0, result = 0;
		int no = 0, rCnt = 0;
		String wTime = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection conn = DriverManager.getConnection(url,id,pwd);
			Statement stmt = conn.createStatement()) 
		{
			Scanner sc = new Scanner(System.in,"euc-kr");
			System.out.println("Connection 객체 생성 성공");
			
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
					
					System.out.println("제목을 입력하세요");
					title = sc.nextLine();
					
					System.out.println("내용을 입력하세요.");
					contents = sc.nextLine();
					
					sql = "INSERT INTO board(name,title,contents) values('"+name+"','"+title+"','"+contents+"')";
					System.out.println(sql);
					result = stmt.executeUpdate(sql);
					
					if(result > 0)
						System.out.println(result + "데이터 삽입성공");
					break;
				}
				case 2: {
					
					break;
				}
				case 3: {
					System.out.println("프로그램을 종료합니다.");
					sc.close();
					return;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + menu);
				}
			}
		
		} catch (SQLException e) {
			System.out.println("Connection 객체 생성 실패");
			e.printStackTrace();
		}
		

	}

}
