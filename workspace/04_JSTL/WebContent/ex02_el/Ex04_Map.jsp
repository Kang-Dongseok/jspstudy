<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
		Map<String, Object> map = new HashMap<>();
		map.put("name", "브레드");
		map.put("age", 50);
		
		// EL 사용을 위해서
		pageContext.setAttribute("map", map);
	%>
	
	<%-- Map은 bean처럼 사용할 수 있다. --%>
	<h3>이름: ${map.name}</h3>
	<h3>나이: ${map.age}</h3>
	
	
	
	
</body>
</html>