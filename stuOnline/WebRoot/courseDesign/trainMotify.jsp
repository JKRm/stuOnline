<%@ page language="java" import="java.util.*,
			com.shanda.linglong.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>培训修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/admin.css">
	<script type="text/javascript" src="<%=basePath%>courseDesign/jquery-1.8.2.js"></script>
	<script type="text/javascript">      
	
		function condel(cid) {
		if (confirm("确定删除？")) {
			$.post(
           		"<%=basePath%>design/delCourse.action",
           		{'cid':cid},
           		function (data, statusCode) {
           			if (statusCode == 404 || statusCode == 400 || statusCode == 500) {
           				alert("未知错误");
           			} else if(data == "success"){
           				$("#"+cid).remove();
           			} else if (data == "error") {
           				alert("未知错误");
           			}
           			
           		}
           		);
        
        
        }
			
		 else {
		}
	}
	
        
      function update(cid,content){
      	var e = document.createElement("input");
		e.type = 'text';
		e.value = content;
		e.id = cid+'newContent';
		var b = document.createElement("input");
		b.type = "button";
		b.onclick = function (){
			var Str = cid + 'newContent';
			var content=document.getElementById(Str).value;
		$.post(
           		"<%=basePath%>design/updateCourse.action",
           		{'cid':cid,'content':content,'introduction':'培训'},
           		function (data, statusCode) {
           			if (statusCode == 404 || statusCode == 400 || statusCode == 500) {
           				alert("未知错误");
           			}
           			
           			var list = data;
					if(list == '['){
						list += ']';
					}
					var jsonStr = eval('('+list+')');
					var length = jsonStr.length;
					$("#train").children().remove();
					for (var i = 0; i < length; ++i) {
						var delStr = "<a href='javascript: void(0);' onclick='condel(" + jsonStr[i]["value"] + ")'>删除</a>";
						var updateStr = "<a href='javascript: void(0);' onclick='update(" + jsonStr[i]["value"]+",\""+ jsonStr[i]["text"] + "\")'>编辑</a>";
						var addItem = "<ul style='list-style: none;'><li style='line-height: 20px; height: 20px; border-bottom: 1px dashed gray;'><p id='"+jsonStr[i]["value"]+"'><a value='"+jsonStr[i]["value"]+"'>"+jsonStr[i]["text"]+"</a>" + "</p><p class=\"action-list\">" + delStr + updateStr + "</p></li></ul>";
						$("#train").append(addItem);
					}
					//for (var i = 0; i < length; ++i) {
					//	var delStr = "<a href='javascript: void(0);' onclick='condel(" + jsonStr[i]["value"] + ")'>删除</a>";
					//	var updateStr = "<a href='javascript: void(0);' onclick='update(" + jsonStr[i]["value"]+",\""+ jsonStr[i]["text"] + "\")'>编辑</a>";
					//	var addItem = "<ul id='"+jsonStr[i]["value"]+"' style='list-style: none;'><li style='line-height: 20px; height: 20px; border-bottom: 1px dashed gray;'><p ><a value='"+jsonStr[i]["value"]+"'>"+jsonStr[i]["text"]+"</a>" + "</p><p>" + delSt + updateStr + "</p></li></ul>";
					//	$("#train").append(addItem);
					//}
           		}
           		);
		}; 
		b.value = "修改";
		b.className = 'button';
      	var p = document.createElement("p");
		p.className = 'submitLine';
      	p.appendChild(e);
      	p.appendChild(b);
      	$("#edit-area").children().remove();
      	$("#edit-area").append(p);
      }
	  function change4lesson()
	{
		var cho = $("#train").val();
		if(cho=='0') {
			$("#lesson").append("<a>无相应课程</a><br>");
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
				document.getElementById('lesson').disabled=false;
				document.getElementById('addbutton').disabled=false;
				for (var i = 0; i < length; ++i) {
					var delStr = "<a href='javascript: void(0);' onclick='condel(" + jsonStr[i]["value"] + ")'>删除</a>";
					var updateStr = "<a href='javascript: void(0);' onclick='update(" + jsonStr[i]["value"]+",\""+ jsonStr[i]["text"] + "\")'>编辑</a>";
					var addItem = "<li style='line-height: 20px; height: 20px; border-bottom: 1px dashed gray;'><p id='"+jsonStr[i]["value"]+"'><a value='"+jsonStr[i]["value"]+"'>"+jsonStr[i]["text"]+"</a>" + "&nbsp;&nbsp;&nbsp;</p><p style='text-align: right; margin-top: -40px;'>" + delStr + "&nbsp;&nbsp;&nbsp;" + updateStr + "</p>";
					$("#lesson").append(addItem);
				}
			},
			"html");
		}
	}
</script>
  </head>
  <body>
  <div id="include-div">
  <h3>培训管理</h3>
    <div id="train">
                <%
					 List<Course> course = new ArrayList<Course>();
					 course = (List<Course>)request.getAttribute("trainList");
                	 for(int i=0;i<course.size();i++){
                	 	String courseName = course.get(i).getC_name();
                	 	long courseNo = course.get(i).getC_id();
                 %>
                 <ul style="list-style: none;" id=<%=courseNo %>>
	                 <li style="line-height: 20px; height: 20px; border-bottom: 1px dashed gray;">
	                 	<p ><%=courseName %>
	                 </p>
	                 <p class="action-list">
		                 <a href='javascript: void(0);' onclick='condel(<%=courseNo%>)'>删除</a>
		                 <a href='javascript: void(0);' onclick='update(<%=courseNo%>,"<%=courseName %>")'>编辑</a>
	                 </p>
	                 </li>
                 </ul>
                 
					<%} %>
					
				
		</div>
			<div id="edit-area"></div>
		  <a id="addArea"></a><br>
       
	</div>
  </body>
</html>
