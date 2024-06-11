<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
	<span id="id" hidden>${sessionScope.udto.id}</span>
	<span id="check" hidden>${param.check}</span>
	<span id="modify" hidden>${param.modify}</span>
	<script src="js/alert.js"></script>
</body>
</html>