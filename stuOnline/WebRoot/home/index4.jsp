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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>test/style.css" />
	</head>

	<body>
		<div id="site">
			<div id="wrapper">
				<div id="header">
					<a href="index.html" id="logo"><img src="<%=basePath%>test/images/spacer.gif"
							alt="" width="360" height="90" /> </a>
					
					<ul id="menu">
						<li>
							<a href="index.html" class="but1_active">公司主页</a>
						</li>
						<li>
							<a href="index2.html" class="but2">首页</a>
						</li>
						<li>
							<a href="index2.html" class="but3">个人主页</a>
						</li>
						<li>
							<a href="index2.html" class="but4">企业新闻</a>
						</li>
						<li>
							<a href="index2.html" class="but5">职业测评</a>
						</li>
						<li>
							<a href="index2.html" class="but6">在线学习</a>
						</li>
						<li>
							<a href="index2.html" class="but7">企业社区</a>
						</li>
					</ul>
					<div class="logo">
						Dolor sit amet, consectetuer adipiscing elit. Prant pulvinar
						venenati dolor. Etiam ultrices, magna a luctus lacinia, sem lorem
						vestibulum csectetuer velit id sapien. Donec fermeat.
					</div>
					
					<span class="text">企业口号</span>
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
						<p>
							Copyright &copy;. All rights reserved. Design from
							<a href="http://www.cssmoban.com" target="_blank"
								title="Free Templates">cssMoban.com</a>
						</p>
					</div>
				</div>
		
	</body>
</html>