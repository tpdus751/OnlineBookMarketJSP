<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="member.*"
    pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("MemberId") == null
		&& session.getAttribute("AdminId") == null) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
	}
%>
<%
	String noStr = request.getParameter("no");
	if (noStr == null || noStr.isEmpty()) {
		response.sendRedirect(request.getContextPath() + "/common/errorPage.jsp?removeError=1");
		return;
	}
	MemberService service = new SYMemberService(new OracleMemberDAO());
	Member member = service.read(Integer.parseInt(noStr));
	if (member == null) {
		response.sendRedirect(request.getContextPath() + "/common/errorPage.jsp?removeError=2");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴 페이지</title>
</head>
<body>
<%@ include file = "/common/header.jsp" %>
<h3>회원 탈퇴</h3>
	<ul>
		<li>회원번호 : <%= member.getNo() %></li>
		<li>아이디 : <%= member.getUserId() %></li>
		<li>닉네임 : <%= member.getNickname() %></li>
		<li>등록일 : <%= member.getRegdate() %></li>
		<li>휴대폰번호 : <%= member.getMobile() %></li>
		<li>이메일 : <%= member.getEmail() %></li>
		<li>주소 : <%= member.getAddress() %></li>
	</ul>
	<br>
	회원 탈퇴를 하시겠습니까
	<a href="remove.jsp?no=<%= member.getNo() %>"><button>삭제</button></a>
	<a href="detailPage.jsp?no=<%= member.getNo() %>"><button>취소</button></a>
<%@ include file = "/common/footer.jsp" %>
</body>
</html>