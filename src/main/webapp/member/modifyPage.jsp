<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="member.*"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/isLoggedIn.jsp" %>
<%
	String noStr = request.getParameter("no");
	if (noStr == null || noStr.isEmpty()) {
		response.sendRedirect(request.getContextPath() + "/common/errorPage.jsp?modifyError=1");
		return;
	}
	MemberService service = new SYMemberService(new OracleMemberDAO());
	Member member = service.read(Integer.parseInt(noStr));
	if (member == null) {
		response.sendRedirect(request.getContextPath() + "/common/errorPage.jsp?modifyError=2");
		return;
	}
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 페이지</title>
</head>
<body>
<%@ include file = "/common/header.jsp" %>
<h3>회원 정보 수정</h3>
	<form action="modify.jsp" method="post">
		<input type="hidden" name="no" value="<%= member.getNo() %>">
		<input type="text" name="id" value="<%= member.getUserId() %>" placeholder="아이디 입력" disabled><br>
		<input type="password" name="old_password" placeholder="기존 비밀번호 입력"><br>
		<input type="password" name="new_password" placeholder="새 비밀번호 입력"><br>
		<input type="text" name="nickname" value="<%= member.getNickname() %>" placeholder="닉네임 입력"><br>
		<br>
		<input type="submit" value="정보수정">
		<a href="detailPage.jsp?no=<%= member.getNo() %>"><input type="button" value="취소"></a>
	</form>
<%@ include file = "/common/footer.jsp" %>
</body>
</html>