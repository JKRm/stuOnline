<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.shanda.linglong.model.Exam"%>
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
	</head>

	<body>
	  <div id="include-div" class="subjects-list">
		  <h3>批改试卷</h3>
		<%
			List<Exam> exam1List = (List<Exam>)request.getAttribute("exam1List"); 
			List<Exam> exam2List = (List<Exam>)request.getAttribute("exam2List"); 
			List<Exam> exam3List = (List<Exam>)request.getAttribute("exam3List"); 
			List<Exam> exam4List = (List<Exam>)request.getAttribute("exam4List"); 
			List<Exam> exam5List = (List<Exam>)request.getAttribute("exam5List"); 
			List<Exam> exam6List = (List<Exam>)request.getAttribute("exam6List"); 
			List<Exam> exam7List = (List<Exam>)request.getAttribute("exam7List"); 
			List<Exam> exam8List = (List<Exam>)request.getAttribute("exam8List"); 
		%>
		
		<%	
			if(exam1List.size() > 0){
		%>
			<p class="subjects-type">判断题</p>
				<ul>
		<%
				for(int i = 0; i < exam1List.size(); ++i){
		%>	
					<li><a href="exam/analyAction.action?e_id=<%=exam1List.get(i).getE_id() %>">题目<%=i+1 %></a></li>
		<%		}%>
				</ul>
		<%	}%>
		
		<%	
			if(exam2List.size() > 0){
		%>
				<p class="subjects-type">辨析题</p>
				<ul>
		<%
				for(int i = 0; i < exam2List.size(); ++i){
		%>	
					<li><a href="exam/analyAction.action?e_id=<%=exam2List.get(i).getE_id() %>">题目<%=i+1%></a></li>
		<%		}%>
				</ul>
		<%	}%>
		
		<%	
			if(exam3List.size() > 0){
		%>
				<p class="subjects-type">选择题</p>
				<ul>
		<%
				for(int i = 0; i < exam3List.size(); ++i){
		%>	
					<li><a href="exam/analyAction.action?e_id=<%=exam3List.get(i).getE_id() %>">题目<%=i+1 %></a></li>
		<%		}%>
				</ul>
		<%	}%>
		
		<%	
			if(exam4List.size() > 0){
		%>
				<p class="subjects-type">填空题</p>
				<ul>
		<%
				for(int i = 0; i < exam4List.size(); ++i){
		%>	
					<li><a href="exam/analyAction.action?e_id=<%=exam4List.get(i).getE_id() %>">题目<%=i+1 %></a></li>
		<%		}%>
				</ul>
		<%	}%>
		
		<%	
			if(exam5List.size() > 0){
		%>
				<p class="subjects-type">名词解释题</p>
				<ul>
		<%
				for(int i = 0; i < exam5List.size(); ++i){
		%>	
					<li><a href="exam/analyAction.action?e_id=<%=exam5List.get(i).getE_id() %>">题目<%=i+1 %></a></li>
		<%		}%>
				</ul>
		<%	}%>
		
		<%	
			if(exam6List.size() > 0){
		%>
				<p class="subjects-type">计算题</p>
				<ul>
		<%
				for(int i = 0; i < exam6List.size(); ++i){
		%>	
					<li><a href="exam/analyAction.action?e_id=<%=exam6List.get(i).getE_id() %>">题目<%=i+1 %></a></li>
		<%		}%>
				</ul>
		<%	}%>
		
		<%	
			if(exam7List.size() > 0){
		%>
				<p class="subjects-type">简答题</p>
				<ul>
		<%
				for(int i = 0; i < exam7List.size(); ++i){
		%>	
					<li><a href="exam/analyAction.action?e_id=<%=exam7List.get(i).getE_id() %>">题目<%=i+1 %></a></li>
		<%		}%>
				</ul>
		<%	}%>
		
		<%	
			if(exam8List.size() > 0){
		%>
				<p class="subjects-type">实践题</p>
				<ul>
		<%
				for(int i = 0; i < exam8List.size(); ++i){
		%>	
					<li><a href="exam/analyAction.action?e_id=<%=exam8List.get(i).getE_id() %>">题目<%=i+1 %></a></li>
		<%		}%>
				</ul>
		<%	}%>
		
	  </div>
	</body>
</html>
