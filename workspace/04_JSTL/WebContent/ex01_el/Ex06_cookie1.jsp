<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 10분간 유지되는 name, age 쿠키
	Cookie cookie1 = new Cookie("name", "브레드");
	cookie1.setMaxAge(60 * 10);
	response.addCookie(cookie1);
	Cookie cookie2 = new Cookie("age", "50");
	cookie2.setMaxAge(60 * 10);
	response.addCookie(cookie2);
	
	// Ex06_cookie2.jsp로 이동
	response.sendRedirect("Ex06_cookie2.jsp");
%>
