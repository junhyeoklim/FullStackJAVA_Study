<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<hr>
이름 : ${param.name }<br>
성별 : ${param.gender }<br>
취미 : ${paramValues["hobby"][0] }
${paramValues["hobby"][1] }
${paramValues["hobby"][2] }
${paramValues["hobby"][3] }<br>

<hr>

</body>
</html>