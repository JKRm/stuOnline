<%@ page language="java" import="java.util.*,com.shanda.linglong.vo.*,com.shanda.linglong.model.*"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>企业社区</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet"
			href="<%=basePath%>enCommunity/images/TechJunkie.css" type="text/css" />
		<link href="<%=basePath%>enCommunity/Picasa/Picasa.css"
			rel="stylesheet" type="text/css" />
		<script type="text/javascript">
		function addNewLine(obj,location,to,source) {
		var area = document.getElementById(location);
		if(obj.innerHTML=="回复"){
			
			area.innerHTML +=  "<form action=\"community/addRpeat.action\" method=\"post\"><input type=\"textarea\" id=\"content\" name=\"content\" style=\"width:450px;height:50px;\"><input type=\"hidden\" id=\"to\" name=\"to\" value="+to+"><input type=\"hidden\" id=\"source\" name=\"source\" value="+source+">&nbsp;&nbsp;<div style=\"position:relative;left:400px;top:3px;\"><input type=\"submit\" value=\"回复\"></div></form>";
			obj.innerHTML="收起回复";
		}
		else{
		area.innerHTML = "";
		obj.innerHTML="回复";
		}
			
		}
		
		function topage(currentpage) {
			var form = document.createElement("form");
			location.href = "<%=basePath%>community/disList.action?currentpage=" + currentpage;
			form.submit();
	}
		
	</script>
	</head>

	<body>
	
	
	
		<!-- wrap starts here -->
		<div id="wrap">

			<!--header -->
			<div id="header">

				<h1 id="logo-text">
					<a href="index.html" title=""></a>
				</h1>
				<p id="slogan">
					
				</p>


				<p></p>


				<!--header ends-->
			</div>

			<!-- navigation starts	-->
			<div id="nav">
				<ul>
					<li id="current">
						<%
							if (request.getAttribute("message") != null) {
						%>
						<a><%=request.getAttribute("message").toString()%></a>
						<%
							}
						%>




						<!--  				<form action="community/publish.action"
							enctype="multipart/form-data" method="post">


							想说的话：&nbsp;&nbsp;
							<input type="text" id="content" name="content">
							&nbsp;&nbsp; 添加图片：&nbsp;&nbsp;
							<input type="file" id="upload" name="upload">
							&nbsp;&nbsp;



							<input type="submit" value="发送" onclick="alert('微言发送成功！');">
						</form>-->

					</li>

				</ul>
				<!-- navigation ends-->
			</div>

			<!-- content-wrap starts -->
			<div id="content-wrap">

				<div id="main">

					<a name="TemplateInfo"></a>
					<h2>
						<a href="index.html" title="">发表评论</a>
					</h2>



					<%
						String r_id = (request.getAttribute("rid")).toString();
					%>
					<%Record record = new Record();
	record = (Record)session.getAttribute("recordDoc");
	
	if(record.getR_title()!=null){ 
	%>
	<center><h3><%=record.getR_title() %></h3></center>
	<p><%=record.getR_content() %></p>
	
	<%} %>
					<form action="community/addDis.action" method="post">
						
							我的评论：&nbsp;&nbsp;
							<textarea id="content" name="content" style="width:450px;height:50px;"></textarea>
						
							<input type="hidden" id="to" name="to" value=<%=r_id%>>
							<br />
					
						<div style="position:relative;left:400px;top:-10px;">
						<input type="submit" value="发送"></div>
					</form>

					<div>

						<%
							List<DiscussVo> dvList = (List<DiscussVo>) request
									.getAttribute("dvList");
							for (int i = 0; i < dvList.size(); ++i) {
								DiscussVo discuss = dvList.get(i);
						%>

						<a
							href="<%=basePath%>community/homeDes.action?pid=<%=discuss.getRecord_discuss().getPerson_id()%>"><%=discuss.getNickname()%></a>:
						<%=discuss.getRecord_discuss().getRd_content()%>

						<font size="2px"><a href="javascript:void(0)"
							onclick="addNewLine(this,<%=discuss.getRecord_discuss().getRd_id()%>,'<%=discuss.getRecord_discuss().getPerson_id()%>',<%=r_id%>);return false"
							id="<%=r_id%>">回复</a>
						</font>&nbsp;&nbsp;
						<a><font size="2px" color="grey">发布时间:<%=discuss.getRecord_discuss().getRd_time()%></font>
						</a>
						<%
							if (((String) session.getAttribute("myUser")).equals(discuss
										.getRecord_discuss().getPerson_id())) {
						%>
						<a
							href="<%=basePath%>community/delDis.action?rdid=<%=discuss.getRecord_discuss().getRd_id()%>"><font
							size="2px">删除</font> </a>
						<%
							}
						%>
						<br>
						<div id="<%=discuss.getRecord_discuss().getRd_id()%>">
						&nbsp;
						</div>

						

						<%
							}
						%>
					</div>
<br><br>
					<div>
						<%
							PageView pageView = new PageView();
							pageView = (PageView) request.getAttribute("pageView");
						%>
						当前页:第<%=pageView.getCurrentpage()%>页 | 总记录数:<%=pageView.getTotalrecord()%>条
							| 每页显示:<%=pageView.getMaxresult()%>条 | 总页数:<%=pageView.getTotalpage()%>页
						<br>
						<br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<%
							if (pageView.getCurrentpage() == 1) {
						%>
						<b>第1页 </b>
						<%
							} else {
						%>
						<a href="javascript:topage('1')">第1页</a>
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
						<b>第<%=pageView.getCurrentpage()%>页 </b>
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
						<b>末页 </b>
						<%
							}
						%>
					</div>



					<!-- main ends -->


					


				</div>

				<div id="sidebar">

<font face="宋体" size="2" color="red"> 
					<%
        String user=(String)session.getAttribute("myUser");
	if(user!=null){
	%> &nbsp;
	您好：<%=user %>
	
	&nbsp;<a href="<%=basePath %>login/exit.action" style="text-decoration:none;">退出系统</a>
	 <%} 
	%>
					<h3>
						
					</h3>
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



					<h3>
						
					</h3>
					<form action="community/personSearch.action" method="post">
						<input type="text" id="source" name="source">
						&nbsp;&nbsp;
						<input type="submit" value="搜索">
					</form>
					<p></p>





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
