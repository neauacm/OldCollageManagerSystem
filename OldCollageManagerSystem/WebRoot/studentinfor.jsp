<%@ page language="java" import="java.util.*,xin.miku.hat.studentbean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
		<link href="an.css" rel="stylesheet" type="text/css" />
	<link href="table.css" rel="stylesheet" type="text/css" />
	<link title="style1" rel="stylesheet" href="stylezxr.css" type="text/css" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="<%=basePath%>">
    
    <title>学生管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="scriptaculous/lib/prototype.js" type="text/javascript"></script>
<script src="scriptaculous/src/effects.js" type="text/javascript"></script>
<script type="text/javascript" src="validation.js"></script>
<script type="text/javascript">


//<![CDATA[
<!--
// Alternative Style: Working With Alternate Style Sheets
// http://www.alistapart.com/articles/alternate/
function setActiveStyleSheet(title) {
var i, a, main;
for(i=0; (a = document.getElementsByTagName("link")[i]); i++) {
if(a.getAttribute("rel").indexOf("style") != -1 && a.getAttribute("title")) {
a.disabled = true;
if(a.getAttribute("title") == title) a.disabled = false;
}
}
}
//-->
//]]>
</script>

</head>
<body>
	
	<%ArrayList studentlist = (ArrayList)request.getAttribute("studentlist"); %>
    <div align="center">
    	
       <font size="10">学生管理</font>
       <div align="center">
         <table border="1" id="mytable" cellspacing="0" summary="The technical specifications of the Apple PowerMac G5 series">
    	<tr>
  
    	<th scope="col" >学生姓名</th>
    	
    	<th scope="col" >学生性别</th>
    	
    	<th scope="col" >学号</th>
    	
    	<th scope="col" >身份证号</th>
    	
    	<th scope="col" >学生电话号码</th>
    	
    	<th scope="col" >学生身份</th>
    	
    	<th scope="col" >亲属电话</th>
    	
    	<th scope="col" >亲属关系</th>
    	
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
    			<%=student.getId()%>
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
    </div>
    </div>
	<div class="form_content">
    <form id="test" action="#" method="get">
    <fieldset>
        <legend>查询学生</legend>
        <div class="form-row">
        	<form action="Select_student_class_infor_servlet" method="post">
    	
   
            <div class="field-label"><label for="field1">输入学生号:</label></div>
            <div class="field-widget"><input type ="text" name="studentid" id="field1" class="required"  /></div>
        </div>
        <br />
         
        <div align="center" >
            <input type="submit" style="border-radius:8px; font-size: 20px;background:#B2DFEE;" value="查询某学生选课结果">
        </div>
         </form>
        
    </fieldset>
    <fieldset>
        <legend>删除学生</legend>
        <div class="form-row">
        	 <form action ="Delete_student_servlet" method="post">
    
   		
    
   
            <div class="field-label"><label for="field1">输入学生号</label></div>
            <div class="field-widget"><input type ="text" name="studentid" id="field1" class="required"  /></div>
        </div>
        <br />
        
        <div align="center" >
            <input type="submit" style="border-radius:8px; font-size: 20px;background:#B2DFEE;" value="删除该学号的学生">
        </div>
         </form>
        
    </fieldset>
    
    <fieldset>
   <div align="center" >
   	<a class="button white href="test.jsp">添加学生</a>
           <a class="button white"" href="index.jsp">返回主页</a>
            </div> 	
        </div>
        </form>     
    </fieldset>
    </form>
    </div>
     <div align="center" >
           <font size="4">黑龙江省老干部大学东北农业大学分校</font>
            </div> 
    <script type="text/javascript">
        function formCallback(result, form) {
            window.status = "valiation callback for form '" + form.id + "': result = " + result;
        }
        
        var valid = new Validation('test', {immediate : true, onFormValidate : formCallback});
        Validation.addAllThese([
            ['validate-password', '> 6 characters', {
                minLength : 7,
                notOneOf : ['password','PASSWORD','1234567','0123456'],
                notEqualToField : 'field1'
            }],
            ['validate-password-confirm', 'please try again.', {
                equalToField : 'field8'
            }]
        ]);
    </script>

</body>
</html>
