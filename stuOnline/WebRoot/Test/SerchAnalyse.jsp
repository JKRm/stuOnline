<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.shanda.linglong.model.Test_answer"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SerchAnalyse.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%Test_answer ta=(Test_answer)request.getAttribute("testAnswer"); %>
    <P>总得分:<%=ta.getTa_score()%></P>
    <p>评价：<%=ta.getTa_analyse()%></p>
  </body>
</html>
