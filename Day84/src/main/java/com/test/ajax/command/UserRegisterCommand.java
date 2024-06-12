package com.test.ajax.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ajax.dao.UserDAO;
import com.test.ajax.dto.UserDTO;

public class UserRegisterCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse respons) throws ServletException, IOException {
		UserDAO userDAO = UserDAO.getUserDAO();
		UserDTO dto = new UserDTO();
		
		try {
			dto.setUserName(request.getParameter("userName"));
			dto.setUserAge(Integer.parseInt(request.getParameter("userAge")));
			dto.setUserGender(request.getParameter("userGender"));
			dto.setUserEmail(request.getParameter("userEmail"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("result", userDAO.register(dto));
	}

}
