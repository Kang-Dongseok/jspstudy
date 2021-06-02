<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="../layout/header.jsp">
	<jsp:param value="${dto.idx}번 게시글" name="title" />
</jsp:include>

<link rel="stylesheet" href="../assets/css/layout.css">
<style>
	.board_view {
		width: 100%;
		display: flex;
		justify-content: space-between;
	}
	.board_content {
		width: 40%;
	}
	.board_img {
		width: 55%;
	}
	.board_img > img {
		width: 100%;
	}
	.reply_form {
		width: 100%;
	}
	.reply_form textarea {
		width: 85%;
		height: 50px;
	}
	.reply_form button {
		width: 13%;
	}
</style>
<script>
	$(document).ready(function(){
		const delete_btn = $('#delete_btn');
		delete_btn.click(function(){
			if (confirm('삭제할까요?')) {
				location.href='/10_MODEL2/deleteBoard.b?idx=${dto.idx}';
			}
		})
	})
</script>
<div class="board_view">
	<div class="board_content">
		<p class="title">작성자</p>
		${dto.author}<br><br>
		<p class="title">작성자IP</p>
		${dto.ip}<br><br>
		<p class="title">최종수정일</p>
		${dto.lastmodified}<br><br>
		<p class="title">조회수</p>
		${dto.hit}<br><br>
		<p class="title">제목</p>
		${dto.title}<br><br>
		<p class="title">내용</p>
		<pre>${dto.content}</pre><br><br>	
	</div>
	<div class="board_img">
		<img src="/10_MODEL2/archive/${dto.filename}" alt="첨부파일 이미지">
	</div>
</div>
<div>
	<form action="/10_MODEL2/updateBoardPage.b" method="post">
		<input type="button" value="목록보기" onclick="location.href='${referer}'">
		<c:if test="${loginDTO.id == dto.author}">  <%-- 작성자만 볼 수 있다. --%>
			<input type="hidden" name="idx" value="${dto.idx}">
			<input type="hidden" name="title" value="${dto.title}">
			<input type="hidden" name="content" value="${dto.content}">
			<input type="hidden" name="filename" value="${dto.filename}">
			<button>수정하기</button>
			<input type="button" value="삭제하기" id="delete_btn">
		</c:if>
	</form>
</div>

<%-- 댓글 입력창 --%>
<div class="reply_form">
	<form action="/10_MODEL2/insertReply.b" method="post">
		<input type="hidden" name="boardIdx" value="${dto.idx}"> 
		<textarea name="content" placeholder="로그인을 하면 작성할 수 있습니다."></textarea>
		<c:if test="${loginDTO != null}">
			<button>작성하기</button>
		</c:if>
	</form>
</div>

<%-- 댓글 목록창 --%>
<div class="reply_list">
	댓글 ${replyCount}개<br>
	<table>
		<tbody>
			<c:forEach var="replyDTO" items="${replyList}">
				<tr>
					<td>${replyDTO.content}</td>
					<td>${replyDTO.author}</td>
					<td>${replyDTO.postdate}</td>
					<td>
						<c:if test="${loginDTO.id == replyDTO.author}">  <%-- 댓글의 작성자만 삭제할 수 있다. --%>
							<a href="/10_MODEL2/deleteReply.b?replyIdx=${replyDTO.idx}&idx=${replyDTO.boardIdx}">삭제</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>




<%@ include file="../layout/footer.jsp" %>