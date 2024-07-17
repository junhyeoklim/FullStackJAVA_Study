package com.springbook.view.salary;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbook.biz.common.Constants;
import com.springbook.biz.common.PageVO;
import com.springbook.biz.salary.CompanyVO;
import com.springbook.biz.salary.impl.CompanyDAO;

@Controller
public class CompanyListController {

    @Autowired
    private CompanyDAO companyDAO;

    @RequestMapping("/companyList.do")
    public String companyList(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(value = "select-box", required = false) String select,
                              @RequestParam(value = "search", required = false) String search,
                              @RequestParam(value = "s_id", required = false) String s_id,
                              @RequestParam(value = "page", required = false, defaultValue = "1") int page) throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        PageVO pageVO = new PageVO();
        pageVO.setCurrentPage(page);
        pageVO.setRecordsPerPage(10);

        ArrayList<CompanyVO> list;

        if (s_id != null) {
            list = companyDAO.searchDAO(s_id);
        } else if (select != null && search != null && !search.isEmpty()) {
            search = search.replaceAll("'", "''"); // 작은 따옴표를 이스케이프 처리
            list = companyDAO.searchDAO(pageVO, Integer.parseInt(select), search);
        } else {
            list = companyDAO.listDAO(pageVO);
        }

        // request 객체에 데이터 저장
        request.setAttribute("pagingInfo", pageVO);
        request.setAttribute("list", list);
        request.setAttribute("selectBox", select);
        request.setAttribute("search", search);

        return Constants.ADMIN_VIEW + "/companyList.jsp"; // 뷰 이름 반환
    }
}
