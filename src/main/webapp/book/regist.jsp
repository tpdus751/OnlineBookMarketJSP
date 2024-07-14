<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="book.*"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/isAdminLogged.jsp" %>
<%
	String title = request.getParameter("title");
	String author = request.getParameter("author");
	String publisher = request.getParameter("publisher");
	String priceStr = request.getParameter("price");
	String instockStr = request.getParameter("instock");
	
	if (title == null || author == null || publisher == null || priceStr == null || instockStr == null) {
		response.sendRedirect("registPage.jsp");
	} else {
		BookService service = new SYBookService(new OracleBookDAO());
		if (service.regist(new Book(title, author, publisher, Integer.parseInt(priceStr), Integer.parseInt(instockStr)))) {
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("registPage.jsp?error=1");
		}
	}
%>