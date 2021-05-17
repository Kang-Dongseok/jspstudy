<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String directory = request.getParameter("directory");
	String filename = request.getParameter("filename");
	
	String realPath = request.getServletContext().getRealPath(directory);
	
	File file = new File(realPath, filename);
	
	// 응답 헤더
	// response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "utf-8"));
	// 파일명의 공백이 +로 처리되는데 이를 다시 공백으로 수정하려면 아래와 같이 처리한다.
	response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "utf-8").replaceAll("\\+", " "));
	response.setHeader("Content-Length", file.length() + "");
	response.setHeader("Content-Type", "application/x-msdownload");
	
	// JSP의 출력 스트림 : out
	// OutputStream 사용을 위해서 겹침 방지 처리
	out.clear();
	out = pageContext.pushBody();
	
	// 다운로드 (일종의 파일 복사 프로그램)
	// realPath의 filename -> response
	// 바이트 기반 입출력 스트림 사용
	BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	
	// 서버에 저장된 파일을 한 번에 읽을 수 있는 메모리 확보
	byte[] bytes = new byte[(int)file.length()];
	
	// realPath의 filename 읽어서 bytes 배열에 저장
	bis.read(bytes, 0, (int)file.length());
	
	// bytes 배열을 응답 처리
	bos.write(bytes, 0, (int)file.length());
	
	if (bos != null) {
		bos.close();
	}
	if (bis != null) {
		bis.close();
	}
	
%>