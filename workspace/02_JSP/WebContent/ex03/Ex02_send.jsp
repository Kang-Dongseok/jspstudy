<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%
	String name = "브레드";
	int age = 50;
%>

<script>
	function fn1() {
		location.href = '/02_JSP/ex03/Ex02_receive.jsp?name=<%=name%>';
	}
	function fn2() {
		location.href = '/02_JSP/ex03/Ex02_receive.jsp?age=<%=age%>';		
	}
	function fn3() {
		location.href = '/02_JSP/ex03/Ex02_receive.jsp?name=<%=name%>&age=<%=age%>';
	}
</script>
</head>
<body>
	
	<input type="button" value="Ex02_receive.jsp로보내기" onclick="fn1()">
	<input type="button" value="Ex02_receive.jsp로보내기" onclick="fn2()">
	<input type="button" value="Ex02_receive.jsp로보내기" onclick="fn3()">
	
</body>
</html>