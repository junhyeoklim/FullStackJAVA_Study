package com.springbook.view.salary;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.common.Constants;
import com.springbook.biz.salary.CompanyVO;
import com.springbook.biz.salary.impl.CompanyDAO;

@Controller
public class LoginController {

    @Autowired
    private CompanyDAO companyDAO;

    @RequestMapping(value = "/loginOK.do", method = RequestMethod.POST)
    public String handleRequest(HttpSession session, CompanyVO vo, Model model) {
        CompanyVO userVO = companyDAO.searchDAO(vo);
        if (userVO != null) {
            session.setAttribute("vo", userVO);
            return Constants.ALERT_VIEW + "/alert.jsp"; // 로그인 성공 시 이동할 뷰 이름
        } else {
            model.addAttribute("message", "Invalid username or password");
            return "LoginUI.jsp"; // 로그인 실패 시 다시 로그인 페이지로 이동
        }
    }
}
