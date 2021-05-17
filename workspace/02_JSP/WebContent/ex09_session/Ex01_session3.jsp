<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션 삭제하기
	
	// 1. 특정 속성만 삭제하기
	session.removeAttribute("name");
	session.removeAttribute("age");
	
	// 2. 전체 삭제하기
	session.invalidate();
	
	// 세션 정보 확인
	response.sendRedirect("/02_JSP/ex09_session/Ex01_session2.jsp");
%>