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
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/front.css">

		<!-- JavaScript -->
		<script type="text/javascript" src="<%=basePath%>/flexpaper/js/jquery.js"></script>
	</head>

	<body>
	<div id="include-div">
	<h3>职业测评</h3>
		<%
			Test_question test_question = (Test_question) request
					.getAttribute("test_question");
			List<Test_option> test_option = (List<Test_option>) request
					.getAttribute("test_option");
		%>
		
		<h4><%=test_question.getTq_question()%></h4>
		<div id="test_option">
		<ul>
		<%for(int i = 0; i <test_option.size(); ++i ) {%>
			<li><input type="radio" name="to_option" id="to_option" value="<%=test_option.get(i).getToption_id()%>" onchange="answer()"><%=test_option.get(i).getTo_option()%></li>
		<%} %>
		</ul>
		</div>
		<script type="text/javascript">
		function answer(){
			var radios = document.getElementsByName("to_option");
			for(var i = 0; i < radios.length; ++i){
				var radio = radios[i];
				if(radio.checked){
					window.location.href = "answerTest/answerTest_questionListAction.action?toption_id="+radio.value;
				}
			}
		}
		</script>
	</div>
	</body>
</html>
