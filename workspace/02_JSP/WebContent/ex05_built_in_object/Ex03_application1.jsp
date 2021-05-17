<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		onload = function(){
			const f = document.forms.insert_form;
			if ('<%=request.getParameter("state")%>' == 'visited') {
				f.writer.value = '';
				f.title.value = '';
				f.contents.value = '';
			}
			f.addEventListener('submit', function(event){
				if (f.writer.value == '') {
					alert('작성자를 입력하세요.');
					event.preventDefault();
					f.writer.focus();
					return false;
				} else if (f.title.value == '') {
					alert('제목을 입력하세요.');
					event.preventDefault();
					f.title.focus();
					return false;
				}
			})
		}
	</script>
</head>
<body>

	<h3>게시글 작성하기</h3>
	
	<form action="<%=application.getContextPath()%>/ex05/Ex03_application2.jsp"
	      name="insert_form">
	
		<input type="text" name="date" value="<%=new Date(System.currentTimeMillis())%>" placeholder="작성일자"><br>
		<input type="text" name="writer" placeholder="작성자"><br>
		<input type="text" name="title" placeholder="제목"><br>
		<textarea name="contents" rows="5" cols="23"></textarea><br><br>
		<button>작성하기</button>
		<input type="reset" value="작성취소">
	
	</form>

</body>
</html>