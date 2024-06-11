<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<form action="FileFormOK.jsp" method="post" enctype="multipart/form-data">
		이름 : <input type="text" name="name"><br />
		파일1 : <input type="file" name="file1"><br />
		<!--  파일2 : <input type="file" name="file2"><br /> -->
		<input type="submit" value="File Upload">
	</form>
</body>
</html>