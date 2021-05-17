<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>이미지 게시판</h3>
	<form action="/02_JSP/ex10_file/Ex05_board_upload.jsp"
	      method="post"
	      enctype="multipart/form-data">
	
		<input type="text" name="title" placeholder="제목"><br>
		<input type="text" name="writer" placeholder="작성자"><br>
		<input type="file" name="filename"><br><br>
		<button>게시하기</button>
	
	</form>

</body>
</html>