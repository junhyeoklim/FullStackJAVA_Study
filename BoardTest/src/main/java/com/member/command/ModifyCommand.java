package com.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boardtest.dao.MemberDAO;
import com.set.dto.AddressDTO;
import com.set.dto.UserDTO;

public class ModifyCommand implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getMemberDAO();
		UserDTO udto = new UserDTO();
		AddressDTO adto = new AddressDTO();
		
		String id = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String upostcode = request.getParameter("postcode");
		String birth = request.getParameter("year").concat(request.getParameter("month").concat(request.getParameter("date")));
		String phone = request.getParameter("phone");
		
		String aid = id;
		String apostcode = upostcode;
		String roadAddress = request.getParameter("roadAddress");
		String jibunAddress = request.getParameter("jibunAddress");
		String detailAddress = request.getParameter("detailAddress");
		String extraAddress = request.getParameter("extraAddress");
		
		udto.setId(id);
		udto.setNickName(nickname);
		udto.setPassword(pwd);
		udto.setEmail(email);
		udto.setPostcode(Integer.parseInt(upostcode));
		udto.setBirth(birth);
		udto.setPhone(Integer.parseInt(phone));
		
		adto.setId(aid);
		adto.setPostcode(Integer.parseInt(apostcode));
		adto.setRoadAddress(roadAddress);
		adto.setJibunAddress(jibunAddress);
		adto.setDetailAddress(detailAddress);
		adto.setExtraAddress(extraAddress);
		
		dao.updateDAO(udto, adto);
	}

}
