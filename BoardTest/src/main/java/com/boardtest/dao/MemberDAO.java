package com.boardtest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.set.dto.AddressDTO;
import com.set.dto.UserDTO;

public class MemberDAO {
	private static MemberDAO memberDAO = new MemberDAO();
	private String CONNECTION_POLLRESOURCE_NAME = "jdbc/testdb";
	private final String BOARD_TABLE = "board";
	private final String ADDRESS_TABLE = "address";
	private final String USER_TABLE = "user";
	private DataSource dataSource;
	
	private MemberDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/"+CONNECTION_POLLRESOURCE_NAME);
		} catch (NamingException e) {
			
		}
	}
	
	public static MemberDAO getMemberDAO() {
		return memberDAO;
	}
	
	
	public void searchUserDAO(UserDTO udto) {
	
		String sql = "SELECT * FROM user WHERE id='"+udto.getId()+"' AND password='"+udto.getPassword()+"'";
		boolean flag = false;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();) {

			
			while(rs.next()) {
				udto.setId(rs.getString("id"));
				udto.setName(rs.getString("name"));				
				udto.setNickName(rs.getString("nickname"));
				udto.setEmail(rs.getString("email"));
				udto.setPostcode(rs.getInt("postcode"));
				udto.setBirth(rs.getString("birth"));
				udto.setPhone(rs.getInt("phone"));
				udto.setSex(rs.getString("sex"));
				flag = true;
			}
			if(flag)
				return;
			else
				udto.setId(null);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void searchAddressDAO(UserDTO udto,AddressDTO adto) {
		
		String sql = "SELECT * from "+ADDRESS_TABLE+" a, "+USER_TABLE+" u WHERE a.postcode = u.postcode and u.id = '"+udto.getId()+"'";
		
		try(Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();) {
			
			while(rs.next()) {
				adto.setPostcode(udto.getPostcode());
				adto.setRoadAddress(rs.getString("roadaddress"));
				adto.setJibunAddress(rs.getString("jibunaddress"));
				adto.setDetailAddress(rs.getString("detailaddress"));
				adto.setExtraAddress(rs.getString("extraaddress"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void insertDAO(UserDTO udto,AddressDTO adto) {
		
		String userSql = "INSERT INTO "+USER_TABLE+" VALUES(?,?,?,?,?,?,?,?,?)";
		String addressSql = "INSERT INTO "+ADDRESS_TABLE+" VALUES(?,?,?,?,?,?)";
		
		try(Connection conn = dataSource.getConnection();
			PreparedStatement upstmt = conn.prepareStatement(userSql);
			PreparedStatement apstmt = conn.prepareStatement(addressSql);) {
		
			upstmt.setString(1, udto.getId());
			upstmt.setString(2, udto.getName());
			upstmt.setString(3, udto.getNickName());
			upstmt.setString(4, udto.getPassword());
			upstmt.setString(5, udto.getEmail());
			upstmt.setInt(6, udto.getPostcode());
			upstmt.setString(7, udto.getBirth());
			upstmt.setInt(8, udto.getPhone());
			upstmt.setString(9, udto.getSex());
			
			apstmt.setString(1, adto.getId());
			apstmt.setInt(2, adto.getPostcode());
			apstmt.setString(3, adto.getRoadAddress());
			apstmt.setString(4, adto.getJibunAddress());
			apstmt.setString(5, adto.getDetailAddress());
			apstmt.setString(6, adto.getExtraAddress());
			
			int result1 =0,result2 =0;
			result1 = upstmt.executeUpdate();
			result2 = apstmt.executeUpdate();
			
			if(result1>0 && result2 <= 0 )
				System.out.println("유저 업데이트");
			else if(result2>0 && result1 <=0)
				System.out.println("주소 업데이트");
			else if(result1>0 && result2>0)
				System.out.println("다 성공");
			else
				System.out.println("다 실패");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateDAO(UserDTO udto,AddressDTO adto) {
		String userSql = "UPDATE "+USER_TABLE+" SET password=?,email=?,postcode=?,birth=?,phone=? WHERE id=?";
		String addressSql = "UPDATE "+ADDRESS_TABLE+" SET postcode=?,roadaddress=?,jibunaddress=?,detailaddress=?,extraaddress=? WHERE id=?"; 
		
		try(Connection con = dataSource.getConnection();
			PreparedStatement upstmt = con.prepareStatement(userSql);
			PreparedStatement apstmt = con.prepareStatement(addressSql);)
		{
			upstmt.setString(1, udto.getPassword());
			upstmt.setString(2, udto.getEmail());
			upstmt.setInt(3, udto.getPostcode());
			upstmt.setString(4, udto.getBirth());
			upstmt.setInt(5, udto.getPhone());
			upstmt.setString(6, udto.getId());
			upstmt.executeUpdate();
			
			apstmt.setInt(1, adto.getPostcode());
			apstmt.setString(2, adto.getRoadAddress());
			apstmt.setString(3, adto.getJibunAddress());
			apstmt.setString(4, adto.getDetailAddress());
			apstmt.setString(5, adto.getExtraAddress());
			apstmt.setString(6, adto.getId());
			apstmt.executeUpdate();
			
			if(upstmt.executeUpdate() > 0 && apstmt.executeUpdate()>0)
				System.out.println("성공");
			else if(upstmt.executeUpdate() < 0 && apstmt.executeUpdate()>0)
				System.out.println("유저 정보 변경 실패");
			else if (upstmt.executeUpdate() > 0 && apstmt.executeUpdate()<0) 
				System.out.println("주소 변경 실패");
			else
				System.out.println("다 실패");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
