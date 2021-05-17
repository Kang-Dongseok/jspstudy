<%@page import="ex09_session.MemberDTO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	// id/pw/name을 저장하고 있는 빈
	MemberDTO dto = new MemberDTO();
	dto.setId(id);
	dto.setPw(pw);
	switch (id) {
	case "admin": dto.setName("관리자"); break;
	case "superman": dto.setName("슈퍼맨"); break;
	case "bread": dto.setName("브레드"); break;
	}
	
	// DB대용 Map
	// Map은 key와 value의 조합으로 데이터를 저장한다.
	// key는 id, value는 pw를 사용한다.
	// Map<key, value>
	Map<String, String> db = new HashMap<String, String>();
	db.put("admin", "1234");
	db.put("superman", "1234");
	db.put("bread", "1234");
	
	boolean isMember = false;
	
	if (db.containsKey(dto.getId())) {  // 동일한 id 점검
		if (db.get(dto.getId()).equals(dto.getPw())) {  // 비밀번호 일치 점검
			isMember = true;
			session.setAttribute("loginDTO", dto);
		}
	}
	
	// 로그인 성공하면 mall로 이동, 실패하면 login으로 이동
	if (isMember) {
		response.sendRedirect("/02_JSP/ex09_session/Ex03_mall.jsp");
	} else {
		response.sendRedirect("/02_JSP/ex09_session/Ex03_login.jsp");
	}
	
%>