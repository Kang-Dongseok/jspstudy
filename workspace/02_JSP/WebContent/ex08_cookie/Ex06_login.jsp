<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.container {
			margin: 300px auto;
			width: 300px;
		}
		.blind {
			display: none;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
	
	<%
		// 쿠키명이 id인 쿠키를 찾는다.
		String id = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length != 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("id")) {
					id = cookie.getValue();
					break;
				}
			}
		}
	%>
	<script>
		$(document).ready(function(){
			if ('<%=id%>' != 'null') {
				$('#id').val('<%=id%>');
				$('#chk').attr('checked', true);
			}
		})
	</script>
	
	<div class="container">
		<form action="/02_JSP/ex08_cookie/Ex06_idCheck.jsp" method="post">
			<label for="id" class="blind">아이디</label>
			<input type="text" name="id" id="id" placeholder="아이디"><br>
			<label for="pw" class="blind">비밀번호</label>
			<input type="password" name="pw" id="pw" placeholder="●●●●"><br>
			<button>로그인</button><br><br>
			<input type="checkbox" name="chk" id="chk">
			<label for="chk">아이디 기억하기</label>
		</form>
	</div>
	
</body>
</html>