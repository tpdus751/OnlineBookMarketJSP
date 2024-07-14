<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="book.*"
	import="java.util.List"
    pageEncoding="UTF-8"%>
<%
	BookService service = new SYBookService(new OracleBookDAO());
	List<Book> bookList = service.listAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to SY BookMarket</title>
</head>
<body>

<% if (request.getParameter("order") != null) { %>
	<script>
		alert("주문을 완료하였습니다.")
	</script>
<% } %>

<%@ include file = "/common/header.jsp" %>

<h3>도서 목록</h3>
<% if (bookList.size() == 0) { %>
	<p>등록된 책이 없습니다.</p>
<% } else { %>
	<table border=1>
		<tr><th>아이디</th><th>제목</th><th>저자</th><th>출판사</th><th>가격</th><th>재고</th><th>등록일</th></tr>
		<% for (Book book : bookList) { %>
			<tr>
				<td><%= book.getId() %></td>
				<td><a href="<%= request.getContextPath() %>/book/detailPage.jsp?id=<%= book.getId() %>"><%= book.getTitle() %></a></td>
				<td><%= book.getAuthor() %></td>
				<td><%= book.getPublisher() %></td>
				<td><%= String.format("%d", book.getPrice()) %>원</td>
				<td><%= book.getInstock() %>권</td>
				<td><%= book.getRegDate() %></td>
			</tr>
		<% } %>
	</table>
<% } %>	

<%@ include file = "/common/footer.jsp" %>
</body>
</html>