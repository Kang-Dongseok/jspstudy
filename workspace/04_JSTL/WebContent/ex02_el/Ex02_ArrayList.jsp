<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<%
		List<String> list = new ArrayList<>();
		list.add("브레드");
		list.add("초코");
		list.add("윌크");
		
		// EL 사용을 위해서
		pageContext.setAttribute("list", list);
	%>
	
	<%-- EL에서 ArrayList 사용 : 배열처럼 쓴다. --%>
	<h3>이름1: ${list[0]}</h3>
	<h3>이름2: ${list[1]}</h3>
	<h3>이름3: ${list[2]}</h3>
	
</body>
</html>