<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="book.*"
	import="java.util.List"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/isAdminLogged.jsp" %>
<%
	BookService service = new SYBookService(new OracleBookDAO());
	List<Book> bookList = service.listAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리 메인 페이지</title>
<style>
	table {
		border-collapse : collapse;
		text-align : center;
	}
	td {
		padding : 5px;
	}
</style>
</head>
<body>
<%@ include file = "/common/header.jsp" %>
<h1>도서 관리</h1>
	<a href="registPage.jsp"><button>도서 등록</button></a>
	<h3>도서 목록</h3>
<% if (bookList.size() == 0) {%>
	<p>등록된 책이 없습니다.</p>
<% } else { %>
	<table border=1>
		<tr><th>아이디</th><th>제목</th><th>저자</th><th>출판사</th><th>가격</th><th>재고</th><th>등록일자</th><tr>
		<% for (Book book : bookList) { %>
			<tr>
				<td><%= book.getId() %></td>
				<td><a href="detailPage.jsp?id=<%= book.getId() %>"><%= book.getTitle() %></td>
				<td><%= book.getAuthor() %></td>
				<td><%= book.getPublisher() %></td>
				<td><%= book.getPrice() %></td>
				<td><%= book.getInstock() %></td>
				<td><%= book.getRegDate() %></td>
			</tr>
		<% } %>
	</table>
<% } %>
<%@ include file = "/common/footer.jsp" %>
</body>
</html>