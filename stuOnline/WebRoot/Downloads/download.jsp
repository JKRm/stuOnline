<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*,
			com.shanda.linglong.model.*,
			com.shanda.linglong.vo.*
"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String filePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>查看下载</title>
<link href="<%=basePath %>css/front.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath %>js/string.js" type="text/javascript"></script>
</head>
<body>
<div id="include-div">
<h3>常用下载</h3>
  <%NewsVo newsVo = (NewsVo) session.getAttribute("newsVo");
  	Enterprise_news news = newsVo.getNews();
  	List<News_appendix> appendixs = newsVo.getAppendixs();
  %>
  <div class="news-content">
  <p class="title"><%=news.getEn_theme()%></p>
  <p class="publish_time">发表时间:<%=news.getEn_time().substring(0, 19)%>&nbsp;点击:<%=news.getEn_number()%></p>
  <div id="detail">
  <p><%=news.getEn_content()%></p>
  </div>
  <% if (appendixs != null && appendixs.size() > 0) { %>
  <div class="file-list">
  <p>下载列表</p>
  <%for (int i=0; i<appendixs.size(); ++i) {
  	News_appendix appendix = appendixs.get(i);
  %>
  <ul>
  <li class="<%=appendix.getNa_name_load().substring(appendix.getNa_name_load().lastIndexOf(".")+1, appendix.getNa_name_load().length()) %>">
  	<a href="<%=filePath %>studentOnline_source/appendix/<%=appendix.getNa_name_load() %>"><%=appendix.getNa_name_show() %></a>
  </li>
  </ul>
  <%} %>
  </div>
  </div>
  <%} %>
</div>
</body>
</html>