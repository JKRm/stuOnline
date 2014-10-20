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

		<title>试题上传</title>

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
			src="<%=basePath%>Exam/exam_js/ExamUpload.js"></script>

	</head>

	<body>
	 <div id="include-div">
		<form action="exam/ExamAction.action" class="exam-form" method="post">
		<h3>添加试题</h3>
		<p class="text-info">
			<label>知识点</label>
			<select name="e_kno_id" id="e_kno_id">
				<option selected>请选择</option>
				<%
					List<Course> courseList = (List<Course>)session.getAttribute("courseList"); 
					for(int i = 0; i < courseList.size(); ++i){
				%>
				<option value="<%=courseList.get(i).getC_id()%>"><%=courseList.get(i).getC_name()%></option>
				<%}
				%>
			</select>
		</p>
		<p class="text-info">
			<label>类型</label>
			<select name="e_type" id="e_type" onchange="select()">
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
		<p class="text-info">
			<label>题干</label>
		</p>
		<p>
			<textarea name="e_question" id="e_question"></textarea>
		</p>
			<div id="e_hiden">
			</div>
			答案：
			<textarea name="e_answer" id="e_answer"
				style="resize: none; width: 300; height: 100"></textarea>
			
			分数：
			<input type="text" name="e_score" id="e_score">
			
			<input type="submit" class="button" value="提交">
		</form>
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
		CKEDITOR.replace('e_question');
		CKEDITOR.replace('e_answer');
	//
	</script>
</html>