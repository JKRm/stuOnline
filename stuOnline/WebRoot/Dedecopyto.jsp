<%@ page language="java" import="java.util.*,com.shanda.linglong.model.Permission_assignment" pageEncoding="utf-8"%>
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


		<title>后台管理--玲珑轮胎在线学习系统</title>


		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>home/style.css">

	</head>


	<body>
		<%
		if(session.getAttribute("myUser")==null){
		response.sendRedirect(basePath+"login/noLogin.jsp"); 
		}
		%>
		<div id="site">
			<div id="wrapper">
				<div id="header">
					<a href="index.html" id="logo"><img
							src="<%=basePath%>home/images/spacer.gif" alt="" width="360"
							height="90" /> </a>
					<div
						style="position: absolute; top: 1px; left: 1px; height: 0px; width: 0px; overflow: hidden">
						<h1>
							<a href="http://www.cssmoban.com">best free templates</a>
						</h1>
					</div>

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
							<a href="<%=basePath%>news/getNotices.action" class="but4">企业新闻</a>
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

					<span class="text">玲珑轮胎在线学习系统--学习更快捷，工作更有效率。
					
					<font face="宋体" size="2" color="red"> <%
        String user=(String)session.getAttribute("myUser");
	if(user!=null){
	%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	您好：<%=user %>&nbsp;&nbsp;&nbsp;<a href="<%=basePath %>exit.action" style="text-decoration:none;">退出系统</a> <%} 
		
	%> </font>
					</span>
				</div>
				<div id="content">
					<div id="sidebar">
						<h4>
							管理导航
						</h4>
						<ul>
							<li>

                 <%List<Permission_assignment> quanxian=(List<Permission_assignment>)session.getAttribute("quanxian"); 
                 %>
								<table border="0" width="58" cellspacing="0">
									<tr>
										<td></td>
									</tr>
									<tr>
										<td>
											<table cellspacing="0" width="58">
											<%for(int i=0;i<quanxian.size();i++){
												if(quanxian.get(i).getPermission_name().equals("权限管理"))
												{
												%>
											
												<tr>
													<td onclick="hide(1)" onmouseover="over(this)"
														onmouseout="out(this)" style="width: 58px;">
														<a href="#"><h5>
																&nbsp;&nbsp;权&nbsp;&nbsp;&nbsp;限
															</h5> </a>
													</td>
												</tr>
												<tr>
													<td>
														<table id=1 style="display: none" cellspacing="0" 
															width="58">
															<tr>
																<td>
																	<a href="<%=basePath%>results.action?right=add"
																		target="testIframe3">增加权限</a>
																</td>
															</tr>
															<tr>
																<td>
																	<a href="<%=basePath%>results.action?right=delete"
																		target="testIframe3">删除权限</a>
																</td>
															</tr>
															<tr>
																<td>
																	<a href="<%=basePath%>results.action?right=modify"
																		target="testIframe3">修改权限</a>
																</td>
															</tr>
															<tr>
																<td>
																	<a href="<%=basePath%>results.action?right=allot"
																		target="testIframe3">分配权限</a>
																</td>
															</tr>
														</table>
													</td>
												</tr>
												<%}
												%>
										
												
											<%if(quanxian.get(i).getPermission_name().equals("新闻管理")){ %>	
												
												<tr>
													<td onclick="hide(2)" onmouseover="over(this)"
														onmouseout="out(this)" style="width: 58px;">
														<a href="#"><h5>
																&nbsp;&nbsp;新&nbsp;&nbsp;&nbsp;闻
															</h5> </a>
													</td>
												</tr>
												<tr>
													<td>
														<table id=2 style="display: none" cellspacing="0"
															width="58">

															<tr>
																<td>
																	<a href="<%=basePath%>News/add.jsp"
																		target="testIframe3">&nbsp;&nbsp;增&nbsp;&nbsp;&nbsp;加</a>
																</td>
															</tr>
															<tr>
																<td>
																	<a href="<%=basePath%>news/getList.action"
																		target="testIframe3">修改删除</a>
																</td>
															</tr>


														</table>
													</td>
												</tr>
												<%} %>
												
												<%if(quanxian.get(i).getPermission_name().equals("调查问卷管理")){ %>	
												<!-- 调查问卷管理 -->
												<tr>
													<td onclick="hide(3)" onmouseover="over(this)"
														onmouseout="out(this)" style="width: 58px;">
														<a href="#"><h5>
																调查问卷
															</h5> </a>
													</td>
												</tr>
												<tr>
													<td>
														<table id=3 style="display: none" cellspacing="0"
															width="80">
															
															<tr>
																<td>
																	<a href="<%=basePath%>Test/TestUpload.jsp"
																		target="testIframe3">增加调查问卷</a>
																</td>
															</tr>
															
															<tr>
																<td>
																	<a href="previewTest/TestListAction.action"
																		target="testIframe3">修改调查问卷</a>
																</td>
															</tr>

															<tr>
																<td>
																	<a href="answerTest/AnswerTestListAction.action"
																		target="testIframe3">批阅调查问卷</a>
																</td>
															</tr>

															<tr>
																<td>
																	<a href=""
																		target="testIframe3">安排问卷答题</a>
																</td>
															</tr>

														</table>
													</td>
												</tr>

                                               <%} %>


												<!-- 试题库管理 -->
                                        <%if(quanxian.get(i).getPermission_name().equals("试题库管理")){ %>	
												<tr>
													<td onclick="hide(6)" onmouseover="over(this)"
														onmouseout="out(this)" style="width: 58px;">
														<a href="#"><h5>
																&nbsp;&nbsp;试&nbsp;&nbsp;&nbsp;题
															</h5> </a>
													</td>
												</tr>
												<tr>
													<td>
														<table id=6 style="display: none" cellspacing="0"
															width="80">
															
															<tr>
																<td>
																	<a href="exam/ExamAddAction.action"
																		target="testIframe3">添加试题</a>
																</td>
															</tr>

															<tr>
																<td>
																	<a href="exam/Exam_prouceAddAction.action"
																		target="testIframe3">自动生成试卷</a>
																</td>
															</tr>

															<tr>
																<td>
																	<a href="exam/Exam_prouceMunAction.action"
																		target="testIframe3">手动生成试卷</a>
																</td>
															</tr>

															<tr>
																<td>
																	<a href="exam/PersonListAction.action"
																		target="testIframe3">开始答题</a>
																</td>
															</tr>

															<tr>
																<td>
																	<a href="exam/AnswerExamAction.action"
																		target="testIframe3">批改试卷</a>
																</td>
															</tr>

															<tr>
																<td>
																	<a href="exam/AnswerExamShowAction.action"
																		target="testIframe3">查看结果</a>
																</td>
															</tr>

														</table>
													</td>
												</tr>
												
												<%} %>
												
												<!-- 课程设计管理 -->
												<%if(quanxian.get(i).getPermission_name().equals("课程设计管理")){ %>	
												<tr>
													<td onclick="hide(5)" onmouseover="over(this)"
														onmouseout="out(this)" style="width: 58px;">
														<a href="#"><h5>
																课程设计
															</h5> </a>
													</td>
												</tr>
												<tr>
													<td>
														<table id="5" style="display: none" cellspacing="0"
															width="80">
															<tr>
																<td>
																	<a href="<%=basePath%>design/getTrain.action?sort=4"
																	
																		target="testIframe3">培训修改</a>
																</td>
															</tr>
															<tr>
																<td>
																	<a href="<%=basePath%>design/getTrain.action?sort=3"
																	
																		target="testIframe3">课程修改</a>
																</td>
															</tr>
															<tr>
																<td>
																	<a href="<%=basePath%>design/getTrain.action?sort=2"
																	
																		target="testIframe3">单元修改</a>
																</td>
															</tr>
															<tr>
																<td>
																	<a href="<%=basePath%>design/getTrain.action?sort=1"
																	
																		target="testIframe3">小节修改</a>
																</td>
															</tr>
															<tr>
																<td>
																	<a href="<%=basePath%>design/getTrain.action?sort=0"
																	
																		target="testIframe3">知识点修改</a>
																</td>
															</tr>
															

														</table>
													</td>
												</tr>
												
												<%} %>
												
												
												<!-- 分析 -->
                                          <%if(quanxian.get(i).getPermission_name().equals("分析管理")){ %>	
												<tr>
													<td onclick="" onmouseover="over(this)"
														onmouseout="out(this)" style="width: 58px;">
														<a href="#"><h5>
																&nbsp;&nbsp;分&nbsp;&nbsp;&nbsp;析
															</h5> </a>
													</td>
												</tr>
												<tr>
													<td>
														<table id=2 style="display: none" cellspacing="0"
															width="80">
															<tr>
																<td>
																	修改及删除
																</td>
															</tr>
															<tr>
																<td>
																	增加新闻
																</td>
															</tr>

														</table>
													</td>
												</tr>
                                               <%} %>

<%if(quanxian.get(i).getPermission_name().equals("虚拟证书管理")){ %>	
												<!-- 虚拟证书管理 -->
												<tr>
													<td onclick="" onmouseover="over(this)"
														onmouseout="out(this)" style="width: 58px;">
														<a href="#"><h5>
																虚拟证书
															</h5> </a>
													</td>
												</tr>
												<tr>
													<td>
														<table id=2 style="display: none" cellspacing="0"
															width="80">
															<tr>
																<td>
																	修改及删除
																</td>
															</tr>
															<tr>
																<td>
																	增加新闻
																</td>
															</tr>

														</table>
													</td>
												</tr>
												
										<%} %>		
												
												
												<!-- 邮件提醒管理 -->
<%if(quanxian.get(i).getPermission_name().equals("邮件管理")){ %>	
												<tr>
													<td onmouseover="over(this)" onmouseout="out(this)"
														style="width: 58px;">
														<a><h5>
																<a href="<%=basePath%>mail/initSel.action"
																	target="testIframe3">邮件提醒</a>
															</h5> </a>
													</td>
												</tr>
<%} %>


<%	} %>
											</table>
										</td>
									</tr>
								</table>



							</li>


						</ul>

					</div>
					<div id="main">
						<h4>

						</h4>
						<iframe src="<%=basePath%>home/System_self.jsp" frameborder="0"
							width="630" scrolling="auto" name="testIframe3" height="300">
						</iframe>

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
					<p>
						玲珑轮胎集团
						<br>
						Copyright &copy;. All rights reserved.

					</p>
				</div>
			</div>
		</div>


		<script type="text/javascript">
    pa1=false;pa2=false;pa3=false;pa4=false;pa5=false;pa6=false;
    function hide(x){
    
    obj=document.getElementById(x);
    switch(x){
      case 1:
      if(pa1)
        {obj.style.display="none";pa1=false;}
      else {obj.style.display="block";pa1=true;}
      break;
       case 2:
         if(pa2)
            {obj.style.display="none";pa2=false;}
         else {obj.style.display="block";pa2=true;}
         break;
       case 3:
          if(pa3)
            {obj.style.display="none";pa3=false;}
          else {obj.style.display="block";pa3=true;}
          break;
       case 4:
          if(pa4)
            {obj.style.display="none";pa4=false;}
          else {obj.style.display="block";pa4=true;}
          break;
       case 5:
           if(pa5)
             {obj.style.display="none";pa5=false;}
           else {obj.style.display="block";pa5=true;}
           break;
       case 6:
           if(pa6)
             {obj.style.display="none";pa6=false;}
           else {obj.style.display="block";pa6=true;}
           break;
    }
    
    }
    function over(x){
        x.style.backgroundColor="#cacaca";
    }
    function out(x){
        x.style.backgroundColor="white";
    }
    </script>
	</body>
</html>
