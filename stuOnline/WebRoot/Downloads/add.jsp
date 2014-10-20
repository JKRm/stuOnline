<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />



<title>新增下载</title>
<link href="<%=basePath %>css/admin.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath %>js/string.js" type="text/javascript"></script>
<script>
	
	function addNewImgLine() {
		var area = document.getElementById("imgInputArea");
		area.innerHTML += "<p><label class=\"level2\">附件名称</label><input type=\"text\" name=\"atitle\"/></p><p><label class=\"level2\">选择附件</label><input type=\"file\" name=\"upload\"/></p>";
	}  
	
	function addline(){
		var obj = document.getElementById("imgInputArea");
		var e = document.createElement("input");
		var m = document.createElement("input");
		var p1 = document.createElement("p");
		var p2 = document.createElement("p");
		var l1 = document.createElement("label");
		var l2 = document.createElement("label");
		e.type = 'file';
		e.name='upload';
		m.type = 'text';
		m.name = 'atitle';
		l1.innerHTML = '附件名称';
		l2.innerHTML = '选择附件';
		p1.appendChild(l1);
		p2.appendChild(l2);
		obj.appendChild(p1);
		obj.appendChild(p2);
		p2.appendChild(e);
		p1.appendChild(m);
		
	}
	
	function addNoticeCheck() {
		var title = document.getElementById("title").value;
		var detail = document.getElementById("detail").value;
		title = Trim(title);
		detail = Trim(detail);
		if (title != "" && detail != "") {
			return true;
		} 
		if (title == "") {
			document.getElementById("title_prompt").innerHTML = "标题不能为空";
			document.getElementById("title_prompt").style.visibility = "visible";
		} else {
			document.getElementById("title_prompt").innerHTML = "";
			document.getElementById("title_prompt").style.visibility = "hidden";
		}
		if (detail == "") {
			document.getElementById("detail_prompt").innerHTML = "内容不能为空";
			document.getElementById("detail_prompt").style.visibility = "visible";
		} else {
			document.getElementById("detail_prompt").innerHTML = "";
			document.getElementById("detail_prompt").style.visibility = "hidden";
		}
		return false;
	}
</script>
<style>
	.top {
	 	margin-top: 23px;
		margin-left: 9px;
		padding-left: 6px;
		padding-bottom: 2px;
		border-bottom: 1px solid rgb(230, 230, 230);
		font-size: 12px;
	}
	.top span {
		font-weight: bold;
	}
</style>
</head>
<body>
<div id="include-div">
  <h3>添加下载</h3>
  <form action="<%=basePath %>news/AddNews.action?isd=3" enctype="multipart/form-data" onsubmit="return addNoticeCheck()" method="post">
	<p>
	  <label class="notnull">标题</label>
	  <input type="text" id="title" name="title"/>
	  <span id="title_prompt" class="prompt"></span>
	</p>
	<p>
	  <label class="notnull">内容</label>
	  <span id="detail_prompt" class="prompt">
	  </span>
	</p>
	<p>
	  <label>&nbsp;</label>
	  <textarea id="detail" name="detail"></textarea>
	</p>
	<div id="attachmentList">
	<p><label>附件列表</label><span id="upload_prompt" class="prompt"></span></p>
	<div id="imgInputArea">
	  <p><label class="level2">附件名称</label><input type="text" name="atitle"/></p>
	  <p><label class="level2">选择附件</label><input type="file" name="upload" /></p>
	  <p><label class="level2">附件名称</label><input type="text" name="atitle"/></p>
	  <p><label class="level2">选择附件</label><input type="file" name="upload" /></p>
	</div>
	<p class="submitLine"><input type="button" class="button" onclick="addNewImgLine()" value="更多附件"/></p>
	</div>
	<p class="submitLine"><input type="submit" class="button" value="提交"/></p>
  </form>
</div>
<script type="text/javascript">
		//         
			window.CKEDITOR_BASEPATH = '<%=basePath%>ckeditor/';
		//
		</script>
		<script type="text/javascript" src="<%=basePath%>ckeditor/ckeditor.js?t=B37D54V"></script>
		<script type="text/javascript">
		//         
			CKEDITOR.replace('detail');
		//
		</script>
</body>
</html>