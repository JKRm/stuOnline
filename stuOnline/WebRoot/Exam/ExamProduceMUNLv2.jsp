<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.shanda.linglong.model.Exam" %>
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
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<!-- CSS -->
		<link type="text/css" rel="stylesheet"
			href="<%=basePath%>ckeditor/_samples/sample.css" />
		<link type="text/css" rel="stylesheet"
			href="<%=basePath%>css/admin.css" />

	</head>

	<body>
	<div id="include-div">
		<h3>手动生成试卷</h3>
		<p class="step">第二步 手工选择试题题目</p>
		<form action="exam/MunInsertAction.action" method="post" class="exam-form" id="handleSelectForm">
	<%
		List<Exam> exam1List = (List<Exam>)request.getAttribute("exam1List");
		List<Exam> exam2List = (List<Exam>)request.getAttribute("exam2List");
		List<Exam> exam3List = (List<Exam>)request.getAttribute("exam3List");
		List<Exam> exam4List = (List<Exam>)request.getAttribute("exam4List");
		List<Exam> exam5List = (List<Exam>)request.getAttribute("exam5List");
		List<Exam> exam6List = (List<Exam>)request.getAttribute("exam6List");
		List<Exam> exam7List = (List<Exam>)request.getAttribute("exam7List");
		List<Exam> exam8List = (List<Exam>)request.getAttribute("exam8List");
		if(exam1List.size() > 0){
			for(Exam exam : exam1List){
	%>
				<input type="checkbox" name="course" value="<%=exam.getE_id() %>"><%=exam.getE_question() %>			
	<%		
			}
		}
	%>
	<%
		if(exam2List.size() > 0){
			for(Exam exam : exam2List){
	%>
				<input type="checkbox" name="course" value="<%=exam.getE_id() %>"><%=exam.getE_question() %>			
	<%			
			}
		}
	%>
	<%
		if(exam2List.size() > 0){
			for(Exam exam : exam3List){
	%>
				<input type="checkbox" name="course" value="<%=exam.getE_id() %>"><%=exam.getE_question() %>			
	<%			
			}
		}
	%>
	<%
		if(exam2List.size() > 0){
			for(Exam exam : exam4List){
	%>
				<input type="checkbox" name="course" value="<%=exam.getE_id() %>"><%=exam.getE_question() %>			
	<%			
			}
		}
	%>
	<%
		if(exam2List.size() > 0){
			for(Exam exam : exam5List){
	%>
				<input type="checkbox" name="course" value="<%=exam.getE_id() %>"><%=exam.getE_question() %>			
	<%			
			}
		}
	%>
	<%
		if(exam2List.size() > 0){
			for(Exam exam : exam6List){
	%>
				<input type="checkbox" name="course" value="<%=exam.getE_id() %>"><%=exam.getE_question() %>			
	<%			
			}
		}
	%>
	<%
		if(exam2List.size() > 0){
			for(Exam exam : exam7List){
	%>
				<input type="checkbox" name="course" value="<%=exam.getE_id() %>"><%=exam.getE_question() %>			
	<%			
			}
		}
	%>
	<%
		if(exam2List.size() > 0){
			for(Exam exam : exam8List){
	%>
				<input type="checkbox" name="course" value="<%=exam.getE_id() %>"><%=exam.getE_question() %>			
	<%			
			}
		}
	%>
			<input type="submit" class="button" value="下一步">
		</form>
	</div>
	</body>
</html>
