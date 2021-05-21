<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<c:set var="now" value="<%=new Date()%>" />
	
	<h3>디폴트 : <fmt:formatDate value="${now}" /></h3>
	
	<%-- SimpleDateFormat 클래스의 날짜 패턴을 그대로 사용한다. --%>
	<h3>날짜 : <fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 E요일" /> </h3>
	<h3>12시간제 : <fmt:formatDate value="${now}" pattern="a h:mm:ss" /> </h3>
	<h3>24시간제 : <fmt:formatDate value="${now}" pattern="H:mm:ss" /> </h3>
	
</body>
</html>