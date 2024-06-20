package company.command;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.dto.PageDTO;
import company.dao.CompanyDAO;
import company.dto.CompanyDTO;

public class CompanyListCommand implements Command {

    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CompanyDAO dao = CompanyDAO.getCompanyDAO();
        PageDTO pageDTO = new PageDTO();
        
        try {
            if (request.getParameter("page") != null) {
                String pageStr = request.getParameter("page").replaceAll("[^\\d]", "");
                pageDTO.setCurrentPage(Integer.parseInt(pageStr));
            } else {
                pageDTO.setCurrentPage(1);
            }
        } catch (NumberFormatException e) {
            pageDTO.setCurrentPage(1);
        }
        
        pageDTO.setRecordsPerPage(10);
        ArrayList<CompanyDTO> list = dao.listDAO(pageDTO);
        
        HttpSession session = request.getSession();
        session.setAttribute("pagingInfo", pageDTO);
        session.setAttribute("list", list);
    }
}
