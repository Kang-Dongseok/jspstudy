<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.removeAttribute("cart");
	response.sendRedirect("/02_JSP/ex09_session/Ex03_cart.jsp");
%>