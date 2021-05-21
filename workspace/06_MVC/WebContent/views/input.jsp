<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
	
		// 페이지 로드 이벤트
		$(document).ready(function(){
			const btn1 = $('#btn1');
			btn1.on('click', function(){
				location.href = '/06_MVC/date.do';
			})
			const btn2 = $('#btn2');
			btn2.on('click', function(){
				location.href = '/06_MVC/time.do';
			})
		})
	
	</script>
</head>
<body>

	<input type="button" value="현재 날짜를 알려다오" id="btn1"><br>
	<input type="button" value="지금 시간을 알려다오" id="btn2"><br>

</body>
</html>