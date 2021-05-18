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
		// Login.java가 넘겨준 request에서 캡차 이미지 경로와 파일명을 꺼낸다.
		request.setCharacterEncoding("utf-8");
		String DIR = (String)request.getAttribute("DIR");
		String filename = (String)request.getAttribute("filename");
	%>
	<h1>로그인</h1>
	<form action="/03_CAPTCHA/LoginValidation"
		  method="post">
	  	<input type="text" name="id" placeholder="아이디"><br>
	  	<input type="password" name="pw" placeholder="비밀번호"><br>
	  	<p>자동가입 방지문자</p>
	  	<img src="<%=DIR%>/<%=filename%>" style="width: 200px;">
	  	<input type="button" value="새로고침" id="refresh_btn"><br>
	  	<input type="text" name="user_key" placeholder="입력하세요">
	  	<button>로그인</button>
	</form>
	<script>
		document.getElementById('refresh_btn').addEventListener('click', function(){
			location.href = '/03_CAPTCHA/Login';
		})
	</script>
</body>
</html>