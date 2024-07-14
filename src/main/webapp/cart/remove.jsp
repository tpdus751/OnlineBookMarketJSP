<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="cart.*"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/isLoggedIn.jsp" %>
<%
	String idStr = request.getParameter("id");
	if (idStr == null || idStr.isEmpty()) {
		response.sendRedirect(request.getContextPath() + "/common/errorPage.jsp?cartIdErr=1");
		return;
	}
	
	CartService service = new SYCartService(new HashMapCartDAO());
	if (service.remove(Integer.parseInt(idStr), memberNo))
		response.sendRedirect(request.getContextPath() + "/cart/main.jsp");
	else
		response.sendRedirect(request.getContextPath() + "/common/errorPage.jsp?cartClearErr=1");
%>
