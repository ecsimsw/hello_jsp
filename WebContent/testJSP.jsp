<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import= "java.util.*" %>

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
   String id = "jinhwan";
   String pw = "1234";
   
   public void printId(){
	   System.out.println(id+" "+pw);
   }
  %>
 
  <%-- ��ũ��Ʈ�� �±� : jsp ������ �ȿ� �ڹ� �ڵ带 ���� ��Ű�� ���� �±� --%>
  <%
    String inputID = "jinhwan";
    String inputPW = "1234";
 
    List<String> list  = new ArrayList<>();
    
    if(inputID.equals(id) && inputPW.equals(pw)){
  %>
    <p> login - success </p>
  <% 
    }else{
  %>
    <p> login - fail </p> 
  <%} %>
  
  <!-- ǥ���� �±� : html �ȿ��� jsp ���� ��� -->  
  <p> id : <%= inputID %> </p>
  
  <%@ include file = "bottom.jsp"%>

</body>
</html>