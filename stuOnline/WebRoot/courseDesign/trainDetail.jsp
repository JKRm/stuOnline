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
    
    <title>培训设计</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/admin.css">
	<script>
	function isNum(obj){
		var r = /^\+?[1-9][0-9]*$/;
		var con = obj.period.value;
		var select = obj.cid.value;
		if (!(r.test(con))) 
		{
			alert ('请输入正确的天数！');
			return false;
		} else if(select==0) {
			alert('请选择培训！');
			return false;
		} else {
			return true;
		}
	}
	</script>

  </head>
  <body>
  <div id="include-div">
  <form action="<%=basePath%>design/trainDetail.action" method="post" onsubmit="return isNum(this)">
    <h3>培训设计</h3>
	<p>
  		<label>培训名</label>
		<input type="text" name="trainName" >
	</p>
	<p>
  		<label>培训时长</label>
		<input type="text" id="period" name="period">天
	</p>
	<p>
  		<label>邮件提示内容</label>
		<input type="text" id="mailcontent" name="mailcontent">
	</p>
	<p>
  		<label>培训简介</label>
		<input type="text" id="content" name="content" >
	</p>
	<p class="submitLine">
		<input type="submit" class="button" value="添加">
  		<input type="reset" class="button" value="清空">
  	</p>
  </form>

  </div>
  </body>
</html>
