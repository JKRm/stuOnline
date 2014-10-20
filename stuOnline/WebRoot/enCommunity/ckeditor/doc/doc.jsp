<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
	<title>发表文章</title>
	<meta content="text/html; charset=utf-8" http-equiv="content-type" />
	<script type="text/javascript" src="<%=basePath %>enCommunity/ckeditor/ckeditor.js"></script>
	<script src="<%=basePath %>enCommunity/ckeditor/doc/sample.js" type="text/javascript"></script>
	<link href="<%=basePath %>enCommunity/ckeditor/doc/sample.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet"
			href="<%=basePath%>enCommunity/images/TechJunkie.css" type="text/css" />
</head>
<body>
	<!-- wrap starts here -->
<div id="wrap">

	<!--header -->
	<div id="header">			
				
		
			
	<!--header ends-->					
	</div>
		
	<!-- navigation starts-->	
	<div  id="nav">
		<ul>
			
		</ul>
	<!-- navigation ends-->	
	</div>					
			
	<!-- content-wrap starts -->
	<div id="content-wrap">
	
		<div id="main">
				
			<a name="TemplateInfo"></a>
			<h2><a href="index.html" title="">Template Info</a></h2>
					
			<form action="<%=basePath %>community/publishdoc.action" method="post">
		<p>
			<label for="editor1">
				Editor 1:</label>
				<p><input type="text" name="title" id="title"></p>
			<textarea class="ckeditor" cols="80" id="content" name="content" rows="10">
			
			</textarea>
		</p>
		<p>
			<input type="submit" value="提交" />
		</p>
	</form>
			
			
		

		<!-- main ends -->	
		</div>
		<!-- 	
		<div id="sidebar">
			
			<h3>Sidebar Menu</h3>
			<ul class="sidemenu">				
				<li>
							<a href="<%=basePath%>community/getStatusList.action">社区首页</a>
						</li>
						<li>
							<a href="community/personDetail.action">资料修改</a>
						</li>
						<li>


						</li>

			</ul>	
				
			
		</div>		-->
		<!-- sidebar ends -->		
			
		 	
	<!-- content-wrap ends-->	
	</div>
		
	<!-- footer starts -->		
	<div id="footer-wrap">
	<div id="footer-content">
	
		<div id="footer-columns">	
			<div class="col3">
				
			</div>

			<div class="col3-center">
				
			</div>

			<div class="col3">
				
			</div>
		<!-- footer-columns ends -->
		</div>	
	
		<div id="footer-bottom">
			<p>
			&copy; 2010 <strong>Your Company</strong> &nbsp;&nbsp;&nbsp;&nbsp;
			<a href="http://www.cssmoban.com/" title="Website Templates">website templates</a> from <a href="http://www.cssmoban.com/">网站模板</a> |
			Valid <a href="http://validator.w3.org/check?uri=referer">XHTML</a> | 
			<a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a>
			
   		    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			<a href="index.html">Home</a>&nbsp;|&nbsp;
   		    <a href="index.html">Sitemap</a>&nbsp;|&nbsp;
	   	    <a href="index.html">RSS Feed</a>
   		    </p>
		</div>	

<!-- footer ends-->
</div></div>

<!-- wrap ends here -->
</div>

</body>
</html>
