<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<%--
		EL 산술 연산자 특징
		1. 문자열, 숫자 모두 정상적으로 연산한다.
	
		EL 크기 비교 연산자 특징
		1. 문자열이 전달되면 "사전 편찬 순"으로 비교한다.
		2. 숫자가 전달되면 숫자의 크기를 비교한다.
		3. 문자열이 전달되는 경우를 대비해서 크기 비교는 아래와 같이 한다.
		   ${a > b} => ${a - b > 0}
		   ${a < b} => ${a - b < 0}
	--%>

	${a} + ${b} = ${a + b}<br>
	${a} - ${b} = ${a - b}<br>
	${a} * ${b} = ${a * b}<br>
	${a} / ${b} = ${a div b}<br>
	${a} % ${b} = ${a mod b}<br>
	
	${a} &gt; ${b} = ${a - b gt 0}<br>  <%-- ${a > b} --%>
	${a} &ge; ${b} = ${a - b ge 0}<br>  <%-- ${a >= b} --%>
	${a} &lt; ${b} = ${a - b lt 0}<br>  <%-- ${a < b} --%>
	${a} &le; ${b} = ${a - b le 0}<br>  <%-- ${a <= b} --%>
	${a} == ${b} = ${a eq b}<br>  <%-- ${a == b} --%>
	${a} != ${b} = ${a ne b}<br>  <%-- ${a != b} --%>
	
	${a} == null = ${empty a}<br>  <%-- empty : null, 크기가 0 --%>
	
	a와 b중 큰 값: ${a - b gt 0 ? a : b};

</body>
</html>