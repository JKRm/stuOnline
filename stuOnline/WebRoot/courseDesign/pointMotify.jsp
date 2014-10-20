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
    
    <title>知识点修改</title>
    
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
	
	function add(obj) {
		var area = document.getElementById("addArea");
		var father = document.getElementById("bar").value;
		if(obj.value=="添加…"){
			area.innerHTML +=  "<p class=\"submitLine\"><input type=\"text\" id=\"content\" name=\"content\" ><input type=\"hidden\" id=\"father\" name=\"father\" value="+father+"><input class='button' type=\"button\" value=\"保存\" onclick=\"addexe()\"></p>";
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
           		{'content':content,'father':father,'introduction':'知识点'},
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
					document.getElementById('point').disabled=false;
					$("#point").children().remove();
					for (var i = 0; i < length; ++i) {
						var delStr = "<a href='javascript: void(0);' onclick='condel(" + jsonStr[i]["value"] + ")'>删除</a>";
						var updateStr = "<a href='javascript: void(0);' onclick='update(" + jsonStr[i]["value"]+",\""+ jsonStr[i]["text"] + "\")'>编辑</a>";
						var addItem = "<ul id='"+jsonStr[i]["value"]+"' style='list-style: none;'><li style='line-height: 20px; height: 20px; border-bottom: 1px dashed gray;'><a value='"+jsonStr[i]["value"]+"'>"+jsonStr[i]["text"]+"</a>" + "<p class='action-list'>" + delStr + updateStr + "</p></li></ul>";
						$("#point").append(addItem);
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
		b.onclick = function (){
		var father = document.getElementById("bar").value;
		var Str = cid + 'newContent';
		var content=document.getElementById(Str).value;
		$.post(
           		"<%=basePath%>design/updateCourse.action",
           		{'cid':cid,'content':content,'father':father,'introduction':'知识点'},
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
					document.getElementById('point').disabled=false;
					$("#point").children().remove();
					for (var i = 0; i < length; ++i) {
						var delStr = "<a href='javascript: void(0);' onclick='condel(" + jsonStr[i]["value"] + ")'>删除</a>";
						var updateStr = "<a href='javascript: void(0);' onclick='update(" + jsonStr[i]["value"]+",\""+ jsonStr[i]["text"] + "\")'>编辑</a>";
						var addItem = "<ul id='"+jsonStr[i]["value"]+"' style='list-style: none;'><li style='line-height: 20px; height: 20px; border-bottom: 1px dashed gray;'><a value='"+jsonStr[i]["value"]+"'>"+jsonStr[i]["text"]+"</a>" + "<p class='action-list'>" + delStr + updateStr + "</p></li></ul>";
						$("#point").append(addItem);
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
		var button = document.getElementById("addbutton").value;
		if(button=="取消添加"){
		area.innerHTML = "";
		document.getElementById("addbutton").value="添加…";
		};
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
		var button = document.getElementById("addbutton").value;
		if(button=="取消添加"){
		area.innerHTML = "";
		document.getElementById("addbutton").value="添加…";
		};
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
		var button = document.getElementById("addbutton").value;
		if(button=="取消添加"){
		area.innerHTML = "";
		document.getElementById("addbutton").value="添加…";
		};
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
				document.getElementById('point').disabled=false;
				document.getElementById('addbutton').disabled=false;
				for (var i = 0; i < length; ++i) {
					var delStr = "<a href='javascript: void(0);' onclick='condel(" + jsonStr[i]["value"] + ")'>删除</a>";
					var updateStr = "<a href='javascript: void(0);' onclick='update(" + jsonStr[i]["value"]+",\""+ jsonStr[i]["text"] + "\")'>编辑</a>";
					var addItem = "<ul id='"+jsonStr[i]["value"]+"' style='list-style: none;'><li style='line-height: 20px; height: 20px; border-bottom: 1px dashed gray;'><a value='"+jsonStr[i]["value"]+"'>"+jsonStr[i]["text"]+"</a>" + "<p class='action-list'>" + delStr + updateStr + "</p></li></ul>";
					$("#point").append(addItem);
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
 	<h3>知识点设计</h3>
	<p>
	<label>培训</label>
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
			<label>课程</label>
		
			<select name="lesson" id="lesson"  onchange="change4unit()" disabled="disabled">
                <option value='0'>请选择课程</option>
        	</select>
      </p>
	  <p>
			<label>单元</label>
       
			<select name="unit" id="unit"  onchange="change4bar()" disabled="disabled">
                <option value='0'>请选择单元</option>
        	</select>
			</p>
       
       <label>小节</label>
        
			<select name="bar" id="bar"  onchange="change4point()" disabled="disabled">
                <option value='0'>请选择小节</option>
        	</select>
			</p>
		<p>
        <label>知识点</label>
        <p id="point">
        </p>
		<div id="edit-area"></div>
         <a id="addArea"></a>
       <p class="submitLine"><input type="button" id="addbutton" onclick="add(this)" disabled="disabled" class="button" value="添加…"></p>
		</form>
		</div>
  </body>
</html>
