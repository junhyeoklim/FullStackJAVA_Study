<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
 	<script>
 	$(document).ready(function () {
		$("#btn").on("click",function() {
			alert("tt");
		});
 	});
	</script>
</head>
<body>
 	<h1>������ �׽�Ʈ</h1>
 	<table border = 1>
 	<button id="btn">test</button>
 	
 	<%
 		int x = 0 , y = 0;
 	
 		for(x = 2; x<=9; x++){
 			out.print("<tr>");
 			for(y = 1; y <=9; y++){
 				out.print("<td>"+x+"*"+y+"="+(x*y)+" </td>");
 			}
 			out.print("</tr>");
 			out.print("<br>");
 		}
 	%> 	
 	</table>

</body>
</html>