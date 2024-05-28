<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body{
	user-select: none;
}
input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}
</style>
</head>
<body>
	<form action="BoardInputValueOK.jsp">
		<table>
			<tr>
				<td><label for="name">name : </label></td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			
			<tr>
				<td><label for="id">id : </label></td>
				<td><input type="text" name="id" id="id"></td>
			</tr>
			
			<tr>
				<td><label for="password">password : </label></td>
				<td><input type="password" name="password" id="password"></td>
			</tr>
			
			<tr>
				<td><label for="age">age :</label></td>
				<td><input type="number" name="age" id="age"></td>
			</tr>
			
			<tr>
				<td><label for="email">email : </label></td>
				<td><input type="email" name="email" id="email"></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="전송"></td>
			</tr>
		</table>
	</form>
</body>
</html>