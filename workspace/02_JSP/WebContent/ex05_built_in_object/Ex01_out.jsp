<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 1~100 사이 모든 홀수를 출력하시오. --%>
	<% for(int n = 1; n <= 100; n++) { %>
		<% if (n % 2 == 1) { %>
			<%=n%>&nbsp;&nbsp;
		<% } %>
		<% if (n % 10 == 0) { %>
			<br>
		<% } %>
	<% } %>
	
	<%
		for (int n = 1; n <= 100; n++) {
			if (n % 2 == 1) {
				out.println(n + "&nbsp;&nbsp;");
			}
			if (n % 10 == 0) {
				out.println("<br>");
			}
		}
	%>
</body>
</html>