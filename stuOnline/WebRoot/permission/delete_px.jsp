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
		<%List<Course> list_cpqx=(List<Course>)session.getAttribute("list_pxfp"); %>
		<form action="<%=basePath %>permission/select_pxfp_train.action" name="fpqx">
		<h3>取消培训</h3>
		<p>
			<label>培训名称</label>
		<select name="delete_px"> 
		<option value="0">请选择培训名称</option>
		 <% 
		if(list_cpqx!=null){
		%>
		<%for(int i=0;i<list_cpqx.size();i++){ %>
			
			<option
				value="<%=list_cpqx.get(i).getC_id()%>">
		   	<%=list_cpqx.get(i).getC_name()%></option>
			<%} %>
			</select>
		</p>
		<p>
			<label>&nbsp;</label>
			<input type="submit" class="button" style="margin-left: 0px;" value="查询">
		</p>
			
			<%} %>
		<% String[] a=(String[])session.getAttribute("person_info2");
		String[] b=(String[])session.getAttribute("person_info3");
		String courseid=(String)session.getAttribute("person_info4");
		if(a!=null){%>
		<input type="checkbox" id="xuanzhong" onclick="isOr()"><b>全选</b>
		<input type="hidden" name="delete_px2" value="<%=courseid %>">
		
			<%
		for(int i=0;i<a.length;i++){
		 %>
		 
		 
		<%if(i%2==0){ %><br><%} %>
		<input type="checkbox" name="person_name" value="<%=a[i] %>">
		<label><%=b[i]%></label></font>
		
		<%} 
		session.setAttribute("person_info2",null);
		session.setAttribute("person_info3",null);
		%>
		<br>
		<input type="button" value="确认删除" onclick="change_action()">
		<% 
		}
		%>
		</form>
</div>
			
		
		<script type="text/javascript">
		function change_action(){
		document.fpqx.action="<%=basePath%>permission/delete_pxfp.action";
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
