<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*,
			com.shanda.linglong.model.*,
			com.shanda.linglong.service.impl.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
 		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/admin.css">
	<script type="text/javascript" src="<%=basePath%>courseDesign/jquery-1.8.2.js"></script>
	</head>

	<body>
		<div id="include-div">
		<script language="JavaScript">
		function isNull(obj){
			var point = obj.point.value;
			var upload = obj.upload.value;
			var title = obj.title.value;
			if (point==0) 
			{
				alert ('请选择知识点');
				return false;
			}
			
			else if(upload==""){
				alert('请选择上传课件！');
				return false;
			}
			else if(title==""){
				alert('请输入上传课件名！');
				return false;
			}
			
			
			else{
				return true;
			}
	    	
		}
		
  			function OP()
  			{
    			var x=document.getElementsByName("upload")[0];
    			var y = x.value.substring(x.value.lastIndexOf("\\")+1);
    			document.getElementById("title").value=y;
  			}

  			
  			 function change4lesson()
	{
		var area = document.getElementById("addArea");
		$("#point").children().remove();
		var cho = $("#train").val();
		if(cho=='0') {
			$("#lesson option").remove();
			$("#lesson").append("<option value='0'>请选择</option>");
		}
		else {
			$.get("design/Json4lesson.action",
			"c_pid="+cho,
			function(data, statusText) {
				var list = data;
				if(list == '['){
					list += ']';
				}
				var jsonStr = eval('('+list+')');
				var length = jsonStr.length;
				$("#lesson option").remove();
				$("#lesson").append("<option value='0'>请选择</option>");
				 document.getElementById('lesson').disabled=false;
				for (var i = 0; i < length; ++i) {
					var addItem = "<option value='"+jsonStr[i]["value"]+"'>"+jsonStr[i]["text"]+"</option>";
					$("#lesson").append(addItem);
					
				}
			},
			"html");
		}
	}
	
	 function change4unit()
	{
		var area = document.getElementById("addArea");
		$("#point").children().remove();
		var cho = $("#lesson").val();
		if(cho=='0') {
			$("#unit option").remove();
			$("#unit").append("<option value='0'>请选择</option>");
		}
		else {
			$.get("design/Json4unit.action",
			"c_pid="+cho,
			function(data, statusText) {
				var list = data;
				if(list == '['){
					list += ']';
				}
				var jsonStr = eval('('+list+')');
				var length = jsonStr.length;
				$("#unit option").remove();
				$("#unit").append("<option value='0'>请选择</option>");
				document.getElementById('unit').disabled=false;
				for (var i = 0; i < length; ++i) {
					var addItem = "<option value='"+jsonStr[i]["value"]+"'>"+jsonStr[i]["text"]+"</option>";
					$("#unit").append(addItem);
				}
			},
			"html");
		}
	}
	
	 function change4bar()
	{
		var area = document.getElementById("addArea");
		$("#point").children().remove();
		var cho = $("#unit").val();
		if(cho=='0') {
			$("#bar option").remove();
			$("#bar").append("<option value='0'>请选择</option>");
		}
		else {
			$.get("design/Json4bar.action",
			"c_pid="+cho,
			function(data, statusText) {
				var list = data;
				if(list == '['){
					list += ']';
				}
				var jsonStr = eval('('+list+')');
				var length = jsonStr.length;
				$("#bar option").remove();
				$("#bar").append("<option value='0'>请选择</option>");
				document.getElementById('bar').disabled=false;
				for (var i = 0; i < length; ++i) {
					var addItem = "<option value='"+jsonStr[i]["value"]+"'>"+jsonStr[i]["text"]+"</option>";
					$("#bar").append(addItem);
				}
			},
			"html");
		}
	}
	
	 function change4point()
	{
		var area = document.getElementById("addArea");
		$("#point").children().remove();
		var cho = $("#bar").val();
		if(cho=='0') {
			$("#point").append("<a>无相应知识点</a><br>");
		}
		else {
			$.get("design/Json4point.action",
			"c_pid="+cho,
			function(data, statusText) {
				var list = data;
				if(list == '['){
					list += ']';
				}
				var jsonStr = eval('('+list+')');
				var length = jsonStr.length;
				$("#point option").remove();
				$("#point").append("<option value='0'>请选择</option>");
				document.getElementById('point').disabled=false;
				for (var i = 0; i < length; ++i) {
					var addItem = "<option value='"+jsonStr[i]["value"]+"'>"+jsonStr[i]["text"]+"</option>";
					$("#point").append(addItem);
				}
			},
			"html");
		}
	}
		</script>
		<form action="upload/fileUploadAction.action" enctype="multipart/form-data" method="post" onsubmit="return isNull(this)">
  		<h3>资料上传</h3>
  		<p>
  			<label>培训名称</label>
  		<select name="train" id="train"  onchange="change4lesson()">
                <option value="0">请选择培训</option>
                <%
					 List<Course> course = new ArrayList<Course>();
					 
					 course = (List<Course>)request.getAttribute("trainList");
                
                	 for(int i=0;i<course.size();i++){
                	 	
                	 	String courseName = course.get(i).getC_name();
                	 	
                	 	long courseNo = course.get(i).getC_id();
                	 	
                 %>
					<option value="<%=courseNo %>"><%=courseName %></option>
					<%} %>
					
		</select>
		</p>
		<p>	
			<label>课程名称</label>
			<select name="lesson" id="lesson"  onchange="change4unit()" disabled="disabled">
                <option value='0'>请选择课程</option>
        	</select>
		</p>
		<p>	
			<label>单元名称</label>
			<select name="unit" id="unit"  onchange="change4bar()" disabled="disabled">
                <option value='0'>请选择单元</option>
        	</select>
		</p>	
		<p>
			<label>小节名称</label>
			<select name="bar" id="bar"  onchange="change4point()" disabled="disabled">
                <option value='0'>请选择小节</option>
        	</select>
        </p>
		<p>	
			<label>知识点名称</label>		
			<select name="point" id="point"  disabled="disabled">
                <option value='0'>请选择知识点</option>
        	</select>
        </p>
        <p>
        <label>是否显示下载</label>
       	    <input type="radio" name="isDownload" value="1">是
			<input type="radio" name="isDownload" value="0">否
        </p>
        
			<p>
			<label>文件路径</label>
				<input type="file" id="upload" name="upload" onblur="return OP()">
				<br />
			</p>
			<p>
			<label>文件名</label>			
				<input type="text" id="title" name="title" />
				<br />
			</p>
			<p class="submitLine">
				<input type="submit" value="提交" class="button">
			</p>
		</form>
	</div>
	</body>
</html>