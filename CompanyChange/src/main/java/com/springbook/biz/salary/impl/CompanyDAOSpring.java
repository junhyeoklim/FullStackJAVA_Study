package com.springbook.biz.salary.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.common.PageVO;
import com.springbook.biz.salary.CompanyVO;

@Repository
public class CompanyDAOSpring {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String TABLE_NAME = "salary_man";

    public List<CompanyVO> listDAO(PageVO pageVO) {
        String sql = "SELECT SQL_CALC_FOUND_ROWS * FROM " + TABLE_NAME + " ORDER BY Join_Date DESC LIMIT ?, ?";
        List<CompanyVO> list = jdbcTemplate.query(sql, new Object[] {
            (pageVO.getCurrentPage() - 1) * pageVO.getRecordsPerPage(), pageVO.getRecordsPerPage()
        }, new BeanPropertyRowMapper<>(CompanyVO.class));

        pageVO.setNoOfRecords(jdbcTemplate.queryForObject("SELECT FOUND_ROWS()", Integer.class));
        pageVO.setNoOfPages((int) Math.ceil(pageVO.getNoOfRecords() * 1.0 / pageVO.getRecordsPerPage()));

        return new ArrayList<>(list);
    }

    public List<CompanyVO> listDAO() {
        String sql = "SELECT * FROM " + TABLE_NAME + " ORDER BY Join_Date DESC";
        List<CompanyVO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CompanyVO.class));
        return new ArrayList<>(list);
    }

    public List<CompanyVO> searchDAO(PageVO pageVO, int select, String text) {
        String sql = "";
        switch (select) {
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

        List<CompanyVO> list = jdbcTemplate.query(sql, new Object[] {
            "%" + text + "%", (pageVO.getCurrentPage() - 1) * pageVO.getRecordsPerPage(), pageVO.getRecordsPerPage()
        }, new BeanPropertyRowMapper<>(CompanyVO.class));

        pageVO.setNoOfRecords(jdbcTemplate.queryForObject("SELECT FOUND_ROWS()", Integer.class));
        pageVO.setNoOfPages((int) Math.ceil(pageVO.getNoOfRecords() * 1.0 / pageVO.getRecordsPerPage()));

        return new ArrayList<>(list);
    }

    public CompanyVO searchDAO(CompanyVO vo) {
        String sql = "SELECT * FROM salary_man WHERE s_id=? AND s_name=?";
        String asql = "SELECT * FROM admin WHERE s_id=? AND s_name=?";
        
        List<CompanyVO> list = jdbcTemplate.query(sql, new Object[]{ vo.getS_id(), vo.getS_name() }, new BeanPropertyRowMapper<>(CompanyVO.class));
        if (list.isEmpty()) {
            list = jdbcTemplate.query(asql, new Object[]{ vo.getS_id(), vo.getS_name() }, new BeanPropertyRowMapper<>(CompanyVO.class));
        }
        
        return list.isEmpty() ? null : list.get(0);
    }

    public void insertOK(CompanyVO vo) {
        String sql = "INSERT INTO " + TABLE_NAME + "(s_id, s_name, s_birth, s_gender, s_department, s_rank, s_mail, s_phoneNumber) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, vo.getS_id(), vo.getS_name(), vo.getS_birth(), vo.getS_gender(), vo.getS_department(), vo.getS_rank(), vo.getS_mail(), vo.getS_phoneNumber());
    }

    public void updateOK(CompanyVO vo) {
        String sql = "UPDATE " + TABLE_NAME + " SET s_name=?, s_birth=?, s_department=?, s_rank=?, s_mail=?, s_phoneNumber=? WHERE s_id=?";
        jdbcTemplate.update(sql, vo.getS_name(), vo.getS_birth(), vo.getS_department(), vo.getS_rank(), vo.getS_mail(), vo.getS_phoneNumber(), vo.getS_id());
    }

    public boolean searchID(String id) {
        String sql = "SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE s_id=?";
        int count = jdbcTemplate.queryForObject(sql, new Object[]{ id }, Integer.class);
        return count > 0;
    }

    public Map<String, Integer> getMonthlyNewHires() {
        String sql = "SELECT DATE_FORMAT(Join_Date, '%Y-%m') AS month, COUNT(*) AS new_hires FROM " + TABLE_NAME + " WHERE Join_Date >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) GROUP BY DATE_FORMAT(Join_Date, '%Y-%m') ORDER BY month ASC";
        Map<String, Integer> newHires = new HashMap<>();
        jdbcTemplate.query(sql, rs -> {
            newHires.put(rs.getString("month"), rs.getInt("new_hires"));
        });
        return newHires;
    }

    public Map<String, Integer> getMonthlyResignations() {
        String sql = "SELECT DATE_FORMAT(s_date, '%Y-%m') AS month, COUNT(*) AS resignations FROM join_resign WHERE s_date >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) GROUP BY DATE_FORMAT(s_date, '%Y-%m') ORDER BY month ASC";
        Map<String, Integer> resignations = new HashMap<>();
        jdbcTemplate.query(sql, rs -> {
            resignations.put(rs.getString("month"), rs.getInt("resignations"));
        });
        return resignations;
    }
    
 // RowMapper for CompanyVO
    class CompanyRowMapper implements RowMapper<CompanyVO> {
		@Override
		public CompanyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            CompanyVO vo = new CompanyVO();
            vo.setId(rs.getInt("id"));
            vo.setName(rs.getString("name"));
            vo.setSalary(rs.getDouble("salary"));
            return vo;
		}
    }
    
}


