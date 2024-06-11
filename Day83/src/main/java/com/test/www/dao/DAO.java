package com.test.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.test.www.dto.MovieScriptDto;

public class DAO {
	private static DAO dao = new DAO();
	private String CONNECTION_POOL_RESOURCE_NAME = "jdbc/testdb";
	private final String TABLE_NAME = "movie";
	private DataSource dataSource;
	
	
	
	
	private DAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/"+CONNECTION_POOL_RESOURCE_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<MovieScriptDto> getMovieScript(){
		String sql = "SELECT * FROM " + TABLE_NAME;
		ArrayList<MovieScriptDto> list = new ArrayList<>();
		
		try(Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery())
		{
			
			while(rs.next()) {
				MovieScriptDto dto = new MovieScriptDto();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setMsg(rs.getString("msg"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int checkId(String id) {
		String sql = "SELECT * FROM member WHERE ID= '"+id+"'";
		
		int result = 0;
		
		try(Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();) {
			
			if(rs.next()) result = 0;
			else result = 1;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
		
	}
	public static DAO getBoardDAO() {
		return dao;
	}
}
