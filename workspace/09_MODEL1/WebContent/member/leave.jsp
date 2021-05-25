<%@page import="dao.MemberDAO"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 탈퇴할 회원 번호
	long no = ((MemberDTO)session.getAttribute("loginDTO")).getNo();

	// 2. DAO의 deleteMember() 메소드 호출
	int result = MemberDAO.getInstance().deleteMember(no);
	
	// 3. 결과
	if (result > 0) {
		// session의 loginDTO 제거
		session.invalidate();
		out.println("<script>");
		out.println("alert('탈퇴되었습니다. 이용해 주셔서 감사합니다.')");
		out.println("location.href='/09_MODEL1/index.jsp'");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('탈되되지 않았습니다.')");
		out.println("history.back()");
		out.println("</script>");
	}
%>