<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
String title = request.getParameter("title");
String content = request.getParameter("content");

String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC"; // 데이터베이스 이름을 test로 설정
String user = "root";
String password = "1234";

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
int postID = -1;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(url, user, password);
    String sql = "INSERT INTO board (title, content) VALUES (?, ?)";
    pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    pstmt.setString(1, title);
    pstmt.setString(2, content);
    pstmt.executeUpdate();

    rs = pstmt.getGeneratedKeys();
    if (rs.next()) {
        postID = rs.getInt(1);
    }

    // 이미지 파일 경로 가져오기
    String imagePath = application.getRealPath("/uploads");
    File imageDir = new File(imagePath);
    File[] files = imageDir.listFiles();
    if (files != null) {
        for (File file : files) {
            if (file.isFile() && file.getName().contains(postID + "사진.jpg")) {
                // 기존 파일을 새로운 이름으로 변경
                String newFileName = postID + "사진.jpg";
                File newFile = new File(imagePath + "/" + newFileName);
                file.renameTo(newFile);

                // 이미지 테이블에 경로 저장
                sql = "INSERT INTO images (post_id, file_path) VALUES (?, ?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, postID);
                pstmt.setString(2, request.getContextPath() + "/uploads/" + newFileName);
                pstmt.executeUpdate();
            }
        }
    }

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write("{\"postID\":" + postID + "}");
} catch (Exception e) {
    e.printStackTrace();
    response.getWriter().write("{\"error\":\"오류가 발생했습니다.\"}");
} finally {
    if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
    if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
    if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
}
%>
