<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ page contentType="text/html;charset=utf-8"%>
<%@ page language="java" import="java.sql.*" errorPage=""%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>错误--玲珑轮胎在线学习系统</title>
		<script language="javascript">
	function loadimage() {
		document.getElementById("randImage").src = "image.jsp?" + Math.random();
	}
</script>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>home/style2.css" />
	</head>
	
	
	<body>
		<div id="site">
			<div id="wrapper">
				<div id="header">
					<a href="index.html" id="logo"><img src="<%=basePath%>home/images/spacer.gif"
							alt="" width="360" height="90" /> </a>
					
					<ul id="menu">
						<li>
							<a href="http://www.linglong.cn/" class="but1_active">公司主页</a>
						</li>
						
						
					</ul>
					<div class="logo">
			 			Dolor sit amet, consectetuer adipiscing elit. Prant pulvinar
						venenati dolor. Etiam ultrices, magna a luctus lacinia, sem lorem
						vestibulum csectetuer velit id sapien. Donec fermeat.
				
					</div>
					
					<span class="text">玲珑轮胎在线学习系统--学习更快捷，工作更有效率。</span>
				</div>
	
					
					
<div style="float:left;background-color:#fafafa;">
  <img src="<%=basePath %>home/images/nosession.png">
</div>

<div style="float:left;">
<a href="<%=basePath %>login/login.jsp">
<font size="2" face="宋体" style="text-decoration:none;">立即登录?</font></a>
</div>
					<div id="footer2">
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


