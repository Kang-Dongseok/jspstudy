<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="../layout/header.jsp">
	<jsp:param value="로그인" name="title" />
</jsp:include>

<link rel="stylesheet" href="../assets/css/layout.css">
<style>
	.login_form {
		width: 300px;
		margin: 50px auto;
	}
	#f input {
		padding: 5px;
		width: 100%;
		height: 50px;
	}
	#f button {
		width: 100%;
		height: 50px;
		line-height: 50px;
		background-color: orange;
		border: none;
		font-size: 18px;
	}
	#f button:hover {
		cursor: pointer;
	}
	.message {
		font-size: 12px;
		color: crimson;
	}
</style>
<script>
	$(document).ready(function(){
		const f = $('#f');
		const id = $('#id');
		const pw = $('#pw');
		const id_message = $('#id_message');
		const pw_message = $('#pw_message');
		f.submit(function(event){
			if (id.val() == '') {
				id_message.text('아이디를 입력하세요.');
				id.focus();
				event.preventDefault();
				return false;
			}
			else if (pw.val() == '') {
				id_message.text('');
				pw_message.text('비밀번호를 입력하세요.');
				pw.focus();
				event.preventDefault();
				return false;
			}
		})		
	})
</script>

<div class="login_form">
	<form action="/10_MODEL2/login.m" id="f" method="post">
		<input type="text" name="id" id="id" placeholder="ID"><br>
		<span class="message" id="id_message"></span><br>
		<input type="password" name="pw" id="pw" placeholder="Password"><br>
		<span class="message" id="pw_message"></span><br>
		<button>로그인</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp" %>