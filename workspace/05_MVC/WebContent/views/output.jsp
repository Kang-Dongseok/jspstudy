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
	<h3>요청한 현재 날짜는 ${today}입니다.</h3>
	<h3>요청한 현재 시간은 ${now}입니다.</h3>
	<c:forEach var="ball" items="${lotto}">
		${ball}<br>
	</c:forEach>
	<h3>요청한 구구단입니다.</h3>
	${gugudan}<br>
	<h3>${result}</h3>
	<h3>지금 준비된 식사는 ${meal}입니다.</h3>
</body>
</html>