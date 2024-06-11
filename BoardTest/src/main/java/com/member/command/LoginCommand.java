package com.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.boardtest.dao.MemberDAO;
import com.set.dto.AddressDTO;
import com.set.dto.UserDTO;

public class LoginCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDAO dao = MemberDAO.getMemberDAO();
		UserDTO udto = new UserDTO();
		AddressDTO adto = new AddressDTO();
		HttpSession session = request.getSession();
		
		udto.setId(id);
		udto.setPassword(pwd);
		dao.searchUserDAO(udto);
		session.setAttribute("udto", udto);
		
		dao.searchAddressDAO(udto, adto);		
		session.setAttribute("adto", adto);
	}

}
