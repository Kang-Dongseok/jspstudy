<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	
	<%
		request.setCharacterEncoding("utf-8");
	
		String filename = request.getParameter("filename");
		String realPath = request.getServletContext().getRealPath("quiz/" + filename);
		BufferedReader br = new BufferedReader(new FileReader(realPath));
		String buffer = null;
		String message = "";
		while ((buffer = br.readLine()) != null) {
			message += buffer + "<br>";
		}
		if (br != null) {
			br.close();
		}
	%>
	
	<h1>가입되었습니다.</h1>
	<h3>가입내용</h3>
	<%=message%>
	<br><br>
	<form method="post">
		<input type="hidden" name="filename" value="<%=filename%>">
		<input type="button" value="탈퇴" onclick="fn(this.form)">
	</form>
	<script>
		function fn(f) {
			if (confirm('정말 탈퇴하시겠습니까?')) {
				f.action = '/02_JSP/quiz/Quiz05_5.jsp';
				f.submit();
			}
		}
	</script>

</body>
</html>