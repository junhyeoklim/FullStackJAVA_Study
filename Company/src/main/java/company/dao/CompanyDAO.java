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
				dto.setS_department(rs.getString("s_department"));
				dto.setS_rank(rs.getString("s_rank"));
				dto.setS_mail(rs.getString("s_mail"));
				dto.setS_phoneNumber(rs.getString("s_phoneNumber"));
				dto.setS_salary(rs.getInt("s_salary"));
				dto.setDate(rs.getString("Join_Date"));
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
				sql = "SELECT * FROM "+TABLE_NAME+" WHERE s_name='"+text+"' ORDER BY Join_Date DESC";
				break;
			case 2:
				sql = "SELECT * FROM "+TABLE_NAME+" WHERE s_rank='"+text+"' ORDER BY Join_Date DESC";
				break;
			case 3:
				sql = "SELECT * FROM "+TABLE_NAME+" WHERE s_department='"+text+"' ORDER BY Join_Date DESC";
				break;
		}
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();) {
			while(rs.next()) {
				CompanyDTO dto = new CompanyDTO();
				dto.setS_id(rs.getInt("s_id"));
				dto.setS_name(rs.getString("s_name"));
				dto.setS_department(rs.getString("s_department"));
				dto.setS_rank(rs.getString("s_rank"));
				dto.setS_mail(rs.getString("s_mail"));
				dto.setS_phoneNumber(rs.getString("s_phoneNumber"));
				dto.setS_salary(rs.getInt("s_salary"));
				dto.setDate(rs.getString("Join_Date"));	
				list.add(dto);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insertOK(CompanyDTO dto) {
		String sql = "INSERT INTO "+TABLE_NAME+"(s_name,s_department,s_rank,s_mail,s_phoneNumber) VALUES(?,?,?,?,?)";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, dto.getS_name());
			pstmt.setString(2, dto.getS_department());
			pstmt.setString(3, dto.getS_rank());
			pstmt.setString(4, dto.getS_mail());
			pstmt.setString(5, dto.getS_phoneNumber());			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
