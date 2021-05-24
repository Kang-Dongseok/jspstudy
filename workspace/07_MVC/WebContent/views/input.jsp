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
			const f = $('#f');
			const btn1 = $('#btn1');
			const btn2 = $('#btn2');
			const btn3 = $('#btn3');
			btn1.on('click', function(){
				f.attr('action', '/07_MVC/rectangle.do');
				f.submit();
			})
			btn2.on('click', function(){
				f.attr('action', '/07_MVC/triangle.do');
				f.submit();
			})
			btn3.on('click', function(){
				f.attr('action', '/07_MVC/circle.do');
				f.submit();
			})
		})
	</script>
</head>
<body>

	<form id="f">
		<h3>도형의 면적 구하기</h3>
		<input type="text" name="width" placeholder="너비 입력"><br>
		<input type="text" name="height" placeholder="높이 입력"><br>
		<input type="text" name="radius" placeholder="반지름 입력"><br>
		<input type="button" value="사각형 면적" id="btn1">
		<input type="button" value="삼각형 면적" id="btn2">
		<input type="button" value="원 면적" id="btn3">
		
	</form>
</body>
</html>