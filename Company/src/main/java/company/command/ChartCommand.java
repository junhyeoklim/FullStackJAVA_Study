package company.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.util.DataProcessor;
import company.dao.CompanyDAO;
import company.dto.CompanyDTO;

public class ChartCommand implements Command {

    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CompanyDAO dao = CompanyDAO.getCompanyDAO();
        ArrayList<CompanyDTO> list = dao.listDAO();
        Map<String, Object> dataMap = DataProcessor.processData(list);
        Map<String,Integer> hires = dao.getMonthlyNewHires();
        Map<String,Integer> resignations = dao.getMonthlyResignations();

        // JSON 문자열로 변환하여 전달
        String hiresJson = new Gson().toJson(hires);
        String resignationsJson = new Gson().toJson(resignations);

        request.setAttribute("dataMap", dataMap);
        request.setAttribute("hires", hiresJson);
        request.setAttribute("resignations", resignationsJson);
    }
}
