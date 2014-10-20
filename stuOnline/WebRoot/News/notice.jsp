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
<title>查看新闻</title>
<script src="<%=basePath %>js/string.js" type="text/javascript"></script>
<link href="<%=basePath %>css/notice.css" rel="stylesheet" type="text/css" />
</head>
<body>
  <%NewsVo newsVo = (NewsVo) session.getAttribute("newsVo");
  	Enterprise_news news = newsVo.getNews();
  	List<News_appendix> appendixs = newsVo.getAppendixs();
  %>
  <p><%=news.getEn_theme()%></p>
  <p>发表时间:<%=news.getEn_time().substring(0, 19)%>&nbsp;点击:<%=news.getEn_number() %></p>
  <p><%=news.getEn_content()%></p>
  <ul>
  <%for (int i=0; i<appendixs.size(); ++i) {
  	News_appendix appendix = appendixs.get(i);
  %>
  <li class="<%=appendix.getNa_name_load().substring(appendix.getNa_name_load().lastIndexOf(".")+1, appendix.getNa_name_load().length()) %>"><a href="<%=filePath %>studentOnline_source/appendix/<%=appendix.getNa_name_load() %>"><%=appendix.getNa_name_show() %></a></li>
  <%} %>
  </ul>
</body>
</html>