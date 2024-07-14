<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	if (session.getAttribute("MemberId") == null) {
		//response.sendRedirect(request.getContextPath() + "/common/errorPage.jsp?loginError=1");
		response.sendRedirect(request.getContextPath() + "/member/loginPage.jsp?loginError=1");
		return;
	}

	int memberNo = (Integer)session.getAttribute("MemberNo");
%>
