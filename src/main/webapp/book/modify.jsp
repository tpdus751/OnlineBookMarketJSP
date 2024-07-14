<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="book.*"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/isAdminLogged.jsp" %>
<%
 	String idStr = request.getParameter("id");
	String title = request.getParameter("title");
	String author = request.getParameter("author");
	String publisher = request.getParameter("publisher");
	String priceStr = request.getParameter("price");
	String instockStr = request.getParameter("instock");
	
	//****** 이상함 priceStr과 instockStr을 null로 확인 문제가 생김
		if (idStr == null) {
			response.sendRedirect("main.jsp");
		}
		else if (title == null || author == null || publisher == null || priceStr == "" || instockStr == "") {
			response.sendRedirect("modifyPage.jsp");
		} else {
			BookService service = new SYBookService(new OracleBookDAO());
			Book book = service.detail(Integer.parseInt(idStr));
			if (book == null) {
				response.sendRedirect("main.jsp");
			} else {
				book.setTitle(title);
				book.setAuthor(author);
				book.setPublisher(publisher);
				book.setPrice(Integer.parseInt(priceStr));
				book.setInstock(Integer.parseInt(instockStr));
				if (service.edit(book)) {
					response.sendRedirect("main.jsp");
				} else {
					response.sendRedirect("modifyPage.jsp");
				}
			}
		}
		
	%>
