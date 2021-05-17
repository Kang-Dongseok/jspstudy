<%@page import="java.io.FileWriter"%>
<%@page import="java.io.File"%>
<%@page import="java.io.BufferedWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 작성일자, 작성자, 제목, 내용, 작성IP --%>
<%
	request.setCharacterEncoding("utf-8");

	String date = request.getParameter("date");
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String contents = request.getParameter("contents");
	String ip = request.getHeader("X-Forwarded-For");
	if (ip == null) {
		ip = request.getRemoteAddr();
	}

	// 파일명 결정
	// "ip_writer.txt  ip를 구성하는 마침표(.)는 밑줄(_)로 바꿔서 처리
	String filename = ip.replaceAll("\\.", "_") + "_" + writer + ".txt";
	
	// 파일이 저장될 경로 (realPath 활용)
	String realPath = application.getRealPath("ex05/" + filename);
	
	// 파일 생성
	File file = new File(realPath);
	BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	bw.write("작성일자: " + date + "\n");
	bw.write("작성IP: " + ip + "\n");
	bw.write("작성자: " + writer + "\n");
	bw.write("제목: " + title + "\n");
	bw.write(contents);
	
	if (bw != null) {
		bw.close();
	}
	
	boolean isExist = file.exists();  // 파일이 정상적으로 생성되었다면 true 반환
	
%>
<script>
	if (<%=isExist%>) {
		alert('<%=filename%> 파일이 생성되었습니다.');
	} else {
		alert('파일이 생성되지 않았습니다.');
	}
	// 뒤로 갈 때 파라미터 전달이 안 된다.
	// history.back();
	location.href = '/02_JSP/ex05/Ex03_application1.jsp?state=visited';
</script>