package com.springbook.view.salary;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.common.PageVO;
import com.springbook.biz.salary.CompanyVO;
import com.springbook.biz.salary.impl.CompanyDAO;
import com.springbook.view.controller.Controller;

public class SearchListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        CompanyDAO dao = CompanyDAO.getCompanyDAO();
        PageVO pageVO = new PageVO();
        ArrayList<CompanyVO> list = null;

        String select = request.getParameter("select-box");
        String search = request.getParameter("search");
        String s_id = request.getParameter("s_id");
        
        try {
            if (request.getParameter("page") != null) {
                String pageStr = request.getParameter("page").replaceAll("[^\\d]", "");
                pageVO.setCurrentPage(Integer.parseInt(pageStr));
            } else {
                pageVO.setCurrentPage(1);
            }
        } catch (NumberFormatException e) {
            pageVO.setCurrentPage(1);
        }

        pageVO.setRecordsPerPage(10);
        
        if(s_id != null)
            list = dao.searchDAO(s_id);
        else if (select != null && search != null && !search.isEmpty()) {
            search = search.replaceAll("'", "''"); // 작은 따옴표를 이스케이프 처리
            list = dao.searchDAO(pageVO, Integer.parseInt(select), search);
        } else {
            list = dao.listDAO(pageVO);
        }

        request.setAttribute("pagingInfo", pageVO);
        request.setAttribute("list", list);
        request.setAttribute("selectBox", select);
        request.setAttribute("search", search);

        return "searchList"; // 뷰 이름 반환
    }
}
