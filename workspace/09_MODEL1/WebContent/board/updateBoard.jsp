<%@page import="dao.BoardDAO"%>
<%@page import="dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 파라미터 처리
	request.setCharacterEncoding("utf-8");

	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	// 2. 수정할 게시글 번호
	long idx = ((BoardDTO)session.getAttribute("boardDTO")).getIdx();
	
	// 3. DB로 보낼 DTO 생성
	BoardDTO dto = new BoardDTO();
	dto.setIdx(idx);
	dto.setTitle(title);
	dto.setContent(content);
	
	// 4. DAO의 updateBoard() 메소드 실행
	int result = BoardDAO.getInstance().updateBoard(dto);
	pageContext.setAttribute("result", result);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${result eq 1}">
	<h1>게시글이 수정되었습니다.</h1>
</c:if>
<c:if test="${result eq 0}">
	<h1>게시글이 수정되지 않았습니다.</h1>
</c:if>
<a href="view.jsp?idx=<%=idx%>">게시글로 가기</a><br>
<a href="boardList.jsp">게시판으로 가기</a>