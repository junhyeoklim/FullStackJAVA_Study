<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL Test3</title>
</head>
<body>
<!-- 기본태그(core)로 num1 변수 선언하고 10에 값을 준다. -->
<c:set var="num1" value="10"/>
<!-- 기본태그(core)로 num2 변수 선언하고 20에 값을 준다. -->
<c:set var="num2" value="20"/>

<!-- 기본태그(core)로 num1이 num2보다 크면 num1이 크다고 출력한다. 그리고 그 조건이 true인지 false인지 출력한다. -->
<c:if test="${num1 > num2 }" var="result1">
${num1 }이 ${num2 }보다 크다.<br>
</c:if>
결과1: ${result1}<br>
<!-- 기본태그(core)로 num2가 num1보다 크면 num2가 크다고 출력한다. 그리고 그 조건이 true인지 false인지 출력한다. -->
<c:if test="${num1 < num2 }" var="result1">
${num2 }가 ${num1 }보다 크다.<br>
</c:if>
결과1: ${result1}<br>
</body>
</html>