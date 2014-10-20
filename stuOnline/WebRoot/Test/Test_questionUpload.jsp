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
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<!-- CSS -->
		<link type="text/css" rel="stylesheet"
			href="<%=basePath%>ckeditor/_samples/sample.css" />
		<link type="text/css" rel="stylesheet"
						href="<%=basePath%>css/admin.css" />	
		<!-- JavaScript -->
		<script type="text/javascript"
			src="<%=basePath%>Test/test_js/Test_questionUpload.js"></script>

	</head>

	<body>
	  <div id="include-div">
	    <h3>添加调查问卷</h3>
	    <p class="step">
			第二步 请逐一输入问卷题目，点击完成录入完成该张问卷的录入
		</p>
		<form action="uploadTest/uploadTest_optionAction.action" method="post" id="upload">
		  <p>
		    <label><font color="red">*</font>题目题干</label>
		  </p>
		  <p>
		    <label>&nbsp;</label>
			<textarea name="tq_question" id="tq_question"></textarea>
		  </p>
		  <p>
		  <p>
		    <label>题目选项</label>
			<input name="to_option" id="to_option" type="text">
		  </p>
		  <p>
		    <label>得分</label>
			<input name="to_score" id="to_score" type="text">
		  </p>
		  <p>
			<input type="button" class="button" value="添加选项" onclick="add()">
			<input type="submit" class="button" value="下一步">
			<input type="reset" class="button" value="重置">
			<input type="submit" class="button" value="完成录入" onclick="changeAction()">
		  </p>
			<div id="form_upload">
			</div>
		</form>
		
	  </div>
		<script type="text/javascript">
			function changeAction(){
				document.getElementById("upload").action="uploadTest/finshAction.action";
		        document.getElementById("upload").submit();
		        return true;
			}
		</script>
	</body>
</html>
