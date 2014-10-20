<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>

		<title>玲珑轮胎在线学习平台</title>

		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/front.css">

	</head>
	<body>
	<div id="include-div">
		<h3>在线学习</h3>
		<iframe src="<%=basePath%>design/CourseList.action" frameborder="0" width="600" scrolling="auto" name="testIframe4" height="300"></iframe>
	</div>
	<script type="text/javascript">
    pa1=false;pa2=false;pa3=false;
    function hide(x){
    
    obj=document.getElementById(x);
    switch(x){
    case 1:
      if(pa1)
        {obj.style.display="none";pa1=false;}
      else {obj.style.display="block";pa1=true;}
      break;
       case 2:
         if(pa2)
            {obj.style.display="none";pa2=false;}
         else {obj.style.display="block";pa2=true;}
         break;
       case 3:
          if(pa3)
            {obj.style.display="none";pa3=false;}
          else {obj.style.display="block";pa3=true;}
          break;
    }
    
    
    }
    function over(x){
        x.style.backgroundColor="#cacaca";
    }
    function out(x){
        x.style.backgroundColor="white";
    }
    </script>
	</body>
</html>
