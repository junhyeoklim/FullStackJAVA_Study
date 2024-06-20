<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.UUID" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>

<%
String savePath = application.getRealPath("/uploads");
File saveDir = new File(savePath);
if (!saveDir.exists()) {
    saveDir.mkdirs(); // 디렉토리 생성
}
int sizeLimit = 10 * 1024 * 1024; // 최대 업로드 파일 크기 (10MB)

MultipartRequest multi = null;

try {
    multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
    String originalFileName = multi.getFilesystemName("file");
    String fileExt = originalFileName.substring(originalFileName.lastIndexOf("."));
    String uuidFileName = UUID.randomUUID().toString() + fileExt;
    
    File oldFile = new File(savePath + "/" + originalFileName);
    File newFile = new File(savePath + "/" + uuidFileName);
    oldFile.renameTo(newFile);

    String fileUrl = request.getContextPath() + "/uploads/" + uuidFileName;
    out.print(fileUrl); // 브라우저에서 접근 가능한 경로 반환
} catch (Exception e) {
    e.printStackTrace();
    out.print("파일 업로드 실패");
}
%>
