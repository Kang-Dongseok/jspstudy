<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String agreement = request.getParameter("agreement");
	if (agreement.equals("yes")) {  // 동의함
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String filename = id + ".txt";
		String realPath = request.getServletContext().getRealPath("quiz/" + filename);
		BufferedWriter bw = new BufferedWriter(new FileWriter(realPath));
		bw.write("가입 아이디: " + id); bw.newLine();
		bw.write("가입 비밀번호: " + pw); bw.newLine();
		bw.write("가입 성명: " + name);
		bw.flush();
		if (bw != null) {
			bw.close();
		}
		// 가입이 끝나면 "시스템 변화"가 생긴 것으로 가정하고, 리다이렉트를 한다.
		// 이동할 때 생성된 파일명을 함께 전달한다.
		response.sendRedirect("/02_JSP/quiz/Quiz05_4.jsp?filename=" + filename);
	} else {  // 동의 안 함
		out.println("<h1>가입되지 않았습니다.</h1>");
		out.println("<a href=\"/02_JSP/quiz/Quiz05_1.jsp\">다시 가입하기</a>");
	}
%>