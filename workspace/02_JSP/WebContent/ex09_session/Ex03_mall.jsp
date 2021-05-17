<%@page import="ex09_session.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		if (session.getAttribute("loginDTO") != null) {
			MemberDTO loginDTO = (MemberDTO)session.getAttribute("loginDTO");
			out.println("<h3>" + loginDTO.getName() + "님 환영합니다.");
		}
	%>
	<form action="/02_JSP/ex09_session/Ex03_addCart.jsp">
		<h3>상품 선택</h3>
		<select name="product">
			<option value="냉장고">냉장고</option>
			<option value="세탁기">세탁기</option>
			<option value="건조기">건조기</option>
		</select>
		<input type="text" name="quantity" size="3">개
		<button>장바구니에 담기</button>
	</form>
</body>
</html>