<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.shanda.linglong.model.Test_produce"%>
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
		<h3>查看结果</h3>
		<p>
		  <label>试卷名称</label>
		<select onchange="direct()" name="selectTest" id="selectTest">
			<option selected>请选择</option>
			<%
				List<Test_produce> test_produceList = (List<Test_produce>)request.getAttribute("test_produceList"); 
				for(int i = 0; i < test_produceList.size(); ++i){
			%>
				<option value="<%=test_produceList.get(i).getTp_id()%>"><%=test_produceList.get(i).getTp_title()%></option>>
			<%
				}
			%>
		</select>
		</p>
		<script type="text/javascript">
			function direct(){
				var select = document.getElementById("selectTest");
				var options = select.options;
				var tp_id;
				for(var i = 0; i < options.length; ++i){
					var option = options[i];
					if(option.selected)
						tp_id = option.value;
				}
				window.location.href="exam/showAnalyAction.action?tp_id="+tp_id;
			}
		</script>
		</div>
	</body>
</html>
