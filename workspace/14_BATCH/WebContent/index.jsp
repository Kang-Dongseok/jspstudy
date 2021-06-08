<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>잠시 후 학생관리로 이동합니다.</h1>
	<script>
		setTimeout(function(){
			location.href='/14_BATCH/selectStudentList.do'
		}, 3000);
	</script>
</body>
</html>