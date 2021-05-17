<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 로그아웃
	// session에 저장된 loginDTO 정보를 삭제
	session.invalidate();

	// 다시 로그인 페이지로 이동
	response.sendRedirect("/02_JSP/ex09_session/Ex02_login.jsp");
%>