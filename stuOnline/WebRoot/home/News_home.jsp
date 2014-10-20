<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*,
			com.shanda.linglong.dao.impl.*,
			com.shanda.linglong.model.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>玲珑轮胎在线学习平台</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>home/style.css" />
	</head>

	<body>
		<div id="site">
			<div id="wrapper">
				<div id="header">
					<a href="index.html" id="logo"><img src="<%=basePath%>home/images/spacer.gif"
							alt="" width="360" height="90" /> </a>
					<div
						style="position: absolute; top: 1px; left: 1px; height: 0px; width: 0px; overflow: hidden">
						<h1>
							<a href="http://www.cssmoban.com">best free templates</a>
						</h1>
					</div>
					
					<ul id="menu">
						<li>
							<a href="http://www.linglong.cn/" class="but1_active">公司主页</a>
						</li>
						<li>
							<a href="<%=basePath %>home/Home.jsp" class="but2">系统首页</a>
						</li>
						<li>
							<a href="index2.html" class="but3">个人主页</a>
						</li>
						<li>
							<a href="<%=basePath%>news/getNotices.action" class="but4">企业新闻</a>
						</li>
						<li>
							<a href="index2.html" class="but5">职业测评</a>
						</li>
						<li>
							<a href="<%=basePath %>home/Learning_home.jsp" class="but6">在线学习</a>
						</li>
						<li>
							<a href="<%=basePath%>community/getStatusList.action" class="but7">企业社区</a>
						</li>
					</ul>
					<div class="logo">
						Dolor sit amet, consectetuer adipiscing elit. Prant pulvinar
						venenati dolor. Etiam ultrices, magna a luctus lacinia, sem lorem
						vestibulum csectetuer velit id sapien. Donec fermeat.
					</div>
					<span class="text">玲珑轮胎在线学习系统--学习更快捷，工作更有效率。
					
				<font face="宋体" size="2" color="red"> <%
        String user=(String)session.getAttribute("myUser");
	if(user!=null){
	%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	您好：<%=user %>&nbsp;&nbsp;&nbsp;<a href="<%=basePath %>exit.action" style="text-decoration:none;">退出系统</a> <%} else
		response.sendRedirect(basePath+"login/noLogin.jsp");
	%> </font>
					</span>
				</div>
				<div id="content">
					<div id="sidebar">
						
						<img  src="<%=basePath %>home/images/news.png">
						<br><br><br><br>
						<p>
						此新闻页面，展示了玲珑公司最新的新闻动态。读者可以在线阅读，也可以下载文档。</p>
						
						
					</div>
					<div id="main">
					 	<b>
							公司新闻
						</b>
						<hr/>
  <iframe src="<%=basePath %>News/newss.jsp" frameborder="0" width="600" scrolling="no" name="testIframe2" height="300">
 </iframe>

						<br><br><br>
				
						<h5 class="pad15">
						</h5>
			<!--  		<p>欢迎使用玲珑在线学习平台
						</p>-->	
					</div> 
					</div>
					<div id="footer">
						<ul>
							<li>
								<a href="index.html">Home</a> |
							</li>
							<li>
								<a href="index2.html">Submit a Listing</a> |
							</li>
							<li>
								<a href="index2.html">New Listings</a> |
							</li>
							<li>
								<a href="index2.html">Top Viewed</a> |
							</li>
							<li>
								<a href="index2.html">Partners Directories</a> |
							</li>
							<li>
								<a href="index2.html">Contact Us</a>
							</li>
						</ul>
						<p>玲珑轮胎集团<br>
							Copyright &copy;. All rights reserved. 
							
						</p>
					</div>
				</div>
			</div>
	</body>
</html>