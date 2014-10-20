<%@ page language="java" import="java.util.*,com.shanda.linglong.model.*,com.shanda.linglong.vo.*"
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
		
		
		<script language="javascript"
			src="<%=basePath %>enCommunity/Picasa/Picasa.js"></script>

<script>
function topage(currentpage) {
			var form = document.createElement("form");
			location.href = "<%=basePath %>community/homeDes.action?currentpage=" + currentpage;
			form.submit();
	}

</script>
	</head>

	<body>
		<!-- wrap starts here -->
		<div id="wrap">

			<!--header -->
			<div id="header">




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




				<!--  		<form action="community/publish.action"
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
						<a href="index.html" title="">查看社区成员</a>
					</h2>
						
			
<%
			Person_detail pd = new Person_detail();
			List<Record> rList = new ArrayList<Record>();
			pd = (Person_detail) request.getAttribute("personDetail");
			rList = (List<Record>) request.getAttribute("rList");
			String imgpath = "../../studentOnline_source/community/image/";
			String portrait = "../../studentOnline_source/community/portrait/";
		%>
		<p>
			用户ID：<%=pd.getPerson_id()%></p>
		<p>
			昵称：<%=pd.getPd_nickname()%></p>
		<p>
			邮箱：<%=pd.getPd_email()%></p>
		<p>
			头像：<img src="<%=portrait+pd.getPd_photo() %>" width="54px" height="54px"/></p>
		<div id="noticeList">
			已发消息：<br>

			<%
					for (int i = 0; i < rList.size(); ++i) {
						Record record = rList.get(i);
				%>

			Ta说：<%=record.getR_content()%>
			<ul class="DemoItems">
				<li>
					<a href="javascript: void(0);"
						rel="Picasa[<%=imgpath+ record.getR_phourl() %>]"><img
							src="<%=imgpath+record.getR_phourl() %>" width="54px"
							height="54px" />
					</a>
				</li>
			</ul>
			
	<div style="clear: both"></div>
	<a href="<%=basePath %>community/disList.action?rid=<%=record.getR_id()%>"><font size="2px">评论(<%=record.getR_comment() %>)</font> </a>&nbsp;&nbsp;
	<a href="<%=basePath %>community/resList.action?rid=<%=record.getR_id()%>&mark=false"><font size="2px">转发(<%=record.getR_resend()%>)</font></a>&nbsp;&nbsp;
	<a><font size="2px" color="grey">发布时间:<%=record.getR_time() %></font></a>&nbsp;&nbsp;
	<%if(((String)session.getAttribute("myUser")).equals(record.getPerson_id())){	%>
				<a href="<%=basePath %>community/delRecord.action?rid=<%=record.getR_id() %>"><font size="2px">删除该条微言</font></a>
			 <%}%>
	
	<br><hr><br>
			<%
					}
				%>

		</div>
		<div>
<%PageView pageView = new PageView();
  pageView = (PageView)request.getAttribute("pageView");
 %>
 <font>当前页:第<%=pageView.getCurrentpage() %>页 | 总记录数:<%=pageView.getTotalrecord() %>条 | 每页显示:<%=pageView.getMaxresult() %>条 | 总页数:<%=pageView.getTotalpage() %>页</font><br><br>
　&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%if(pageView.getCurrentpage()==1){ %>
	<b><font >第1页</font></b>
<%} else{ %>
	<a href="javascript:topage('1')" >第1页</a>
<%} %>

<%if(pageView.getCurrentpage()>2) {%>
<a href="javascript:topage(<%=pageView.getCurrentpage()-1 %>)" >上一页</a>
<%} %>
<%if(pageView.getCurrentpage()!=1&&pageView.getCurrentpage()!=pageView.getTotalpage()) {%>
<b><font>第<%=pageView.getCurrentpage() %>页</font></b>
<%} %>
<%if(pageView.getCurrentpage()<pageView.getTotalpage()) {%>
<a href="javascript:topage(<%=pageView.getCurrentpage()+1 %>)" >下一页</a>
<%} %>

<%if(pageView.getCurrentpage()<pageView.getTotalpage()) {%>
<a href="javascript:topage(<%=pageView.getTotalpage() %>)" >末页</a>
<%} else{%>
<b><font>末页</font></b>
<%} %>
</div>


					<!-- main ends -->


					<div>
					
					</div>



				</div>

				<div id="sidebar">

					
					<ul class="sidemenu">
						<li>
							<a href="<%=basePath %>community/getStatusList.action">社区首页</a>
						</li>
						<li>
							<a href="<%=basePath %>community/personDetail.action">资料修改</a>
						</li>
						<li>
							

						</li>

					</ul>



					
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
							&copy; 2010
							<strong>Your Company</strong> &nbsp;&nbsp;&nbsp;&nbsp;
							<a href="http://www.cssmoban.com/" title="Website Templates">website
								templates</a> from
							<a href="http://www.cssmoban.com/">网站模板</a> | Valid
							<a href="http://validator.w3.org/check?uri=referer">XHTML</a> |
							<a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a>

							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

							<a href="index.html">Home</a>&nbsp;|&nbsp;
							<a href="index.html">Sitemap</a>&nbsp;|&nbsp;
							<a href="index.html">RSS Feed</a>
						</p>
					</div>

					<!-- footer ends-->
				</div>
			</div>

			<!-- wrap ends here -->
		</div>

	</body>
</html>
