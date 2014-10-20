<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.shanda.linglong.model.Person"%>
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
	    <div class="person-list">
		<%
			List<Person> personList = (List<Person>)request.getAttribute("personList"); 
			List<Integer> yonList = (List<Integer>)request.getAttribute("yonList");
			for(int i = 0; i < personList.size(); ++i){
				if(yonList.get(i) == 0){
		%>
			<p>
				<a href="answerTest/evaluateTestAction.action?person_id=<%=personList.get(i).getPerson_id() %>&yon=0"><%=personList.get(i).getPersonname() %></a><br />
			</p>
		<%
				}else{
		%>
			<p>
				<a href="answerTest/evaluateTestAction.action?person_id=<%=personList.get(i).getPerson_id() %>&yon=1"><%=personList.get(i).getPersonname() %></a><br />
			</p>
		<%			
				}
			}
		%>
	    </div>
	  </div>
	</body>
</html>
