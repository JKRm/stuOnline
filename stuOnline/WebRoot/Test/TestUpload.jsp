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

		<title>问卷上传</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		
		<!-- CSS -->
		<link type="text/css" rel="stylesheet"
			href="<%=basePath%>ckeditor/_samples/sample.css" />
		<link type="text/css" rel="stylesheet"
						href="<%=basePath%>css/admin.css" />
		<!-- JavaScript -->
		<script type="text/javascript"
			src="<%=basePath%>Test/test_js/TestUpload.js"></script>

	</head>

	<body>
	<div id="include-div">
	  <h3>增加调查问卷</h3>
	  <p class="step">
		第一步 请输入调查问卷基本信息，加*的为必填项
	  </p>
		<form action="uploadTest/uploadTestAction.action" method="post" class="exam-form">
			<p class="text-info">
			  <label>
				<font color="red">*</font>问卷名称
			  </label>
			  <input name="t_name" type="text" id="t_name">
			</p>
			<p class="text-info">			
			   	<label>问卷说明</label>
			</p>
			<p class="text-info">			
			   	<label>&nbsp;</label>
				<textarea name="t_explain" id="t_explain"></textarea>
			</p>
			<p>&nbsp;</p>
			<p class="submitLine" style="margin-top:15px;clear:both;">
			  <input type="submit" class="button" value="下一步" onclick="return validation()">
			  <input type="reset" class="button" value="重置">
			</p>
		</form>
	</div>
	</body>
</html>
