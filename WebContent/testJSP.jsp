<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page errorPage = "Error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	Cookie[] cookies = request.getCookies();
	Cookie loginInfo = null;
	
	if(cookies != null){
		for(Cookie c : cookies){
			if(c.getName().equals("loginInfo")){
				loginInfo = c;
			}
		}
	}
	%>
	
	<%
		if(loginInfo == null){
	%>
	<p>먼저 로그인을 하세요</p>
	<form action= "login" method ="post">
		<p>
			<strong>아이디</strong>
			<input type="text" name="id" value="아이디 입력">
		</p>
		<p>
			<strong>비밀번호</strong>
			<input type="password" name="pw" value="비밀번호 입력">
		</p>
		<p>
			<input type="submit" value="제출">
		</p>
	</form>
	
	<%
		}else{
	%>
	<p> 당신의 로그인 id <%= loginInfo.getValue()%> </p>
	<%
	}
	%>
</body>
</html>