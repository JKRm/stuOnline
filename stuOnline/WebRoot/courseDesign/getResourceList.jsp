<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*,
			com.shanda.linglong.dao.impl.*,
			com.shanda.linglong.model.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>课程资料列表</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/front.css">
</head>
<body>
<div id="include-div-second">
<div class="course-list">
<h4>学习资料</h4>
  <ul>
  <%List<Course_resource> crList = (List<Course_resource>) request.getAttribute("crList");
  if(crList.size()==0){%>
  
  <p>无此知识点相关资料</p>
  
  <% }
  
  	for (int i=0; i<crList.size(); ++i) {
  		Course_resource cr = crList.get(i);
  %>
  <li class="<%=cr.getCr_name().substring(cr.getCr_name().lastIndexOf(".")+1, cr.getCr_name().length()) %>">
    <a href="<%=basePath %>flexpaper/showResource.jsp?nid=<%=cr.getCr_url() %>&old=<%=cr.getCr_urlname() %>&new=<%=cr.getCr_name() %>&isDis=<%=cr.getCr_display() %>"><%=cr.getCr_name() %></a>
  </li>
  <%}%>
  </ul>
  </div>
</div>
</body>
</html>
