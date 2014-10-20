<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="image/jpeg" import="java.awt.*, 
java.awt.image.*,java.util.*,javax.imageio.*" %> 
<%! 
Color getRandColor(int fc,int bc) 
{ 
Random random = new Random(); 
if(fc>255) fc=255; 
if(bc>255) bc=255; 
int r=fc+random.nextInt(bc-fc); 
int g=fc+random.nextInt(bc-fc); 
int b=fc+random.nextInt(bc-fc); 
return new Color(r,g,b); 
} 
%> 
<% 
 out.clearBuffer(); 

    out = pageContext.pushBody();

response.setHeader("Pragma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0); 
int width=60, height=20; 
BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
Graphics g = image.getGraphics(); 
Random random = new Random(); 
g.setColor(getRandColor(200,250)); 
g.fillRect(0, 0, width, height); 
g.setFont(new Font("Times New Roman",Font.PLAIN,18)); 
g.setColor(getRandColor(160,200)); 
for (int i=0;i<155;i++) 
{ 
int x = random.nextInt(width); 
int y = random.nextInt(height); 
int xl = random.nextInt(12); 
int yl = random.nextInt(12); 
g.drawLine(x,y,x+xl,y+yl); 
} 
String sRand=""; 
char ch[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
for (int i=0;i<4;i++){ 
String rand="";
             if(random.nextInt(2)==0){
            rand=String.valueOf(random.nextInt(10));  }
           else 
             rand=ch[random.nextInt(25)]+"";
sRand+=rand; 
g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110))); 
g.drawString(rand,13*i+6,16); 
} 
// 将认证码存入SESSION 
session.setAttribute("rand",sRand); 
g.dispose(); 
ImageIO.write(image, "JPEG", response.getOutputStream()); 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
