package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCTest {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/jdbcTest?serverTimezone=UTC";
		String driverPath = "com.mysql.cj.jdbc.Driver";
		String id = "root", pwd = "1234";
		String sql = "INSERT INTO board(name,title,contents) VALUES(?,?,?)";
		String sql2 = "UPDATE board SET contents = ? WHERE no = ?";

		String name = null, title = null, contents = null, date = null;
		int no = 0, result = 0, menu = 0, rCnt = 0;

		Scanner sc = new Scanner(System.in);

		try (Connection conn = DriverManager.getConnection(url, id, pwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
			Class.forName(driverPath);
			System.out.println("드라이버 연결 성공!");
			System.out.println("Connection 연결 성공!");

			while (true) {
				System.out.println("메뉴를 선택하세요.");
				System.out.println("1. 쓰기");
				System.out.println("2. 조회");
				System.out.println("3. 수정");
				System.out.println("4. 삭제");
				System.out.println("5. test 테이블 생성");
				System.out.println("6. test 테이블 삭제");
				System.out.println("7. 종료");
				System.out.print("선택 : ");

				menu = sc.nextInt();
				sc.nextLine();

				switch (menu) {
				case 1: 
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
					System.out.println();
					if (result > 0)
						System.out.println(result + "건 데이터 삽입성공");

					break;

				case 2: 
					sql = "SELECT * FROM board ORDER BY no DESC";
					ResultSet rs = pstmt.executeQuery(sql);
					System.out.println();

					while (rs.next()) {
						no = rs.getInt("no");
						name = rs.getString("name");
						title = rs.getString("title");
						contents = rs.getString("contents");
						date = rs.getString("date");
						rCnt = rs.getInt("rCnt");

						System.out.println("번호 " + no);
						System.out.println("이름 " + name);
						System.out.println("제목 " + title);
						System.out.println("내용 " + contents);
						System.out.println("시간 " + date);
						System.out.println("조회수 " + rCnt);
						System.out.println();
					}

					break;

				case 3: 
					System.out.println("수정할 글 번호를 입력하세요.");
					no = sc.nextInt();
					sc.nextLine();

					System.out.println("수정할 글 내용을 입력하세요.");
					contents = sc.nextLine();

					pstmt2.setString(1, contents); 
					pstmt2.setInt(2, no); 

					result = pstmt2.executeUpdate();

					if(result > 0)
						System.out.println(result+"건 데이터 수정성공");

					break;

				case 4: 
					System.out.println("삭제할 글 번호를 입력하세요.");
					no = sc.nextInt();
					sc.nextLine();

					sql = "DELETE FROM board WHERE no=" + no;
					result = pstmt.executeUpdate(sql);

					if (result > 0)
						System.out.println(result + "건 데이터 삭제성공");

					break;

				case 5: 
					sql = "CREATE TABLE test (no int)";
					pstmt.executeUpdate(sql);

					System.out.println("테이블이 생성 되었습니다!\n");
					break;

				case 6: 
					sql = "DROP TABLE test";
					pstmt.executeUpdate(sql);
					System.out.println("테이블이 삭제 되었습니다!\n");
					break;

				case 7: 
					System.out.println("시스템을 종료합니다.");
					return;
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
