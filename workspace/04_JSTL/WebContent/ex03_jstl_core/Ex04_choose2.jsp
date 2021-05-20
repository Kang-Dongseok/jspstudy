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
	
	<%-- 평균 구하기 --%>
	<c:set var="average" value="${(param.kor + param.eng + param.mat) div 3}" />
	
	<%-- if 태그로 학점(grade) 계산하기 --%>
	<c:if test="${average - 90 ge 0}">
		<c:set var="grade" value="A" />
	</c:if>
	<c:if test="${average - 90 lt 0 and average - 80 ge 0}">
		<c:set var="grade" value="B" />
	</c:if>
	<c:if test="${average - 80 lt 0 and average - 70 ge 0}">
		<c:set var="grade" value="C" />
	</c:if>
	<c:if test="${average - 70 lt 0 and average - 60 ge 0}">
		<c:set var="grade" value="D" />
	</c:if>
	<c:if test="${average - 60 lt 0}">
		<c:set var="grade" value="F" />
	</c:if>
	
	<%-- choose 태그로 학점(grade) 계산하기 --%>
	<%-- choose 태그의 서브 태그인 when 태그는 else의 개념을 가지고 있다. --%>
	<c:choose>
		<c:when test="${average - 90 ge 0}">  <%-- if() --%>
			<c:set var="grade" value="A" />
		</c:when>
		<c:when test="${average - 80 ge 0}">  <%-- else if() --%>
			<c:set var="grade" value="B" />
		</c:when>
		<c:when test="${average - 70 ge 0}">  <%-- else if() --%>
			<c:set var="grade" value="C" />
		</c:when>
		<c:when test="${average - 60 ge 0}">  <%-- else if() --%>
			<c:set var="grade" value="D" />
		</c:when>
		<c:otherwise>  <%-- else --%>
			<c:set var="grade" value="F" />
		</c:otherwise>
	</c:choose>
	
	${grade}
	
</body>
</html>