<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %> 
<% 
String rand = (String)session.getAttribute("rand"); 
String input = request.getParameter("rand2"); 

if(rand.equals(input)){ 
out.print("<script>alert('验证通过！');</script>"); 
} else{ 
out.print("<script>alert('请输入正确的验证码！');location.href='login.jsp';</script>"); 
} 
%> 

