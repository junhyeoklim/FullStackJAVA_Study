<%@page import="company.dto.CompanyDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>사원정보 변경</title>
<link rel="icon" href="../source/company.ico" />
<link rel="stylesheet" href="css/defaultStyle.css?after">
<link rel="stylesheet" href="css/modify.css?after">
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
	<c:forEach var="dto" items="${list}">
		<form method="post" action="modifyOK.do">
			<table border="1" id="modify">
				<caption>사원정보변경</caption>
				<tr>
					<td><label for="name">이름</label></td>
					<td><input type="text" name="name" id="name" required
						value="${dto.s_name}"></td>
				</tr>

			<tr>
				<td><label>부서</label></td>
				<td><select id="select-box" name="dpartment-box">
					<c:set var="department" value="${'경영','인사','개발'}"/>
						<option disabled selected>선택</option>
						<option value="경영" <c:if test="${dto.s_department == '101'}"> selected </c:if>>경영</option>
						<option value="인사" <c:if test="${dto.s_department == '102'}"> selected </c:if>>인사</option>
						<option value="개발" <c:if test="${dto.s_department == '103'}"> selected </c:if>>개발</option>
					</select></td>
			</tr>

				<tr>
					<td><label for="rank">직급</label></td>
					<td><input type="text" name="rank" id="rank" required
						value="${dto.s_rank}"></td>
				</tr>

				<tr>
					<td><label for="email">이메일</label></td>
					<td>
						<div class="container">
							<div class="mail">
								<input type="email" name="email" id="email" required
									value="${dto.s_mail}">
							</div>
						</div>
					</td>

				</tr>

				<tr>
					<td><label for="phone">전화번호</label></td>
					<td colspan="2"><input type="number" name="phone" id="phone"
						required value="${dto.s_phoneNumber}"></td>
				</tr>

				<tr>
					<td colspan="2" id="footer"><input type="submit" id="btn"
						value="등록"> <input type="button" id="back" value="취소"></td>
				</tr>
			</table>
		</form>
	</c:forEach>
	<script type="text/javascript" src="js/register.js"></script>
</body>
</html>