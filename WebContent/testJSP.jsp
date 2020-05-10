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
 
 <!-- html 주석 -->
  
 <%-- jsp 주석  --%>

 <%-- 선언 태그 --%>
  <%!
   String id = "jinhwan";
   String pw = "1234";
   
   public void printId(){
	   System.out.println(id+" "+pw);
   }
  %>
 
  <%-- 스크립트립 태그 : jsp 페이지 안에 자바 코드를 포함 시키기 위한 태그 --%>
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
  
  <!-- 표현식 태그 : html 안에서 jsp 변수 사용 -->  
  <p> id : <%= inputID %> </p>
  
  <%@ include file = "bottom.jsp"%>

</body>
</html>