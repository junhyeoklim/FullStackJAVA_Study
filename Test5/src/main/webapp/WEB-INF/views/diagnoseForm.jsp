<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>환자 진단</title>
</head>
<body>
    <h1>환자 진단</h1>
    <form action="diagnose" method="post" enctype="multipart/form-data">
        환자 상태: <input type="text" name="patientStatus" required><br>
        CT/X-ray 이미지: <input type="file" name="imageFile" required><br>
        <button type="submit">진단하기</button>
    </form>
</body>
</html>
