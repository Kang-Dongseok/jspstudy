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
		if문
		
		1. <c:if test="조건식"></c:if>
		2. else 개념이 없다.
	--%>
	
	${param.a gt param.b}<br>  <%-- a와 b는 문자열이기 때문에 잘못된 비교 --%>
	${param.a - param.b gt 0}<br>  <%-- 올바른 비교 --%>

	<%-- parameter로 전달되고 있는 a와 b중에서 큰 수를 출력하기 --%>
	<c:if test="${param.a - param.b gt 0}">
		<c:set var="max" value="${param.a}" />
	</c:if>
	<c:if test="${param.a - param.b lt 0}">
		<c:set var="max" value="${param.b}" />
	</c:if>
	
	<h3>${param.a}와 ${param.b} 중 큰 수는 ${max}이다.</h3>

	<%-- a와 b중에서 10과 가까운 수를 출력하시오. --%>
	<c:if test="${param.a - 10 gt 0}">
		<c:set var="diff1" value="${param.a - 10}" />
	</c:if>
	<c:if test="${param.a - 10 lt 0}">
		<c:set var="diff1" value="${10- param.a}" />
	</c:if>
	
	<c:if test="${param.b - 10 gt 0}">
		<c:set var="diff2" value="${param.b - 10}" />
	</c:if>
	<c:if test="${param.b - 10 lt 0}">
		<c:set var="diff2" value="${10- param.b}" />
	</c:if>
	
	<c:if test="${diff1 - diff2 gt 0}">
		<h3>10과 가까운 값은 ${param.b}이다.</h3>
	</c:if>
	<c:if test="${diff1 - diff2 lt 0}">
		<h3>10과 가까운 값은 ${param.a}이다.</h3>
	</c:if>
	<c:if test="${diff1 eq diff2}">
		<h3>${param.a}와 ${param.b}는 10과 같은 차이를 가진다.</h3>
	</c:if>

</body>
</html>