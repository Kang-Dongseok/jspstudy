<%@page import="dto.PageVO"%>
<%@page import="dao.BoardDAO"%>
<%@page import="dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.container {
			width: 600px;
			margin: 100px auto;
		}
		table {
			border-collapse: collapse;
		}
		td {
			padding: 5px;
			border-top: 1px solid gray;
			border-bottom: 1px solid gray;
			text-align: center;
		}
		td:nth-of-type(1) { width: 100px; }
		td:nth-of-type(2) { width: 200px; }
		td:nth-of-type(3) { width: 100px; }
		td:nth-of-type(4) { width: 100px; }
		td:nth-of-type(5) { width: 100px; }
		
	</style>
</head>
<body>

	<div class="container">
		<a href="insertPage.jsp">새 글 작성하기</a><br>
		<a href="/09_MODEL1/index.jsp">인덱스로 가기</a>
		<br><hr><br>
		<%
			// session에 올라간 boardDTO 제거
			if (session.getAttribute("boardDTO") != null){
				session.removeAttribute("boardDTO");
			}
			/* Paging 처리*/
			// 1. PageVO 객체 생성
			PageVO pageVO = new PageVO(); 
			
			// 2. 전체 레코드의 개수 구하기
			int totalRecord = BoardDAO.getInstance().getTotalRecord();
			pageVO.setTotalRecord(totalRecord);
			
			// 3. 전체 페이지의 개수 구하기
			pageVO.setTotalPage();
			
			// 4. 파라미터 처리
			//    1) page가 안 넘어오면 page = 1로 처리
			//    2) page가 넘어오면 넘어온 page로 처리
			String strPage = request.getParameter("page");
			if (strPage != null) {
				pageVO.setPage(Integer.parseInt(strPage));
			}
			
			// 5. 현재 페이지 번호를 이용해 시작 게시글 번호와 종료 게시글 번호 구하기
			/****************** 예시********************
				1. 전체 11개 게시글이 있다.
				2. 한 페이지에 3개의 게시글을 표시한다.
				page = 1, beginRecord = 1,  endRecord = 3
				page = 2, beginRecord = 4,  endRecord = 6
				page = 3, beginRecord = 7,  endRecord = 9
				page = 4, beginRecord = 10, endRecord = 11
			*******************************************/
			// 시작게시글번호 = (현재페이지번호 - 1) * 페이지당레코드수 + 1
			int beginRecord = (pageVO.getPage() - 1) * pageVO.getRecordPerPage() + 1;
			pageVO.setBeginRecord(beginRecord);
			// 시작게시글번호 + 페이지당게시글수 - 1
			// 단, 종료게시글번호와 전체게시글수 중 작은 값을 종료게시글번호로 사용한다.
			int endRecord = beginRecord + pageVO.getRecordPerPage() - 1;
			endRecord = (endRecord < totalRecord) ? endRecord : totalRecord;
			pageVO.setEndRecord(endRecord);
			
			// 6. 블록당 시작페이지, 종료페이지 구하기
			/****************** 예시********************
				1. 전체 12개 페이지가 있다.
				2. 한 블록에 5개의 페이지를 표시한다.
				page = 1~5,   beginPage = 1,  endPage = 5
				page = 6~10,  beginPage = 6,  endPage = 10
				page = 11~15, beginPage = 11,  endPage = 12
			*******************************************/
			// 시작페이지번호 = ((현재페이지번호 - 1) / 블록당페이지수) * 블록당페이지수 + 1
			int beginPage = ((pageVO.getPage() - 1) / pageVO.getPagePerBlock()) * pageVO.getPagePerBlock() + 1;
			pageVO.setBeginPage(beginPage);
			// 종료페이지번호 = 시작페이지번호 + 블록당페이지수 - 1
			// 단 ,종료페이지번호와 전체페이지수 중 작은 값을 종료페이지번호로 사용한다.
			int endPage = beginPage + pageVO.getPagePerBlock() - 1;
			endPage = (endPage < pageVO.getTotalPage()) ? endPage : pageVO.getTotalPage();
			pageVO.setEndPage(endPage);
			/* paging 처리 끝 */
			
			
			// beginRecord ~ endRecord 사이의 목록만 가져오기
			List<BoardDTO> list = BoardDAO.getInstance().selectAll(pageVO);
			pageContext.setAttribute("list", list);
		%>
		<table>
			<thead>
				<tr>
					<td>게시글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>조회수</td>
					<td>작성일</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list}">
					<tr>
						<td>${dto.idx}</td>
						<td><a href="view.jsp?idx=${dto.idx}">${dto.title}</a></td>
						<td>${dto.author}</td>
						<td>${dto.hit}</td>
						<td>${dto.postdate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>