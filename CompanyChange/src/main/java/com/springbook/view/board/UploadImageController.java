package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UploadImageController {

    @RequestMapping("/uploadImage.do")
    @ResponseBody
    public String handleImageUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws IOException {
        String category = request.getParameter("category") != null ? request.getParameter("category") : "normal";
        String fileName = file.getOriginalFilename();
        String fileType = "images";

        String uploadPath = request.getServletContext().getRealPath("") + File.separator + "upload" + File.separator + category + File.separator + fileType;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        String filePath = uploadPath + File.separator + fileName;
        file.transferTo(new File(filePath));

        String fileUrl = request.getContextPath() + "/upload/" + category + "/" + fileType + "/" + URLEncoder.encode(fileName, "UTF-8");
        return fileUrl;
    }
}
