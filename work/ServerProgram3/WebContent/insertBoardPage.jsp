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
			$('#insert_btn').click(function(){
				$('#f').attr('action', 'insertBoard.do');
				$('#f').submit();
			})
			
			$('#list_btn').click(function(){
				location.href = 'selectBoardList.do';
			})
		})
	</script>
</head>
<body>
	<h1>게시글 작성하기</h1>
	<form id="f">
		작성자<br><br>
		<input type="text" name="author"><br><br>
		제목<br><br>
		<input type="text" name="title"><br><br>
		내용<br><br>
		<textarea rows="5" cols="23" name="content"></textarea><br>
		<input type="button" value="저장하기" id="insert_btn">
		<input type="reset" value="작성초기화">
		<input type="button" value="목록보기" id="list_btn">
	</form>
</body>
</html>