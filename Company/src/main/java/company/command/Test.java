package company.command;

import company.dao.CompanyDAO;
import company.dto.CompanyDTO;

public class Test {

	public static void main(String[] args) {
		CompanyDAO dao = CompanyDAO.getCompanyDAO();
		CompanyDTO dto = new CompanyDTO();

		int cnt = 0;
		String department = "101";
		String id = department;

		

		while(true) {
			if(cnt == 5) {
				if(!dao.searchID(id)) {
					break;
				}
				else {
					cnt = 0;
					id = department;
				}
			}
			else {
				id += (int)(Math.random()*10);
				System.out.println(id);
				System.out.println(cnt);
				cnt++;
			}
		}


		
	}

}
