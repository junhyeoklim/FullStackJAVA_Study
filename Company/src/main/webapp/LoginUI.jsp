<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="icon" href="${contextPath}/assets/ico/company.ico" />
<link rel="stylesheet" href="${contextPath}/assets/css/login.css?after">
<script src="${contextPath}/assets/js/jquery.js"></script>
</head>
<body>
    <div id="login" class="login_wrap">
        <div class="log_inr">
            <h1 class="login_title">Log-in</h1>
            <form method="post" action="${contextPath}/loginOK.do" onsubmit="return check()">
                <fieldset>
                    <div class="login_inp">
                        <div class="input_box">
                            <label for="name" class="lab_login">NAME</label>
                            <input type="text" name="name" id="name" class="inp_txt" maxlength="10">
                        </div>
                        <div class="input_box">
                            <label for="id" class="lab_login">ID</label>
                            <input type="password" name="id" id="id" class="inp_txt">
                        </div>
                    </div>
                    <div class="login_set">
                        <input type="submit" value="로그인" class="btn_inout login">
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
<script src="${contextPath}/assets/js/login.js"></script>
</body>
</html>
