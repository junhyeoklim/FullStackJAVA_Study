package company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.text.TabExpander;

import company.dto.CompanyDTO;

public class CompanyDAO {
	private static CompanyDAO companyDAO = new CompanyDAO();
	private final String TABLE_NAME = "salary_man";
	private static Connection con;


	private CompanyDAO() {
		con = JDBCConnector.getCon();
	}

	public static CompanyDAO getCompanyDAO() {
		return companyDAO;
	}

	public ArrayList<CompanyDTO> listDAO(){
		ArrayList<CompanyDTO> list = new ArrayList<CompanyDTO>();
		String sql = "SELECT * FROM "+TABLE_NAME+" ORDER BY Join_Date DESC";

		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while(rs.next()) {
				CompanyDTO dto = new CompanyDTO();
				dto.setS_id(rs.getInt("s_id"));
				dto.setS_name(rs.getString("s_name"));
				dto.setS_birth(rs.getInt("s_birth"));
				dto.setS_gender(rs.getString("s_gender"));
				dto.setS_department(rs.getString("s_department"));
				dto.setS_rank(rs.getString("s_rank"));
				dto.setS_mail(rs.getString("s_mail"));
				dto.setS_phoneNumber(rs.getString("s_phoneNumber"));
				dto.setS_salary(rs.getInt("s_salary"));
				dto.setDate(rs.getString("Join_Date"));
				dto.setUpdateTime(rs.getString("updateTime"));
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<CompanyDTO> searchDAO(int select,String text) {
		ArrayList<CompanyDTO> list = new ArrayList<CompanyDTO>();
		String sql = "";		

		switch(select)
		{
		case 1:				
			sql = "SELECT * FROM "+TABLE_NAME+" WHERE s_name LIKE '%"+text+"%' ORDER BY Join_Date DESC";
			break;
		case 2:
			sql = "SELECT * FROM "+TABLE_NAME+" WHERE s_rank LIKE '%"+text+"%' ORDER BY Join_Date DESC";
			break;
		case 3:
			sql = "SELECT * FROM "+TABLE_NAME+" WHERE s_department LIKE '%"+text+"%' ORDER BY Join_Date DESC";
			break;
		}

		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while(rs.next()) {
				CompanyDTO dto = new CompanyDTO();
				dto.setS_id(rs.getInt("s_id"));
				dto.setS_name(rs.getString("s_name"));
				dto.setS_birth(rs.getInt("s_birth"));
				dto.setS_gender(rs.getString("s_gender"));
				dto.setS_department(rs.getString("s_department"));
				dto.setS_rank(rs.getString("s_rank"));
				dto.setS_mail(rs.getString("s_mail"));
				dto.setS_phoneNumber(rs.getString("s_phoneNumber"));
				dto.setS_salary(rs.getInt("s_salary"));
				dto.setDate(rs.getString("Join_Date"));
				dto.setUpdateTime(rs.getString("updateTime"));
				list.add(dto);				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<CompanyDTO> searchDAO(String name) {
		ArrayList<CompanyDTO> list = new ArrayList<CompanyDTO>();
		String sql = "SELECT * FROM "+TABLE_NAME+" WHERE s_name='"+name+"'";		


		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while(rs.next()) {
				CompanyDTO dto = new CompanyDTO();
				dto.setS_id(rs.getInt("s_id"));
				dto.setS_name(rs.getString("s_name"));
				dto.setS_birth(rs.getInt("s_birth"));
				dto.setS_gender(rs.getString("s_gender"));
				dto.setS_department(rs.getString("s_department"));
				dto.setS_rank(rs.getString("s_rank"));
				dto.setS_mail(rs.getString("s_mail"));
				dto.setS_phoneNumber(rs.getString("s_phoneNumber"));
				dto.setS_salary(rs.getInt("s_salary"));
				dto.setDate(rs.getString("Join_Date"));
				dto.setUpdateTime(rs.getString("updateTime"));
				list.add(dto);				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void searchDAO(CompanyDTO dto) {
		String sql = "SELECT * FROM salary_man WHERE s_id="+dto.getS_id()+" AND s_name = '"+dto.getS_name()+"'";
		String asql = "SELECT * FROM admin WHERE id="+dto.getS_id()+" AND name = '"+dto.getS_name()+"'"; 
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement apstmt = con.prepareStatement(asql);				
				ResultSet rs = pstmt.executeQuery();
				ResultSet ars = apstmt.executeQuery();) {

			if(rs.next())
				return;
			else {
				if(ars.next())
					return;
				else {
					System.out.println("존재하지 않음");
					dto.setS_id(0);
					dto.setS_name(null);
				}
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertOK(CompanyDTO dto) {
		String sql = "INSERT INTO "+TABLE_NAME+"(s_id,s_name,s_birth,s_gender,s_department,s_rank,s_mail,s_phoneNumber) VALUES(?,?,?,?,?,?,?,?)";

		try(PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, dto.getS_id());
			pstmt.setString(2, dto.getS_name());
			pstmt.setInt(3, dto.getS_birth());
			pstmt.setString(4, dto.getS_gender());
			pstmt.setString(5, dto.getS_department());
			pstmt.setString(6, dto.getS_rank());
			pstmt.setString(7, dto.getS_mail());
			pstmt.setString(8, dto.getS_phoneNumber());			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateOK(CompanyDTO dto) {
		String sql = "UPDATE "+TABLE_NAME+" SET s_name=?,s_birth=?, s_department=?,s_rank=?,s_mail=?,s_phoneNumber = ? WHERE s_name=?";

		try(PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, dto.getS_name());
			pstmt.setInt(2, dto.getS_birth());
			pstmt.setString(3, dto.getS_department());
			pstmt.setString(4, dto.getS_rank());
			pstmt.setString(5, dto.getS_mail());
			pstmt.setString(6, dto.getS_phoneNumber());
			pstmt.setString(7, dto.getS_name());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}




	public boolean searchID(String id) {
		boolean flag = false;

		String sql = "SELECT * FROM salary_man WHERE s_id='"+id+"'";

		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while(rs.next()) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}



}
