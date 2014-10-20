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
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resources/css/ext-all.css">
	<script type="text/javascript" src="bootstrap.js"></script>
	
	<script type="text/javascript" src="ext-lang-zh_CN.js"></script>
	<script type="text/css">
	#CheckCode{ float:left;} 
.x-form-code{width:730px;height:200px;vertical-align:middle;cursor:pointer; float:left; margin-left:7px;} 
	</script>
  </head>
  
  <body>
    <script type="text/javascript" src="test2.js"></script>
  </body>
</html>
