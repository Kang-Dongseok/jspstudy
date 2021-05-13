<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int age = Integer.parseInt(request.getParameter("age"));
%>
<script>
	alert('성인이군요! 당신의 나이는 <%=age%>살이므로 술을 살 수 있어요!');
	history.back();
	// forward는 이동 경로(URL)가 변하지 않는 이동이기 때문에 history에 잡히지 않는다.
	// 따라서, history.go(-2)가 아니라 history.go(-1) 내지는 history.back()이다.
</script>