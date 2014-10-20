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
		<p class="step">第一步 请输入试卷基本信息，加*的为必填项</p>
		<form action="exam/Exam_prouceAction.action" method="post" class="exam-form">
		<p class="text-info">
			<label><font color="red">*</font>试卷名称</label>
			<input name="tp_title" type="text" id="tp_title">
		</p>
		<p class="text-info">
			<label>试卷说明</label>
		</p>
			<textarea name="tp_describe" id="tp_describe"
				style="resize: none; width: 300; height: 100"></textarea>
			<p>
			<label>所属范围</label>	
			<select name="c_id" id="c_id">
				<option selected="selected">请选择</option>
				<%
					List<Course> courseProduceList = (List<Course>)request.getAttribute("courseProduceList"); 
					for(int i = 0; i < courseProduceList.size(); ++i){
				%>
				<option value="<%=courseProduceList.get(i).getC_id()%>"><%=courseProduceList.get(i).getC_name()%></option>
				<%
					}
				%>
			</select>
			<input type="submit" value="下一步" class="button">
			<input type="reset" value="重置" class="button">
			</p>
		</form>
		<script type="text/javascript">
		//         
			window.CKEDITOR_BASEPATH = '<%=basePath%>ckeditor/';
		//
		</script>
		<script type="text/javascript" src="<%=basePath%>ckeditor/ckeditor.js?t=B37D54V"></script>
		<script type="text/javascript">
		//         
			CKEDITOR.replace('tp_describe');
		//
		</script>
	</div>
	</body>
</html>
