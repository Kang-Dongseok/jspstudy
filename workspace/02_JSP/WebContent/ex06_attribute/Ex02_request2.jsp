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
	
		// setAttribute()로 저장된 데이터는 getParameter()를 사용할 수 없다.
		// String name = (String)request.getParameter("name");
		
		String name = (String)request.getAttribute("name");
		int age = (int)request.getAttribute("age");
	%>

	<h3>이름: <%=name%></h3>
	<h3>나이: <%=age%></h3>

</body>
</html>