moren<%@ page language="java" import="java.util.*,xin.miku.hat.studentbean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student_class_inorder.jsp' starting page</title>
    
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
  
	<%ArrayList studentidlist = (ArrayList)request.getAttribute("studentidlist"); %>
	
	<table border="1">
		<%for(int i=0;i<studentidlist.size();i++){ %>
		<%Studentbean student = (Studentbean)studentidlist.get(i); %>
		<tr>
			<td><%=student.getNumber()%></td>
		</tr>
		<%} %>
	</table>
	<a href="index.jsp">点我返回主页</a>
  </body>
  
</html>
