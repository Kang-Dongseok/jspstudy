<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="../layout/header.jsp">
	<jsp:param value="게시글 수정" name="title" />
</jsp:include>

<link rel="stylesheet" href="../assets/css/layout.css">
<style>
	.update_form {
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
		/*
		const f = $('#f');
		const title = $('#title');
		const content = $('#content');
		const filename = $('#filename');
		f.submit(function(event){
			let file = filename.val();
			file = file.substring(file.lastIndexOf('\\') + 1);
			if (title.val() == '${param.title}' &&
				content.val() == '${param.content}' &&
				file == '${param.filename}') {
				alert('수정할 내용이 없습니다.');
				event.preventDefault();
				return false;
			}
		})
		*/
		const list_btn = $('#list_btn');
		list_btn.click(function(){
			location.href = '/10_MODEL2/selectListBoardPage.b';
		})
		
	})
</script>
<div class="update_form">
	
	<form action="/10_MODEL2/updateBoard.b" id="f" method="post" enctype="multipart/form-data">
		<p class="title">제목</p>
		<input type="text" id="title" name="title" value="${param.title}"><br><br>
		<p class="title">첨부</p>
		<input type="file" id="filename" name="filename">&nbsp;&nbsp;&nbsp;
		<c:if test="${empty param.filename}">
			[기존 첨부파일: 없음]<br><br>
		</c:if>
		<c:if test="${not empty param.filename}">
			[기존 첨부파일: ${param.filename}]<br><br>
		</c:if>
		<p class="content">내용</p>
		<textarea id="content" name="content">${param.content}</textarea><br><br>
		<input type="hidden" name="idx" value="${param.idx}">
		<input type="hidden" name="filename2" value="${param.filename}">
		<div class="btns">
			<button class="btn">수정하기</button>
			<input type="reset" value="수정초기화" class="btn" id="reset_btn">
			<input type="button" value="목록보기" class="btn" id="list_btn">
		</div>
	</form>
	
</div>

<%@ include file="../layout/footer.jsp" %>