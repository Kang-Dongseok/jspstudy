<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	1. page 지시어
	   1) <%@ page %>
	   2) 페이지의 속성을 저장한다.
	   3) WAS(톰캣)가 page 지시어를 해석하고 처리한다.
	   4) 속성
	      (1) language     사용언어
	          <%@ page language="java" %>
	      (2) contentType  문서타입
	          <%@ page contentType="text/html; charset=utf-8" %>
	      (3) pageEncoding 인코딩
	          <%@ page pageEncoding="utf-8" %>
	      (4) import       자바의 import
	          <%@ page import="java.util.Date" %>
	      (5) session      세션 사용 유무
	          <%@ page session="true" %>
	      (6) buffer       출력 버퍼 크기
	          <%@ page buffer="8KB" %>
	      (7) autoFlush    출력 버퍼 자동 비우기
	          <%@ page autoFlush="true" %>
	      (8) errorPage    에러 발생 시 이동할 페이지
	          <%@ page errorPage="error.html" %>
	      (9) isErrorPage  에러 페이지 유무
	          <%@ page isErrorPage="false" %>

	2. include 지시어
	   1) 현재 페이지에 다른 페이지를 포함한다.
	   2) 정적 페이지(변화가 없는 페이지)를 포함시킬 때 사용한다.
	   3) <%@ include file="파일.html" %>
	
	3. taglib 지시어
	   1) JSP는 HTML태그와 추가로 확장태그를 사용한다.
	   2) 확장태그를 태그라이브러리라고 한다.
	   3) 확장태그로 변수처리, 제어문(분기문, 반복문) 등을 처리한다.
	   4) <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E요일 H:mm:ss");
		String message = sdf.format(now);
	%>

	<h1><%=message%></h1>

</body>
</html>