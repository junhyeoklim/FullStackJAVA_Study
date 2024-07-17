package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.springbook.biz.board.FileVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.salary.CompanyVO;

@Controller
public class UploadFileController {

    @RequestMapping("/uploadFiles.do")
    @ResponseBody
    public String handleFileUpload(
            HttpServletRequest request,
            HttpSession session,
            @RequestParam("fileAttachment") List<MultipartFile> files,
            BoardDAO boardDAO) throws IOException {

        CompanyVO VO = (CompanyVO) session.getAttribute("vo");
        int userId = VO.getS_id();
        String userType = VO.getS_name().equals("admin") ? "admin" : "salary_man";
        long b_id = Long.parseLong(request.getParameter("b_id"));
        boolean is_notice = Boolean.parseBoolean(request.getParameter("is_notice"));
        String boardType = is_notice ? "notice" : "board";

        List<FileVO> fileList = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                String fileName = Paths.get(file.getOriginalFilename()).getFileName().toString();
                String uploadDir = session.getServletContext().getRealPath("/upload/" + boardType + "/files");
                File uploadDirFile = new File(uploadDir);
                if (!uploadDirFile.exists()) {
                    uploadDirFile.mkdirs();
                }
                String filePath = uploadDir + File.separator + fileName;
                file.transferTo(new File(filePath));

                FileVO fileVO = new FileVO();
                fileVO.setB_id(b_id);
                fileVO.setS_id(userId);
                fileVO.setUser_type(userType);
                fileVO.setFile_name(fileName);
                fileVO.setFile_path("/upload/" + boardType + "/files/" + fileName);
                fileVO.setBoard_type(boardType);
                fileList.add(fileVO);
            }
        }

        try {
            boardDAO.insertFiles(fileList);
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("status", "success");
            return jsonResponse.toString();
        } catch (Exception e) {
            e.printStackTrace();
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("status", "error");
            return jsonResponse.toString();
        }
    }
}
