package test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCTest {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
		String driverPath = "com.mysql.cj.jdbc.Driver";		
		String id = "root",pwd = "1234";

		String name = null, title = null, contents = null, sql = null, rTime = null;
		int menu = 0 , result = 0, no =0,rCnt = 0;

		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in,"euc-kr");

		sql = "INSERT INTO board(name,title,contents) values(?,?,?)";
		try(Connection conn = DriverManager.getConnection(url,id,pwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			Class.forName(driverPath);
			System.out.println("드라이버 연결 성공");
			System.out.println("Connection 연결 성공");

			while(true)
			{
				System.out.println("1. 쓰기");
				System.out.println("2. 조회");
				System.out.println("3. 수정");
				System.out.println("4. 삭제");
				System.out.println("5. 종료");
				System.out.print("선택 : ");
				menu = sc.nextInt();
				sc.nextLine();

				switch(menu)
				{
				case 1:{
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
						System.out.println("데이터 삽입 성공");
					break;
				}
				case 2:{
					sql = "SELECT * FROM board ORDER BY no DESC";
					rs = pstmt.executeQuery(sql);
					
					while(rs.next())
					{
						no = rs.getInt("no");
						name = rs.getString("name");
						title = rs.getString("title");
						contents = rs.getString("contents");
						rTime = rs.getString("rTime");
						rCnt = rs.getInt("rCnt");
						
						System.out.println("번호 "+ no);
						System.out.println("이름 "+ name);
						System.out.println("제목 "+ title);
						System.out.println("내용 "+ contents);
						System.out.println("시간 "+ rTime);
						System.out.println("조회수 "+ rCnt);
					}					
					break;
				}
				case 3:{
					sql = "UPDATE board SET contents=? WHERE no =?";
					System.out.println("수정할 글 번호를 입력하세요.");
					no = sc.nextInt();
					sc.nextLine();
					
					System.out.println("수정할 글 내용을 입력하세요.");
					contents = sc.nextLine();
					
					pstmt.setString(1, contents);
					pstmt.setInt(2, no);
					
					result = pstmt.executeUpdate();
					
					if(result > 0 )
						System.out.println("내용 변경 성공");
					break;
				}
				case 4:{					
					System.out.println("삭제할 글 번호를 입력하세요.");
					no = sc.nextInt();
					sc.nextLine();					
					sql = "DELETE FROM board where no = "+no;
					result = pstmt.executeUpdate(sql);
					
					if(result > 0)
						System.out.println("삭제성공");
					break;
				}
				case 5:{
					System.out.println("프로그램을 종료합니다.");
					return;
				}
				}
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
