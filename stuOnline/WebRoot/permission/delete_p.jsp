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
		 <%List<Permission> list_cpqx=(List<Permission>)session.getAttribute("permissions"); %>
		<form action="<%=basePath %>permission/select_xtqx_delete.action" name="fpqx">
		<h3>收回权限</h3>
		<label>权限名称</label>
		<select name="delete_xtqx"> 
		<option value="0">请选择权限名称</option>
		 <% 
		if(list_cpqx!=null){
		%>
		<%for(int i=0;i<list_cpqx.size();i++){ %>
			
			<option
				value="<%=list_cpqx.get(i).getP_name()%>">
		   	<%=list_cpqx.get(i).getP_name()%></option>
			<%} %>
			</select><input type="submit" value="查询" class="button">
		
			
			<%} %>
		<br>
		<% Person[] list=(Person[])session.getAttribute("list_person");
		if(list!=null){%>
		<table class="employee-list">
			<tr>
				<th class="checkbox"><input type="checkbox" id="xuanzhong" onclick="isOr()">全选</th>
				<th class="name">姓名</th>
			</tr>
		<input type="hidden" name="delete_xtqx_again" value="<%=session.getAttribute("xtqx_delete") %>">
		<%for(int i=0;i<list.length;i++){%>
		<%if(i%2==0){ %><br><%} %>
		<tr>
			<td class="checkbox"><input type="checkbox" name="person_name" value="<%=list[i].getPerson_id() %>"></td>
			<td class="name"><%=list[i].getPersonname()%></td>
		</tr>
		<%} 
		session.setAttribute("list_person",null);
		%>
		</table>
		<p class="submitLine">
		<input type="button" class="button" value="确认删除" onclick="change_action()">
		</p>
		<% 
		}
		%>
		</form>
</div>
			
		
		<script type="text/javascript">
		function change_action(){
		document.fpqx.action="<%=basePath%>permission/delete_xtqx.action";
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
	</body>

</html>
