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
		
		<link type="text/css" rel="stylesheet"
						href="<%=basePath%>css/admin.css" />
	</head>

	<body>
	  <div id="include-div">
		<h3>安排测评答题</h3>
		<form action="<%=basePath %>permission/select_cpb.action" name="fpqx">
		<div style="float:left;width:350px;">
		<p>
		  <label>查询方式</label>
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
			<input type="submit" class="button" value="查询" style="margin-left:-1px;">
		</p>
		<% List<Person> person_info=(List<Person>)session.getAttribute("person_info");
		if(person_info!=null){%>
		
		<table class="employee-list">
		  <tr>
		    <th class="checkbox"><input type="checkbox" id="xuanzhong" onclick="isOr()">全选</th>
		    <th class="name">姓名</th>
		  </tr>
		
		<% for(int i=0;i<person_info.size();i++){ %>
		<%if(i%2==0){ %><%} %>
		  <tr>
			  <td class="checkbox">
				<input type="checkbox" name="person_name" value="<%=person_info.get(i).getPerson_id() %>">
			  </td>
			  <td class="name">
				<%=person_info.get(i).getPersonname() %>
			  </td>
		  </tr>
		<%} %>
		</table>
		<%session.setAttribute("person_info",null); } %>
		</div>
		<div style="float:left;width:40px;"></div>
		<div style="float:left;width:200px;border-left:1px solid gray;">

		 <%List<Test> list_cpqx=(List<Test>)session.getAttribute("list_cpqx"); 
		if(list_cpqx!=null){
		%>
		<p><label>请选择测评表</label></p>
		<%for(int i=0;i<list_cpqx.size();i++){ %>
			<p>
			&nbsp;&nbsp;
			<input type="checkbox" name="name2" value="<%=list_cpqx.get(i).getT_id()%>">
		  	<%=list_cpqx.get(i).getT_name()%>
		  	</p>
			<%} %>
			
			<p>
			<input type="button" value="确认分配" class="button" onclick="changeAction()">
			</p>
			<%} %>
			</div>
			
			</form>
	  </div>
		
		<script type="text/javascript">
		function changeAction(){
		document.fpqx.action="<%=basePath%>permission/save_cpb.action";
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
