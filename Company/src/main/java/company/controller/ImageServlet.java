package company.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upload/*")
public class ImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ImageServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getPathInfo();
        
        if (filename == null || filename.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "File name is missing");
            return;
        }
        
        filename = filename.substring(1); // Extracts file name from URL
        String filePath = getServletContext().getRealPath("/upload/") + File.separator + filename;
        
        System.out.println("Attempting to read file: " + filePath); // 경로 로그 출력

        File file = new File(filePath);

        if (!file.exists() || !file.canRead()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found or cannot be read");
            return;
        }

        response.setContentType(getServletContext().getMimeType(file.getName()));
        response.setContentLength((int) file.length());

        try (FileInputStream fis = new FileInputStream(file);
             OutputStream os = response.getOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to read the file: " + e.getMessage());
        }
    }
}
