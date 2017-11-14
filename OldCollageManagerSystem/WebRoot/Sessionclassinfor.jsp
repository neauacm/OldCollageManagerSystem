<%@ page language="java" import="java.util.*,xin.miku.hat.classbean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Sessionclassinfor.jsp' starting page</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/1.css">

  </head>
  
   <body align="center" style="font-size: 20px;" background="css/images/backimgzxr.jpg" >
    
    <%ArrayList sessionclasslist = (ArrayList)request.getAttribute("sessionclasslist"); %>
    	
    <table align="center" style="border-radius:25px;" bgcolor="	#FFEFDB">
    
    <tr>
    	
    		<td>课程ID</td>
    		
    		<td>课程名</td>
    		
    </tr>
    	
    <%for(int i=0;i<sessionclasslist.size();i++){ %>
    	
    	<%Sessionclassbean sessionclass = (Sessionclassbean)sessionclasslist.get(i); %>
    	<tr>
    		<td>
    			<%=sessionclass.getClassid() %>
    		</td>
    		
    		<td>
    			<%=sessionclass.getClassname() %>
    		</td>
    		
    	</tr>
    	
    <%} %>
    </table>
      	</br>
     <a href="index.jsp"><input type=button value="返 回 主 页" style="border-radius:8px; background:#B2DFEE; font-size: 20px;" >
    	
    </a>
    
  </body>
</html>
