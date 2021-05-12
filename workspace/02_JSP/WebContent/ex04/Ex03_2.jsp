<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 리다이렉트
	// 1. 기존의 request를 유지하지 않는다.
	// 2. 클라이언트에게 새로 이동할 경로를 이다이렉트 해 준다.
	// 3. 클라이언트가 이동할 수 있도록 컨텍스트 패스를 포함한 전체 경로를 작성한다.
	
	// response.sendRedirect("/02_JSP/ex04/Ex03_3.jsp");

	// 만약 기존의 request를 유지해서 리다이렉트 해야 하는 상황이면?
	// 새로운 파라미터를 붙여 준다.
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	response.sendRedirect("/02_JSP/ex04/Ex03_3.jsp?name=" + URLEncoder.encode(name, "utf-8"));
%>