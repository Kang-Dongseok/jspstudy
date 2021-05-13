<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String site = request.getParameter("site");
%>

<%-- 풀이1. 자바스크립트로 이동하기 --%>
<script>
	// location.href = '<%=site%>';
</script>


<%-- 풀이2. 리다이렉트로 이동하기 --%>
<%
	// site에는 전체 URL이 포함되어 있다.
	// redirect : 클라이언트에게 전체 URL을 응답하면 클라이언트가 다시 이동한다.
	response.sendRedirect(site);

	// 참고.
	// forward는 서버 내부 경로로 이동하기 때문에 전체 URL을 처리할 수 없다.
	// request.getRequestDispatcher(site).forward(request, response);
%>