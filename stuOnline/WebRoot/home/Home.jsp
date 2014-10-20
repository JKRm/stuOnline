<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath%>">
		<script type="text/javascript" src="<%=basePath %>js/modernizr-latest.js"></script>
		<title>玲珑轮胎在线学习平台</title>
		<script type="text/javascript" src="<%=basePath %>js/index.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css"/>
	</head>
	<body onload="setLinkClickMethod()">
	<div id="mainBody">
	 	<div id="header">
	 		<div id="logo">
	 			<img src="<%=basePath %>images/logo.gif"/>
	 			<h1>员工在线学习系统</h1>
	 		</div>
	 		<div id="user-info">
	 		<a href="<%=basePath %>home/Home.jsp">系统首页</a>
	 		<%String user=(String)session.getAttribute("myUser");
						if(user!=null){%> 
							您好：<%=user %><a href="<%=basePath %>exit.action">退出</a> 
					<%} else response.sendRedirect(basePath+"login/noLogin.jsp");%> 
	 		</div>
	 	</div>
	 	<div id="center">
		 <div id="nav">
		 	<ul>
				<li><a href="http://www.linglong.cn/" ">公司主页</a></li>
				<li><a href="<%=basePath%>news/getNotices.action" target="testIframe">企业新闻</a></li>
				<li><a href="<%=basePath %>answerTest/test_answerListAction.action" target="testIframe">职业测评</a></li>
				<li><a href="<%=basePath %>home/Learning_home.jsp" target="testIframe">在线学习</a></li>
				<li><a href="<%=basePath %>exam/PersonListAction.action" target="testIframe">在线答题</a></li>
				<li><a href="<%=basePath%>community/getStatusList.action" >企业社区</a></li>
				<li><a href="<%=basePath%>news/getDownload.action" target="testIframe">常用下载</a></li>
			</ul>	
		 </div>	
		 <div id="right">
				<iframe src="<%=basePath%>home/System_self.jsp" frameborder="0" width="680" scrolling="auto" name="testIframe" height="400"></iframe>
		 </div>
	 </div>
	 <div id="foot">
			<div class="link">
				<p>
					<a href="http://www.linglong.cn/index.html">Company Home</a>
				</p>
				<p>
					<a href="<%=basePath %>home/Home.jsp">Learning online home</a>
				</p>
			</div>
			<div>
				<p>玲珑轮胎集团</p>
				<p>Copyright &copy;. All rights reserved.</p>
			</div>
		</div>
	 </div>
	</body>
</html>