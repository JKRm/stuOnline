<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*,
			com.shanda.linglong.dao.impl.*,
			com.shanda.linglong.model.*
"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>下载列表</title>
<link href="<%=basePath %>css/admin.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath %>js/string.js" type="text/javascript"></script>
<script>
	function con(nid) {
		if (confirm("确定删除？")) {
			var form = document.createElement("form");
			var change = document.createElement("input");
			change.type = 'text';
			change.name = 'nid';
			change.value = nid;
			form.appendChild(change);
			form.action = "<%=basePath %>news/deleteNews.action";
			form.submit();
		
		} else {
		}
	}
</script>
<style>
	.top {
	 	margin-top: 23px;
		margin-left: 9px;
		padding-left: 6px;
		padding-bottom: 2px;
		border-bottom: 1px solid rgb(230, 230, 230);
		font-size: 12px;
	}
	.top span {
		font-weight: bold;
	}
</style>
</head>
<body>
<div id="include-div">
  <h3>下载列表</h3>
  <div id="noticeList">
  <ul style="list-style: none;">
  <%List<Enterprise_news> newss = (List<Enterprise_news>) session.getAttribute("Download");
  	for (int i=0; i<newss.size(); ++i) {
  		Enterprise_news news = newss.get(i);
  %>
  <li>
    <a href="<%=basePath %>news/get.action?nid=<%=news.getEn_id() %>&isd=3"><%=news.getEn_theme() %></a>
    <span class="time">[<%=news.getEn_time().substring(0, 10) %>]</span>
    <span class="actions">
      <a href="<%=basePath %>news/edit.action?nid=<%=news.getEn_id() %>&isd=3">编辑</a>
      <a style="cursor:pointer" onclick="con(<%=news.getEn_id() %>)">删除</a>
    </span>
  </li>
  <%}%>
  </ul>
  </div>
</div>
</body>
</html>