<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<c:set var="varName" value="varValue" />
	${varName }
	<br>
	<c:remove var="varName" />
	${varName }
	<br>

<c:catch var="error">
<%= 10/0 %>
</c:catch>
<c:out value="${error.message }" /><br>
	
	
	<c:choose>
		<c:when test="${(1+2) == 3 }">
			${"1+2=3"}<br>		
		</c:when>
		<c:otherwise>
			${"1+2 != 3" }
		</c:otherwise>
	</c:choose>
	
	
	<c:forEach var="i" begin="0" end="30" step="3">
		${i}<br>
	</c:forEach>
</body>
</html>