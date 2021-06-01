<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="../layout/header.jsp">
	<jsp:param value="게시판" name="title" />
</jsp:include>

<link rel="stylesheet" href="../assets/css/layout.css">
<style>
	.board_list {
		width: 600px;
		margin: 0 auto;
	}
	table {
		border-collapse: collapse;
	}
	td {
		border: 1px solid gray;
		padding: 5px;
		text-align: center;
	}
	td:nth-of-type(1) { width: 100px; }
	td:nth-of-type(2) { width: 200px; }
	td:nth-of-type(3) { width: 100px; }
	td:nth-of-type(4) { width: 100px; }
	td:nth-of-type(5) { width: 100px; }
</style>
<div class="board_list">
	
	<%-- 검색 기능 --%>
	<form action="/10_MODEL2/findBoard.b">
		<select name="column">
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
			<option value="AUTHOR">작성자</option>
		</select>
		<input type="text" name="query">
		<button>검색</button>
		<input type="button" value="전체목록보기" onclick="location.href='/10_MODEL2/selectListBoardPage.b'">
	</form><br><br>
	
	<%-- 로그인을 해야만 게시글을 작성할 수 있다. --%>
	<c:if test="${loginDTO != null}">
		<br>
		<input type="button" value="게시글 작성하기" onclick="location.href='/10_MODEL2/insertBoardPage.b'">
		<br><br>
	</c:if>
	
	<p>전체 : ${totalRecord}개 게시물</p>
	<table>
		<thead>
			<tr>
				<td>순번</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
				<td>최종수정일</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list}" varStatus="k">
				<c:if test="${dto.state == -1}">
					<tr>
						<td>${seq - k.index}</td>
						<td colspan="4">삭제된 게시글로 비공개 처리되었습니다.</td>
					</tr>
				</c:if>
				<c:if test="${dto.state == 0}">
					<tr>
						<td>${seq - k.index}</td>
						<td><a href="/10_MODEL2/selectOneBoard.b?idx=${dto.idx}">${dto.title}</a></td>
						<td>${dto.author}</td>
						<td>${dto.hit}</td>
						<td>${dto.lastmodified}</td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">
					${paging}
				</td>
			</tr>
		</tfoot>
	</table>
	
</div>

<%@ include file="../layout/footer.jsp" %>