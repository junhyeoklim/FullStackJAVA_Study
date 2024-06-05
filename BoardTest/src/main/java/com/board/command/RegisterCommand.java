package com.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.board.dao.BoardDAO;
import com.set.dto.AddressDTO;
import com.set.dto.UserDTO;

public class RegisterCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getBoardDAO();
		UserDTO udto = new UserDTO();
		AddressDTO adto = new AddressDTO();
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String upostcode = request.getParameter("postcode");
		String birth = request.getParameter("year").concat(request.getParameter("month").concat(request.getParameter("date")));
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		
		String apostcode = upostcode;
		String roadAddress = request.getParameter("roadAddress");
		String jibunAddress = request.getParameter("jibunAddress");
		String detailAddress = request.getParameter("detailAddress");
		String extraAddress = request.getParameter("extraAddress");
		
		udto.setName(name);
		udto.setId(id);
		udto.setNickName(nickname);
		udto.setPassword(pwd);
		udto.setEmail(email);
		udto.setPostcode(Integer.parseInt(upostcode));
		udto.setBirth(birth);
		udto.setPhone(Integer.parseInt(phone));
		udto.setSex(sex);
		
		adto.setPostcode(Integer.parseInt(apostcode));
		adto.setRoadAddress(roadAddress);
		adto.setJibunAddress(jibunAddress);
		adto.setDetailAddress(detailAddress);
		adto.setExtraAddress(extraAddress);
		
		dao.insertDAO(udto, adto);
		
	}

}
