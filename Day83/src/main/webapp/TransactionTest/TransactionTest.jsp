<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	DataSource dataSource = null;		 
	String occuredException = null;
	String payment = "1000";		// 지불 금액
	
	try {
		Context context = new InitialContext();
		dataSource = (DataSource)context.lookup("java:comp/env/jdbc/testdb");
	} catch (NamingException e) {
		e.printStackTrace();
	}
	
	try(Connection conn = dataSource.getConnection();){
		try(PreparedStatement pstmtBankBook = conn.prepareStatement("update bankbook set balance= balance-"+payment+" where name = 'starTraveller'");
				PreparedStatement pstmtPoint= conn.prepareStatement("update pointbook set point = point+("+payment+"/10) where name = 'starTraveller'")){
					//트랜잭션 설정 , false를 인자값으로 넘겨서 트랜잭션을 시작
					conn.setAutoCommit(false);
				    
				    //통장 잔고 업데이트
				    pstmtBankBook.executeUpdate(); 
				    
				    //강제로 예외 날리기
				    if(true){
				        	throw new Exception("오류 발생 !!");
				    }
				    
				     //10% 포인트 적립
				    pstmtPoint.executeUpdate(); 
				     
				    //트랜젝션 커밋
				    conn.commit();
				}
				catch(Exception e){
					occuredException = "error";
					conn.rollback();
				}
			 
			}catch(Exception e){
			    e.printStackTrace();
			}
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>


	<%if(occuredException != null){
    out.println("<h2>거래 실패</h2>");    
}else{
    out.println("<h2>거래 성공</h2>");
}
%>
</body>


</html>