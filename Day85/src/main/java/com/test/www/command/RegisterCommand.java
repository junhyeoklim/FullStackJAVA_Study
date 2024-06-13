package com.test.www.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.www.dao.DAO;
import com.test.www.dto.DTO;

public class RegisterCommand implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao = DAO.getDAO();
		DTO dto = new DTO();
		
		try {
			dto.setUserName(request.getParameter("userName"));
			dto.setUserAge(Integer.parseInt(request.getParameter("userAge")));
			dto.setUserGender(request.getParameter("userGender"));
			dto.setUserEmail(request.getParameter("userEmail"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("result", dao.register(dto));
	}

}
