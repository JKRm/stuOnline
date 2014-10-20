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
	  <h3>开始答题</h3>
	  <ul class="exams-list">
		<%
			List<Test_produce> testProduceList = (List<Test_produce>)request.getAttribute("testProduceList");
			List<Long> ep_yon = (List<Long>)request.getAttribute("ep_yon");
			List<Integer> show = (List<Integer>)request.getAttribute("show");
			for(int i = 0; i < testProduceList.size(); ++i){
				%>
	  	<li>
				<%=testProduceList.get(i).getTp_title() %>
				<%
				if(show.get(i) == 1){
				%>
					正在审核中
				<%	
				}else{
					if(ep_yon.get(i) == 1) {
				%>
						<a href="exam/showAnalysePersonAction.action?tp_id=<%=testProduceList.get(i).getTp_id() %>">查看</a>
					
				<%			
					}else { %>
						<a href="exam/AnswerExamExAction.action?tp_id=<%=testProduceList.get(i).getTp_id() %>">答题</a>
				<%
					}
				}
				%>
		  </li>
				<%
			}
		%>
	  </ul>
	</div>
	</body>
</html>
