package com.springbook.view.board;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonObject;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.common.Constants;
import com.springbook.biz.salary.CompanyVO;

@Controller
public class InsertBoardController {

	@RequestMapping("/newBoard.do")
	public String insertBoard() {
		return Constants.USER_VIEW+"/BoardCreateView.jsp";
	}
	
	
	
    @RequestMapping("/insertBoard.do")
    public String insertBoard(BoardVO vo, HttpSession session, HttpServletResponse response,BoardDAO boardDAO) throws IOException {
        
        CompanyVO user = (CompanyVO) session.getAttribute("vo");
        String userName = user.getS_name();
        int userId = user.getS_id();
        String userDepartment = user.getS_department();
        
        // BoardVO의 필드에 자동으로 바인딩된 값들
        String title = vo.getTitle();
        String content = vo.getContent();
        boolean isNotice = vo.isNotice();

        long b_id = 0;

        try {
            if ("admin".equals(userName)) {
                b_id = boardDAO.insertPost(title, content, userName, userId, isNotice);
            } else {
                b_id = boardDAO.insertPost(title, content, userName, userId, userDepartment);
                System.out.println("Inserted post ID: " + b_id);
            }

            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("b_id", b_id);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonResponse.toString());
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("status", "error");
            jsonResponse.addProperty("message", "게시물 등록에 실패했습니다.");
            response.getWriter().write(jsonResponse.toString());
            return null;
        }
    }
}
