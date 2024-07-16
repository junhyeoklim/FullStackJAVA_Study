package com.springbook.view.salary;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.salary.CompanyVO;
import com.springbook.biz.salary.impl.CompanyDAO;
import com.springbook.view.controller.Controller;

public class LoginController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CompanyDAO dao = CompanyDAO.getCompanyDAO();
        CompanyVO VO = new CompanyVO();
        HttpSession session = request.getSession();

        String pwd = request.getParameter("id");
        String id = request.getParameter("name");

        VO.setS_id(Integer.parseInt(pwd));
        VO.setS_name(id);
        dao.searchDAO(VO);

        session.setAttribute("vo", VO);

        return "AlertView/alert"; // 로그인 성공 시 이동할 뷰 이름
    }
}
