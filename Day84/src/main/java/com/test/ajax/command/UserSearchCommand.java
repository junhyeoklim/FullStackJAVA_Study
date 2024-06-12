package com.test.ajax.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ajax.dao.UserDAO;
import com.test.ajax.dto.UserDTO;

public class UserSearchCommand implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse respons) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		if(userName == null) userName = "";
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		UserDAO userDAO = UserDAO.getUserDAO();
		ArrayList<UserDTO> userList = userDAO.search(userName);
		for(int i=0; i<userList.size(); i++) {
			result.append("[{\"value\":\"" + userList.get(i).getUserName() + "\"},");
			result.append("{\"value\":\"" + userList.get(i).getUserAge() + "\"},");
			result.append("{\"value\":\"" + userList.get(i).getUserGender() + "\"},");
			result.append("{\"value\":\"" + userList.get(i).getUserEmail() + "\"}]");
			
			if(i != userList.size()-1) result.append(",");
		}
		result.append("]}");
		System.out.println(result);
		request.setAttribute("result", result.toString());
	}

}
