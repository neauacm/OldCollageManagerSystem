<%@ page language="java" import="java.util.*,xin.miku.hat.studentbean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentinfortable.jsp' starting page</title>
    
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
  <img  src="d:1231.jpg" height="200" width="200">
  
  </br>
  
   	 <%ArrayList studentlist =(ArrayList)request.getAttribute("studentlist1"); %>
   	 
    <table border="1">
    
    <tr>
    	<td>学生姓名</td>
    	<td>性别</td>
    	<td>学号</td>
    	<td>电话号码</td>
    	<td>学员身份</td>
    	<td>亲属电话</td>
    	<td>亲属关系</td>
    </tr>
    
	<%for(int i=0;i<studentlist.size();i++){ %>
    
    	<%Studentbean student = (Studentbean)studentlist.get(i); %>
    	<tr>
    		<td>
    			<%=student.getXingming()%>
    		</td>
    
    		<td>
    			<%=student.getXingbie()%>
    		</td>
    	
    		<td>
    			<%=student.getNumber()%>
    		</td>
    
    		<td>
    			<%=student.getPhone()%>
    		</td>
   
    		<td>
    			<%=student.getShenfen()%>
    		</td>
    	
    		<td>
    			<%=student.getFamilyphone()%>
    		</td>
    	
    		<td>
    			<%=student.getGuanxi()%>
    		</td>
    	</tr>
    	
    	</br>
    	
    <%} %>
     </table>
    </br>
    
      <%ArrayList classnametable  = (ArrayList)request.getAttribute("classnametable1");  %>
      
    <table  border="1">
    	
    	<tr>
    		<td>学生身份证号</td>
    		<td>课程编号</td>
    	</tr>
    <%for(int i=0;i<classnametable.size();i++){ %>
    
 	<%Studentclassbean studentclass = (Studentclassbean)classnametable.get(i);%>
    <tr>
    	<td>
    		<%=studentclass.getStudentname() %>
    	</td>
    	
    	<td>
    		<%=studentclass.getClassname() %>
    	</td>
    	
    </tr>
    <%} %>
    </br>
    </table>
    </br>
    <script language=JavaScript>
    
	if (window.print) {document.write('<input type=button name=print value="打印页面"'+ 'onClick="javascript:window.print()">');}

</script> 
  </body>
</html>
