<%@ page language="java" import="java.util.*,xin.miku.hat.studentbean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>打印页面</title>
		<style>				
			#div1{                    	
				width:794px;	
				height:1123px;	
				margin:0 auto			
			}</style>
	</head>
	<body >
		<div id='div1' align="center" >
		<h3 align="center">黑龙江省老干部大学东北农业大学老年大学分校</h3>
		<h3 align="center">学院报名信息确认表</h3>
		
		<%ArrayList studentlist =(ArrayList)request.getAttribute("studentlist2"); %>
			
		 <%ArrayList classnametable  = (ArrayList)request.getAttribute("classnametable2");  %>
		 
		 	<%Studentbean student = (Studentbean)studentlist.get(0); %>
		<table border="1" height="300" width="794px" align="center" style='border:1px solid #aaa' cellspacing="0" cellpadding="10">
			<tr >
				<td  width="200px">姓名</td>
				
				<td  width="200px">
					<%=student.getXingming()%>
				</td>
				
				<td  width="200px">性别</td>
				
				<td  width="200px">
					<%int int_xingbiie = student.getXingbie();
					String xingbie = "男";
						if(int_xingbiie==0)
						xingbie ="女";
					%>
					<%=xingbie %>
				</td>
				
				<td width="200px"  rowspan='4'></td>
            </tr>
            <tr >
				<td  width="200px">身份证号</td>
				
				<td  width="200px"  colspan="3">
					<%=student.getId() %>
				</td>


            </tr>
            <tr >
				<td  width="200px">本人电话</td>
				<td  width="200px">
					<%=student.getPhone() %>
				</td>
				<td  width="200px">学院身份</td>
				<td  width="200px">
					<%=student.getShenfen() %>
				</td>
            </tr>
            <tr >
				<td  width="200px">家属电话</td>
				<td  width="200px">
					<%=student.getFamilyphone()%>
				</td>
				<td  width="200px">与本人关系</td>
				<td  width="200px">
					<%=student.getGuanxi() %>
				</td>
            </tr>
            <tr >
				<td  width="200px">所选课程</td>
				<td  width="200px"  colspan="5">
					 <%for(int i=0;i<classnametable.size();i++){ %>
					 
					 	<%Studentclassbean studentclass = (Studentclassbean)classnametable.get(i);%>
					 	
					 	<%=studentclass.getClassname() %>
					 	
					 	<%=" "%>
					 	
					 <%} %>
				</td>

            </tr>
            <tr >
				<td  width="200px">学号</td>
				<td  width="200px"  colspan="5">
					<%=student.getNumber() %>
				</td>

            </tr>
		</table>
		<p>学院应身体健康，自愿参加老年大学学习，在校期间发生任何意外情况自行负责。报名时应认真阅读招生简章和课程计划，交费后不退费，不转班，自觉遵守学校各项规章制度。</p>
	<p align="center">本人已阅读并确认以上内容</p>
	<p align="center">本人签字：      </p>
	<hr>
	<table  width="794px" align="center">
  <tr>
    <td align="center">听课证
    	<table height="150" border="1" style='border:1px solid #aaa' cellspacing="0" cellpadding="10" width="350px">
      <tr>
        <td align="center" width="80px"  >姓名</td>
        
        <td align="center" width="80px" >性别</td>
        
        <td align="center" width="80px" >年龄</td>
        
        <td align="center" width="110px"rowspan='3' >
       	 1
        </td>
      </tr>
      <tr>
        <td align="center" width="80px" > 
        <%=student.getXingming()%>
		</td>
		  <td align="center" width="80px" > 
        <%=xingbie %>
		</td>
        <td align="center" width="80px" >
        	11
         </td>
      </tr>
      <tr>
        <td width="80px" align="center" >学号</td>
        <td align="center" colspan="2" >
        <%=student.getNumber() %>
        </td>
      </tr>
    </table>东北农业大学老年大学
    </td>
    
    <td align="center">课        程
    	<table height="150" border="1" style='border:1px solid #aaa' cellspacing="0" cellpadding="10" width="350px">
    	<%for(int i=0;i<classnametable.size();i++){ %>
    	
    		  <%Studentclassbean studentclass = (Studentclassbean)classnametable.get(i);%>
		      <tr>
		        <td align="center" ><%=studentclass.getClassname() %></td>
		      </tr>
      <%} %>
    </table>不懈追求                   完善人生
    </td>
  </tr>
</table>
<hr>
<h3 align="center">学员报名缴费回执</h3>
<table align="center" height="150" border="1" style='border:1px solid #aaa' cellspacing="0" cellpadding="10" width="794px">
      <tr>
        <td  >姓名: <%=student.getXingming() %></td>
        <td >学号: <%=xingbie %></td>
      </tr>
      <tr>
        <td  colspan="2">所选课程：
        	
        	 <%for(int i=0;i<classnametable.size();i++){ %>
					 
					 	<%Studentclassbean studentclass = (Studentclassbean)classnametable.get(i);%>
					 	
					 	<%=studentclass.getClassname() %>
					 	
					 	<%=" "%>
					 	
					 <%} %>
        </td>
        
      </tr>
      <tr>
        <td  > </td>
        <td  >学费：</td>
      </tr>
    </table>
    <br>
    <hr>
     <script language=JavaScript>
    
	if (window.print) {document.write('<input type=button name=print value="打印页面"'+ 'onClick="javascript:window.print()">');}

</script> 
	</body>
</html>
