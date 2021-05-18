<%@page import="ex02_el.Person"%>
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
	
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Person p = new Person();
		p.setName(name);
		p.setAge(age);
		
		// EL 표현을 위해서 4개 영역에 저장
		pageContext.setAttribute("p", p);  // 객체를 저장해 둔다.
	%>
	
	<%-- EL의 객체 표현방법 --%>
	<h3>이름: ${p.getName()}</h3>
	<h3>나이: ${p.getAge()}</h3>
	<hr>
	<h3>이름: ${p.name}</h3>  <%-- 내부적으로 getter를 호출한다. --%>
	<h3>나이: ${p.age}</h3>  <%-- 내부적으로 getter를 호출한다. --%>
	
</body>
</html>