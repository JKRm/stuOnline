<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/home.css">

  </head>
  
  <body>
  <div id="brief-info">
	  <h3>系统简介</h3>
  	  <div class="content">
  	    <p>
    	本系统包括试题库管理系统和门户网站两个主要部分，以员工在线学习在线培训为主体，辅以专题新闻、活动通知等功能。其中，在线学习和在线考核部分以智能化、人性化为设计主旨，如：科学的错题回顾，薄弱知识点、重难点攻克，智能阅卷等功能，都为本系统的使用者带来了极大的便利。
  	    </p>
  	  </div>
  </div>
  </body>
</html>
