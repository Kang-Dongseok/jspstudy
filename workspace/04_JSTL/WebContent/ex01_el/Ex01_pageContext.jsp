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
		int a = 7;
		int b = 2;  // 현재 EL로 표현할 수 없다.
		
		// EL 표현을 위해서 pageCoext에 a와 b를 "속성"으로 저장한다.
		pageContext.setAttribute("a", a);
		pageContext.setAttribute("b", b);
	%>
	${a}<br>  <%-- 속성의 이름을 EL로 표현한다. --%>
	${b}<br>
	
	
	<h3>표현식 vs 표현언어</h3>
	<%-- 표현식은 "Java" 연산이다. --%>
	<%=a%> + <%=b%> = <%=a+b%><br>
	<%=a%> - <%=b%> = <%=a-b%><br>
	<%=a%> * <%=b%> = <%=a*b%><br>
	<%=a%> / <%=b%> = <%=a/b%><br>  <%-- 몫 --%>
	<%=a%> % <%=b%> = <%=a%b%><br>
	<hr>
	<%-- 표현언어는 자신의 연산을 가지고 있다. --%>
	${a} + ${b} = ${a + b}<br>
	${a} - ${b} = ${a - b}<br>
	${a} * ${b} = ${a * b}<br>
	${a} / ${b} = ${a / b}<br>  <%-- 나누기 결과가 소수점으로 반환 --%>
	${a} / ${b} = ${a div b}<br>
	${a} % ${b} = ${a % b}<br>
	${a} % ${b} = ${a mod b}<br>
	
	
</body>
</html>