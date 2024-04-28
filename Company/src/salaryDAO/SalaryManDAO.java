package salaryDAO;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import salaryVO.SalaryManVO;

public class SalaryManDAO {

	private Connection conn = JDBCConnector.getCon();
//	private static SalaryManDAO sms;
	private String sql;
	private boolean check;
	private int result;

	//싱글톤 사용이유 : 검색 하거나 데이터 입력을 할때마다 새로운 객체가 생성 되는지 배열에 널값이 들어감

//	private SalaryManDAO(int size) {
//		new ArrayList<>(size);
//	}
//
//	public static SalaryManDAO getSalary(int size) {
//		if (sms == null)
//			sms = new SalaryManDAO(size);
//		return sms;
//	}

	public void setSalaryMan(SalaryManVO smi) {

		//휴대 전화 중복 확인
		check = checkPhone(smi.getPhoneNumber());

		if(!check)
		{
			sql = "INSERT INTO salary_man(s_name,s_department,s_rank,s_salary,s_phoneNumber) values(?,?,?,?,?)";

			try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.setString(1, smi.getName());
				pstmt.setString(2, smi.getDepartment());
				pstmt.setString(3, smi.getRank());
				pstmt.setInt(4, smi.getSalary());
				pstmt.setString(5, smi.getPhoneNumber());

				result = pstmt.executeUpdate();

				if(result > 0)
					System.out.println("등록이 완료되었습니다.\n");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			System.out.println("이미 등록된 사원입니다.\n");

	}



	public void searchName(String name)
	{		
		check = search(name);

		sql = "SELECT * FROM salary_man WHERE s_name = '"+name+"'";		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while(rs.next())
			{
				System.out.println();
				System.out.println("사원 번호 : " +rs.getInt("s_id"));
				System.out.println("이름 : "+ rs.getString("s_name"));
				System.out.println("전화번호 : "+rs.getString("s_phoneNumber"));
				System.out.println("부서 : "+rs.getString("s_department"));
				System.out.println("직급 : "+rs.getString("s_rank"));
				System.out.println("연봉 : "+rs.getInt("s_salary"));
				System.out.println("회사 입사일 : "+rs.getString("Join_Time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(!check)
			System.out.println("찾으시는 사원 정보가 없습니다.");
	}

	/*
	 * public int search(String name) { int manLength = man.size();
	 * 
	 * //기존에 사용하던 알고리즘 for (int i = 0; i < manLength; i++) {
	 * if(man.get(i).getName().compareTo(name) == 0) return i; } return -1; }
	 */   

	public boolean search(String name)
	{		
		sql = "SELECT s_name FROM salary_man WHERE s_name = '"+name+"'";		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			check = rs.next();

			while(true)
			{
				if(check)
					return true;
				check = rs.next();
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}   

	public boolean checkPhone(String phoneNumber)
	{
		sql = "SELECT s_phoneNumber FROM salary_man WHERE s_phoneNumber = '"+phoneNumber+"'";

		try(PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while(rs.next())
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}






	public void searchDepartment(String department)
	{   
		sql = "SELECT s_id,s_name,s_phoneNumber,s_rank,s_salary,Join_Time FROM salary_man WHERE s_department = '"+department+"'";		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while(rs.next())
			{
				System.out.println("사원 번호 : " +rs.getInt("s_id"));
				System.out.println("이름 : "+ rs.getString("s_name"));
				System.out.println("전화번호 : "+rs.getString("s_phoneNumber"));
				System.out.println("직급 : "+rs.getString("s_rank"));
				System.out.println("연봉 : "+rs.getInt("s_salary"));
				System.out.println("회사 입사일 : "+rs.getString("Join_Time"));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!check)
			System.out.println("찾으시는 사원 정보가 없습니다.");

	}

	public void searchRank(String rank)
	{
		sql = "SELECT s_id,s_name,s_phoneNumber,s_department,s_salary,Join_Date FROM salary_man WHERE s_rank = '"+rank+"'";		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while(rs.next())
			{
				System.out.println("사원 번호 : " +rs.getInt("s_id"));
				System.out.println("이름 : "+ rs.getString("s_name"));
				System.out.println("전화번호 : "+rs.getString("s_phoneNumber"));
				System.out.println("부서 : "+rs.getString("s_department"));
				System.out.println("연봉 : "+rs.getInt("s_salary"));
				System.out.println("회사 입사일 : "+rs.getString("Join_Time"));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!check)
			System.out.println("찾으시는 사원 정보가 없습니다.");

	}
	public void searchSalary(int salary)
	{
		sql = "SELECT s_id,s_name,s_phoneNumber,s_department,s_rank,Join_Time FROM salary_man WHERE s_salary = '"+salary+"'";		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while(rs.next())
			{
				System.out.println("사원 번호 : " +rs.getInt("s_id"));
				System.out.println("이름 : "+ rs.getString("s_name"));
				System.out.println("전화번호 : "+rs.getString("s_phoneNumber"));
				System.out.println("부서 : "+rs.getString("s_department"));
				System.out.println("직급 : "+rs.getString("s_rank"));
				System.out.println("회사 입사일 : "+rs.getString("Join_Time"));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void updatePhoneNumber(String name,String phoneNumber)
	{
		sql = "UPDATE salary_man SET s_phoneNumber = ? WHERE s_name = '"+name+"'";

		check = checkPhone(phoneNumber);

		if(!check)
		{
			try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.setString(1, phoneNumber);
				result = pstmt.executeUpdate();			

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			System.out.println("이미 등록된 전화번호 입니다.");
	}
	public void updateDepartment(String name,String department)
	{
		sql = "UPDATE salary_man SET s_department = ?WHERE s_name = ?";

		try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, department);
			pstmt.setString(2, name);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(result > 0)
			System.out.println("변경이 완료 되었습니다!");
	}
	public void updateRank(String name,String rank)
	{
		sql = "UPDATE salary_man SET s_rank = ?WHERE s_name = ?";

		try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, rank);
			pstmt.setString(2, name);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(result > 0)
			System.out.println("변경이 완료 되었습니다!");
	}
	public void updateSalary(String name,int salary)
	{
		sql = "UPDATE salary_man SET s_salary = ? WHERE s_name = ?";


		try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, salary);
			pstmt.setString(2, name);
			result = pstmt.executeUpdate();

			if(result > 0)
				System.out.println("변경이 완료 되었습니다!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateAllInfo(String name,String phoneNumber,String department, String rank, int salary)
	{
		sql = "UPDATE salary_man SET s_phoneNumber = ? ,s_department = ?,s_rank = ?,s_salary = ? WHERE s_name = ?";

		check = checkPhone(phoneNumber);

		if(!check)
		{
			try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.setString(1, phoneNumber);
				pstmt.setString(2, department);
				pstmt.setString(3, rank);
				pstmt.setInt(4, salary);
				pstmt.setString(5, name);
				result = pstmt.executeUpdate();

				if(result > 0)
					System.out.println("변경이 완료 되었습니다!");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			System.out.println("이미 등록된 전화번호 입니다!");
	}

	public void deleteSalary(String name)
	{
		sql = "DELETE FROM salary_man WHERE s_name = '" + name+"'";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);) {

			result = pstmt.executeUpdate();

			if(result > 0)
				System.out.println("삭제가 완료되었습니다.");
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	//등록된 사원 전부를 출력하는 메소드
	public void salaryManeList()
	{
		sql = "SELECT * FROM salary_man";

		try(PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();)
		{
			
			check = rs.next();

			System.out.println();

			if(!check)
				System.out.println("사원 데이터가 존재 하지 않습니다!");
			else
			{				
				while(check)
				{
					System.out.println("사원 번호 : " +rs.getInt("s_id"));
					System.out.println("이름 : "+ rs.getString("s_name"));
					System.out.println("전화번호 : "+rs.getString("s_phoneNumber"));
					System.out.println("부서 : "+rs.getString("s_department"));
					System.out.println("직급 : "+rs.getString("s_rank"));
					System.out.println("연봉 : "+rs.getInt("s_salary"));
					System.out.println("회사 입사일 : "+rs.getString("Join_Date"));
					System.out.println();
					check = rs.next();
				}
			}
			System.out.println();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void save()
	{
		sql = "SELECT * FROM salary_man";
		
		try(FileOutputStream fos = new FileOutputStream("Salary_Man_List.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();) {
			
			check = rs.next();
			
			if(!check)
			{
				System.out.println("사원 정보가 존재하지 않습니다.");
				return;
			}
			else
			{
				while(check)
				{
					bw.write("사원 번호 : "+rs.getInt("s_id"));
					bw.write("\n");
					bw.write("사원 이름 : "+rs.getString("s_name"));
					bw.write("\n");
					bw.write("전화 번호 : "+rs.getString("s_phoneNumber"));
					bw.write("\n");
					bw.write("부서 이름 : "+rs.getString("s_department"));
					bw.write("\n");
					bw.write("사원 직급 : "+rs.getString("s_rank"));
					bw.write("\n");
					bw.write("사원 연봉 : "+rs.getInt("s_salary"));
					bw.write("\n");
					bw.write("회사 입사일 : "+rs.getString("Join_Date"));
					bw.write("\n\n");
					
					check = rs.next();
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}


