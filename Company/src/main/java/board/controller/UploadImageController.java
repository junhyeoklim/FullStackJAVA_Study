package board.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadImageController")
@MultipartConfig
public class UploadImageController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file");
        String fileName = getFileName(filePart);
        String category = request.getParameter("category") != null ? request.getParameter("category") : "normal";
        String fileType = "images";

        String uploadPath = getServletContext().getRealPath("") + File.separator + "upload" + File.separator + category + File.separator + fileType;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);

        String fileUrl = request.getContextPath() + "/upload/" + category + "/" + fileType + "/" + URLEncoder.encode(fileName, "UTF-8");
        response.getWriter().write(fileUrl);
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null;
    }
}
