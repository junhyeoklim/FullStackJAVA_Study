<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>register</title>
    <link rel="stylesheet" href="../css/styles.css">
    <script src="../js/jquery.js"></script>
</head>
<body>    
        <table border="1" id="register">
            <caption>사원 정보 입력</caption>
            <tr>
                <td><label for="name">이름</label></td>
                <td><input type="text" name="name" id="name" required></td>
            </tr>

            <tr>
                <td><label for="department">부서</label></td>
                <td><input type="text" name="department" id="department" required></td>
            </tr>

            <tr>
                <td><label for="rank">직급</label></td>
                <td><input type="text" name="rank" id="rank" required></td>
            </tr>

            
            <tr>
                <td><label for="first">이메일</label></td>
                <td>
                    <input type="text" name="email" id="first" required> @
                    <input type="text" id="second" required>
                    <select id="selectBox">
                        <option selected disabled>선택</option>
                        <option value="1">naver.com</option>
                        <option value="2">gmail.com</option>
                        <option value="3">daum.net</option>
                        <option value="4">직접입력</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td><label for="phone">전화번호</label></td>
                <td colspan="2">
                    <input type="text" name="phone" id="phone" required>
                </td>                
            </tr>

            <tr>
                <td colspan="2" id="footer">
                    <input type="button" id="btn" value="등록">
                    <input type="reset" value="취소">
                </td>
            </tr>
        </table>    
    <script src="../js/register.js"></script>
</body>
</html>