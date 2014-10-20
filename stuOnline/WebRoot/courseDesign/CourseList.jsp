<%@ page language="java" import="java.util.*,
			com.shanda.linglong.model.*,com.shanda.linglong.vo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>培训内容列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/front.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/admin.css">

	</head>

	<body>
	<div id="include-div-second">
		<div class="course-list">
		<h4>教学大纲</h4>
		<%	if(request.getAttribute("tvList")==null){
				List<Course> course = new ArrayList<Course>();
				course = (List<Course>)session.getAttribute("courseList");
                for(int i=0;i<course.size();i++){
                	 String courseName = course.get(i).getC_name();
                	 long courseNo = course.get(i).getC_id();%>
                 
                 <a href="<%=basePath%>design/CourseList.action?cid=<%=courseNo %>"><%=courseName %></a>
                 <%}} 
                 else{
                 	List<TrainVo> tvList = new ArrayList<TrainVo>();
                 	tvList = (List<TrainVo>)request.getAttribute("tvList");
                 	for(int i=0;i<tvList.size();i++){
                	 		String courseName = tvList.get(i).getTrainName();
                	 		long courseNo = tvList.get(i).getTrainId();
                	 		String notice = tvList.get(i).getTrainNotice();
                	 		if(!(notice.equals("已完成"))){
                 %>
                 <a href="<%=basePath%>design/CourseList.action?cid=<%=courseNo %>"><%=courseName %></a>&nbsp;&nbsp;&nbsp;<%=notice %> 
                 <%}else{%>
                 <p>
                 	<a><%=courseName %></a>&nbsp;&nbsp;&nbsp;<%=notice %> 
                 </p> 	
                  <% }}}%>
		</div>
	</div>
	</body>
</html>
