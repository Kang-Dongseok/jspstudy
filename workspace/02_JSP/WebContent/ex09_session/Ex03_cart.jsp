<%@page import="ex09_session.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
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
		ArrayList<ProductDTO> cart = (ArrayList<ProductDTO>)session.getAttribute("cart");
		String message = "";
		if (cart == null) {
			message += "장바구니가 비었습니다.";
		} else {
			for (ProductDTO dto : cart) {
				message += dto.getProduct() + "__________" + dto.getQuantity() + "<br>";
			}
		}
	%>
	<h3>장바구니 목록</h3>
	<%=message%>
	<br><br>
	<input type="button" value="계속쇼핑하기" onclick="fn1()">
	<input type="button" value="장바구니비우기" onclick="fn2()">
	<script>
		function fn1() {
			location.href = '/02_JSP/ex09_session/Ex03_mall.jsp';
		}
		function fn2() {
			location.href = '/02_JSP/ex09_session/Ex03_deleteCart.jsp';
		}
	</script>
</body>
</html>