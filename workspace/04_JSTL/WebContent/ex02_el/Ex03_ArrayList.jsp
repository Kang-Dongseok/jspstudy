<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
		// Person 3명을 ArrayList에 담아서 EL로 표현해보자.
		Person p1 = new Person();
		p1.setName("브레드");
		p1.setAge(50);
		Person p2 = new Person();
		p2.setName("초코");
		p2.setAge(30);
		Person p3 = new Person();
		p3.setName("윌크");
		p3.setAge(20);
		List<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		// EL 표현을 위해서
		pageContext.setAttribute("list", list);
	%>
	
	<h3>이름1: ${list[0].name}</h3>
	<h3>나이1: ${list[0].age}</h3>
	
	<h3>이름2: ${list[1].name}</h3>
	<h3>나이2: ${list[1].age}</h3>
	
	<h3>이름3: ${list[2].name}</h3>
	<h3>나이3: ${list[2].age}</h3>
</body>
</html>