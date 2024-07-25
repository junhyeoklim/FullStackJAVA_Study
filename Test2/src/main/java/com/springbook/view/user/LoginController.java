package com.springbook.view.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserService;

@Controller
public class LoginController{
	
	@Autowired
	private UserService userService;	
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}

	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, HttpSession session) {
		System.out.println("로그인 처리");
		if(vo.getId() == null|| vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}		
		
		UserVO user = userService.getUser(vo);
		if(user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}
		else return "login.jsp";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		
		session.invalidate();
		return "login.jsp";
	}
	
	// id 중복 체크
	@RequestMapping("/idCheck.do")
	public void idCheck(UserVO vo, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(vo);
		response.setCharacterEncoding("UTF-8"); 
		PrintWriter out = response.getWriter();
		UserVO tmp = userService.idCheck(vo);
		System.out.println(tmp);
		if(tmp==null) out.write("1");
		else out.write("0");
	}
	
	// 회원수
	@RequestMapping("/memberCount.do")
	public String memberCount(UserVO vo) {
		
		userService.memberCount(vo);
		return "index.jsp";
	}	
}