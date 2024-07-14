<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
</head>
<body>
<%@ include file = "/common/header.jsp" %>
	<h3>회원 가입</h3>
<% 
	if (request.getParameter("joinError") != null) {
		out.println("회원 가입을 위해 아래의 정보를 모두 입력하세요.");
	}
%>
	<form action="join.jsp" method="post">
		<input type="text" name="id" placeholder="아이디 입력"><br>
		<input type="password" name="password" placeholder="비밀번호 입력"><br>
		<input type="text" name="nickname" placeholder="닉네임 입력"><br>
		<input type="text" name="mobile" placeholder="휴대폰 번호 입력"><br>
		<input type="text" name="email" placeholder="이메일 입력"><br>
		<input type="text" name="address" placeholder="주소 입력"><br>
		<br>
		<input type="submit" value="회원 가입">
		<a href="<%= request.getContextPath() %>/index.jsp"><input type="button" value="취소"></a>
	</form>
<%@ include file = "/common/footer.jsp" %>
</body>
</html>