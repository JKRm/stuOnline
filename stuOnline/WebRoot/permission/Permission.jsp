<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page
	import="com.shanda.linglong.service.impl.PermissionServiceImpl,
	com.shanda.linglong.model.Permission,com.shanda.linglong.model.Person,
	com.shanda.linglong.model.Test_produce,
	com.shanda.linglong.model.Test,
	com.shanda.linglong.model.Orgnization,
	com.shanda.linglong.model.Course
	"%>
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

		<title>My JSP 'Permission.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/admin.css">
		
	</head>

	<body>
	<div id="include-div">
		<%
		List<Permission> list = (List<Permission>)session.getAttribute("delete_permission");
			String right = (String)session.getAttribute("canshu");
			if (right.equals("add")) {
		%>
		
			<h3>增加权限</h3>
		
		<form action="permission/save.action" method="post" name="main">
		
			<p>
				<label>权限名称</label>
				<input type="text" name="p_name" style="width:200px;">
			</p>
			<p>
				<label>权限描述</label>
			</p>
			<p>
				<label>&nbsp;</label>
				<textarea name="p_describe"></textarea>
			</p>
			<p class="submitLine">
				<input type="submit" class="button" value="确认">
			</p>
		</form>
		<%}
			if (right.equals("delete")) {
				if (list != null) {%>
		<h3>删除权限</h3>
		
		<form action="permission/delete.action">
		<p>选择要删除的权限</p>
			<%
				for (int i = 0; i < list.size(); i++) {
			%>
			<p>
				<label>&nbsp;</label>
				<input type="checkbox" name="name" value="<%=list.get(i).getP_name()%>">
				<%=list.get(i).getP_name()%>
			</p>
			<%}%>
			<p class="submitLine">
			<input type="submit" class="button" value="删除"></p>
		</form>
		<%
			}
			}
			if (right.equals("modify")) {
		%>
		<p><h3>修改权限</h3></p>
		
		<form action="permission/update.action">
		<%if(list!=null) {
				for (int i = 0; i < list.size(); i++) {
			%>
		<input type="hidden" name="<%=list.get(i).getP_describe()%>" id="<%=list.get(i).getP_name()%>">
		<%}} %>
		
		<p><label>权限名称</label>
			<select name="test2" onchange="show_contents()" id="show_content">
			<option value="false">请选择</option>
			<%if(list!=null) {
				for (int i = 0; i < list.size(); i++) {
			%>
			<option value="<%=list.get(i).getP_name()%>"><%=list.get(i).getP_name()%></option>
			<%}} %>
			</select>
		</p>
		<p>	
			<label>权限描述</label>
		</p>
		<p><label>&nbsp;</label>
			<textarea name="test1" id="show_content_area"></textarea>
		</p>
		<p class="submitLine">
			<input type="submit" class="button" value="修改">
		</p>
		</form>
		<%} %>
		<%if(right.equals("allot")){ %>
		<h3>分配权限</h3>
		<form action="<%=basePath %>permission/select.action" name="fpqx">
		<div style="float:left;width:350px;">
		<p><label>查询方式</label>
		<select name="cxfs" onchange="onchange_cxfs()" id="cxfs">
		<option>请选择查询方式</option>
		<option value="zgbh">按职工编号查询</option>
		<option value="zgxm">按职工姓名查询</option>
		<option value="jgmc">按机构名称查询</option>
		<option value="zwmc">按职位名称查询</option>
		</select>
		</p>
		<p>
			<label>&nbsp;</label>
			<input id="display_text" type="text" name="cxxx" style="width:150px;display:none;">
			<select name="cxxx3" id="display_select1" style="display:none;">
			<%List<Orgnization> orgnization=(List<Orgnization>)session.getAttribute("orgnization"); %>
			<option>请选择机构名称</option>
			<%if(orgnization!=null){ %>
			<%for(int i=0;i<orgnization.size();i++){ %>
			<option value="<%=orgnization.get(i).getOrg_id() %>"><%=orgnization.get(i).getName() %></option>
			<%} %>		
			<%} %>
			</select>
		<select name="cxxx4" id="display_select2" style="display:none;">
		<option>请选择职位名称</option>
		</select>
		</p>
		<p>
			<label>&nbsp;</label>
			<input type="submit" class="button" value="查询" style="margin-left: -1px;">
		</p>
		
		<% List<Person> person_info=(List<Person>)session.getAttribute("person_info");
		if(person_info!=null){%>
		<table class="employee-list">
			<tr>
				<th class="checkbox"><input type="checkbox" id="xuanzhong" onclick="isOr()">全选</th>
				<th class="name">姓名</th>
			</tr>
		<%
		for(int i=0;i<person_info.size();i++){
		 %>
		<%if(i%2==0){ %><%} %>
			<tr>
				<td class="checkbox"><input type="checkbox" name="person_name" value="<%=person_info.get(i).getPerson_id() %>"></td>
				<td class="name"><%=person_info.get(i).getPersonname() %></td>
			</tr>
		<%} %>
		</table>
		<%session.setAttribute("person_info",null);
			}%>
		</div>
		<div style="float:left;width:40px;"></div>
		<div style="float:left;width:250px;border-left: 1px solid gray;">

		 <!-- 显示系统权限列表 -->
		<p>
			<label>请选择权限</label>
		</p>
		<% for (int i = 0; i < list.size(); i++) { %>
			<p>
				<label>&nbsp;</label>
				<input type="checkbox" name="name2" value="<%=list.get(i).getP_name()%>" />
				<%=list.get(i).getP_name()%>
			</p>
		<% } %>
			<p>
			<input type="button" class="button" value="确认分配" onclick="changeAction()" style="margin-left: 108px;">
			</p>
			<!-- END系统权限 -->
			</div>
			</form>
		<%
		} %>
		<script type="text/javascript">
		function show_contents(){
			var select_show=document.getElementById("show_content").value;
			var describe=document.getElementById(select_show).name;
			var test=document.getElementById("show_content_area");
			
			test.innerHTML=describe;
		}
		function changeAction(){
		document.fpqx.action="<%=basePath%>permission/save_permission.action";
		fpqx.submit();
		}
		
		function change_qxzl(){
			document.fpqx.action="<%=basePath%>cxqxzl.action";
			fpqx.submit();
		}
		
		function isOr(){
			var name=document.getElementsByName("person_name");
			if(document.getElementById("xuanzhong").checked==true){
				for(i=0;i<name.length;i++){
					name[i].checked=true;
				}
			}
			else{
				for(i=0;i<name.length;i++){
					name[i].checked=false;
				}
			}
			
		}
		function onchange_cxfs(){
			var cxfs=document.getElementById("cxfs").value;
			if(cxfs=="zgbh"||cxfs=="zgxm"){
				document.getElementById("display_text").style.display="table-cell";
			document.getElementById("display_select1").style.display="none";
			document.getElementById("display_select2").style.display="none";
			}
			if(cxfs=="jgmc"){
				document.getElementById("display_select1").style.display="table-cell";
			document.getElementById("display_select2").style.display="none";
			document.getElementById("display_text").style.display="none";
			}
			if(cxfs=="zwmc"){
				document.getElementById("display_select1").style.display="none";
			document.getElementById("display_text").style.display="none";
				document.getElementById("display_select2").style.display="table-cell";
			}
			
		}
		</script>
		</div>
	</body>

</html>
