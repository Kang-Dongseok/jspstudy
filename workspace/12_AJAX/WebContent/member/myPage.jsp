<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			// 이벤트
			$('#update_pw_btn').click(function(){
				updatePw();
			})
			$('#update_member_btn').click(function(){
				updateMember();
			})
			$('#delete_member_btn').click(function(){
				deleteMember();
			})
			// 함수
			function updatePw() {
				if ('${loginUser.pw}' != $('#pw0').val()) {
					alert('현재 비밀번호를 확인하세요.');
					return;
				} else if ('${loginUser.pw}' == $('#pw').val()) {
					alert('현재 비밀번호와 동일한 비밀번호입니다.');
					return;
				} else if ($('#pw').val() == '') {  // 비밀번호 정규식으로 변경
					alert('새 비밀번호를 확인하세요.');
					return;
				} else if ($('#pw').val() != $('#pw1').val()) {
					alert('비밀번호를 확인하세요.');
					return;
				}
				$.ajax({
					url: '/12_AJAX/updatePw.do',
					type: 'post',
					data: $('#my_form').serialize(),
					dataType: 'json',
					success: function(obj){
						if (obj.result == 1) {
							alert('비밀번호가 변경되었습니다.');
							$('#pw0').val('');
							$('#pw').val('');
							$('#pw1').val('');
						} else {
							alert('비밀번호가 변경되지 않았습니다.');
						}
					},
					error: function(){
						alert('비밀번호 변경 과정에 오류가 발생했습니다.');
					}
				})
			}
			function updateMember(){
				$.ajax({
					url: '/12_AJAX/updateMember.do',
					type: 'post',
					data: $('#my_form').serialize(),
					dataType: 'json',
					success: function(obj){
						if (obj.result == 1) {
							alert('회원정보가 변경되었습니다.');
						} else {
							alert('회원정보가 변경되지 않았습니다.');
						}
					},
					error: function(xhr, status, error){
						console.log(status + ", " + error);
						alert('회원정보 변경 과정에 오류가 발생했습니다.');
					}
				})
			}
			function deleteMember() {
				if (!confirm('탈퇴하시겠습니까?')) {
					return;
				}
				$.ajax({
					url: '/12_AJAX/deleteMember.do',
					type: 'post',
					data: 'no=${loginUser.no}',
					dataType: 'json',
					success: function(obj){
						if (obj.result == 1) {
							alert('탈퇴되었습니다. 이용해 주셔서 감사합니다.');
							location.href = '/12_AJAX/loginPage.do';
						} else {
							alert('탈퇴되지 않았습니다.');
						}
					},
					error: function(xhr, status, error) {
						console.log(status + ": " + error);
						alert('회원 탈퇴 중 오류가 발생했습니다.');
					}
				})
			}
		})  // 페이지 로드
		
	</script>
</head>
<body>

	<form id="my_form">
	
		${loginUser.name}님 반갑습니다. <a href="/12_AJAX/logout.do">로그아웃</a>
		
		<br><br>
		
		아이디<br>
		${loginUser.id}<br><br>
		
		현재 비밀번호<br>
		<input type="password" name="pw0" id="pw0"><br>
		새 비밀번호<br>
		<input type="password" name="pw" id="pw"><br>
		비밀번호 확인<br>
		<input type="password" name="pw1" id="pw1">
		<input type="button" value="비밀번호 변경하기" id="update_pw_btn"><br><br>
		
		이름<br>
		<input type="text" name="name" id="name" value="${loginUser.name}"><br><br>
		
		이메일<br>
		<input type="text" name="email" id="email" value="${loginUser.email}"><br><br>
		
		연락처<br>
		<input type="text" name="phone" id="phone" value="${loginUser.phone}"><br><br>
		
		가입일시<br>
		${loginUser.regdate}<br><br>
		
		<input type="hidden" name="no" value="${loginUser.no}">
	
		<input type="button" value="수정하기" id="update_member_btn">
		<input type="button" value="탈퇴하기" id="delete_member_btn">
	
	</form>

</body>
</html>