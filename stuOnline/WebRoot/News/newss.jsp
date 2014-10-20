<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,com.shanda.linglong.dao.impl.*,com.shanda.linglong.model.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>新闻列表</title>
		<link href="<%=basePath%>css/admin.css" rel="stylesheet"
			type="text/css" />
	</head>
	<body>
	<div id="include-div">
	  <h3>企业新闻</h3>
		<div id="noticeList">
			<ul style="list-style: none;">
				<%
					List<Enterprise_news> newss = (List<Enterprise_news>) session.getAttribute("news");
					for (int i = 0; i < newss.size(); ++i) {
						Enterprise_news news = newss.get(i);
				%>
				<li style="line-height: 20px; height: 20px; border-bottom: 1px dashed gray;">
					<a href="<%=basePath%>news/read.action?nid=<%=news.getEn_id()%>" style="text-decoration: none;"><%=news.getEn_theme()%></a>
						<p class="datetime" style="text-align: right; margin-top: -20px;">[<%=news.getEn_time().substring(0, 10)%>]</p>
				</li>
				<%
					}
				%>
			</ul>
		</div>
	</div>
	</body>
</html>