<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.shanda.linglong.model.Test_answer"%>
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

		<title>问卷列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<link type="text/css" rel="stylesheet"
						href="<%=basePath%>css/admin.css" />
		<link type="text/css" rel="stylesheet"
						href="<%=basePath%>css/exam.css" />
	</head>

	<body>
	  <div id="include-div">
	    <h3>批阅调查问卷</h3>
		<%
			Test_answer test_answer = (Test_answer)session.getAttribute("test_answer");
			String yon = (String)request.getAttribute("yon");
			if(yon.equals("0")){
		%>	
		<p>
		  <label>得分</label>
		  <span class="score"><%=test_answer.getTa_score() %></span>分
		</p>
		<form action="answerTest/insertTestAction.action" method="post">
		  <p>
		    <label>评价</label>			
		  </p>
		  <textarea name="ta_analyse" id="ta_analyse"></textarea>
		  <p class="submitLine">
			<input type="submit" class="button" value="下一步">
		  </p>
		</form>
		<%	
			}else{
		%>	
		  <p>
		    <label>得分</label>
			<span class="score"><%=test_answer.getTa_score() %></span>
		  </p>
		  <p>
		    <label>评价</label>
		    <div class="score-div">
			<%=test_answer.getTa_analyse() %>
		    </div>
		  </p>
		<% } %>
	  </div>
	</body>
	
	<script type="text/javascript">
	//         
		window.CKEDITOR_BASEPATH = '<%=basePath%>ckeditor/';
	//
	</script>
	<script type="text/javascript" src="<%=basePath%>ckeditor/ckeditor.js?t=B37D54V"></script>
	<script type="text/javascript">
	//         
		CKEDITOR.replace('ta_analyse');
	//
	</script>
	
</html>
