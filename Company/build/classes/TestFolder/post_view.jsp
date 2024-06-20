<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

<%
String postId = request.getParameter("postId");

String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC"; // 데이터베이스 이름을 test로 설정
String user = "root";
String password = "1234";

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String title = "";
String content = "";
String createdAt = "";
List<String> imageUrls = new ArrayList<>();

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(url, user, password);
    String sql = "SELECT title, content, created_at FROM board WHERE id = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, postId);
    rs = pstmt.executeQuery();

    if (rs.next()) {
        title = rs.getString("title");
        content = rs.getString("content");
        createdAt = rs.getString("created_at");
    }
    
    rs.close();
    pstmt.close();
    
    // 이미지 경로 가져오기
    sql = "SELECT file_path FROM images WHERE post_id = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, postId);
    rs = pstmt.executeQuery();
    
    while (rs.next()) {
        imageUrls.add(rs.getString("file_path"));
    }
} catch (Exception e) {
    e.printStackTrace();
} finally {
    if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
    if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
    if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
}

request.setAttribute("title", title);
request.setAttribute("content", content);
request.setAttribute("createdAt", createdAt);
request.setAttribute("imageUrls", imageUrls);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../source/css/defaultStyle.css?after">
    <link rel="stylesheet" href="../source/css/menubar.css?after">
</head>
<body>
<c:import url="../source/jsp/Menubar.jsp"/>

<div class="container">
    <h2 class="title">${title}</h2>
    <p>${content}</p>
    <small>작성일: ${createdAt}</small>
    <div>
        <c:forEach var="imageUrl" items="${imageUrls}">
            <img src="${imageUrl}" width="300" height="300">
        </c:forEach>
    </div>
</div>
</body>
</html>
