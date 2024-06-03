package company.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.dao.CompanyDAO;
import company.dto.CompanyDTO;

public class UpdateCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompanyDAO dao = CompanyDAO.getCompanyDAO();
		CompanyDTO dto = new CompanyDTO();
		
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String rank = request.getParameter("rank");
		String mail = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		dto.setS_name(name);
		dto.setS_department(department);
		dto.setS_rank(rank);
		dto.setS_mail(mail);
		dto.setS_phoneNumber(phone);
		dao.updateOK(dto);	
	}

}
