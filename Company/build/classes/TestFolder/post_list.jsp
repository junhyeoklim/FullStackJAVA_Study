<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%
String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC"; // 데이터베이스 이름을 test로 설정
String user = "root";
String password = "1234";

int pagec = 1;
int recordsPerPage = 5;
if (request.getParameter("pagec") != null) {
    pagec = Integer.parseInt(request.getParameter("pagec"));
}

List<Map<String, String>> posts = new ArrayList<>();
int noOfRecords = 0;
int noOfPages = 0;

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(url, user, password);
    
    String sql = "SELECT SQL_CALC_FOUND_ROWS id, title, content, created_at FROM board LIMIT ?, ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setInt(1, (pagec-1)*recordsPerPage);
    pstmt.setInt(2, recordsPerPage);
    rs = pstmt.executeQuery();

    while (rs.next()) {
        Map<String, String> post = new HashMap<>();
        post.put("id", rs.getString("id"));
        post.put("title", rs.getString("title"));
        post.put("content", rs.getString("content"));
        post.put("created_at", rs.getString("created_at"));
        posts.add(post);
    }

    rs.close();
    rs = pstmt.executeQuery("SELECT FOUND_ROWS()");
    if (rs.next()) {
        noOfRecords = rs.getInt(1);
    }
    noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
} catch (Exception e) {
    e.printStackTrace();
} finally {
    if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
    if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
    if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
}
request.setAttribute("posts", posts);
request.setAttribute("noOfPages", noOfPages);
request.setAttribute("currentPage", pagec);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 목록</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../source/css/defaultStyle.css?after">
    <link rel="stylesheet" href="../source/css/menubar.css?after">
</head>
<body>
<c:import url="../source/jsp/Menubar.jsp"/>

<div class="container">
    <h2 class="title">게시글 목록</h2>
    <c:forEach var="post" items="${posts}">
        <div class="post">
            <h3><a href="post_view.jsp?postId=${post.id}">${post.title}</a></h3>
            <p>${post.content}</p>
            <small>작성일: ${post.created_at}</small>
        </div>
        <hr>
    </c:forEach>
    
    <!-- 페이징 기능 -->
    <nav class="pagination-wrapper">
        <ul class="pagination justify-content-center">
            <c:if test="${currentPage > 1}">
                <li class="page-item"><a class="page-link" href="post_list.jsp?pagec=1" title="최신글 보기"><<</a></li>
                <li class="page-item"><a class="page-link" href="post_list.jsp?pagec=${currentPage-1}"><</a></li>
            </c:if>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <li class="page-item ${currentPage == i ? 'active' : ''}"><a class="page-link" href="post_list.jsp?pagec=${i}">${i}</a></li>
            </c:forEach>
            <c:if test="${currentPage < noOfPages}">
                <li class="page-item"><a class="page-link" href="post_list.jsp?pagec=${currentPage+1}">></a></li>
                <li class="page-item"><a class="page-link" href="post_list.jsp?pagec=${noOfPages}" title="첫 글 보기">>></a></li>
            </c:if>
        </ul>
    </nav>
</div>
</body>
</html>
