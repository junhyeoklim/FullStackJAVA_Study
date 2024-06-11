<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
</body>
</html>
<!-- 
JSON(JavaScript Object Notation)
자바스크립트의 객체를 문자열로 표현하는 방법 
크롬 브라우저의 개발자 도구를 열어서 다음을 입력해본다.

var pi = 3.14;
var str = "string";
JSON.stringify(pi);
JSON.stringify(str);
JSON.parse("3.14");
JSON.parse("\"string\"");
var arr = [
	"문자열", 3.14, true, null, undefined, function a() { console.log("method") }
];
var t = JSON.stringify(arr);
t;
JSON.parse(t);
var obj = {
	"str" : "문자열",
	"num" : 3.14,
	"boolean" : true,
	"null" : null,
	"undefined":undefined,
	"method" : function a() { console.log("method")}
	};
	
var t2 = JSON.stringify(obj);
t2;
JSON.parse(t2);
-->

<!-- 
JSON
JSON : Javascript Object Notification
자바스크립트의 객체를 문자열로 표현하는 방법
프로그램간에 전달하기 편리 (서버 -> 브라우저)
JSON API
JSON.stringify( object )
인자로 받은 객체를 JSON 문자열로 반환함
JSON.parse( string )
인자로 받은 문자열을 Javascript Object로 변경해 반환함
var original_obj = { pi:3.14, str:"string" };

var json_str = JSON.stringify( original_obj );
// 반환 문자열 : {"pi":3.14,"str":"string"}

var parsed_obj = JSON.parse( json_str );

console.log( original_obj ); // {pi: 3.14, str: "string"}
console.log( parsed_obj ); // {pi: 3.14, str: "string"}

undefined, function 은 변환되지 않음에 주의!
 -->