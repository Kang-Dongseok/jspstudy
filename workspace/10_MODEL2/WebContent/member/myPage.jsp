<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="../layout/header.jsp">
	<jsp:param value="마이페이지" name="title" />
</jsp:include>

<link rel="stylesheet" href="../assets/css/layout.css">
<style>
	.my_form {
		width: 300px;
		margin: 0 auto;
	}
	#f input:not([type=button]) {
		padding: 5px;
		width: 100%;
		height: 50px;
	}
	#f input[type=button] {
		width: 100%;
		height: 50px;
		line-height: 50px;
		background-color: orange;
		border: none;
		font-size: 18px;
	}
	#f input[type=button]:hover {
		cursor: pointer;
	}
	.title {
		font-weight: 700;
		font-size: 14px;
	}
</style>
<script>
	$(document).ready(function(){
		const pw_btn = $('#pw_btn');
		pw_btn.click(function(){
			location.href = '/10_MODEL2/updatePwPage.m';
		})
		const update_btn = $('#update_btn');
		const name = $('#name');
		const email = $('#email');
		const f = $('#f');
		update_btn.click(function(){
			if (name.val() == '${loginDTO.name}' && email.val() == '${loginDTO.email}') {
				alert('변경할 정보가 없습니다.');
				return;
			}
			f.attr('action', '/10_MODEL2/updateMember.m');
			f.submit();
		})
		
		const delete_btn = $('#delete_btn');
		delete_btn.click(function(){
			if (confirm('탈퇴하시겠습니까?')) {
				location.href = '/10_MODEL2/deleteMember.m';
			}
		})
		
	})
</script>

<div class="my_form">
	<form id="f" method="post">
		<%-- 아이디 --%>
		<span class="title">아이디</span><br>
		${loginDTO.id}<br><br>
		<%-- 비밀번호 --%>
		<span class="title">비밀번호 변경</span><br>
		<input type="button" value="비밀번호 변경하기" id="pw_btn"><br><br>
		<%-- 이름 --%>
		<span class="title">이름</span><br>
		<input type="text" id="name" name="name" value="${loginDTO.name}"><br><br>
		<%-- 이메일 --%>
		<span class="title">이메일</span><br>
		<input type="text" id="email" name="email" value="${loginDTO.email}"><br><br>
		<input type="button" value="회원정보수정" id="update_btn"><br><br>
		<input type="button" value="회원탈퇴" id="delete_btn">
	</form>
</div>

<%@ include file="../layout/footer.jsp" %>