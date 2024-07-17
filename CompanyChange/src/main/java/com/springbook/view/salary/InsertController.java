package com.springbook.view.salary;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbook.biz.common.Constants;
import com.springbook.biz.salary.CompanyVO;
import com.springbook.biz.salary.impl.CompanyDAO;

@Controller
public class InsertController {

	
	@RequestMapping("/register.do")
	public String insertSalaryUI() {
		return Constants.ADMIN_VIEW+"/registerUI.jsp";
	}
	
	
	
    @Autowired
    private CompanyDAO companyDAO;

    @RequestMapping(value = "/registerOK.do")
    public String insertSalary(@RequestParam("name") String name,
                               @RequestParam("year") String year,
                               @RequestParam("month") String month,
                               @RequestParam("date") String date,
                               @RequestParam("gender") String gender,
                               @RequestParam("department-box") String department,
                               @RequestParam("rank") String rank,
                               @RequestParam("first") String first,
                               @RequestParam("second") String second,
                               @RequestParam("phone") String phone) throws IOException {
        
        CompanyVO VO = new CompanyVO();
        String id = null;
        int cnt = 0;
        String birth = year.concat(month).concat(date);
        String mail = first.concat("@" + second);

        if (department.equals("경영"))
            id = "101";
        else if (department.equals("인사"))
            id = "102";
        else if (department.equals("개발"))
            id = "103";

        while (true) {
            if (cnt == 5) {
                if (!companyDAO.searchID(id)) {
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
        companyDAO.insertOK(VO);

        return Constants.ADMIN_VIEW + "/companyList.jsp"; // 뷰 이름 반환
    }
}
