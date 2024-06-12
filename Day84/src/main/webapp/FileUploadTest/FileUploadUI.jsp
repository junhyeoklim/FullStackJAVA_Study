<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<form action="FileUploadOK.jsp" method="post" enctype="multipart/form-data">
	이름 : <input type="text" name="name"/><br>
	파일1 : <input type="file" name="file1"><br />
	파일2 : <input type="file" name="file2"><br />
		<input type="submit" value="File Upload">
	</form>
</body>
</html>