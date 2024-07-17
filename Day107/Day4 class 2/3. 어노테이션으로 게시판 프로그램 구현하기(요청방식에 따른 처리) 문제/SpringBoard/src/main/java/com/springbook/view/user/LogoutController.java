package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController{

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		
		session.invalidate();
		return "login.jsp";
	}
}

/*
	"/logout.do" 요청으로 실행되는 logout() 메소드는 로그아웃 처리를 위해 세션 객체가 필요하다.
	이때 HttpSession을 매개변수로 선언하면 스프링 컨테이너가 로그아웃을 요청한 브라우저와 매핑된
	세션 객체를 찾아서 넘겨준다. 따라서 매개변수로 받은 세션 객체를 강제 종료하면 된다.
*/