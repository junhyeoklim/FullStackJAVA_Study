package company.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import company.dao.CompanyDAO;
import company.dto.CompanyDTO;

public class ListCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompanyDAO dao = CompanyDAO.getCompanyDAO();
		ArrayList<CompanyDTO> list = dao.listDAO();
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		
	}

}