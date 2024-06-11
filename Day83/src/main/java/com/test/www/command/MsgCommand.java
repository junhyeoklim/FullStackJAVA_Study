package com.test.www.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.www.dao.DAO;
import com.test.www.dto.MovieScriptDto;

public class MsgCommand implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = DAO.getBoardDAO();
		ArrayList<MovieScriptDto> list = dao.getMovieScript();
		StringBuilder sb = new StringBuilder("[");
		int size = list.size();
		
		for(int i=0; i<size; i++) {
			MovieScriptDto dto = list.get(i);
			sb.append("{\"id\" : \"" + dto.getId() + "\", " + "\"msg\" : \"" + dto.getMsg() + "\"}");
			
			if(i != size-1)
				sb.append(",");
		}
		sb.append("]");
		System.out.println("msg "+sb.toString());
		request.setAttribute("result", sb.toString());
		
	}

}
