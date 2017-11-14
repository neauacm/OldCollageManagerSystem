<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fail.jsp' starting page</title>
    
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
    
    <h3>
    
       操作失败，请仔细检查是否是以下问题:</br>
       
    1.所选信息不存在</br>
    
    2.请仔细核对填写信息是否有误</br>
    
    3.请检查是否重复多次录入</br>
    
    4.请检查网络连接</br>
  	
  	5.数据库连接失败</br>
    
    </h3>
    
    <a href="index.jsp">点我回到主页</a>
    
  </body>
  
</html>
