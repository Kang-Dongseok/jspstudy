<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		/***** 업로드 진행 *****/
		
		// 1. 파일이 업로드 될 디렉터리명을 변수로 저장한다.
		String directory = "archive";
	
		// 2. 파일이 업로드 될 디렉터리의 실제 경로를 변수로 저장한다.
		String realPath = request.getServletContext().getRealPath(directory);
		
		// 3. 디렉터리가 생성되지 않았다면 새로 생성한다.
		File dir = new File(realPath);
		if (!dir.exists()) {  // 디렉터리가 없다면
			dir.mkdirs();  // 디렉터리를 만든다.
		}
		
		// 4. 기존 request를 사용하지 않고, MultipartRequest 클래스 타입의 객체를 생성한다.
		//    객체를 만들면 업로드가 된다.
		MultipartRequest multipart = new MultipartRequest(
				request,   // 기존 request를 전달
				realPath,  // 업로드 될 경로 지정
				1024 * 1024 * 10,  // 10MB(최대 업로드 크기) (1024바이트 == 1KB, 1024KB == 1MB)
				"utf-8",  // 인코딩
				new DefaultFileRenamePolicy()  // 기본파일명변경정책 (동일한 파일을 업로드하면 원래 파일명에 숫자 추가)
				);
	%>

	<h3>파일 업로드 결과</h3>
	<ul>
		<li>업로드 경로: <%=realPath%></li>
		<%-- request를 사용할 수 있는가? No! --%>
		<li>업로더: <%=request.getParameter("uploader")%></li>
		<li>파일명: <%=request.getParameter("filename")%></li>
		<%-- request 대신 multipart를 사용한다. --%>
		<li>업로더: <%=multipart.getParameter("uploader")%></li>
		<li>올릴 때 파일명: <%=multipart.getOriginalFileName("filename")%></li>
		<li>저장된 파일명: <%=multipart.getFilesystemName("filename")%></li>
		<%
			// multipart 객체에 저장된 첨부 파일을 가져오는 메소드: getFile()
			// getFile() 메소드의 반환 타입은 File이다.
			File file = multipart.getFile("filename");
			String filename = file.getName();
			long size = file.length() / 1024;  // length() 메소드는 바이트를 반환하므로 1024로 나누어 KB로 저장
			String date = new SimpleDateFormat("yyyy-MM-dd a h:mm").format(file.lastModified());
		%>
		<li>저장된 파일명: <%=filename%></li>
		<li>파일 크기: <%=size%>KB</li>
		<li>수정한 날짜: <%=date%></li>
	</ul>

	<%-- 다운로드 링크 --%>
	<a href="/02_JSP/ex10_file/Ex03_download.jsp?directory=<%=directory%>&filename=<%=multipart.getOriginalFileName("filename")%>">다운로드</a>

</body>
</html>