<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = session.getAttribute("name") == null ? "기본이름" : (String)session.getAttribute("name");
	int age = session.getAttribute("age") == null ? 0 : (int)session.getAttribute("age");
	
	out.println("이름: " + name + "<br>");
	out.println("나이: " + age + "<br>");
	out.println("<a href=\"Ex01_session3.jsp\">세션 삭제하기</a>");
%>