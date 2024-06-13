package com.test.www.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.www.dao.DAO;
import com.test.www.dto.DTO;

public class SearchCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		
		if(userName == null) userName = "";
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		DAO dao = DAO.getDAO();
		ArrayList<DTO> list = dao.search(userName);
		for(int i=0; i<list.size();i++) {
			result.append("[\"value\":\""+list.get(i).getUserName()+"\"},");
			result.append("{\"value\":\"" + list.get(i).getUserAge() + "\"},");
			result.append("{\"value\":\"" + list.get(i).getUserGender() + "\"},");
			result.append("{\"value\":\"" + list.get(i).getUserEmail() + "\"}]");
			
			if(i != list.size()-1) result.append(",");
		}
			
		result.append("]}");
		System.out.println(result);
		request.setAttribute("result", result.toString());
	}
}
