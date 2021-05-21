<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		onload = function(){
			document.getElementById('btn1').onclick = function(){
				location.href = '/05_MVC/DateController';
			}
			document.getElementById('btn2').onclick = function(){
				location.href = '/05_MVC/TimeController';
			}
			document.getElementById('btn3').onclick = function(){
				location.href = '/05_MVC/LottoController';
			}
		}
	</script>
</head>
<body>
	
	<%-- VIEW : 언제나 Servlet(Controller)에게 요청한다. --%>
	<input type="button" value="현재 날짜를 알려다오" id="btn1">
	
	<input type="button" value="지금 시간을 알려다오" id="btn2">
	
	<input type="button" value="로또 번호 6개를 알려다오" id="btn3">

	<form action="/05_MVC/GugudanController">
		<input type="number" min="2" max="9" name="dan" placeholder="원하는 구구단 입력">
		<button>구구단을 보여다오</button>
	</form>

	<a href="/05_MVC/AgeController?age=50">맥주 하나 주이소!</a>
	
	<form id="f">
		<input type="text" name="hour" placeholder="지금 시간을 입력하세요">
		<input type="button" value="밥 주세요" id="btn4">
	</form>
	<script>
		const form = document.getElementById('f');  // const form = $('#f');
		document.getElementById('btn4').addEventListener('click', function(){
			if (form.hour.value == '') {
				alert('지금 시간을 꼭 입력하세요');
				form.hour.focus();
				return;
			}
			form.action = '/05_MVC/MealController';
			form.submit();
		})
	</script>

</body>
</html>