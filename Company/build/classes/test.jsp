<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
						<select	name="month" id="birth">
							<option selected disabled>선택</option>
							<c:forEach var="i" begin="1" end="12" step="1">
								<c:set var="formattedMonth" value="<fmt:formatNumber value='${i}' pattern='00'/>" />
								<option value="${formattedMonth}" <c:if test="${fn:substring(dto.s_birth, 4, 6) == formattedMonth}">selected</c:if>>
									<c:out value="${formattedMonth}"/>
								</option>
							</c:forEach>
						</select> 

</body>
</html>