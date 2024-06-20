<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<span id="test"></span>
<input type="button" id="reset" value="연장">

<script src="../js/jquery.js"></script>
<script type="text/javascript">
	<%-- <%session.setMaxInactiveInterval(10);%> --%>
	let time = 30;
	let timer = document.getElementById('test');
	let m = parseInt(time/60);
	<%-- let session =  <%= session.getMaxInactiveInterval()%>; --%>
	ui();
	checkStart();

	
	$('#reset').on('click',function(){
		console.log("click");
		clearTimeout(orange);
		time = 10;
		checkStart();
		ui();
		<%-- <%session.setMaxInactiveInterval(10);%> --%>
	});


function ui() {
	if(time>=10 && time < 60)	
		timer.textContent = m+":"+time;
	else if(time >= 0 && time < 10)
		timer.textContent = m+":0"+time;
	else
		timer.textContent = m+":00";
}
	
	
	
function checkSession() { 
	time -= 1;
	
	if(time > 10){ 
		timer.textContent = m+":"+time;
	}
	else if(time >= 0 && time <= 10){
		timer.textContent = m+":0"+time;
	}
 	else{		
  		alert("세션이 만료되었습니다!");
  		<%session.invalidate();%>;
  		clearTimeout(orange);  
  		location.href = 'login.do';
 	}
}

function checkStart() {
 /* alert("체크시작");  */
 orange = setInterval(checkSession, 1000);
 /* 참고 https://dololak.tistory.com/551  */
 /*https://dololak.tistory.com/706  */
}

</script>

