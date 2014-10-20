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
	<%request.setCharacterEncoding("UTF-8"); %>

	<body>
	  <div id="include-div">
		<h3>自动生成试卷</h3>
		<p class="step">第三步 请输入试卷题目基本信息，加*的为必填项</p>
		<form action="exam/Exam_prouceLv3AddAction.action" method="post" class="exam-form">
			<%
				int number = Integer.valueOf(request.getParameter("number"));
				int total = Integer.valueOf(request.getParameter("total"));
				int score = total/number;
			%>
				<input type="hidden" value="<%=request.getParameter("e_type")%>" name="e_type" id="e_type">
				<input type="hidden" value="<%=score%>" name="e_score" id="e_score">
				<input type="hidden" value="<%=number%>" name="e_length" id="e_length">
			<%
				for(int i = 0; i < number; ++i){
			%>
			  <p class="text-info">
				<label>
					<font color="red">*</font>题目类型
				</label>
				<%=request.getParameter("e_type")%>
			  </p>
			  <p class="text-info">
			    <label>
					<font color="red">*</font>题目分数
			    </label>	
				<%=score%>
			  </p>
			  <p class="text-info">
			    <label>
					<font color="red">*</font>预期分数
				</label>
				<input type="text" name="e_diff" id="e_diff">
			  </p>
			  <p class="text-info">
			    <label>
					<font color="red">*</font>题目知识点
				</label>
				<select name="e_kno_id" id="e_kno_id">
					<option selected="selected">请选择</option>
				<%
					Set<Course> courseSet = (Set<Course>)session.getAttribute("courseSet"); 
					for(Course course : courseSet){
				%>
						<option value="<%=course.getC_id()%>"><%=course.getC_name()%></option>						
				<%		
					}
				%>
					</select>
		   	  </p>
		   	  <hr/>
			<%	
				}
			%>	
			<p>	
			<input type="submit" class="button" value="下一步" style="margin-left: 60px;">
			<input type="reset" class="button" value="重置">
			</p>
		</form>
	</div>
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
	</body>
</html>
