<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <a href="<%= request.getContextPath() %>/index.jsp"><button>Home</button></a>
    
<% if (session.getAttribute("MemberId") != null) { %> <!-- 즉 로그인했다. -->
	<a href="<%= request.getContextPath() %>/member/logout.jsp"><button>로그아웃</button></a>
	<a href="<%= request.getContextPath() %>/member/detailPage.jsp?no=<%= (Integer)session.getAttribute("MemberNo") %>"><button>마이페이지</button></a>
	<a href="<%= request.getContextPath() %>/cart/main.jsp"><button>장바구니</button></a>
<% } else if (session.getAttribute("AdminId") != null) { %>
	<a href="<%= request.getContextPath() %>/admin/main.jsp"><button>관리자 Home</button></a>
	<a href="<%= request.getContextPath() %>/member/logout.jsp"><button>로그아웃</button></a>
<% } else { %>
	<a href="<%= request.getContextPath() %>/member/loginPage.jsp"><button>로그인</button></a>
	<a href="<%= request.getContextPath() %>/member/joinPage.jsp"><button>회원가입</button></a>
<% } %>

<h2>세연 온라인 서점</h2>
<hr>