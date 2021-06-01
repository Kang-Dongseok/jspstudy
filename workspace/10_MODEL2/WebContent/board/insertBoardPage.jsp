<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="../layout/header.jsp">
	<jsp:param value="게시글 작성" name="title" />
</jsp:include>

<link rel="stylesheet" href="../assets/css/layout.css">
<style>
	.insert_form {
		width: 600px;
		margin: 0 auto;
	}
	input[type=text] {
		padding: 5px;
		width: 100%;
		height: 50px;
	}
	textarea {
		padding: 5px;
		width: 100%;
		height: 200px;
	}
	.btns {
		margin: 0 auto;
		width: 500px;
		text-align: center;
	}
	.btn {
		width: 150px;
		height: 40px;
		line-height: 40px;
		background: orange;
		border: none;
		outline: none;
	}
	.btn:hover {
		background: crimson;
		color: white;
		cursor: pointer;
	}
</style>
<script>
	$(document).ready(function(){
		
		const f = $('#f');
		const title = $('#title');
		const insert_btn = $('#insert_btn');
		insert_btn.click(function(){
			if (title.val() == '') {
				alert('제목은 필수입니다.');
				title.focus();
				return;
			}
			f.attr('action', '/10_MODEL2/insertBoard.b');
			f.submit();
		})
		
		const list_btn = $('#list_btn');
		list_btn.click(function(){
			location.href = '/10_MODEL2/selectListBoardPage.b';
		})
		
	})
</script>
<div class="insert_form">
	
	<form id="f" method="post" enctype="multipart/form-data">
		<p class="title">작성자</p>
		<input type="text" id="author" name="author" value="${loginDTO.id}" readonly><br><br>
		<p class="title">제목</p>
		<input type="text" id="title"  name="title" autofocus><br><br>
		<p class="title">첨부</p>
		<input type="file" id="filename" name="filename"><br><br>
		<p class="content">내용</p>
		<textarea id="content" name="content"></textarea><br><br>
		<input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>">
		<div class="btns">
			<input type="button" value="저장하기" class="btn" id="insert_btn">
			<input type="reset" value="작성초기화" class="btn" id="reset_btn">
			<input type="button" value="목록보기" class="btn" id="list_btn">
		</div>
	</form>
	
</div>

<%@ include file="../layout/footer.jsp" %>