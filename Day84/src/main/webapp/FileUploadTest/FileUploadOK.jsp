<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = application.getRealPath("fileFolder");

	int size = 1024 * 1024 * 10;
	String file = "";
	String oriFile = "";
	
	
	try{
		MultipartRequest multi = new MultipartRequest(request,path,size,"utf-8", new DefaultFileRenamePolicy());
		
		String name = multi.getParameter("name");
		System.out.println("이름 : "+name);
		
		Enumeration<String> files = multi.getFileNames();
		
		while(files.hasMoreElements()){
			String str = files.nextElement();
			file = multi.getFilesystemName(str);
			
			oriFile = multi.getOriginalFileName(str);
			
			System.out.println("저장된 경로 : "+ path + " 저장된 이름 : " + file + " 원본 이름 : "+ oriFile);
			
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	Success
</body>
</html>