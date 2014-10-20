<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.shanda.linglong.model.Exam_paper"%>
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

		<title>试卷列表</title>

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
	<h3>查看结果</h3>
		<%
			List<Exam_paper> exam_paperList = (List<Exam_paper>)session.getAttribute("exam_paperList");
		%>
		<form action="exam/finshowAction.action" method="post">
		<%
			for(Exam_paper exam_paper : exam_paperList){
		%>
			<div class="score-div">
				<p>
					<label>得分</label>
					<span class="score"><%=exam_paper.getEp_score() %></span>分
				</p>
			</div>
			<div class="evaluate-div">
				<p>
					<label>评价</label>
				</p>
				<textarea name="ep_annlyse" id="ep_annlyse"></textarea>
			</div>
		<%
			}
		%>
		<p class="submitLine">
		<input type="submit" class="button" value="提交">
		</p>
		</form>
	</div>
	</body>
</html>
