<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="../layout/header.jsp">
	<jsp:param value="비밀번호변경" name="title" />
</jsp:include>

<link rel="stylesheet" href="../assets/css/layout.css">
<style>
	.pw_form {
		width: 300px;
		margin: 0 auto;
	}
	#f input:not([type=button]) {
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
	.title {
		font-weight: 700;
		font-size: 14px;
	}
</style>
<script>
	$(document).ready(function(){
		const f = $('#f');
		const pw0 = $('#pw0');
		const pw0_message = $('#pw0_message');
		const pw = $('#pw');
		const pw_message = $('#pw_message');
		const pw1 = $('#pw1');
		const pw1_message = $('#pw1_message');
		f.submit(function(event){
			pw0_message.text('');
			pw_message.text('');
			pw1_message.text('');
			if (pw0.val() != '${loginDTO.pw}') {
				pw0_message.text('현재 비밀번호가 일치하지 않습니다.');
				pw0.focus();
				event.preventDefault();
				return false;
			} else if (pw.val() == '') {  // 공백검사 대신 정규식 검사로 수정
				pw_message.text('새 비밀번호를 입력하세요.');
				pw.focus();
				event.preventDefault();
				return false;
			} else if (pw.val() != pw1.val()) {
				pw1_message.text('비밀번호 입력을 확인하세요.');
				event.preventDefault();
				return false;
			}
		})
	})
</script>

<div class="pw_form">
	<form action="/10_MODEL2/updatePw.m" id="f" method="post">
		<%-- 현재 비밀번호 --%>
		<span class="title">현재 비밀번호</span><br>
		<input type="password" name="pw0" id="pw0"><br>
		<span class="message" id="pw0_message"></span><br>
		<%-- 새 비밀번호 --%>
		<span class="title">새 비밀번호</span><br>
		<input type="password" name="pw" id="pw"><br>
		<span class="message" id="pw_message"></span><br>
		<%-- 비밀번호 확인 --%>
		<span class="title">비밀번호 확인</span><br>
		<input type="password" name="pw1" id="pw1"><br>
		<span class="message" id="pw1_message"></span><br>
		<button>비밀번호변경하기</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp" %>