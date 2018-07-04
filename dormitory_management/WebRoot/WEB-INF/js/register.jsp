<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>学生注册页面</title>
    
	
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/servlet/RegisterServlet ">
    用户名：<input type="text" name="username"  /><span id="message"></span><br>
    密码：<input type="password" name="password"  /><span id="message"></span><br>
    确认密码：<input type="password2" name="password2"  /><span id="message"></span><br>
    宿舍：<input type="text" name="room"   /><span id="message"></span><br>
    昵称：<input type="text" name="nickname"  /><span id="message"></span><br>
    <input type="submit" name="submit" value="提交" />
    </form>
  </body>
</html>
