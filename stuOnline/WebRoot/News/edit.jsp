<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*,
			com.shanda.linglong.model.*,
			com.shanda.linglong.vo.*
"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改新闻</title>
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
	
	function addNewsCheck() {
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
	function con(aid) {
		if (confirm("确定删除？")) {
			var form = document.createElement("form");
			var change = document.createElement("input");
			change.type = 'text';
			change.name = 'aid';
			change.value = aid;
			form.appendChild(change);
			form.action = "<%=basePath %>news/delAppendix.action";
			form.submit();
		} else {
		}
	}
</script>
<style>
</style>
</head>
<body>

<div id="include-div">
  <h3>编辑新闻</h3>
  <%NewsVo newsVo = (NewsVo) session.getAttribute("newsVo");
  	Enterprise_news news = newsVo.getNews();
  	List<News_appendix> appendixs = newsVo.getAppendixs();
  %>
  <form action="<%=basePath %>news/save.action?nid=<%=news.getEn_id() %>" enctype="multipart/form-data" onsubmit="return addNewsCheck()" method="post">
  <p>
	  <label class="notnull">标题</label>
	  <input type="text" id="title" style="width:450px;" name="title" value="<%=news.getEn_theme() %>"/>
	  <span id="title_prompt" class="prompt"></span>
	</p>
	<p><label>发表时间</label>&nbsp;<%=news.getEn_time().substring(0, 19)%></p>
	<p><label>点击</label><%=news.getEn_number() %></p>
	
	 <textarea class="ckeditor" id="detail" name="detail"  style="width:500px;height:500px;"><%=news.getEn_content() %></textarea>
	<div id="attachmentList">
	<p><b>附件列表</b><span id="upload_prompt" class="prompt"></span></p>
	<div id="imgInputArea">
	  <p><label class="level2">附件名称</label><input type="text" name="atitle"/></p>
	  <p><label class="level2">选择附件</label><input type="file" name="upload" /></p>
	  <p><label class="level2">附件名称</label><input type="text" name="atitle"/></p>
	  <p><label class="level2">选择附件</label><input type="file" name="upload" /></p>
	</div>
	<p class="submitLine"><input type="button" onclick="addline()" class="button" value="更多附件"/></p>
	<ul class="origin-attachments">
	<%for (int i=0; i<appendixs.size(); ++i) {
  	News_appendix appendix = appendixs.get(i);
  	%>
	<li class="<%=appendix.getNa_name_load().substring(appendix.getNa_name_load().lastIndexOf(".")+1, appendix.getNa_name_load().length()) %>">
	  <%=appendix.getNa_name_show() %>
	  <input type= "button" class="button" value= "删除" onclick="con(<%=appendix.getNa_id() %>)" />
	</li>
  	<%} %>
  	</ul>
  	</div>
	<p class="submitLine"><input type="submit" class="button" value="保存"/></p>
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