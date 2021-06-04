<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.link {
			color: blue;
			font-size: 8px;
			text-decoration: none;
		}
		.link:hover {
			cursor: pointer;
		}
		.insert_reply {
			display: none;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			// '답글'을 클릭하면 아래 insert_reply 클래스가 toggle된다.
			/*
				<tr>
					<td>
						<a class="link">답글</a>
					</td>
				</tr>
				<tr class="insert_reply">
				</tr>
			*/
			const links = $('.link');
			// links.click(); links가 배열이므로 불가, 배열은 each문(for문)
			// $.each(배열, function(인덱스, 요소){})
			$.each(links, function(i, link){
				$(link).click(function(){  // $(link) == <a class="link">답글</a>
					// $(this) == $(link)
					$(this).parent().parent().next().toggleClass('insert_reply');
					// $(this).parents().parents().next().toggleClass('insert_reply');
				})
			})
		})
	</script>
</head>
<body>
	<a href="/11_MYBATIS/insertPage.do">새글작성</a>
	<br><br><br>
	
	<form action="/11_MYBATIS/findList.do">
		<select name="column">
			<option value="TITLE">내용</option>
			<option value="AUTHOR">작성자</option>
			<option value="BOTH">내용+작성자</option>
		</select>
		<input type="text" name="query">
		<button>검색</button>
		<input type="button" value="전체" onclick="location.href='/11_MYBATIS/selectList.do'">
	</form>
	<br>
	
	전체 게시글: ${totalRecord}개<br>
	<table border="1">
		<thead>
			<tr>
				<td>순번</td>
				<td>제목</td>
				<td>작성자</td>
				<td>최종수정일</td>
				<td>조회수</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="5">작성된 게시글이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="dto" items="${list}" varStatus="k">
					<tr>
						<td>${seq - k.index}</td>
						<td>
							<c:if test="${dto.state == 0}">
								<c:if test="${dto.depth == 1}">
									&nbsp;&nbsp;[re]
								</c:if>
								${dto.title} 
								<c:if test="${dto.depth == 0}">
									<a class="link">답글</a>
								</c:if>
								<%--
								<c:if test="${loginDTO.id == dto.author}">
									<a href="">삭제</a>
								</c:if>
								--%>
								<a href="/11_MYBATIS/delete.do?no=${dto.no}">삭제</a>
							</c:if>
							<c:if test="${dto.state == -1}">
								삭제된 게시글입니다.
							</c:if>
						</td>
						<td>${dto.author}</td>
						<td>${dto.lastmodified}</td>
						<td>${dto.hit}</td>
					</tr>
					<tr class="insert_reply">
						<form action="/11_MYBATIS/insertReply2.do">
							<input type="hidden" name="groupno" value="${dto.groupno}">
							<td><input type="text" name="author" placeholder="작성자"></td>
							<td><input type="text" name="title" placeholder="제목"></td>
							<td><input type="text" name="content" placeholder="내용"></td>
							<td><button>작성</button></td>
							<td><input type="button" value="취소">
						</form>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">${paging}</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>