<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		* {
			font-family: '돋움', sans-serif;
			font-size: 16px;
		}
		.container {
			width: 500px;
			margin: 100px auto;
		}
		input[type=text], textarea {
			width: 100%;
		}
		textarea {
			height: 100px;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(function(){
			const f = $('#f');
			const title = $('#title');
			const content = $('#content');
			f.submit(function(event){
				if (title.val() == '${boardDTO.title}' && content.val() == '${boardDTO.content}') {
					alert('수정할 내용이 없습니다.');
					event.preventDefault();
					return false;
				} else if (title.val() == '') {
					alert('제목은 필수입니다.');
					title.focus();
					event.preventDefault();
					return false;
				}
			})
		})
	</script>
</head>
<body>
	<div class="container">
		<form id="f" action="updateBoard.jsp" method="post">
			<h3>게시글 번호</h3>	
			${boardDTO.idx}<br>
			<h3>작성자</h3>
			${boardDTO.author}<br>
			<h3>제목</h3>
			<input type="text" name="title" id="title" value="${boardDTO.title}"><br>
			<h3>내용</h3>
			<textarea name="content" id="content">${boardDTO.content}</textarea><br><br>
			<button>수정하기</button>
			<input type="button" value="수정취소하기" onclick="history.back()">
		</form>
	</div>

</body>
</html>