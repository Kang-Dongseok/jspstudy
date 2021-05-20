<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<%--
		속성(attribute)으로 request에 값을 저장
		set 태그로 저장된 값은 "문자열"이다.
	--%>
		<c:set var="a" value="20" scope="request" />
		<c:set var="b" value="5" scope="request" />
	
	<%--
		// 속성(attribute)으로 request에 값을 저장
		// 저장된 값은 "숫자"이다.
		request.setAttribute("a", 20);
		request.setAttribute("b", 5);
	--%>

	<%-- forward --%>
	<jsp:forward page="Ex02_set2.jsp" />

</body>
</html>