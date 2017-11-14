<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testclass.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<form action="Register_for_class_servlet" method = "post" style="width: 657px; ">
	
	学期id:<input type="text" name="sessionid"></br>
	
  	课程名:<input type ="text" name = "classname"></br> 
  	
  	课程id:<input type ="text" name = "classid"></br>
  	
  	教师id:<input type ="text" name = "teacherid"></br> 
  	
  	学时:<input type ="text" name = "xueshi"></br> 
  	
  	上课时间:<input type ="text" name = "time"></br> 
  	
  	教室:<input type ="text" name = "jiaoshi"></br>
  	
  	<input type ="submit" value="增加课程">
  	
  	
	
  	</form>
  </body>
  
</html>
