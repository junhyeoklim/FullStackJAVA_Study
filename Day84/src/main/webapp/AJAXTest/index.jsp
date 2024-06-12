<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSP AJAX</title>
<script src="js/jquery.js"></script>
<script>
		var searchRequest = new XMLHttpRequest();
		/* 		
		XMLHttpRequest(XHR) 객체는 서버와 상호작용하기 위하여 사용됩니다. 전체 페이지의 새로고침없이도 
		URL 로부터 데이터를 받아올 수 있습니다. 이는 웹 페이지가 사용자가 하고 있는 것을 방해하지 
		않으면서 페이지의 일부를 업데이트할 수 있도록 해줍니다. XMLHttpRequest 는 AJAX 프로그래밍에 주로 사용됩니다.
		XMLHttpRequest 는 이름으로만 봐서는 XML 만 받아올 수 있을 것 같아 보이지만, 모든 종류의 데이터를 받아오는데
		사용할 수 있습니다. 또한 HTTP 이외의 프로토콜도 지원합니다(file 과 ftp 포함).
		*/
		var registerRequest = new XMLHttpRequest();
		function searchFunction() {
			searchRequest.open("get", "./userSearch.do?userName=" + encodeURIComponent(document.getElementById("userName").value), true);
			/*
			@ open(method, url, async) 
			method : the type of request : GET or POST
			url : the server (file) location
			async : true (asynchronous) or false (synchronous) 
			
			async : false (synchronous)
			동기적으로 동작하므로 이 함수가 호출되면 UI가 멈춥니다(즉, 사용불가 상태로 만든다).
			따라서 브라우저가 우리 요청을 처리하는 동안에도 평상시처럼 계속 동작하게 하려면, 
			async : true (asynchronous)를 사용해야 합니다.

			@ 동기식 처리 모델(Synchronous processing model)
			동기식 처리 모델(Synchronous processing model)은 직렬적으로 태스크(task)를 수행한다.
			즉, 태스크는 순차적으로 실행되며 어떤 작업이 수행 중이면 다음 작업은 대기하게 된다.
			예를 들어 서버에서 데이터를 가져와서 화면에 표시하는 작업을 수행할 때, 
			서버에 데이터를 요청하고 데이터가 응답될 때까지 이후 태스크들은 블로킹(blocking, 작업 중단)된다.

			@ 비동기식 처리 모델
			(Asynchronous processing model 또는 Non-Blocking processing model)

			비동기식 처리 모델(Asynchronous processing model 또는 Non-Blocking processing model)은 병렬적으로 
			태스크를 수행한다.
			즉, 태스크가 종료되지 않은 상태라 하더라도 대기하지 않고 다음 태스크를 실행한다.
			예를 들어 서버에서 데이터를 가져와서 화면에 표시하는 태스크를 수행할 때, 
			서버에 데이터를 요청한 이후 서버로부터 데이터가 응답될 때까지 대기하지 않고(Non-Blocking) 
			즉시 다음 태스크를 수행한다. 
			이후 서버로부터 데이터가 응답되면 이벤트가 발생하고 이벤트 핸들러가 데이터를 가지고 수행할 태스크를 
			계속해 수행한다.

			자바스크립트의 대부분의 DOM 이벤트와 Timer 함수(setTimeout, setInterval), 
			Ajax 요청은 비동기식 처리 모델로 동작한다.
			
			@ XMLHttpRequest가 전송하는 파라미터에 대해서 살펴보자. XMLHttpRequest도 파라미터를 웹서버에 
			전송하기 때문에 파라미터 값을 알맞게 인코딩 해 주어야 한다. 그런데, 
			아쉽게도 XMLHttpRequest 자체적으로 인코딩 처리를 지원해주지는 않는다. 
			따라서, 자바스크립트가 지원해주는 인코딩 처리 함수를 사용해야 한다. 
			자바 스크립트가 제공하는 인코딩 처리 함수는 
			escape()와 encodeURIComponent()의 두가지가 있다. 
			이 두가지는 동작 방식이 다른데, 다음표는 두 함수의 실행 결과를 보여주고 있다.

			두 함수의 실행 결과는 문서 캐릭터셋이 euc-kr 이거나 utf-8 인 경우 모두 동일하다.
			escape('한글')				%uD55C%uAE00		유니코드 값을 표현
			encodeURIComponent('한글')	%ED%95%9C%EA%B8%80	utf-8로 인코딩. encodeURI() 함수도 동일한 결과 출력

			두 함수의 실행 결과를 보면 encodeURIComponent() 함수가 utf-8로 인코딩한 결과를 보여줌을 알 수 있다. 
			따라서, XMLHttpRequest로 한글 파라미터를 전송할 때에는 다음과 같은 방법을 
			사용하면 된다.
			웹브라우저에서: 자바스크립트 encodeURIComponent() 함수를 사용하여 파라미터 값을 utf-8로 
			인코딩하여 전송한다.
			서버에서: 파라미터 값을 utf-8로 디코딩하여 읽어온다.
			*/
			searchRequest.onreadystatechange = searchProcess;
			/*
			Ajax의 가장 중요한 비동기(Asynchrous)에 해당하는 부분이다.
			여기에서는 서버의 UserRegisterServlet의 내용을 얻어오는 것이 목적인데, 서버가 처리 결과를 
			언제 줄지는 모르는 일이다. 
			그렇다고 마냥 그 요청 결과를 기다리고 있을 수는 없다. 따라서 작업의 주체인 XMLHTTP에게 서버로 부터 
			응답을 받을 때 까지 대기하고 있다가 
			다 되고 알려주면 콜백함수(여기서는 searchProcess)를 호출하겠다는 의미이다.
			서버에서 응답이 도착하면 특정한 자바스크립트 함수를 호출할 수 있는것이 onreadystatechange이다. 
			onreadystatechange라는 말은 XMLHTTP의 상태(readystate)가 변경될 때 마다(on change)라는 의미이다.
			*/			
			searchRequest.send();
		}
		function searchProcess(){
			var table = document.getElementById("ajaxTable");
			table.innerHTML = "";
			if(searchRequest.readyState == 4 && searchRequest.status == 200){
				// var object = eval('(' + searchRequest.responseText + ')');
				var object = JSON.parse(searchRequest.responseText);
				/*
					responseText 프로퍼티는 서버에 요청하여 응답으로 받은 데이터를 문자열로 반환한다.
				 	문법 eval(string)
				 	예를 들면
				 	eval('2+2')
					는 문자열 2+2가 아니라 계산한 결과 4이다.
					
					JSON Text를 Object로 변환해야 할 때가 있다. 여기서 JSON Text라는 것은 형태는 JSON의 형태이지만 
					자바스크립트에서 이걸 Object가 아닌 그냥 텍스트로만 인식하고 있다는 것이다. 
					이걸 Object로 바꾸어야만 그안의 값을 불러다가 사용할 수 있다.

					가장 흔한 예가 Ajax를 사용할 경우이다. Ajax로 호출을 하고 결과값으로 받은 req.responseText로 
					JSON을 받았을 경우에는 그냥 Text이기 때문에 Object로 변환해 주어야 한다.

					{ id:'Outsider', sex:'male' }

					Ajax에서 리턴받을 JSON의 형태가 위와 같이 되어 있을 경우에는

					var obj = eval("("+returnValue.responseText+")");
					alert(obj.id);  // Outsider

					위의 코드처럼 eval을 해주면 JSON 오브젝트로 변환할 수 있다.					
					
				*/
				var result = object.result;
				for(var i = 0; i < result.length ; i++){
					var row = table.insertRow(0);
					for(var j = 0; j < result[i].length; j++){
						var cell = row.insertCell(j);
						cell.innerHTML = result[i][j].value;
						console.log("result[" + i + "]" + "["+ j+"]" + result[i][j].value);
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
			if(registerRequest.readyState == 4 && registerRequest.status == 200) {
				var result = registerRequest.responseText;
				// responseText 프로퍼티는 서버에 요청하여 응답으로 받은 데이터를 문자열로 반환한다.
				if(result != 1){
					alert("등록에 실패했습니다.");
				}else {
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
		/*
		@ 콜백함수 부분으로 서버에서 응답을 받은 후 수행하는 함수이며, onreadystatechange 이벤트 핸들러라고 한다. 
		이는 XMLHTTP가 응답을 수신하는 과정에서 발생하는 상태(status)를 이벤트로 전달하고, 
		여러 이벤트 중에서 관심 있는 
		이벤트에 대해서 적절한 동작을 기술하는 함수라는 의미가 내포되어 있다. 참고로, readyState == 4인 경우는 
		현재 응답이 
		완전히 도착 한 후 처리할 부분이며, readyState == 1,2,3 부분은 현재 응답이 전송 처리중 상태로 보면 된다. 

		사실 onreadystatechange에서 명시한 콜백 함수는 readyState라는 프로퍼티값이 변경될때 마다 호출(trigger)된다. 
		따라서 실제로 onreadystate함수는 5번(0~4) 호출되는 셈이다.
		그러므로 onreadystatechange 함수안에서 값에 따라 처리를 해줘야 한다.
		
		@ readyState 상태
		값			설명										의미
		0			객체만 생성 (open 메서드가 호출되지 않음)			Unlinitialized
		1			open메서드 호출								Loading
		2			send메서드 호출, status와 헤더는 도착하지 않은 상태	Loaded
		3			데이터의 일부를 받은 상태						INTERACTIVE
		4			데이터를 전부 받은 상태, 완전한 데이터의 이용 가능		COMPLETED
		
		@ status / stateText - 서버로부터의 응답상태.
		값(status)		텍스트(statusText)			설명
		200				OK							요청성공
		403				Forbidden					접근 거부
		404				Not Found					페이지 없음
		500				Internal Server Error		서버 오류 발생		
		*/
		window.onload = function(){
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
						<input type="radio" name="registerGender" 
							value="남자" checked>남자 <input type="radio"
							name="registerGender"  value="여자">여자

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

<!-- 
XMLHttpRequest
https://developer.mozilla.org/ko/docs/Web/API/XMLHttpRequest 
-->