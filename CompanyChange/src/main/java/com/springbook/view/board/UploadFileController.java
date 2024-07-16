package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.JsonObject;
import com.springbook.biz.board.FileVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.salary.CompanyVO;


@WebServlet("/UploadFileController")
@MultipartConfig
public class UploadFileController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CompanyVO VO = (CompanyVO) session.getAttribute("VO");
        int userId = VO.getS_id();
        String userType = VO.getS_name().equals("admin") ? "admin" : "salary_man";
        long b_id = Long.parseLong(request.getParameter("b_id"));
        boolean is_notice = Boolean.parseBoolean(request.getParameter("is_notice"));
        String boardType = is_notice ? "notice" : "board";

        List<FileVO> fileList = new ArrayList<>();
        for (Part part : request.getParts()) {
            if (part.getName().equals("fileAttachment")) {
                String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                String uploadDir = "/upload/" + boardType + "/files";
                String filePath = request.getServletContext().getRealPath(uploadDir) + File.separator + fileName;
                File uploadDirFile = new File(filePath);
                if (!uploadDirFile.exists()) {
                    uploadDirFile.mkdirs();
                }
                part.write(filePath);

                FileVO fileVO = new FileVO();
                fileVO.setB_id(b_id);
                fileVO.setS_id(userId);
                fileVO.setUser_type(userType);
                fileVO.setFile_name(fileName);
                fileVO.setFile_path(uploadDir + "/" + fileName);
                fileVO.setBoard_type(boardType);
                fileList.add(fileVO);
            }
        }

        BoardDAO board = BoardDAO.getBoardDAO();
        try {
            board.insertFiles(fileList);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("status", "success");
            response.getWriter().write(jsonResponse.toString());
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("status", "error");
            response.getWriter().write(jsonResponse.toString());
        }
    }
}

