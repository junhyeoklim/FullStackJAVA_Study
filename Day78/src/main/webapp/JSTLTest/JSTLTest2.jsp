<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL Test2</title>
</head>
<body>

<!-- 액션태그로 com.superman.www.MyMember 객체를 member라는 이름으로 request영역에 생성 -->
<jsp:useBean id="member" class="com.superman.www.MyMember" scope="request"></jsp:useBean>
<!-- 액션태그로 member에 no에 100을 대입하자. -->
<jsp:setProperty property="no" name="member" value="100"/>
<!-- 액션태그로 member에 name에 "홍길동"을 대입하자. -->
<jsp:setProperty property="name" name="member" value="홍길동"/>
<!-- el로 member의 name과 no를 출력하자 -->
${member.no} <br>
${member.name } <br>
<!-- 기본태그(core)로 member에 no에 값을 100을 대입하자.-->

<!-- el로 member에 no를 출력하자 -->


</body>
</html>