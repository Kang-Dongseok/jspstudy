<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<%-- request에 속성(attribute)으로 저장되면 아래와 같이 표현 --%>
	${name}
	
	<%-- request에 파라미터(parameter)로 저장되면 아래와 같이 표현 --%>
	${param.name}<br>
	${param.age}<br>
	${param.gender}<br>
	
	${paramValues.hobbies[0]}
	${paramValues.hobbies[1]}
	${paramValues.hobbies[2]}<br>
	
	${paramValues.tel[0]}-
	${paramValues.tel[1]}-
	${paramValues.tel[2]}
	
</body>
</html>