package com.springbook.view.salary;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout.do")
	public String handleRequest(HttpSession session) {
		System.out.println("로그아웃 처리");
		
		session.invalidate();

		// 2. 세션 종료 후, 메인 화면으로 이동한다.
		return "LoginUI.jsp";
	}

}
