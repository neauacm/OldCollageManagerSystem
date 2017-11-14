<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生登录</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/1.css" type="text/css" rel="stylesheet">
	<script src="META-INF/lib/prototype.js" type="text/javascript"></script>
<script src="js/src/effects.js" type="text/javascript"></script>
<script type="text/javascript" src="idz_indeziner/validation.js"></script>
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
<link title="style1" rel="stylesheet" href="css/style3.css" type="text/css" />
		<style type="text/css">
			img
{
float:right;
}
.file{
            position: relative;
            display: block;

   
}
		</style>
  </head>
  
  <body background="css/images/login_bgx.gif">
    <div align="center">
      	<h1 class="title"  ><font color="blue">学生登录</font></h1>
    </div>

    
	<div class="form_content">
    <form action="Upload_student_image" method="post" enctype="multipart/form-data">
    <fieldset >
        <legend>输入身份证号</legend>
        <div class="form-row">
            <div class="field-label"><label for="field1"><font color="brown">输入身份证号</font></label></div></br>
            <div class="field-widget"><input type="text" name="username"  class="required"  /></div></br>
        </div>
        <div class="form-row">
            <div class="field-label"><label for="field1"> <font color="brown">照片</font> </label></div></br>
            <div class="field-widget"><input type="file" name="picture" class="file"/>
        </div>
    </fieldset>
    	<input type="submit" class="submit" value="上 传" /> 
    </form>
  </div>
  <h4 class="title" align="center" ><font color="blue">黑龙江省老干部大学东北农业大学分校</font></h4>
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
