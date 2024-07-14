<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="book.*"
	import="java.util.List"
	import="cart.*"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/isLoggedIn.jsp" %>
<%
	String idStr = request.getParameter("id");
	String quanStr = request.getParameter("quantity");
	
	if (idStr == null || idStr.isEmpty() || quanStr == null || quanStr.isEmpty()) {
		response.sendRedirect(request.getContextPath() + "/common/errorPage.jsp?cartUpdateErr=1");
		return;
	}
	
	CartService service = new SYCartService(new HashMapCartDAO());
	BookService bookService = new SYBookService(new OracleBookDAO());
	CartItem item = service.readByBookId(Integer.parseInt(idStr), memberNo);
	Book book = bookService.detail(item.getBookId());
	if (Integer.parseInt(quanStr) > book.getInstock()) {
		response.sendRedirect(request.getContextPath() + "/cart/main.jsp?updateError=1");
	} else {
		if (service.update(Integer.parseInt(idStr), memberNo, Integer.parseInt(quanStr))) {
			response.sendRedirect(request.getContextPath() + "/cart/main.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/common/errorPage.jsp?cartUpdateErr=2");
		}
	}
	

%>
