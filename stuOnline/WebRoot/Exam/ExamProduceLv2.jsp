<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.shanda.linglong.model.Course" %>
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

		<title>试卷生成</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

		<!-- CSS -->
		<link type="text/css" rel="stylesheet"
			href="<%=basePath%>ckeditor/_samples/sample.css" />
		<link type="text/css" rel="stylesheet"
			href="<%=basePath%>css/admin.css" />
			
	</head>

	<body>
	  <div id="include-div">
		<h3>自动生成试卷</h3>
		<p class="step">第二步 请输入试卷题目类型信息，加*的为必填项</p>
		
		<form action="<%=basePath%>Exam/ExamProduceLv3.jsp" method="post">
		  <p>
		    <label><font color="red">*</font>题目类型</label>
			<select name="e_type" id="e_type">
				<option selected>请选择</option>
				<option value="填空">填空</option>
				<option value="选择">选择</option>
				<option value="名词解释">名词解释</option>
				<option value="辨析题">辨析题</option>
				<option value="判断题">判断题</option>
				<option value="简答题">简答题</option>
				<option value="计算题">计算题</option>
				<option value="实践题">实践题</option>
			</select>
		  </p>
		  <p>
		    <label><font color="red">*</font>题目数量</label>	
			<input type="text" name="number" id="number">
		  </p>
		  <p>
		    <label><font color="red">*</font>总分数</label>
			<input type="text" name="total" id="total">
		  </p>
		  <p>
			<input class="button" type="submit" value="下一步" style="margin-left: 70px;">
			<input class="button" type="reset" value="重置">
		  </p>
		</form>
	</div>
	</body>
</html>
