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
		pageContext.setAttribute("model", "a-class");
		request.setAttribute("model", "b-class");
		session.setAttribute("model", "c-class");
		application.setAttribute("model", "e-class");
	%>
	<%-- 우선순위 확인 --%>
	${model}<br>  <%-- pageContext의 model --%>
	${requestScope.model}<br>
	${sessionScope.model}<br>
	${applicationScope.model}<br>
	
</body>
</html>