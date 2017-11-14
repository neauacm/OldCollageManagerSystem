<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>管理系统主页面</title>
    
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
	
	
    <div align="center">
    	
       <font size="10">管理系统</font>
       
   
    </div>
	<div class="form_content">
<!--     <form id="test" action="#" method="get"> -->
<!--     <fieldset> -->
<!--         <legend>输入查询</legend> -->
        <div class="form-row">
        	<form action="Classinfor_servlet" method="post">
            <div class="field-label"><label for="field1">输入学期号:</label></div>
            <div class="field-widget"><input type ="text" name="sessionid" id="field1" class="required"  /></div>
        </div>
        <br />
         
        <div align="center" >
            <input type="submit" class="button white" value="查询该学期课程信息">
        </div>
        </form> 
        
    </fieldset>
     <fieldset>
        <legend>点击查询</legend>
        <div align="center" >
        <form action="Studentinfor_servlet" method="post">
 		<input type="submit" class="button white" value="查询学生信息">
 		</form>
 		<form action="Teacherinfor_servlet" method="post">
 		<input type="submit" class="button white" value="查询教师信息">
 		</form>
 		<form action="Sessioninfor_servlet" method="post">
 		<input type="submit" class="button white" value="查询学期信息">
 		</form>
<!--  		<form><a href="studentmore.jsp" class="button white">学生信息查询</a> -->
<!--  		</form> -->
		<form><a href="studentselectsuccess.jsp" class="button white">选课信息查询</a>
		</form>
        </div>
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
