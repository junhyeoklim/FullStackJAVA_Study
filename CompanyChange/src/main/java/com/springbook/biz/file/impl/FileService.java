package com.springbook.biz.file.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.FileVO;

@Service
public class FileService {

    @Autowired
    private FileDAO fileDAO;

    // 파일 등록
    public void insertFiles(List<FileVO> fileList) {
        fileDAO.insertFiles(fileList);
    }
}
