<%@page import="dao.MemberDAO"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 파라미터 처리
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	// 2. DB로 보낼 DTO 생성
	MemberDTO dto = new MemberDTO();
	dto.setName(name);
	dto.setEmail(email);
	dto.setNo( ((MemberDTO)session.getAttribute("loginDTO")).getNo() );
	
	// 3. DAO의 updateMember() 메소드 호출
	int result = MemberDAO.getInstance().updateMember(dto);
	
	// 4. 결과
	if (result > 0) {
		// session에 올라가 있는 loginDTO 갱신
		MemberDTO loginDTO = (MemberDTO)session.getAttribute("loginDTO");
		loginDTO.setName(name);
		loginDTO.setEmail(email);
		out.println("<script>");
		out.println("alert('회원 정보가 수정되었습니다.')");
		out.println("location.href='myPage.jsp'");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('회원 정보가 수정되지 않았습니다.')");
		out.println("history.back()");
		out.println("</script>");
	}
%>