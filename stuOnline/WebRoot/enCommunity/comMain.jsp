<%@ page language="java" import="java.util.*,com.shanda.linglong.vo.*"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>企业社区</title>
		<meta content="text/html; charset=utf-8" http-equiv="content-type" />


		<link rel="stylesheet"
			href="<%=basePath%>enCommunity/images/TechJunkie.css" type="text/css" />
		<link href="<%=basePath%>enCommunity/Picasa/Picasa.css"
			rel="stylesheet" type="text/css" />
		<script language="javascript"
			src="<%=basePath%>enCommunity/Picasa/Picasa.js"></script>
		<script>
		function con(rid) {
			if (confirm("确定删除这条微言？")) {
				var form = document.createElement("form");
				location.href = "<%=basePath%>community/delRecord.action?rid="
					+ rid;
				form.submit();
				} else {
			}
		}

	function topage(currentpage) {
		var form = document.createElement("form");
	location.href
	= "<%=basePath%>community/getStatusList.action?currentpage="
				+ currentpage;
		form.submit();
	}
	
	function addImgfun(obj) {
			var area = document.getElementById("addImg");
			if(obj.innerHTML=="添加图片"){
			area.innerHTML +=  "<input type=\"file\" id=\"upload\" name=\"upload\">";
			obj.innerHTML="取消图片";
			}
			else{
			area.innerHTML="";
			obj.innerHTML="添加图片";
			}
		}
		
</script>
	</head>
	<body>
	<%
	if(session.getAttribute("myUser")==null)
		response.sendRedirect(basePath+"login/noLogin.jsp"); %>
		<!-- wrap starts here -->
		<div id="wrap">

			<!--header -->
			<div id="header">



				<!--header ends-->
			</div>

			<!-- navigation starts-->
			<div id="nav">
				<ul>
				</ul>
				<!-- navigation ends-->
			</div>

			<!-- content-wrap starts -->
			<div id="content-wrap">

				<div id="main">

					<form action="<%=basePath %>community/publish.action"
						enctype="multipart/form-data" method="post">


						<textarea id="content" name="content"
							style="width: 480px; height: 50px; resize: none;"></textarea>

						<a href="javascript:void(0)"
							onclick="addImgfun(this);return false">添加图片</a>&nbsp;&nbsp;&nbsp;
						<a href="<%=basePath %>enCommunity/ckeditor/doc/publishDoc.jsp">发表文章</a>
						<div style="position: absolute; left: 480px; top: 100px;">
							<input type="submit" value="发表" onclick="alert('微言发送成功！');">
						</div>



						<div id="addImg"></div>
						&nbsp;&nbsp;




					</form>

					<a name="TemplateInfo"></a>
					<h2>
						<a href="index.html" title="">社区动态</a>
					</h2>

					<div>
					<br>
						<%
							List<DetailVo> voList = (List<DetailVo>) request
									.getAttribute("voList");
							String imgpath = "../../studentOnline_source/community/image/";
							String portrait = "../../studentOnline_source/community/portrait/";
							for (int i = 0; i < voList.size(); ++i) {
								DetailVo detail = voList.get(i);
						%>

						<img src="<%=portrait + detail.getPhoto_url()%>" width="50px"
							height="50px" />
						<div style="position: relative; top: -60px; left: 70px;">

							<h5>
								<a
									href="<%=basePath%>community/homeDes.action?pid=<%=detail.getRecord().getPerson_id()%>"><%=detail.getNickname()%></a>
							</h5>
						</div>
                        	
    				
    				
    				
    				
						<div style="position: relative; top: -40px; left: 70px;">
						
						
						<% if(detail.getRecord().getR_title()!=null){%>
					
    				<a href="<%=basePath%>community/disList.action?rid=<%=detail.getRecord().getR_id()%>&mark=true">
    				发表日志：<%=detail.getRecord().getR_title()%></a>
    				<%if(detail.getRecord().getR_content().length()>60){ %>
    				<%=detail.getRecord().getR_content().substring(0,60)+"..." %>
    				<%}  else{%>
    				<%=detail.getRecord().getR_content() %>
   					<%} %>
    				<%} 
    				
    				
    				
    				else{%>
							<h4>
								<%=detail.getRecord().getR_content()%></h4> 
								 <%} %>
								
							<%
								if ((detail.getRecord().getR_phourl()) != null
											&& !(detail.getRecord().getR_phourl().isEmpty())) {
							%>
							<ul class="DemoItems">
								<li>
									<a href="javascript: void(0);"
										rel="Picasa[<%=imgpath + detail.getRecord().getR_phourl()%>]"><img
											src="<%=imgpath + detail.getRecord().getR_phourl()%>"
											width="60px" height="60px" /> </a>
								</li>
							</ul>
							<%
								} else {
							%>
							<ul></ul>
							<%
								}
							%>
						</div>

						<p class="post-footer">




							<a class="readmore"
								href="<%=basePath%>community/disList.action?rid=<%=detail.getRecord().getR_id()%>&mark=true"><font
								size="2px">评论(<%=detail.getRecord().getR_comment()%>)</font> </a>|&nbsp;&nbsp;


							<a class="comments"
								href="<%=basePath%>community/resList.action?rid=<%=detail.getRecord().getR_id()%>&mark=false"><font
								size="2px">转发(<%=detail.getRecord().getR_resend()%>)</font> </a>|&nbsp;&nbsp;


							<a class="date"><font size="2px" color="grey">发布时间:<%=detail.getRecord().getR_time()%></font>
							</a>


							<%
								if (((String) session.getAttribute("myUser")).equals(detail
											.getRecord().getPerson_id())) {
							%>
							<a href="javascript: void(0);"
								onclick="con(<%=detail.getRecord().getR_id()%>)"><font
								size="2px">删除该条微言</font> </a>
							<%
								}
							%>
						</p>
						<br>
						<hr>
						<br>
						<%
							}
						%>
					</div>


					<!-- main ends -->

					<div>
					
						<%
							PageView pageView = new PageView();
							pageView = (PageView) request.getAttribute("pageView");
						%>
						<font size="2" face="宋体">当前页:第<%=pageView.getCurrentpage()%>页 | 总记录数:<%=pageView.getTotalrecord()%>条
							| 每页显示:<%=pageView.getMaxresult()%>条 | 总页数:<%=pageView.getTotalpage()%>页</font>
						<br>
						<br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<%
							if (pageView.getCurrentpage() == 1) {
						%>
						<b><font size="2" face="宋体">第1页</font> </b>
						<%
							} else {
						%>
						<a href="javascript:topage('1')"><font size="2" face="宋体">第1页</font></a>
						<%
							}
						%>

						<%
							if (pageView.getCurrentpage() > 2) {
						%>
						<a href="javascript:topage(<%=pageView.getCurrentpage() - 1%>)">上一页</a>
						<%
							}
						%>
						<%
							if (pageView.getCurrentpage() != 1
									&& pageView.getCurrentpage() != pageView.getTotalpage()) {
						%>
						<b><font size="2" face="宋体">第<%=pageView.getCurrentpage()%>页</font> </b>
						<%
							}
						%>
						<%
							if (pageView.getCurrentpage() < pageView.getTotalpage()) {
						%>
						<a href="javascript:topage(<%=pageView.getCurrentpage() + 1%>)">下一页</a>
						<%
							}
						%>

						<%
							if (pageView.getCurrentpage() < pageView.getTotalpage()) {
						%>
						<a href="javascript:topage(<%=pageView.getTotalpage()%>)">末页</a>
						<%
							} else {
						%>
						<b><font size="2" face="宋体">末页</font> </b>
						<%
							}
						%>
					</div>

				</div>


				<div id="sidebar">

    <!-- 20121208新增 -->
					<font face="宋体" size="2" color="red"> 
					<%
        String user=(String)session.getAttribute("myUser");
	if(user!=null){
	%> &nbsp;
	您好：<%=user %>
	
	&nbsp;<a href="<%=basePath %>login/exit.action" style="text-decoration:none;">退出系统</a>
	&nbsp;<a href="<%=basePath %>home/Home.jsp" style="text-decoration:none;">系统首页</a>
	 <%} 
	%>
	</font>
<!-- END 20121208 -->
					<h3>
						
					</h3>
					<ul class="sidemenu">
						<li>
							<a href="<%=basePath%>community/getStatusList.action">社区首页</a>
						</li>
						<li>
							<a href="<%=basePath%>community/personDetail.action">资料修改</a>
						</li>
						<li>
							<%
								if (request.getAttribute("message") != null) {
							%>
							<a><%=request.getAttribute("message").toString()%></a>
							<%
								}
							%>
							<%
								int count = (Integer) request.getAttribute("messageCount");
								if (count == 0) {
							%>
							<a href="<%=basePath%>community/MessageList.action">消息盒子(0)</a>
							<%
								} else {
							%>
							<a href="<%=basePath%>community/MessageList.action"><font
								color="red" style="font-weight: bold">消息盒子(<%=count%>)</font> </a>
							<%
								}
							%>

						</li>

					</ul>



					<h3>
						
					</h3>
					<form action="<%=basePath%>community/personSearch.action" method="post">
						<input type="text" id="source" name="source">
						&nbsp;&nbsp;
						<input type="submit" value="搜索">
					</form>






					<!-- sidebar ends -->
				</div>

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
							
							<a href="http://www.linglong.cn/">Company home
								</a> |
								<a href="<%=basePath %>home/Home.jsp">Learning online home</a>
							<br>
							&copy; 2012
							<strong>玲珑轮胎集团</strong> &nbsp;&nbsp;&nbsp;&nbsp;
						</p>
					</div>

					<!-- footer ends-->
				</div>
			</div>

			<!-- wrap ends here -->
		</div>

	</body>
</html>
