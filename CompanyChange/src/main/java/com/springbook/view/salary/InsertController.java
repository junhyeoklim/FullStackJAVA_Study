package com.springbook.view.salary;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.salary.CompanyVO;
import com.springbook.biz.salary.impl.CompanyDAO;
import com.springbook.view.controller.Controller;

public class InsertController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CompanyDAO dao = CompanyDAO.getCompanyDAO();
		CompanyVO VO = new CompanyVO();

		int cnt = 0;
		String id = null;
		String name = request.getParameter("name");
		String birth = request.getParameter("year").concat(request.getParameter("month"))
				.concat(request.getParameter("date"));
		String gender = request.getParameter("gender");
		String department = request.getParameter("department-box");
		String rank = request.getParameter("rank");
		String mail = request.getParameter("first").concat("@" + request.getParameter("second"));
		String phone = request.getParameter("phone");

		if (department.equals("경영"))
			id = "101";
		else if (department.equals("인사"))
			id = "102";
		else if (department.equals("개발"))
			id = "103";

		while (true) {
			if (cnt == 5) {
				if (!dao.searchID(id)) {
					break;
				} else {
					cnt = 0;

					if (department.equals("경영"))
						id = "101";
					else if (department.equals("인사"))
						id = "102";
					else if (department.equals("개발"))
						id = "103";
				}
			} else {
				id += (int) (Math.random() * 10);
				cnt++;
			}
		}
		VO.setS_id(Integer.parseInt(id));
		VO.setS_name(name);
		VO.setS_birth(Integer.parseInt(birth));
		VO.setS_gender(gender);
		VO.setS_department(department);
		VO.setS_rank(rank);
		VO.setS_mail(mail);
		VO.setS_phoneNumber(phone);
		dao.insertOK(VO);

		return "insertResult"; // 뷰 이름 반환
	}
}
