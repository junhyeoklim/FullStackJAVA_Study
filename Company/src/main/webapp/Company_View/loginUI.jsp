<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="../css/styles.css?after">
    <script src="../js/jquery.js"></script>
    <script>
        $(function () {
            $('#btn').on('click',pageMove);
            $('#name').on('keyup',function (e){
            	if(e.keyCode == 13)
            		pageMove();
            })
            
            function pageMove(){
            	let text = $('#name').val();
                location.href = '../Company_DAO/CompanySearch.jsp?text='+text+'&select='+1+'&where='+0;
            }
        })
    </script>
</head>
<body>
	<%@ include file="sessionTest.jsp"%>
    <table id="login">        
        <tr>
            <td><label for="name">이름</label></td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="button" id="btn" value="로그인"></td>
        </tr>
    </table>
</body>
</html>