<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import= "java.util.*" %>

<%@ page errorPage = "Error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

 <h3> Hello JSP </h3>
 
 <!-- html �ּ� -->
  
 <%-- jsp �ּ�  --%>

 <%-- ���� �±� --%>
  <%!
   String id = "";
   String pw = "";
   
   public void printId(){
	   System.out.println(id+" "+pw);
   }
  %>
 
  <%-- ��ũ��Ʈ�� �±� : jsp ������ �ȿ� �ڹ� �ڵ带 ���� ��Ű�� ���� �±� --%>
  <%
    id = config.getInitParameter("defaultId");
    pw = config.getInitParameter("defaultPw");
  
    application.setAttribute("name", "jinhwan");
    
    String inputID = "jinhwan";
    String inputPW = "1234";
    
    if(inputID.equals(id) && inputPW.equals(pw)){
  %>
    <p> login - success </p>
  <% 
    }else{
  %>
    <p> login - fail </p> 
  <%} %>
  
  
  <!-- ǥ���� �±� : html �ȿ��� jsp ���� ��� -->  
  
  <p> config _ default Id : <%= config.getInitParameter("defaultId") %> </p>
  <p> application _ default DIR : <%= application.getInitParameter("defaultDIR") %> </p>
  
  <p> application _ globalVar : <%= (String)getServletContext().getAttribute("name") %>
  
  <br><br><p>==============bottom File================</p> 
  <%@ include file = "bottom.jsp"%>

  <% out.print("<h3>hello</h3>"); %>
  
  <% throw new Exception(); %>
  
</body>
</html>