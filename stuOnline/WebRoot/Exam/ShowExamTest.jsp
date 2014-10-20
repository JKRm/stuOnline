<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.shanda.linglong.model.Exam"%>
<%@ page import="com.shanda.linglong.model.Exam_option"%>
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
						
		<script>
			function clickSubmit(id) {
				document.getElementById(id).submit();
			}
		</script>
	</head>

	<body>
	<div id="include-div">
	<h3>开始答题</h3>
		<%
			Exam exam = (Exam)request.getAttribute("exam"); 
		%>
		<div class="subject-content"><%=exam.getE_question() %></div>
		<%	if(exam.getE_type().equalsIgnoreCase("选择")){
				List<Exam_option> exam_optionList = (List<Exam_option>)request.getAttribute("exam_optionList");
				for(Exam_option exam_option : exam_optionList){
		%>
			<%=exam_option.getEo_option() %>
		<%	
				}
			}
	    %>
	    <p class="submitLine">
	    	<input type="button" class="button" value="提交" onclick="clickSubmit('exam-subject')">
	    </p>
	    	<form action="exam/AnswerAction.action" method="post" id="exam-subject">
		     <p>
		    	<label>作答</label>
		     </p>
				<textarea name="a_answer" id="e_answer"
					style="resize: none; width: 300; height: 100"></textarea>
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
		CKEDITOR.replace('a_answer');
	//
	</script>
</html>
