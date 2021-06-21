<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			$('#delete_btn').click(function(){
				if (confirm('게시글을 삭제할까요?')) {
					location.href = 'deleteBoard.do?no=${board.no}';
				}
			})
			
			$('#list_btn').click(function(){
				location.href = 'selectBoardList.do';
			})
		})
	</script>
</head>
<body>
	<h1>${board.no}번 게시글</h1>
	작성자: ${board.author}<br>
	작성일: ${board.postdate}<br>
	작성IP: ${board.ip}<br>
	조회수: ${board.hit}<br>
	제목: ${board.title}<br>
	내용<br>
	${board.content}<br>
	<input type="button" value="삭제하기" id="delete_btn">
	<input type="button" value="목록보기" id="list_btn">
	<hr>
	<form action="insertReply.do" method="post">
		<textarea rows="2" cols="20" name="content"></textarea><br>
		<input type="text" name="author">
		<input type="hidden" name="no" value="${board.no}">
		<button>작성</button>
	</form>
	<table border="1">
		<tbody>
			<c:if test="${empty replyList}">
				<tr>
					<td colspan="4">작성된 댓글이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty replyList}">
				<c:forEach var="reply" items="${replyList}">
					<tr>
						<td>${reply.content}</td>
						<td>${reply.author}</td>				
						<td>${reply.ip}</td>
						<td>${reply.postdate}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>