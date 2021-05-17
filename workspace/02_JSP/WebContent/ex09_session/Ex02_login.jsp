<%@page import="ex09_session.MemberDTO"%>
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
		MemberDTO loginDTO = (MemberDTO)session.getAttribute("loginDTO");
	%>

	<% if (loginDTO == null) { %>
		<form action="/02_JSP/ex09_session/Ex02_loginCheck.jsp" method="post">
			<input type="text" name="id" placeholder="아이디"><br>
			<input type="password" name="pw" placeholder="비밀번호"><br>
			<button>로그인</button>
		</form>
	<% } else { %>
		<form action="/02_JSP/ex09_session/Ex02_logout.jsp">
			<%=loginDTO.getName()%>님 환영합니다.<br><br>
			<button>로그아웃</button>
		</form>
	<% } %>
</body>
</html>