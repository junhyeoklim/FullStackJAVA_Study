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

public class SearchListCommand implements Command {

    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        CompanyDAO dao = CompanyDAO.getCompanyDAO();
        PageDTO pageDTO = new PageDTO();
        ArrayList<CompanyDTO> list = null;

        String select = request.getParameter("select-box");
        String search = request.getParameter("search");
		String name = request.getParameter("name");
        
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
        
		if(name != null)
			list = dao.searchDAO(name);
		else if (select != null && search != null && !search.isEmpty()) {
            search = search.replaceAll("'", "''"); // 작은 따옴표를 이스케이프 처리
            list = dao.searchDAO(pageDTO, Integer.parseInt(select), search);
        } else {
            list = dao.listDAO(pageDTO);
        }

        HttpSession session = request.getSession();
        session.setAttribute("pagingInfo", pageDTO);
        session.setAttribute("list", list);
        session.setAttribute("selectBox", select);
        session.setAttribute("search", search);
    }
}
