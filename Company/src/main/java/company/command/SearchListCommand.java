package company.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.dao.CompanyDAO;
import company.dto.CompanyDTO;

public class SearchListCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			CompanyDAO dao = CompanyDAO.getCompanyDAO();
			ArrayList<CompanyDTO> list = null;
			String select = request.getParameter("select-box");
			String search = request.getParameter("search");
			
			if(select == null || search == null || search == "") 
				list = dao.listDAO();			
			else 
				list = dao.searchDAO(Integer.parseInt(select),search);
			
			request.setAttribute("list", list);
	}
	
}
