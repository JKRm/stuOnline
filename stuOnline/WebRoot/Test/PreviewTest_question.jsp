<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.shanda.linglong.model.Test_question"%>
<%@ page import="com.shanda.linglong.model.Test_option"%>
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

		<title>问卷编辑</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

		<!--CSS-->
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>Test/test_css/PreviewTest.css">
		<link type="text/css" rel="stylesheet"
			href="<%=basePath%>ckeditor/_samples/sample.css" />
		<link type="text/css" rel="stylesheet"
						href="<%=basePath%>css/admin.css" />

		<!-- JavaScript -->
		<script type="text/javascript"
			src="<%=basePath%>Test/test_js/PreviewTest_question.js"></script>
		<script type="text/javascript" src="<%=basePath%>/flexpaper/js/jquery.js"></script>
	</head>

	<body>
	  <div id="include-div">
		<%
			Test_question test_question = (Test_question) request
					.getAttribute("test_question");
			List<Test_option> test_option = (List<Test_option>) request
					.getAttribute("test_option");
		%>
		
		<script type="text/javascript">
			var toption_id = new Array();
			var i = 0;
			function next(){
				window.location.href="previewTest/Test_questionListAction.action?t_id=<%=session.getAttribute("t_id")%>";
			}
		</script>	
		
		<p>
			<label style="text-align:left;">题干</label>
		</p>
		<p>
			<label>&nbsp;</label>
		<textarea name="tq_question" id="tq_question" class="readOnly"
			readonly="readonly"><%=test_question.getTq_question()%></textarea>
		</p>
		<div id="test_option">
		<p>
			<label style="text-align:left;">题目选项</label>
		</p>
		<%for(int i = 0; i <test_option.size(); ++i ) {%>
  		  <p>
			<label>选项描述</label>
			<input type="text" name="to_option" id="to_option" class="readOnly" readonly="readonly" value="<%=test_option.get(i).getTo_option()%>">
		  </p>
		  <p>			
			<label>得分</label>
			<input name="to_score" id="to_score" type="text" class="readOnly" readonly="readonly" value="<%=test_option.get(i).getTo_score()%>">
		  </p>
			<script type="text/javascript">
				toption_id[i] = <%=test_option.get(i).getToption_id()%>;
				++i;
			</script>
		<%} %>
		</div>
		<p class="submitLine">
		  <input type="button" class="button" value="修改" id="t_button" onclick="update()">
		  <input type="button" class="button" value="下一步" id="next_butoon" onclick="next()">
		</p>
	</div>
	</body>
</html>
