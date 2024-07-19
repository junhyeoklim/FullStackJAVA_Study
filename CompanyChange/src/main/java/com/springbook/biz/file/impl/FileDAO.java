package com.springbook.biz.file.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.springbook.biz.board.FileVO;
import com.springbook.biz.common.JDBCUtil;

public class FileDAO {
	private PreparedStatement pstmt;

	// 파일 등록
	public void insertFiles(List<FileVO> fileList) {
		String SQL = "INSERT INTO FILES (B_ID, S_ID, USER_TYPE, FILE_NAME, FILE_PATH, BOARD_TYPE) VALUES (?, ?, ?, ?, ?, ?)";

		try(Connection conn = JDBCUtil.getConnection();) {
			for (FileVO file : fileList) {
				pstmt = conn.prepareStatement(SQL);
				pstmt.setLong(1, file.getB_id());
				pstmt.setInt(2, file.getS_id());
				pstmt.setString(3, file.getUser_type());
				pstmt.setString(4, file.getFile_name());
				pstmt.setString(5, file.getFile_path());
				pstmt.setString(6, file.getBoard_type());
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}