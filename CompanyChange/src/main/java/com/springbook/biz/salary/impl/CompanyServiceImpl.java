package com.springbook.biz.salary.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.common.PageVO;
import com.springbook.biz.salary.CompanyVO;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDAOSpring companyDAO;

    @Override
    public List<CompanyVO> listDAO(PageVO pageVO) {
        return companyDAO.listDAO(pageVO);
    }

    @Override
    public List<CompanyVO> listDAO() {
        return companyDAO.listDAO();
    }

    @Override
    public List<CompanyVO> searchDAO(PageVO pageVO, int select, String text) {
        return companyDAO.searchDAO(pageVO, select, text);
    }

    @Override
    public CompanyVO searchDAO(CompanyVO vo) {
        return companyDAO.searchDAO(vo);
    }

    @Override
    public void insertOK(CompanyVO vo) {
        companyDAO.insertOK(vo);
    }

    @Override
    public void updateOK(CompanyVO vo) {
        companyDAO.updateOK(vo);
    }

    @Override
    public boolean searchID(String id) {
        return companyDAO.searchID(id);
    }

    @Override
    public Map<String, Integer> getMonthlyNewHires() {
        return companyDAO.getMonthlyNewHires();
    }

    @Override
    public Map<String, Integer> getMonthlyResignations() {
        return companyDAO.getMonthlyResignations();
    }
}
