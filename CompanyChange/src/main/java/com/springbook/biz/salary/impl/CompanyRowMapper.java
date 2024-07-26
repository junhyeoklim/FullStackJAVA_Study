package com.springbook.biz.salary.impl;

import com.springbook.biz.salary.CompanyVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyRowMapper implements RowMapper<CompanyVO> {
    @Override
    public CompanyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        CompanyVO vo = new CompanyVO();
        vo.setId(rs.getInt("id"));
        vo.setName(rs.getString("name"));
        vo.setSalary(rs.getDouble("salary"));
        // 추가적인 필드 매핑
        return vo;
    }
}
