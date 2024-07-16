package com.springbook.biz.salary.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.common.PageVO;
import com.springbook.biz.salary.CompanyVO;


public class CompanyDAO {
    private static CompanyDAO companyDAO = new CompanyDAO();
    private final String TABLE_NAME = "salary_man";
    private static Connection con;

    private CompanyDAO() {
        con = JDBCUtil.getConnection();
    }

    public static CompanyDAO getCompanyDAO() {
        return companyDAO;
    }

    public ArrayList<CompanyVO> listDAO(PageVO pageVO){
        ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
        String sql = "SELECT SQL_CALC_FOUND_ROWS * FROM "+TABLE_NAME+" ORDER BY Join_Date DESC  LIMIT "+(pageVO.getCurrentPage()-1)*pageVO.getRecordsPerPage()+","+pageVO.getRecordsPerPage();
        ResultSet rs = null;
        
        
        
        try(PreparedStatement pstmt = con.prepareStatement(sql)) {
            rs = pstmt.executeQuery();
            
            while(rs.next()) {            	
                CompanyVO newVO = new CompanyVO();
                newVO.setS_id(rs.getInt("s_id"));
                newVO.setS_name(rs.getString("s_name"));
                newVO.setS_birth(rs.getInt("s_birth"));
                newVO.setS_gender(rs.getString("s_gender"));
                newVO.setS_department(rs.getString("s_department"));
                newVO.setS_rank(rs.getString("s_rank"));
                newVO.setS_mail(rs.getString("s_mail"));
                newVO.setS_phoneNumber(rs.getString("s_phoneNumber"));
                newVO.setS_salary(rs.getInt("s_salary"));
                newVO.setDate(rs.getString("Join_Date"));
                newVO.setUpdateTime(rs.getString("updateTime"));
                list.add(newVO);
            }
            rs.close();
            rs = pstmt.executeQuery("SELECT FOUND_ROWS()");
            
            if(rs.next()) {
                pageVO.setNoOfRecords(rs.getInt(1));
            }
            pageVO.setNoOfPages((int) Math.ceil(pageVO.getNoOfRecords() * 1.0 / pageVO.getRecordsPerPage()));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return list;
    }
    
	public ArrayList<CompanyVO> listDAO(){
		ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
		String sql = "SELECT SQL_CALC_FOUND_ROWS * FROM "+TABLE_NAME+" ORDER BY Join_Date DESC";
		
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();) {
			
			
			while(rs.next()) {
				CompanyVO VO = new CompanyVO();
				VO.setS_id(rs.getInt("s_id"));
				VO.setS_name(rs.getString("s_name"));
				VO.setS_birth(rs.getInt("s_birth"));
				VO.setS_gender(rs.getString("s_gender"));
				VO.setS_department(rs.getString("s_department"));
				VO.setS_rank(rs.getString("s_rank"));
				VO.setS_mail(rs.getString("s_mail"));
				VO.setS_phoneNumber(rs.getString("s_phoneNumber"));
				VO.setS_salary(rs.getInt("s_salary"));
				VO.setDate(rs.getString("Join_Date"));
				VO.setUpdateTime(rs.getString("updateTime"));
				list.add(VO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

    public ArrayList<CompanyVO> searchDAO(PageVO pageVO, int select, String text) {
        ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
        String sql = "";

        switch(select) {
            case 1:
                sql = "SELECT SQL_CALC_FOUND_ROWS * FROM " + TABLE_NAME + " WHERE s_name LIKE ? ORDER BY Join_Date DESC LIMIT ?, ?";
                break;
            case 2:
                sql = "SELECT SQL_CALC_FOUND_ROWS * FROM " + TABLE_NAME + " WHERE s_rank LIKE ? ORDER BY Join_Date DESC LIMIT ?, ?";
                break;
            case 3:
                sql = "SELECT SQL_CALC_FOUND_ROWS * FROM " + TABLE_NAME + " WHERE s_department LIKE ? ORDER BY Join_Date DESC LIMIT ?, ?";
                break;
        }

        ResultSet rs = null;

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, "%" + text + "%");
            pstmt.setInt(2, (pageVO.getCurrentPage() - 1) * pageVO.getRecordsPerPage());
            pstmt.setInt(3, pageVO.getRecordsPerPage());

            rs = pstmt.executeQuery();

            while (rs.next()) {
                CompanyVO newVO = new CompanyVO();
                newVO.setS_id(rs.getInt("s_id"));
                newVO.setS_name(rs.getString("s_name"));
                newVO.setS_birth(rs.getInt("s_birth"));
                newVO.setS_gender(rs.getString("s_gender"));
                newVO.setS_department(rs.getString("s_department"));
                newVO.setS_rank(rs.getString("s_rank"));
                newVO.setS_mail(rs.getString("s_mail"));
                newVO.setS_phoneNumber(rs.getString("s_phoneNumber"));
                newVO.setS_salary(rs.getInt("s_salary"));
                newVO.setDate(rs.getString("Join_Date"));
                newVO.setUpdateTime(rs.getString("updateTime"));
                list.add(newVO);
            }

            rs.close();
            rs = pstmt.executeQuery("SELECT FOUND_ROWS()");

            if (rs.next()) {
                pageVO.setNoOfRecords(rs.getInt(1));
            }
            pageVO.setNoOfPages((int) Math.ceil(pageVO.getNoOfRecords() * 1.0 / pageVO.getRecordsPerPage()));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return list;
    }
    
	public void searchDAO(CompanyVO VO) {
		String sql = "SELECT * FROM salary_man WHERE s_id="+VO.getS_id()+" AND s_name = '"+VO.getS_name()+"'";
		String asql = "SELECT * FROM admin WHERE s_id="+VO.getS_id()+" AND s_name = '"+VO.getS_name()+"'"; 
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement apstmt = con.prepareStatement(asql);				
				ResultSet rs = pstmt.executeQuery();
				ResultSet ars = apstmt.executeQuery();) {

			if(rs.next()) {
				VO.setS_department(rs.getString("s_department"));
				return;
			}
			else {
				if(ars.next())
					return;
				else {
					System.out.println("존재하지 않음");
					VO.setS_id(0);
					VO.setS_name(null);
				}
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<CompanyVO> searchDAO(String s_id) {
		ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
		String sql = "SELECT * FROM "+TABLE_NAME+" WHERE s_id='"+s_id+"'";		


		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while(rs.next()) {
				CompanyVO VO = new CompanyVO();
				VO.setS_id(rs.getInt("s_id"));
				VO.setS_name(rs.getString("s_name"));
				VO.setS_birth(rs.getInt("s_birth"));
				VO.setS_gender(rs.getString("s_gender"));
				VO.setS_department(rs.getString("s_department"));
				VO.setS_rank(rs.getString("s_rank"));
				VO.setS_mail(rs.getString("s_mail"));
				VO.setS_phoneNumber(rs.getString("s_phoneNumber"));
				VO.setS_salary(rs.getInt("s_salary"));
				VO.setDate(rs.getString("Join_Date"));
				VO.setUpdateTime(rs.getString("updateTime"));
				list.add(VO);				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insertOK(CompanyVO VO) {
		String sql = "INSERT INTO "+TABLE_NAME+"(s_id,s_name,s_birth,s_gender,s_department,s_rank,s_mail,s_phoneNumber) VALUES(?,?,?,?,?,?,?,?)";

		try(PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, VO.getS_id());
			pstmt.setString(2, VO.getS_name());
			pstmt.setInt(3, VO.getS_birth());
			pstmt.setString(4, VO.getS_gender());
			pstmt.setString(5, VO.getS_department());
			pstmt.setString(6, VO.getS_rank());
			pstmt.setString(7, VO.getS_mail());
			pstmt.setString(8, VO.getS_phoneNumber());			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateOK(CompanyVO VO) {
		String sql = "UPDATE "+TABLE_NAME+" SET s_name=?,s_birth=?, s_department=?,s_rank=?,s_mail=?,s_phoneNumber = ? WHERE s_id=?";

		try(PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, VO.getS_name());
			pstmt.setInt(2, VO.getS_birth());
			pstmt.setString(3, VO.getS_department());
			pstmt.setString(4, VO.getS_rank());
			pstmt.setString(5, VO.getS_mail());
			pstmt.setString(6, VO.getS_phoneNumber());
			pstmt.setInt(7, VO.getS_id());
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
	
	
	public Map<String, Integer> getMonthlyNewHires(){
		Map<String, Integer> newHires = new HashMap<>();
        String sql = "SELECT DATE_FORMAT(Join_Date, '%Y-%m') AS month, COUNT(*) AS new_hires "
                + "FROM salary_man "
                + "WHERE Join_Date >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) "
                + "GROUP BY DATE_FORMAT(Join_Date, '%Y-%m') "
                + "order by month asc";
        
        try(PreparedStatement pstmt = con.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();) {			
        	
        	while(rs.next()) {
        		newHires.put(rs.getString("month"), rs.getInt("new_hires"));
        	}
        	
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		return newHires;
	}
	
	public Map<String, Integer> getMonthlyResignations() {
	        Map<String, Integer> resignations = new HashMap<>();
	        String sql = "SELECT DATE_FORMAT(s_date, '%Y-%m') AS month, COUNT(*) AS resignations "
	                   + "FROM join_resign "
	                   + "WHERE s_date >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) "
	                   + "GROUP BY DATE_FORMAT(s_date, '%Y-%m') "
	                   + "order by month asc";

	        try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                resignations.put(rs.getString("month"), rs.getInt("resignations"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return resignations;
	    }
	
	
	
}
