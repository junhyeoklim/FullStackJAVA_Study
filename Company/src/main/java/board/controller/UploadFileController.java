package board.controller;

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

import board.dao.BoardDAO;
import board.dto.FileDTO;
import company.dto.CompanyDTO;

@WebServlet("/UploadFileController")
@MultipartConfig
public class UploadFileController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CompanyDTO dto = (CompanyDTO) session.getAttribute("dto");
        int userId = dto.getS_id();
        String userType = dto.getS_name().equals("admin") ? "admin" : "salary_man";
        long b_id = Long.parseLong(request.getParameter("b_id"));
        boolean is_notice = Boolean.parseBoolean(request.getParameter("is_notice"));
        String boardType = is_notice ? "notice" : "board";

        List<FileDTO> fileList = new ArrayList<>();
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

                FileDTO fileDTO = new FileDTO();
                fileDTO.setB_id(b_id);
                fileDTO.setS_id(userId);
                fileDTO.setUser_type(userType);
                fileDTO.setFile_name(fileName);
                fileDTO.setFile_path(uploadDir + "/" + fileName);
                fileDTO.setBoard_type(boardType);
                fileList.add(fileDTO);
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

