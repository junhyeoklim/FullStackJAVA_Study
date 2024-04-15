package salaryDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import salaryVO.SalaryManVO;

public class SalaryManDAO {

	private ArrayList<SalaryManVO> man;
	private Connection conn = JDBCConnector.getCon();
	private static SalaryManDAO sms;
	private String sql;
	private boolean check;
	private int result;

	//싱글톤 사용이유 : 검색 하거나 데이터 입력을 할때마다 새로운 객체가 생성 되는지 배열에 널값이 들어감

	private SalaryManDAO(int size) {
		man = new ArrayList<>(size);
	}

	public static SalaryManDAO getSalary(int size) {
		if (sms == null)
			sms = new SalaryManDAO(size);
		return sms;
	}

	public void setSalaryMan(SalaryManVO smi) {
		sql = "INSERT INTO salary_man(s_name,s_department,s_rank,s_salary,s_phoneNumber) values(?,?,?,?,?)";
		if (!man.stream().anyMatch(m -> m.getPhoneNumber().equals(smi.getPhoneNumber()))) {
			man.add(smi);
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

		} else {
			System.out.println("이미 등록된 사원입니다.");
		}
	}



	public void searchName(String name)
	{		
		int manLength = man.size();

		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getName().compareTo(name) == 0)
			{
				System.out.println();
				man.get(i).showManAllInfo();
				check = true;
			}
		}
		if(!check)
			System.out.println("찾으시는 사원 정보가 없습니다.");
	}

	public int search(String name)
	{		
		int manLength = man.size();

		//기존에 사용하던 알고리즘
		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getName().compareTo(name) == 0)
				return i;
		}
		return -1;
	}   

	public void searchDepartment(String department)
	{   
		int manLength = man.size();

		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getDepartment().compareTo(department) == 0)
			{
				System.out.println();
				man.get(i).showManDepartment();
				check = true;
			}
		}
		if(!check)
			System.out.println("찾으시는 사원 정보가 없습니다.");

	}

	public void searchRank(String rank)
	{
		int manLength = man.size();

		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getRank().compareTo(rank) == 0)
			{
				System.out.println();
				man.get(i).showManRank();
				check = true;
			}
		}
		if(!check)
			System.out.println("찾으시는 사원 정보가 없습니다.");

	}
	public void searchSalary(int salary)
	{
		int manLength = man.size();

		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getSalary() == salary)
			{
				System.out.println();
				man.get(i).showManSalary();
				check = true;
			}
		}
		if(!check)
			System.out.println("찾으시는 사원 정보가 없습니다.");
	}

	public void updatePhoneNumber(String name,String phoeNumber)
	{
		int manLength = man.size();
		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getName().compareTo(name) == 0)
			{
				man.get(i).setPhoneNumber(phoeNumber);
				return;
			}
		}
	}
	public void updateDepartment(String name,String department)
	{
		int manLength = man.size();
		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getName().compareTo(name) == 0)
			{
				man.get(i).setDepartment(department);
				return;
			}
		}
	}
	public void updateRank(String name,String rank)
	{
		int manLength = man.size();
		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getName().compareTo(name) == 0)
			{
				man.get(i).setRank(rank);
				return;
			}
		}
	}
	public void updateSalary(String name,int salary)
	{
		int manLength = man.size();
		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getName().compareTo(name) == 0)
			{
				man.get(i).setSalary(salary);
				return;
			}
		}
	}
	public void updateAllInfo(String name,String phoneNumber,String department, String rank, int salary)
	{
		int manLength = man.size();
		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getName().compareTo(name) == 0)
			{
				man.get(i).setPhoneNumber(phoneNumber);
				man.get(i).setDepartment(department);
				man.get(i).setRank(rank);
				man.get(i).setSalary(salary);
				return;
			}
		}
	}

	public void deleteSalary(int idx)
	{
		man.remove(idx);
		System.out.println("삭제가 완료되었습니다.");
	}
	//등록된 사원 전부를 출력하는 메소드
	public void salaryManeList()
	{
		sql = "SELECT * FROM salary_man";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			ResultSet rs = pstmt.executeQuery(sql);
			check = rs.next();
			
			if(!check)
				System.out.println("사원 정보가 존재하지 않습니다.\n");
			else
			{				
				while(check)
				{
					System.out.println();
					System.out.println("사원 번호 : " +rs.getInt("s_id"));
					System.out.println("이름 : "+ rs.getString("s_name"));
					System.out.println("전화번호 : "+rs.getString("s_phoneNumber"));
					System.out.println("부서 : "+rs.getString("s_department"));
					System.out.println("직급 : "+rs.getString("s_rank"));
					System.out.println("연봉 : "+rs.getInt("s_salary"));
					System.out.println("회사 입사일 : "+rs.getString("Join_Time"));
					
					check = rs.next();
				}
			}

			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


