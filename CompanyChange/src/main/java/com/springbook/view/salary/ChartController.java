package com.springbook.view.salary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.springbook.biz.common.Constants;
import com.springbook.biz.common.DataProcessor;
import com.springbook.biz.salary.CompanyVO;
import com.springbook.biz.salary.impl.CompanyDAO;

@Controller
public class ChartController {

    @Autowired
    private CompanyDAO companyDAO;

    @RequestMapping(value = "/chart.do")
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<CompanyVO> list = companyDAO.listDAO();
        Map<String, Object> dataMap = DataProcessor.processData(list);
        Map<String, Integer> hires = companyDAO.getMonthlyNewHires();
        Map<String, Integer> resignations = companyDAO.getMonthlyResignations();

        // JSON 문자열로 변환하여 전달
        String hiresJson = new Gson().toJson(hires);
        String resignationsJson = new Gson().toJson(resignations);

        request.setAttribute("dataMap", dataMap);
        request.setAttribute("hires", hiresJson);
        request.setAttribute("resignations", resignationsJson);

        return Constants.ADMIN_VIEW+"/chartEX.jsp"; // 뷰 이름 반환
    }
}
