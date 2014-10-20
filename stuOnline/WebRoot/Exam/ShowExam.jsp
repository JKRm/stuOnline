<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.shanda.linglong.model.Test_produce"%>
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

		<title>试卷说明</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<link type="text/css" rel="stylesheet"
					href="<%=basePath%>css/admin.css" />
	</head>

	<body>
	<div id="include-div">
	<h3>开始答题</h3>
		<%Test_produce test_produce = (Test_produce)request.getAttribute("test_produce"); %>
	  <p>
		<label>试卷标题</label>
		<%=test_produce.getTp_title() %>
	  </p>
	  <p>
		<label>试卷说明</label>
		<div class="auto-text-area"><%=test_produce.getTp_describe() %></div>
	  </p>
	  <p class="submitLine">
		<input type="submit" value="下一步" class="button" onclick="next()">
	  </p>
		<script type="text/javascript">
			function next(){
				window.location.href="exam/AnswerExamTestAction.action";
			}
		</script>
	</div>
	</body>
</html>
