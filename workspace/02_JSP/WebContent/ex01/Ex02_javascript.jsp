<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 자바 변수는 자바스크립트에서 사용할 수 있다. --%>
	<% int a = 10; %>
	<script>
		alert(<%=a%>);  // 스크립트 내부에서 표현식으로 사용한다.
	</script>
		
	<%-- 자바스크립트 변수는 자바에서 사용할 수 없다. --%>

</body>
</html>