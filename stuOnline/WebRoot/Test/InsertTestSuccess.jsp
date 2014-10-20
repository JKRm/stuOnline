<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    <link type="text/css" rel="stylesheet"
						href="<%=basePath%>css/admin.css" />
  </head>
  
  <body> 
  <div id="include-div">
    <p>操作成功</p>
    <p class="submitLine">
    	<input type="button" class="button" value="返回" onclick="javascript:history.go(-2);"/>
    </p>
  </div>
  </body>
</html>
