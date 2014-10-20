<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.shanda.linglong.model.Test"%>
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

		<title>问卷列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		
		<link type="text/css" rel="stylesheet"
						href="<%=basePath%>css/admin.css" />

	</head>

	<body>
	<div id="include-div">
		<h3>批阅调查问卷</h3>
		<p>
		  <label>调查问卷名称</label>
		<select onchange="direct()" name="selectTest" id="selectTest">
			<option selected>请选择</option>
			<%
				List<Test> testList = (List<Test>)session.getAttribute("testList"); 
				for(int i = 0; i < testList.size(); ++i){
			%>
				<option value="<%=testList.get(i).getT_id()%>"><%=testList.get(i).getT_name()%></option>
			<%
				}
			%>
		</select>
		</p>
		<script type="text/javascript">
			function direct(){
				var select = document.getElementById("selectTest");
				var options = select.options;
				var t_id;
				for(var i = 0; i < options.length; ++i){
					var option = options[i];
					if(option.selected)
						t_id = option.value;
				}
				window.location.href="answerTest/gradeTestAction.action?t_id="+t_id;
			}
		</script>
		</div>
	</body>
</html>
