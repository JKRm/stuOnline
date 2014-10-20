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

<link rel="stylesheet" type="text/css" href="<%=basePath %>css/admin.css" />
<script>
	function con(nid) {
		if (confirm("确定删除？")) {
			var form = document.createElement("form");
			location.href = "<%=basePath %>resource/delete.action?nid=" + nid;
			form.submit();
			alert(form.action);
		} else {
		}
	}
</script>
</head>
<body>
<div id="include-div">
  <form>
	<h3>资料删除</h3>
  <ul id="file-list">
  <%List<Course_resource> crList = (List<Course_resource>) request.getAttribute("crList");
  	for (int i=0; i<crList.size(); ++i) {
  		Course_resource cr = crList.get(i);
  %>
  <li>
    <a href="<%=basePath %>flexpaper/showResource.jsp?nid=<%=cr.getCr_url() %>&old=<%=cr.getCr_urlname() %>&new=<%=cr.getCr_name() %>&isDis=<%=cr.getCr_display() %>"><%=cr.getCr_name() %></a>
    <a style="cursor:pointer" onclick="con(<%=cr.getCr_id() %>)">删除</a>
  </li>
  <%}%>
    </ul>
  </form>
</div>
</body>
</html>