<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>用户登录--玲珑轮胎在线学习系统</title>
		<script language="javascript">
	function loadimage() {
		document.getElementById("randImage").src = "image.jsp?" + Math.random();
	}
</script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css" />
</head>
<style type="text/css">
*{
	margin:0;
	padding:0;
}

</style>		
<body id="bg">
	<div id="belt">
		<div id="main">
			<div id="login">
				<form action="login/login.action" method="post" name="loginForm">
					<ul>
						<li>
								<label>用户名</label>
								<input type="text" name="person_id">
						</li>
							
						<li>
							<label>密码</label>
							<input type="password" name="password">
						</li>
							
						<li>
							<label>验证码</label>
								<input type="text" name="confirm"  style="width: 4em;"/>
								<input type="image" src="<%=basePath %>login/image.jsp" id="randImage" />
								<a href="" style="text-decoration:none;">换一张？</a>
						</li>
						<li>
							<label>&nbsp;</label>
							<input type="submit" class="button" value="登录" />
							<span class="login-info">
							<%if(request.getAttribute("message")!=null&&(!(request.getAttribute("message").equals("")))){ %>
									<%=request.getAttribute("message").toString() %>
							<%} %>
							</span>
						</li>
					</ul>
					<p class="prompt">提示：此系统没有注册功能，登录用户名和密码有管理员分配。<a href="login/GetPassword.jsp">找回密码</a>
					  <a href="login/ChangePassword.jsp">修改密码</a></p>
				</form>					
			</div>
			<div id="wheel"><img src="<%=basePath %>images/wheel.gif"/></div>
		</div >
	</div>
	<div id="foot">
						<p>玲珑轮胎集团<br>
							Copyright &copy;. All rights reserved. 
						</p>
					</div>
	
 </body>
</html>
