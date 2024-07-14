<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="book.*"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/isAdminLogged.jsp" %>
<%
	String idStr = request.getParameter("id");
	if (idStr == null) {
		response.sendRedirect("main.jsp");
	} else {
		BookService service = new SYBookService(new OracleBookDAO());
		Book book = service.detail(Integer.parseInt(idStr));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 삭제</title>
</head>
<body>
<%@ include file = "/common/header.jsp" %>
<h3>도서 삭제</h3>
	<% if (book == null) { %>
		<p>도서 정보가 없습니다.</p>
	<% } else { %>
		<ul>
			<li>아이디 : <%= book.getId() %></li>
			<li>제목 : <%= book.getTitle() %></li>
			<li>저자 : <%= book.getAuthor() %></li>
			<li>출판사 : <%= book.getPublisher() %></li>
			<li>가격 : <%= book.getPrice() %></li>
			<li>재고 : <%= book.getInstock() %></li>
			<li>등록일 : <%= book.getRegDate() %></li>
		</ul>
		<br>
		도서 정보를 삭제하시겠습니까?
		<a href="remove.jsp?id=<%= book.getId() %>"><button>삭제</button></a>
		<a href="detailPage.jsp?id=<%= book.getId() %>"><button>취소</button></a>
		
	<% } %>
<%@ include file = "/common/footer.jsp" %>
</body>
</html>
<% } %>