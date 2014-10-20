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
<html>
	<head>
		<base href="<%=basePath%>">

		<title>邮件发送</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
	function addNewImgLine() {
		var area = document.getElementById("imgInputArea");
		area.innerHTML += "<p><font size=\"2\" face=\"宋体\"><label class=\"notnull\">收件人</label></font><input type=\"text\" id=\"to\" name=\"to\" /><span id=\"title_prompt\" class=\"prompt\"></span></p>";
	}
	
	function addreceive(){
		var obj = document.getElementById("imgInputArea");
		var m = document.createElement("input");
		var p = document.createElement("p");
		m.type = 'text';
		m.name = 'to';
		m.id = 'to'; 
		p.innerHTML = '收件人';
		obj.appendChild(p);
		p.appendChild(m);
	}
	
	
	
	</script>

	</head>

	<body>
		
		<div class="top">
			<b><span>发送邮件</span></b>
		</div>
		<form action="<%=basePath%>mail/sendMail.action"
			enctype="multipart/form-data" method="post">
			
			<div id="imgInputArea">
			<p><label class="notnull">
					<font size="2" face="宋体">收件人</font>
				</label>
				<input type="text" id="to" name="to" />
				<span id="title_prompt" class="prompt"></span>
				<input type="button" onclick="addreceive()" value="添加收件人" style="size:1"/>
			</p>
			</div>
			
			<p>
				<label class="notnull">
					<font size="2" face="宋体">主&nbsp;&nbsp;题</font>
				</label>
				<input type="text" id="subject" name="subject" style="width:500px;" />
				<span id="detail_prompt" class="prompt"> </span>
			</p>
			
		<div style="position:relative;left:00px;top:20px;">
				<label class="notnull">
				<font size="2" face="宋体">	内&nbsp;&nbsp;容</font>
				</label>
				</div>
				<div style="position:relative;left:50px;top:0px;">
				<textarea style="width:500px;height:300px;" id="content" name="content"></textarea>
				<span id="detail_prompt" class="prompt"> </span>
			</div>
			
			
			<div style="position:relative;left:50px;">
			
			<font face="黑体" size="1">
				<label class="notnull">
					包含超链接
				</label>
				<input type="checkbox" id="mimeContent" name="mimeContent" value="true"/>
				<span id="detail_prompt" class="prompt"> </span>
			
				<label class="notnull">
					包含附件
				</label>
				<input type="checkbox" id="affixFlag" name="affixFlag" value="true"/>
				<span id="detail_prompt" class="prompt"> </span>
				
				</font>
			</div>
			
			
			<p>
				<label>
					附件选择：
				</label>
				<select name="affix" id="affix" ltype="select">
					<option value="0">
						请选择
					</option>
					<%
						List<Course_resource> recourceList = new ArrayList<Course_resource>();

						recourceList = (List<Course_resource>) request.getAttribute("crList");

						for (int i = 0; i < recourceList.size(); i++) {

							String crName = recourceList.get(i).getCr_name();

							long crId = recourceList.get(i).getCr_id();
					%>
					<option value="<%=crName%>"><%=crId + "--" + crName%></option>
					<%
						}
					%>

				</select>
			</p>
			<p>
				<label>
					附件选择：
				</label>
				<select name="affix" id="affix" ltype="select">
					<option value="0">
						请选择
					</option>
					<%
						List<Course_resource> recourceList2 = new ArrayList<Course_resource>();

						recourceList2 = (List<Course_resource>) request.getAttribute("crList");

						for (int i = 0; i < recourceList2.size(); i++) {

							String crName = recourceList2.get(i).getCr_name();

							long crId = recourceList2.get(i).getCr_id();
					%>
					<option value="<%=crName%>"><%=crId + "--" + crName%></option>
					<%
						}
					%>

				</select>
			</p>
			<p>
				<label class="notnull">
					附件名
				</label>
				<input type="text" id="affixName" name="affixName" />
				<span id="detail_prompt" class="prompt"> </span>
			</p>
			<p>
				<label class="notnull">
					附件名
				</label>
				<input type="text" id="affixName" name="affixName" />
				<span id="detail_prompt" class="prompt"> </span>
			</p>
			<p class="submitLine">
				<input type="submit" value="发送" />
			</p>
		</form>
	</body>
</html>
