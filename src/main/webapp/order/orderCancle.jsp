<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="cart.*"
	import="member.*"
	import="book.*"
	import="java.util.List"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/isLoggedIn.jsp" %>
<%
	CartService cartService = new SYCartService(new HashMapCartDAO());
	BookService bookService = new SYBookService(new OracleBookDAO());
	MemberService memberService = new SYMemberService(new OracleMemberDAO());
	
	List<CartItem> itemList = cartService.listAll(memberNo);

	int numItems = 0, totalPrice = 0, i = 0;
	for (CartItem item : itemList) { 
		Book book = bookService.detail(item.getBookId());
		book.setInstock(book.getInstock() + item.getQuantity());
		bookService.edit(book);
	}
	
	response.sendRedirect(request.getContextPath() + "/cart/main.jsp");
%>