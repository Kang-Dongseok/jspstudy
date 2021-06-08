<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>학생 추가하기</h1>
	<form action="/14_BATCH/insertStudent.do">
		<input type="text" name="sno" placeholder="학번" autofocus>&nbsp;
		<input type="text" name="name" placeholder="성명">&nbsp;
		<input type="text" name="kor" placeholder="국어">&nbsp;
		<input type="text" name="eng" placeholder="영어">&nbsp;
		<input type="text" name="mat" placeholder="수학">&nbsp;
		<button>등록</button>
	</form>
	<hr>
	<h1>학생 목록 보기</h1>
	<table border="1">
		<thead>
			<tr>
				<td>학번</td>
				<td>이름</td>
				<td>국어</td>
				<td>영어</td>
				<td>수학</td>
				<td>평균</td>
				<td>학점</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="7">학생이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="dto" items="${list}">
					<tr>
						<td>${dto.sno}</td>
						<td>${dto.name}</td>
						<td>${dto.kor}</td>
						<td>${dto.eng}</td>
						<td>${dto.mat}</td>
						<td>${dto.ave}</td>
						<td>${dto.grade}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>