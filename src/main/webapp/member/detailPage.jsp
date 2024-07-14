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
	if (noStr == null) {
		response.sendRedirect(request.getContextPath() + "/common/errorPage.jsp?detailError=1");
		return;
	}
	MemberService service = new SYMemberService(new OracleMemberDAO());
	Member member = service.read(Integer.parseInt(noStr));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 페이지</title>
</head>
<body>
<%@ include file = "/common/header.jsp" %>
<h3>회원 상세 정보</h3>
<%	if (member == null) {  %>
		<p>해당 회원 정보가 없습니다.</p>		
<%  } else { %>
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
		<% if (session.getAttribute("MemberId") != null) {%>
		<a href="modifyPage.jsp?no=<%= member.getNo() %>"><button>회원 정보 수정</button></a>
		<a href="removePage.jsp?no=<%= member.getNo() %>"><button>회원 탈퇴</button></a>
		<% } else {%>
		<a href="removePage.jsp?no=<%= member.getNo() %>"><button>회원 삭제</button></a>
		<% } %>
<% 	} %>
<%@ include file = "/common/footer.jsp" %>
</body>
</html>