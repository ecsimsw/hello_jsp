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
	<p>���� �α����� �ϼ���</p>
	<form action= "login" method ="post">
		<p>
			<strong>���̵�</strong>
			<input type="text" name="id" value="���̵� �Է�">
		</p>
		<p>
			<strong>��й�ȣ</strong>
			<input type="password" name="pw" value="��й�ȣ �Է�">
		</p>
		<p>
			<input type="submit" value="����">
		</p>
	</form>
	
	<%
		}else{
	%>
	<p> ����� �α��� id <%= loginInfo.getValue()%> </p>
	<%
	}
	%>
</body>
</html>