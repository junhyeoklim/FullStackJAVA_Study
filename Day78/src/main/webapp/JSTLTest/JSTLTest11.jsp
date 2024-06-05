<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL Test11</title>
</head>
<body>
	<% pageContext.setAttribute("tokens", "v1=20&v2=30&op=+"); %>
	<!-- 
		"v1=20&v2=30&op=+" 문자열을 "&"를 기준으로 분해하여 출력하시오.
		실행결과
		● v1=20
		● v2=30
		● op=+
	 -->

</body>
</html>