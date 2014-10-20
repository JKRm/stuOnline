<%@ page language="java"
	import="java.util.*,com.shanda.linglong.model.Permission_assignment"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html class="no-js">
<head>
	<script type="text/javascript" src="<%=basePath %>js/modernizr-latest.js"></script>
	<title>后台管理--玲珑轮胎在线学习系统</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css"/>
	<script type="text/javascript" src="<%=basePath %>js/index.js"></script>
</head>
<body onload="setLinkClickMethod()">
	<div id="mainBody">
	 	<div id="header">
	 		<div id="logo">
	 			<img src="<%=basePath %>images/logo.gif"/>
	 			<h1>员工在线学习系统</h1>
	 		</div>
	 	</div>
	 	
	 	<!-- 准备工作 -->
		<%List<Permission_assignment> quanxian=(List<Permission_assignment>)session.getAttribute("quanxian"); %>
		<div id="center">
		 	<div id="left">
		 		<%for(int i=0;i<quanxian.size();i++){
					if(quanxian.get(i).getPermission_name().equals("权限管理")) {%>
						<ul id="action-1">
							<h2 onclick="show('action-1')">权限管理</h2>
							<li>
								<a href="<%=basePath%>permission/results.action?right=add" target="testIframe3">增加权限</a>
							</li>
							<li>
								<a href="<%=basePath%>permission/results.action?right=delete" target="testIframe3">删除权限</a>
							</li>
							<li>
								<a href="<%=basePath%>permission/results.action?right=modify" target="testIframe3">修改权限</a>
							</li>
							<li>
								<a href="<%=basePath%>permission/results.action?right=allot" target="testIframe3">分配权限</a>
							</li>
							<li>
								<a href="<%=basePath%>permission/to_delete.action?parameter=delete" target="testIframe3">收回权限</a>
							</li>
						</ul>
					<%} else if(quanxian.get(i).getPermission_name().equals("新闻管理")){ %>
						<ul id="action-2">
							<h2 onclick="show('action-2')">新闻管理</h2>
							<li>
								<a href="<%=basePath%>News/add.jsp" target="testIframe3">添加新闻</a>
							</li>
							<li>
								<a href="<%=basePath%>news/getList.action" target="testIframe3">编辑新闻</a>
							</li>
						</ul>
						<ul id="action-21">
							<h2 onclick="show('action-21')">下载管理</h2>
							<li>
								<a href="<%=basePath%>Downloads/add.jsp" target="testIframe3">添加下载文件</a>
							</li>
							<li>
								<a href="<%=basePath%>news/getEnDownload.action?isd=3" target="testIframe3">编辑下载文件</a>
							</li>
						</ul>
					<%} else if(quanxian.get(i).getPermission_name().equals("调查问卷管理")){ %>
						<ul id="action-3">
							<h2 onclick="show('action-3')">调查问卷</h2>
							<li>
								<a href="<%=basePath%>Test/TestUpload.jsp" target="testIframe3">增加调查问卷</a>
							</li>
							<li>
								<a href="<%=basePath%>previewTest/TestListAction.action" target="testIframe3">修改调查问卷</a>
							</li>
							<li>
								<a href="<%=basePath%>answerTest/AnswerTestListAction.action" target="testIframe3">批阅调查问卷</a>
							</li>
							<li>
								<a href="<%=basePath %>permission/cpb.action" target="testIframe3">安排测评答题</a>
							</li>
						</ul>
					<%} else if (quanxian.get(i).getPermission_name().equals("试题库管理")){ %>
						<ul id="action-4">
							<h2 onclick="show('action-4')">试题库管理</h2>
							<li>
								<a href="<%=basePath%>exam/ExamAddAction.action" target="testIframe3">添加试题</a>
							</li>
							<li>
								<a href="<%=basePath%>exam/Exam_prouceAddAction.action" target="testIframe3">自动生成试卷</a>
							</li>
							<li>
								<a href="<%=basePath%>exam/Exam_prouceMunAction.action" target="testIframe3">手动生成试卷</a>
							</li>
							<li>
								<a href="<%=basePath%>exam/PersonListAction.action" target="testIframe3">开始答题</a>
							</li>
							<li>
								<a href="<%=basePath%>exam/AnswerExamAction.action" target="testIframe3">批改试卷</a>
							</li>
							<li>
								<a href="<%=basePath%>exam/AnswerExamShowAction.action" target="testIframe3">查看结果</a>
							</li>
							<li>
								<a href="<%=basePath %>permission/fp_sj.action" target="testIframe3">安排问卷答题</a>
							</li>
						</ul>
					<%}else  if(quanxian.get(i).getPermission_name().equals("课程设计管理")){%>
						<ul id="action-5">
							<h2 onclick="show('action-5')">培训修改 </h2>
							<li>
								<a href="<%=basePath%>design/getTrain.action?sort=4" target="testIframe3">培训管理</a>
							</li>
							<li>
								<a target="testIframe3" href="<%=basePath%>design/getTrain.action?sort=5">培训设计</a>
							</li>
							<li>
								<a href="<%=basePath%>permission/pxfp.action" target="testIframe3">安排培训</a>
							</li>
							<li>
								<a href="<%=basePath%>permission/pxfp.action?parameter=delete" target="testIframe3">取消培训</a>
							</li>
						</ul>
						<ul id="action-6">
							<h2 onclick="show('action-6')">课程设计</h2>
							<li>
								<a  href="<%=basePath%>design/getTrain.action?sort=3" target="testIframe3">课程修改</a>
							</li>
							<li>
								<a href="<%=basePath%>design/getTrain.action?sort=2" target="testIframe3">单元修改</a>
							</li>
							<li>
								<a href="<%=basePath%>design/getTrain.action?sort=1" target="testIframe3">小节修改</a>
							</li>
							<li>
								<a href="<%=basePath%>design/getTrain.action?sort=0" target="testIframe3">知识点修改</a>
							</li>
							<li>
								<a href="<%=basePath%>upload/initSel.action" target="testIframe3">资料上传</a>
							</li>
							<li>
								<a href="<%=basePath%>resource/getResourceList.action" target="testIframe3">资料删除</a>
							</li>
						</ul>
					<%} else if(quanxian.get(i).getPermission_name().equals("邮件管理")){ %>
						<ul id="action-7">
							<h2 onclick="show('action-7')">
							<a href="<%=basePath%>mail/initSel.action" target="testIframe3">邮件提醒</a><h2>
						</ul>
					<%} else if(quanxian.get(i).getPermission_name().equals("新闻管理")){ %>
						<ul id="action-8">
							<h2 onclick="show('action-8')"></h2>
							<li><a href="<%=basePath%>News/add.jsp" target="testIframe3">添加新闻</a></li>
							<li><a href="<%=basePath%>news/getList.action" target="testIframe3">新闻编辑</a></li>
						</ul>
					<%}// end of if  %>						
				<%} // end of for%>	
			</div> 
			<div id="right">
				<iframe src="<%=basePath%>home/System_self.jsp" frameborder="0" width="680" scrolling="auto" name="testIframe3" height="400">
				</iframe>
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
