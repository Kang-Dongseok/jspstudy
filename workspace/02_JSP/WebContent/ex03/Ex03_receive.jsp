<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	if (name.isEmpty()) {
		name = "기본이름";
	}
	String strAge = request.getParameter("age");
	int age = strAge.isEmpty() ? 0 : Integer.parseInt(strAge);
	/*
	int age;
	if (strAge.isEmpty()) {
		age = 0;
	} else {
		age = Integer.parseInt(strAge);
	}
	*/
%>
<script>
	alert('이름은 <%=name%>이고, 나이는 <%=age%>살이다.');
	history.back();
</script>