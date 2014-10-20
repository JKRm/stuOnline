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
    
    <title>课程修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
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
	
	function add(obj) {
		var area = document.getElementById("addArea");
		var father = document.getElementById("train").value;
		if(obj.value=="添加…"){
			area.innerHTML +=  "<p class='submitLine'><input type=\"text\" id=\"content\" name=\"content\" ><input type=\"hidden\" id=\"father\" name=\"father\" value="+father+"><input type=\"button\" value=\"保存\" class='button' onclick=\"addexe()\">";
			obj.value="取消添加";
		}
		else{
		area.innerHTML = "";
		obj.value="添加…";
		}
			
		}
		
		function addexe(){
        var content=document.getElementById("content").value;
        var father=document.getElementById("father").value;
        $.post(
           		"<%=basePath%>design/addCourse.action",
           		{'content':content,'father':father,'introduction':'课程'},
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
					document.getElementById('lesson').disabled=false;
					$("#lesson").children().remove();
					for (var i = 0; i < length; ++i) {
						var delStr = "<a href='javascript: void(0);' onclick='condel(" + jsonStr[i]["value"] + ")'>删除</a>";
						var updateStr = "<a href='javascript: void(0);' onclick='update(" + jsonStr[i]["value"]+",\""+ jsonStr[i]["text"] + "\")'>编辑</a>";
						var addItem = "<ul  id='"+jsonStr[i]["value"]+"' style='list-style: none;'><li style='line-height: 20px; height: 20px; border-bottom: 1px dashed gray;'><p ><a value='"+jsonStr[i]["value"]+"'>"+jsonStr[i]["text"]+"</a>" + "</p><p class='action-list'>" + delStr + updateStr + "</p></li></ul>";
						$("#lesson").append(addItem);
					}
           			
           		}
           		);
        
        
        }
        
        
      function update(cid,content){
      	var e = document.createElement("input");
		e.type = 'text';
		e.value = content;
		e.id = cid+'newContent';
		var b = document.createElement("input");
		b.type = "button";
		b.className = 'button';
		b.onclick = function (){
		var father = document.getElementById("train").value;
		var Str = cid + 'newContent';
		var content=document.getElementById(Str).value;
		$.post(
           		"<%=basePath%>design/updateCourse.action",
           		{'cid':cid,'content':content,'father':father,'introduction':'课程'},
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
					document.getElementById('lesson').disabled=false;
					$("#lesson").children().remove();
					for (var i = 0; i < length; ++i) {
						var delStr = "<a href='javascript: void(0);' onclick='condel(" + jsonStr[i]["value"] + ")'>删除</a>";
						var updateStr = "<a href='javascript: void(0);' onclick='update(" + jsonStr[i]["value"]+",\""+ jsonStr[i]["text"] + "\")'>编辑</a>";
						var addItem = "<ul  id='"+jsonStr[i]["value"]+"' style='list-style: none;'><li style='line-height: 20px; height: 20px; border-bottom: 1px dashed gray;'><p ><a value='"+jsonStr[i]["value"]+"'>"+jsonStr[i]["text"]+"</a>" + "</p><p class='action-list'>" + delStr + updateStr + "</p></li></ul>";
						$("#lesson").append(addItem);
					}
           		}
           		);
		}; 
		b.value = "修改";
		b.className = "button";
      	var p = document.createElement("p");
      	p.className = 'submitLine';
      	p.appendChild(e);
      	p.appendChild(b);
      	$("#edit-area").children().remove();
      	$("#edit-area").append(p);
      }
      
      
    
	  function change4lesson()
	{
		var area = document.getElementById("addArea");
		var button = document.getElementById("addbutton").value;
		if(button=="取消添加"){
		area.innerHTML = "";
		document.getElementById("addbutton").value="添加…";
		};
		$("#lesson").children().remove();
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
					var addItem = "<ul  id='"+jsonStr[i]["value"]+"' style='list-style: none;'><li style='line-height: 20px; height: 20px; border-bottom: 1px dashed gray;'><p ><a value='"+jsonStr[i]["value"]+"'>"+jsonStr[i]["text"]+"</a>" + "</p><p class='action-list'>" + delStr + updateStr + "</p></li></ul>";
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
  <form>
  	<h3>课程修改</h3>
    <p>
  		<label>培训</label>
  		<select name="train" id="train"  onchange="change4lesson()">
                <option value="0">请选择</option>
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
		<label>课程</label>
		</p>
		<p id="lesson" >
        </p>
        <div id="edit-area"></div>
        <a id="addArea"></a>
        <p class="submitLine"><input type="button" id="addbutton" onclick="add(this)" class="button" disabled="disabled" value="添加…"></p>
  </form>
  </div>
  </body>
</html>
