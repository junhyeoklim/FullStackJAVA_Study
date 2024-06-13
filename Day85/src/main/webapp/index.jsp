<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="js/jquery.js"></script>
<script>
	let searchRequest = new XMLHttpRequest();
	
	let registerRequest = new XMLHttpRequest();
	
	function searchFunction(){
		searchRequest.open("get","./userSearch.do?userName="+ encodeURIComponent(document.getElementById("userName").value),true);
		searchRequest.onreadystatechange = searchProcess;
		searchRequest.send();
	}
	
	function searchProcess(){
		let table = document.getElementById("ajaxTable");
		table.innerHTML = "";
		
		if(searchRequest.readyState == 4 && searchRequest.status == 200){
			let object = JSON.parse(searchRequest.responseText);
			let result = object.result;
			
			for(let i = 0; i<result.length; i++){
				let row = rable.insertRow(0);
				
				for(let j = 0; j < result[i].length; j++){
					let cell = row.insertCell(j);
					cell.innerHTML = reqult[i][j].value;					
				}
			}
		}
	}
	
	function registerFunction(){
		let radioButtons = document.querySelectorAll('input[type="radio"]');
		let checkedValue;
		
		radioButtons.forEach(radioButton => {
			if(radioButton.checked){
				checkedValue = radioButton.value;
			}
		});
		registerRequest.open("get", "./userRegister.do?userName=" + encodeURIComponent(document.getElementById("registerName").value)
				+ "&userAge=" + encodeURIComponent(document.getElementById("registerAge").value)
				+ "&userGender=" + encodeURIComponent(checkedValue)
				+ "&userEmail=" + encodeURIComponent(document.getElementById("registerEmail").value),
				true);
		registerRequest.onreadystatechange = registerProcess;
		registerRequest.send();
	}
	
	function registerProcess(){
		if(registerRequest.readyState == 4 && registerRequest.status == 200){
			let result = registerRequest.responseText;
			
			if(result != 1){
				alert("등록에 실패했습니다.");
			}
			else {
				var userName = document.getElementById("userName");
				var registerName = document.getElementById("registerName");
				var registerAge = document.getElementById("registerAge");
				var registerEmail = document.getElementById("registerEmail");
				userName.value = "";
				registerName.value = "";
				registerAge.value = "";
				registerEmail.value = "";
				searchFunction();
			}
		}
	}
	
	window.onload = function (){
		searchFunction();
	}
</script>
</head>
<body>

<input id="userName" onkeyup="searchFunction();" type="text" size="20">
	<button onclick="searchFunction();" type="button">검색</button>

	<table class="table"
		style="text-align: center; border: 1px solid #dddddd">
		<thead>
			<tr>
				<th style="background-color: #fafafa; text-align: center;">이름</th>
				<th style="background-color: #fafafa; text-align: center;">나이</th>
				<th style="background-color: #fafafa; text-align: center;">성별</th>
				<th style="background-color: #fafafa; text-align: center;">이메일</th>
			</tr>
		</thead>
		<tbody id="ajaxTable">
		</tbody>
	</table>
	<table style="text-align: center; border: 1px solid #dddddd">
		<thead>
			<tr>
				<th colspan="2" style="background-color: #fafafa;">회원 등록 양식</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td style="background-color: #fafafa; text-align: center;"><h5>이름</h5></td>
				<td><input type="text" id="registerName" size="20"></td>
			</tr>
			<tr>
				<td style="background-color: #fafafa; text-align: center;"><h5>나이</h5></td>
				<td><input type="text" id="registerAge" size="20"></td>
			</tr>
			<tr>
				<td style="background-color: #fafafa; text-align: center;"><h5>성별</h5></td>
				<td>
					<div style="text-align: center; margin: 0 auto;">
						<input type="radio" name="registerGender" value="남자" checked>남자
						<input type="radio" name="registerGender" value="여자">여자
					</div>
				</td>
			</tr>
			<tr>
				<td style="background-color: #fafafa; text-align: center;"><h5>이메일</h5></td>
				<td><input class="form-control" type="text" id="registerEmail"
					size="20"></td>
			</tr>
			<tr>
				<td colspan="2"><button onclick="registerFunction();"
						type="button">등록</button>
			</tr>
		</tbody>
	</table>
</body>
</html>