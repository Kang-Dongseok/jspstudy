<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP 기본 객체
	
	1. JSP가 미리 만들어 놓은 객체이다.(built-in)
	2. 별도의 생성 과정 없이 사용한다.
	3. 종류
	   1) request : 요청
	   2) response : 응답
	   3) out : 출력 스트림
	   4) page
	   5) pageContext : 페이지 실행에 필요한 Context 정보
	   6) session : 세션
	   7) application : 웹 프로젝트 실행에 필요한 Context 정보
	   8) config
	   9) exception : 예외
--%>
<%
	// 요청 처리
	// 1) 인코딩
	request.setCharacterEncoding("utf-8");
	// 2) 파라미터 저장
	Optional<String> opt1 = Optional.ofNullable(request.getParameter("name"));
	String name = opt1.orElse("기본이름");
	Optional<String> opt2 = Optional.ofNullable(request.getParameter("age"));
	int age = Integer.parseInt(opt2.orElse("0"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>이름: <%=name%></h3>
	<h3>나이: <%=age%>살</h3>
	<input type="button" value="뒤로가기" onclick="history.back()">

</body>
</html>