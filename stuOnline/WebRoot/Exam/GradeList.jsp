<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.shanda.linglong.model.Exam"%>
<%@ page import="com.shanda.linglong.model.Answer"%>
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
		<link type="text/css" rel="stylesheet"
						href="<%=basePath%>css/exam.css" />

	</head>

	<body>
	  <div id="include-div">
	  <h3>批改试卷</h3>
		<%
			Exam exam = (Exam)request.getAttribute("exam");
			List<Answer> answerList = (List<Answer>)session.getAttribute("answerList");
		%>
		<form action="exam/submAction.action" method="post">
		<p>
		  <label>满分分数</label>
		  <span class="score"><%=exam.getE_score() %></span>分
		</p>
		<p>
		  <label>标准答案</label>
		  <div class="right-answer"><%=exam.getE_answer() %></div>
		</p>
		<p class="subjects-type">审批</p>
		<%
			for(Answer answer : answerList){
		%>
		<div class="answer-div">
		  <p>
			<label>所做答案</label>
		  </p>
		  <%=answer.getA_answer() %>
		</div>
		<div class="score-div">
		  <p>
			<label>得分</label>
			<input type="text" name="a_score" id="a_score">
		  </p>
		</div>
		<div class="evaluate-div">
		  <p>
			<label>评价</label>
		  </p>
			<textarea name="a_annotate" id="a_annotate"></textarea>
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
