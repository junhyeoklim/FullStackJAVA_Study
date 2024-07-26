package com.springbook.biz.salary.impl;

import java.util.List;
import java.util.Map;

import com.springbook.biz.common.PageVO;
import com.springbook.biz.salary.CompanyVO;

public interface CompanyService {
    List<CompanyVO> listDAO(PageVO pageVO);
    List<CompanyVO> listDAO();
    List<CompanyVO> searchDAO(PageVO pageVO, int select, String text);
    CompanyVO searchDAO(CompanyVO vo);
    void insertOK(CompanyVO vo);
    void updateOK(CompanyVO vo);
    boolean searchID(String id);
    Map<String, Integer> getMonthlyNewHires();
    Map<String, Integer> getMonthlyResignations();
}
