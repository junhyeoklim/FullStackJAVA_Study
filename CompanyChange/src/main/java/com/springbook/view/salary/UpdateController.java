package com.springbook.view.salary;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.salary.CompanyVO;
import com.springbook.biz.salary.impl.CompanyDAO;
import com.springbook.view.controller.Controller;

public class UpdateController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CompanyDAO dao = CompanyDAO.getCompanyDAO();
        CompanyVO VO = new CompanyVO();
        
        String name = request.getParameter("name");
        String month = request.getParameter("month");
        String id = request.getParameter("id");
        if(Integer.parseInt(month) > 0 && Integer.parseInt(month) < 10)
            month = '0' + month;
        String birth = request.getParameter("year").concat(month).concat(request.getParameter("date"));
        String department = request.getParameter("department-box");
        String rank = request.getParameter("rank");
        String mail = request.getParameter("email");
        String phone = request.getParameter("phone");
        
        VO.setS_id(Integer.parseInt(id));
        VO.setS_name(name);
        VO.setS_birth(Integer.parseInt(birth));
        VO.setS_department(department);
        VO.setS_rank(rank);
        VO.setS_mail(mail);
        VO.setS_phoneNumber(phone);
        dao.updateOK(VO);

        return "updateResult"; // 뷰 이름 반환
    }
}
