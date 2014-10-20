<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>问卷编辑</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

		<!--CSS-->
		<link rel="stylesheet" type="text/css" href="<%=basePath%>Test/test_css/PreviewTest.css">
		<link type="text/css" rel="stylesheet"
						href="<%=basePath%>css/admin.css" />
		<!-- JavaScript -->
		<script type="text/javascript"
			src="<%=basePath%>Test/test_js/PreviewTest.js"></script>
		<script type="text/javascript" src="<%=basePath%>/flexpaper/js/jquery.js"></script>
	</head>

	<script type="text/javascript">
		var t_id = <%=request.getAttribute("t_id")%>;
	
	</script>
	<body>
		<div id="include-div">
		  <h3>职业测评</h3>
		  <p>
		    <label><b>调查问卷名称</b></label>
			<%=request.getAttribute("t_name")%>
		  </p>
			<%if(request.getAttribute("t_explain") != null){ %>
			<p>
				<label><b>问卷内容描述</b></label>
				<%=request.getAttribute("t_explain")%>
			</p>
			<% }%>
			<p class="submitLine">
			<input type="button" value="开始答题" class="button" id="next_butoon" onclick="window.location.href='answerTest/answerTest_questionAction.action'">
			</p>
		</div>
	</body>
</html>
