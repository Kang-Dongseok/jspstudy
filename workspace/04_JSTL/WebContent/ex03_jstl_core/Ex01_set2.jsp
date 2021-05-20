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
		request.setCharacterEncoding("utf-8");
	%>
	
	<h3>이름: ${param.name}</h3>
	<h3>나이: ${param.age}</h3>
	<h3>연락처: ${phone}</h3>
	<h3>주소: ${address}</h3>

</body>
</html>