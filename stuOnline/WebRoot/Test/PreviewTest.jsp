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
			href="<%=basePath%>ckeditor/_samples/sample.css" />
		<link type="text/css" rel="stylesheet"
						href="<%=basePath%>css/admin.css" />	
		<!-- JavaScript -->
		<script type="text/javascript"
			src="<%=basePath%>Test/test_js/PreviewTest.js"></script>
		<script type="text/javascript" src="<%=basePath%>/flexpaper/js/jquery.js"></script>
	</head>

	<script type="text/javascript">
		var t_id = <%=session.getAttribute("t_id")%>;
	
	</script>
	<body>
		<div id="include-div">
		  <h3>修改调查问卷</h3>
		  <p class="text-info">
		    <label>问卷名称</label>
		    <input type="text" name="t_name" id="t_name" class="readOnly" value="<%=request.getAttribute("t_name")%>" readonly="readonly">
		  </p>
			<%if(request.getAttribute("t_explain") != null) {%>
		  <p class="text-info">
			<label>问卷说明</label>
		  </p>
		  <p class="text-info">
		    <label>&nbsp;</label>
			<textarea name="t_explain" id="t_explain" class="readOnly" readonly="readonly" style="resize: none; width: 300; height: 100"><%=request.getAttribute("t_explain")%></textarea>
		  </p>
			<%} %>
		  <p class="text-info">
		  	<label>添加时间</label>
		  	<input type="text" name="t_time" id="t_time" class="readOnly" value="<%=request.getAttribute("t_time")%>" readonly="readonly">
		  </p>
		  <p>
			<input type="button" value="修改" class="button" id="t_button" onclick="update()">
			<input type="button" value="下一步" id="next_butoon" class="button" onclick="window.location.href='previewTest/Test_questionListAction.action?t_id=<%=session.getAttribute("t_id")%>'">
			<input type="button" value="继续添加" id="add" class="button" onclick="window.location.href='<%=basePath%>Test/Test_questionUpload.jsp'">
		  </p>
		</div>
	</body>
</html>
