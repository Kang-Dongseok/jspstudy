<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP의 4개 영역
	
	1. 데이터를 저장할 수 있는 내장 객체 4개를 의미한다.
	2. 각 내장 객체는 데이터를 유지하는 생명 주기(Life Cycle)가 다르다.
	3. 속성(Attribute)으로 데이터를 저장한다.
	4. 종류
	   1) pageContext
	      (1) 해당 페이지에서 사용
	      (2) 해당 페이지를 벗어나면 소멸
	   2) request
	      (1) 요청이 발생하면 사용
	      (2) 응답되면 소멸
	   3) session
	      (1) 웹 브라우저에서 사용
	      (2) 웹 브라우저를 닫으면 소멸
	   4) application
	      (1) 웹 애플리케이션에서 사용
	      (2) 웹 애플리케이션을 닫으면 소멸
	5. 데이터 저장 메소드
	   1) 내장객체.setAttribute("속성명", 데이터);
	   2) 저장되는 모든 데이터의 타입이 Object이다.
	6. 데이터 반환 메소드
	   1) 내장객체.getAttribute("속성명");
	   2) getAttribute()로 읽어 들인 속성은 캐스팅(형 변환)을 해야 한다.
	7. 4개 영역의 데이터는 EL(Express Language)로 사용한다.
--%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		// pageContext에 데이터 저장하기
		pageContext.setAttribute("name", "브레드");
		pageContext.setAttribute("age", 50);
	%>
	<h3>이름: <%=pageContext.getAttribute("name")%></h3>
	<h3>나이: <%=pageContext.getAttribute("age")%></h3>
	
	<%
		// 캐스팅
		String name = (String)pageContext.getAttribute("name");
		int age = (int)pageContext.getAttribute("age");
	%>
	
	<h3>이름의 길이: <%=name.length()%></h3>
	<h3>내년 나이: <%=age + 1%></h3>
	
</body>
</html>