<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
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
		// 쿠키에 주소를 저장해 보자.
		// 쿠키이름 : address
		// 유효시간 : 7일
		// 쿠키값 : 서울시 마포구 서강로
		
		// 쿠키값에 공백, 콤마, 괄호 등이 포함되면 인코딩을 해야 한다.
		
		Cookie cookie = new Cookie("address", URLEncoder.encode("서울시 마포구 서강로", "utf-8"));  // 공백 때문에 인코딩 필요
		cookie.setMaxAge(60 * 60 * 24 * 7);
		response.addCookie(cookie);
	%>
	<h3>쿠키 확인</h3>
	쿠키이름: <%=cookie.getName()%><br>
	유효시간: <%=cookie.getMaxAge()%><br>
	<%-- 인코딩 된 값은 디코딩 해서 꺼낸다. --%>
	쿠키값: <%=URLDecoder.decode(cookie.getValue(), "utf-8")%>
	
</body>
</html>