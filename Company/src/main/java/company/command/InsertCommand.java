package company.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.dao.CompanyDAO;
import company.dto.CompanyDTO;



public class InsertCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompanyDAO dao = CompanyDAO.getCompanyDAO();
		CompanyDTO dto = new CompanyDTO();

		int cnt = 0;
		String id = null;
		String name = request.getParameter("name");
		String department = request.getParameter("dpartment-box");
		String rank = request.getParameter("rank");
		String mail = request.getParameter("first").concat("@"+request.getParameter("second"));
		String phone = request.getParameter("phone");

		
		if(department.equals("경영"))
			id = "101";
		else if(department.equals("인사"))
			id = "102";
		else if(department.equals("개발"))
			id = "103";		

		while(true) {
			if(cnt == 5) {
				if(!dao.searchID(id)) {
					break;
				}
				else {
					cnt = 0;
					
					if(department.equals("경영"))
						id = "101";
					else if(department.equals("인사"))
						id = "102";
					else if(department.equals("개발"))
						id = "103";
				}
			}
			else {
				id += (int)(Math.random()*10);
				cnt++;
			}
		}
		 dto.setS_id(Integer.parseInt(id)); dto.setS_name(name);
		 dto.setS_department(department); dto.setS_rank(rank); dto.setS_mail(mail);
		 dto.setS_phoneNumber(phone); dao.insertOK(dto);
	}
}
