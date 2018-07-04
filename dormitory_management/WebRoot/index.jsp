<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>广东理工宿舍BBS</title>
	
  </head>
  
  <body>
    <h1>广东理工职业学院宿舍BBs在线系统</h1>
    <form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">
  	  帐号：<input type="text" name="username" /><span id="message"></span><br>
   	  密码：<input type="password" name="password" /><span id="message"></span><br>
    <input type="submit" name="submit" value="登录" />   <a href="${pageContext.request.contextPath }/servlet/RegisterUIServlet">注册</a>
    </form><!-- 改名字后记得重新配置xml文件 -->
    
  </body>
</html>
