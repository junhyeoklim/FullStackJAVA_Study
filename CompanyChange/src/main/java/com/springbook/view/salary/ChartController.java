package com.springbook.view.salary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.springbook.biz.common.DataProcessor;
import com.springbook.biz.salary.CompanyVO;
import com.springbook.biz.salary.impl.CompanyDAO;
import com.springbook.view.controller.Controller;

public class ChartController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CompanyDAO dao = CompanyDAO.getCompanyDAO();
        ArrayList<CompanyVO> list = dao.listDAO();
        Map<String, Object> dataMap = DataProcessor.processData(list);
        Map<String,Integer> hires = dao.getMonthlyNewHires();
        Map<String,Integer> resignations = dao.getMonthlyResignations();

        // JSON 문자열로 변환하여 전달
        String hiresJson = new Gson().toJson(hires);
        String resignationsJson = new Gson().toJson(resignations);

        request.setAttribute("dataMap", dataMap);
        request.setAttribute("hires", hiresJson);
        request.setAttribute("resignations", resignationsJson);

        return "Admin_View/chartEX"; // 뷰 이름 반환
    }
}
