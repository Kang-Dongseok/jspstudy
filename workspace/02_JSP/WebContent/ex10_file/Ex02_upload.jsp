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
	
		// 2. 파일이 업로드 될 디렉터리의 실제 경로
		String realPath = request.getServletContext().getRealPath(directory);
		
		// 3. 기존 request를 사용하지 않고, MultipartRequest 클래스 타입의 객체를 생성한다.
		//	    객체를 만들면 업로드가 된다.
		MultipartRequest multipart = new MultipartRequest(
				request,   // 기존 request를 전달
				realPath,  // 업로드 될 경로 지정
				1024 * 1024 * 10,  // 10MB(최대 업로드 크기) (1024바이트 == 1KB, 1024KB == 1MB)
				"utf-8",  // 인코딩
				new DefaultFileRenamePolicy()  // 기본 파일명변경정책 (동일한 파일을 업로드하면 원래 파일명에 숫자 추가)
				);
	%>
</body>
</html>