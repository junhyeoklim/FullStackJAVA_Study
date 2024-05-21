<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<span id="test"></span>
	
<script type="text/javascript">
	<%session.setMaxInactiveInterval(10);%>
	let test = document.getElementById('test');
	let session =  <%= session.getMaxInactiveInterval()%>;
function checkSession() { 
 if(session > 0){
	 test.textContent = session+" ";
 }
 else{
  alert("세션이 만료되었습니다!");  
  clearTimeout(orange);
  <%session.invalidate();%>
  location.href = 'loginUI.jsp';
 }
 session -= 1;
}

function checkStart() {
 alert("체크시작");
 test.textContent = session+" ";
 orange = setInterval(checkSession, 1000);
 /* 참고 https://dololak.tistory.com/551  */
 /*https://dololak.tistory.com/706  */
}
checkStart();
</script>

