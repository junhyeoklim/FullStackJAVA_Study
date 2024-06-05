<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL Test7</title>
</head>
<body>
<%
	ArrayList<String> nameList3 = new ArrayList<String>();
	nameList3.add("홍길동");
	nameList3.add("임꺽정");
	nameList3.add("일지매");
	nameList3.add("주먹대장");
	nameList3.add("똘이장군");
	pageContext.setAttribute("nameList3", nameList3);
%>
<!-- 
		다음과 같이 실행결과가 나오게 하시오.
		실행결과
		● 홍길동
		● 임꺽정
		● 일지매
		● 주먹대장
		● 똘이장군
 -->

</body>
</html>