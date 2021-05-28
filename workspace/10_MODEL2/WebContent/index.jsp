<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 동적 페이지 포함 (파라미터 title을 전달할 수 있다.) --%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="layout/header.jsp">
	<jsp:param value="홈페이지제목" name="title" />
</jsp:include>

			<h1>홈페이지에 오신 걸 환영합니다</h1>

<%-- 정적 페이지 포함 (파라미터 전달이 불가능하다.) --%>
<%@ include file="layout/footer.jsp" %>