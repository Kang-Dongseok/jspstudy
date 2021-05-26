<%@page import="dao.BoardDAO"%>
<%@page import="dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 파라미터 처리
	request.setCharacterEncoding("utf-8");

	String author = request.getParameter("author"); 
	String title = request.getParameter("title"); 
	String content = request.getParameter("content"); 
	
	// 2. DB로 보낼 DTO 생성
	BoardDTO dto = new BoardDTO();
	dto.setAuthor(author);
	dto.setTitle(title);
	dto.setContent(content);
	
	// 3. DAO의 insertBoard() 메소드 호출
	int result = BoardDAO.getInstance().insertBoard(dto);
	pageContext.setAttribute("result", result);  // EL사용을 위해
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${result eq 1}">
	<h1>새로운 게시글이 작성되었습니다.</h1>
	<a href="boardList.jsp">게시판으로 이동</a>
</c:if>
<c:if test="${result eq 0}">
	<h1>게시글이 저장되지 않았습니다.</h1>
	<a href="insertPage.jsp">다시 작성하기</a>
	<a href="boardList.jsp">게시판으로 이동</a>
</c:if>