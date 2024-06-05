<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<script>
		//테이블 명은 반드시 입력해야 하기 때문에 공백 체크를 한다.
		function check_form() {
			var table_name = myform.table_name.value;
			if(table_name == '') {
				alert('테이블 명은 반드시 입력해야 합니다.');
				myform.table_name.focus();
				return false;
			}
		}
	</script>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
		<h2>테이블 정보 출력!</h2>
	<%
	//GET 방식으로 호출 될 때에는 테이블을 검색할 수 있는 화면만 표시한다.
	if(request.getMethod().equalsIgnoreCase("GET")) {
	%>
	<form name='myform' method='post' onSubmit='return check_form()'>
		<table>
			<tr>
			<th width='100' align='right'>테이블명</th>
			<td><input type='text' name='table_name' size='30'/></td>
			</tr>
			<tr>
			<th width='100' align='right'>조건절</th>
			<td><input type='text' name='table_where' size='30'/></td>
			</tr>
			<tr>
			<td colspan='2' align='right'>
				<input type='submit' value='테이블 정보 획득'/>&nbsp;
			</td>
			</tr>
		</table>
	</form>
	<%
	//POST 방식으로 호출이 되면
	} else if(request.getMethod().equalsIgnoreCase("POST")) {
		//요청한 테이블 이름과 조건절의 값을 가져온다.
		request.setCharacterEncoding("utf-8");
		String table_name = request.getParameter("table_name");
		String table_where = request.getParameter("table_where");
		if(table_where == null) table_where = "";
	%>
	<form name='myform' method='post' onSubmit='return check_form()'>
		<table>
			<tr>
			<th width='100' align='right'>테이블명</th>
			<td><input type='text' name='table_name' size='30' value='<%= table_name %>'/></td>
			</tr>
			<tr>
			<th width='100' align='right'>조건절</th>
			<td><input type='text' name='table_where' size='30' value='<%= table_where %>'/></td>
			</tr>
			<tr>
			<td colspan='2' align='right'>
				<input type='submit' value='테이블 정보 획득'/>&nbsp;
			</td>
			</tr>
		</table>
	</form>
	<%
		//config 디폴트 객체를 통해 web.xml에 지정된 초기화 매개변수의 
		//값들을 읽어온다.
		String driver = config.getInitParameter("driver");
		String url = config.getInitParameter("url");
		String user_id = config.getInitParameter("user_id");
		String user_pw = config.getInitParameter("user_pw");
		
		try{
			Class.forName(driver);
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		//DB를 연동할 때 해당 변수의 값들로 설정한다.			
		String query = "SELECT * FROM " + table_name;
		//조건절이 있다면 query에 추가한다.
		if(table_where != null && table_where.trim().length() != 0)
			query += " " + table_where;		
		System.out.println(query);
		//쿼리 수행 결과 셋을 가져온다.		
		try(Connection conn = DriverManager.getConnection(url, user_id, user_pw);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {
			//결과 셋으로 가져온 내용의 Header를 획득한다.
			//헤더의 메타 정보는 Column_Name, Column_Type 등이 있다.
			ResultSetMetaData rsmd = rs.getMetaData();
	%> 	
	<table border='1'>
		<tr>
		<%
			//메타 정보를 통해 Column_Name을 먼저 출력한다.
			for(int i = 1; i <= rsmd.getColumnCount(); ++i) {
				out.println("<td>" + rsmd.getColumnName(i) + "</td>");
			}
		%>
		</tr>
		<%
			//결과 셋을 통해 각 Column별 데이터들을 추출한다.
			//여기서 나머지 자료형들은 전부 getString() 으로 추출할 수 있지만
			//Date 관련 값은 반드시 getDate() 라고 추출해야 오류가 없다.
			while(rs.next()) {
				out.println("<tr>");
				for(int i = 1; i <= rsmd.getColumnCount(); ++i) {
					//해당 Column의 Type이 Date Type 인지의 여부를 확인한다.
					if(rsmd.getColumnTypeName(i).equalsIgnoreCase("Date"))
						out.println("<td>" + rs.getDate(i) + "</td>");
					else
						out.println("<td>" + rs.getString(i) + "</td>");
				}
				out.println("</tr>");
			}
		%>
	</table>
	<%
		}catch(Exception ex) {			
			out.println("ERROR : " + ex.getMessage() + "<br/><br/>");
		}		
	}
	%>
</body>
</html>