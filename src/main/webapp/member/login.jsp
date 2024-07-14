<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="member.*"
    pageEncoding="UTF-8"%>
<% 
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	if (id == null || password == null) {
		response.sendRedirect(request.getContextPath() + "/common/errorPage.jsp?loginError=1");
		return;
	}
	
	if (id.isEmpty() || password.isEmpty()) {
		response.sendRedirect(request.getContextPath() + "/member/loginPage.jsp?loginError=1");
		return;
	}
	
	final String adminId = "admin";
	final String adminPwd = "1234";
	final String adminName = "관리자";
	
	if (id.equals(adminId) && password.equals(adminPwd)) {
		session.setAttribute("AdminId", adminId);
		session.setAttribute("AdminName", adminName);
		response.sendRedirect(request.getContextPath() + "/admin/main.jsp");
	} else {
		MemberService service = new SYMemberService(new OracleMemberDAO());
		Member member = service.login(id, password);
		
		if (member != null) {
			// 로그인 성공
			session.setAttribute("MemberId", member.getUserId());
			session.setAttribute("MemberName", member.getNickname());
			session.setAttribute("MemberNo", member.getNo());
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/member/loginPage.jsp?loginError=1");
		}
	}
%>