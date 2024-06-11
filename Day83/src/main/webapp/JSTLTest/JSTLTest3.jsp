<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<fmt:requestEncoding value="utf-8"/>
<fmt:setLocale value="ko_KR"/>
<fmt:setTimeZone  value="Asia/Seoul"/>
<c:set var="str" value="''<b>Hello World 2 </b>''"/>
<c:set var="str2" value=""/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
		<c:set var="date" value="<%= new java.util.Date() %>"/>
	<fmt:formatDate value="${ date }" pattern="yyyy-MM-dd hh:mm a z"/><br/>
	<fmt:timeZone value="US/Eastern">
		<fmt:formatDate value="${ date }" pattern="yyyy-MM-dd hh:mm a z"/><br/> 
	</fmt:timeZone>
	<hr>
	<c:out value="${str }"/>
	<hr>
	<c:set var="str1" value="Functions <태그>를 사용합니다."/>
	<c:set var="str2" value="사용"/>
	<c:set var="tokens" value="1,2,3,4,5,6,7,8,9,10"/>
	
	<c:out value="${fn:length(str1) }"/><br>
	<c:out value="${fn:toUpperCase(str1) }"/><br>
	<c:out value="${fn:toLowerCase(str1) }"/><br>
	<c:out value="${fn:substring(str1,3,5) }"/><br>	
	<c:out value="${fn:substringAfter(str1,str2) }"/><br>
	<c:out value="${fn:substringBefore(str1,str2) }"/><br>
	<c:out value="${fn:trim(str1) }"/><br>
	<c:out value="${fn:startsWith(str1,Fun) }"/><br>
	<c:out value="${fn:endsWith(str1,'합니다.') }"/><br>
	<c:out value="${fn:contains(str1,str2) }"/><br>
	<c:out value="${fn:containsIgnoreCase(str1,str2) }"/><br>
	<c:out value='${fn:replace(str1," ", "-")}'/><br>
	<c:set var="array" value='${fn:split(tokens,",") }'/>
	<c:out value='${fn:join(array,"-")}'/><br>
	<c:out value="${fn:escapeXml(str1) }"/>
</body>
</html>