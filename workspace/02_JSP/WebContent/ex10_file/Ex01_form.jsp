<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		파일 업로드
		
		1. cos.jar 라이브러리를 추가한다.
		   1) servlets.com에서 다운로드 받는다.
		   2) WEB-INF/lib 디렉터리에 추가한다.
		2. 기존 request 대신 MultipartRequest 클래스를 이용한 객체를 사용한다.
		3. 업로드가 가능한 <form> 태그 속성을 사용한다.
		   <form method="post" enctype="multipart/form-data">
		4. 파일이 업로드 될 디렉터리를 웹 컴포넌트들의 루트 디렉터리인 WebContent
		   디렉터리의 하위에 만든다. (archive) : 디렉터리명은 자유
	--%>

	<h3>파일 첨부를 할 수 있는 폼</h3>
	<form action="/02_JSP/ex10_file/Ex02_upload.jsp"
	      method="post"
	      enctype="multipart/form-data">
	
		업로더 <input type="text" name="uploader"><br><br>
		<input type="file" name="filename"><br><br>
		<button>파일첨부하기</button>
	
	</form>

</body>
</html>