<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("MemberId") != null) {
		session.removeAttribute("MemberId");
		session.removeAttribute("MemberName");
		session.removeAttribute("MemberNo");
	} else if (session.getAttribute("AdminId") != null) {
		session.removeAttribute("AdminId");
		session.removeAttribute("AdminName");
	}
	
	response.sendRedirect(request.getContextPath() + "/index.jsp");
%>