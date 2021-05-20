<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<jsp:forward page="Ex03_if2.jsp">
		<jsp:param value="20" name="a" />
		<jsp:param value="5" name="b" />
	</jsp:forward>

</body>
</html>