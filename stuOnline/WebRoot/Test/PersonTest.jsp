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
		<link href="<%=basePath%>css/front.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
	  <div id="include-div">
	    <h3>职业测评</h3>
		<%
			List<Test> testList = (List<Test>) request.getAttribute("testList");
			List<Long> yonList = (List<Long>) request.getAttribute("yonList");
			List<Integer> showList = (List<Integer>)request.getAttribute("showList");
		%>
		<div id="pro-test">
		  <ul>
			<%
				if (testList.size() > 0) {
					for (int i = 0; i < testList.size(); ++i) {
			%>
						<li><%=testList.get(i).getT_name()%>
						<%
							long num = yonList.get(i);
							int show = showList.get(i);
							if (show == 1 && num == 0) {
						%>
								<span class="status">[正在批阅中]</span>
						<%
							}else{
								 if (num == 1){ 
						%>
									<span class="status"><a href="answerTest/searchAnalyseAction.action?t_id=<%=testList.get(i).getT_id()%>">[查看]</a></span>
						<%
								}else {
						%>
									<span class="status"><a href="answerTest/answerTestAction.action?t_id=<%=testList.get(i).getT_id()%>">[答题]</a></span>
						<%		}%>
						<%}// end of if%>
						</li>
						<%
					}// end of for
				}
			%>
		  </ul>
		</div>
	  </div>
	</body>
</html>
