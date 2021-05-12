<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 테이블을 생성한다. --%>
	<%
		String[] names = {"브레드", "초코", "윌크"};
		int[] ages = {50, 30, 20};
	%>
	<table border="1">
		<thead>
			<tr>
				<td>순번</td>
				<td>이름</td>
				<td>나이</td>
			</tr>
		</thead>
		<tbody>
			<% for (int i = 0; i < names.length; i++) { %>
				<tr>
					<td><%=i+1%></td>
					<td><%=names[i]%></td>
					<td><%=ages[i]%></td>
				</tr>
			<% } %>
		</tbody>
	</table>

</body>
</html>