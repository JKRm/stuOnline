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
	</head>

	<body>
	<div id="include-div">
		<%Exam_paper exam_paper = (Exam_paper)request.getAttribute("exam_paper"); %>
		<h3>开始答题</h3>
		<p>
			<label>得分</label>
			<span class="score"><%=exam_paper.getEp_score() %></span>分
		</p>
		<p>
			<label>评价</label>
			<%=exam_paper.getEp_annlyse() %>
		</p>
	</div>
	</body>
</html>
