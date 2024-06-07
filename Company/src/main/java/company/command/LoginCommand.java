package company.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import company.dao.CompanyDAO;
import company.dto.CompanyDTO;

public class LoginCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompanyDAO dao = CompanyDAO.getCompanyDAO();
		CompanyDTO dto = new CompanyDTO();
		HttpSession session = request.getSession();
		
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		dto.setS_id(Integer.parseInt(id));
		dto.setS_name(name);
		dao.searchDAO(dto);
		
		session.setAttribute("dto", dto);
		
	}

}
