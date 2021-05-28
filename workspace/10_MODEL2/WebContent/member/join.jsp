<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="../layout/header.jsp">
	<jsp:param value="회원가입" name="title" />
</jsp:include>

<link rel="stylesheet" href="../assets/css/layout.css">
<style>
	.join_form {
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
		const pw2 = $('#pw2');
		const name = $('#name');
		const email = $('#email');
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

<div class="join_form">
	<form id="f" method="post">
		<%-- 아이디 --%>
		<span class="title">아이디</span><br>
		<input type="text" name="id" id="id">
		<span class="message" id="id_message"></span><br><br>
		<%-- 비밀번호 --%>
		<span class="title">비밀번호</span><br>
		<input type="password" name="pw" id="pw" placeholder="Password"><br>
		<span class="message" id="pw_message"></span><br>
		<%-- 비밀번호 확인 --%>
		<span class="title">비밀번호 확인</span><br>
		<input type="password" id="pw2"><br>
		<span class="message" id="pw2_message"></span><br>
		<%-- 이름 --%>
		<span class="title">이름</span><br>
		<input type="text" id="name" name="name"><br>
		<%-- 이메일 --%>
		<span class="title">이메일</span><br>
		<input type="text" id="email" name="email"><br>
		<span class="message" id="email_message"></span><br>
		<%-- 인증(캡차, SMS, 이메일) --%>
		<%-- 약관 동의 --%>
		<button>회원가입</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp" %>