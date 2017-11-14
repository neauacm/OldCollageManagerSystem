<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	
	<meta charset="UTF-8">
    <base href="<%=basePath%>">
    
    <title>教师页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	
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
<link title="style1" rel="stylesheet" href="stylezxr.css" type="text/css" />
</head>




<body>
    <div class="style_changer">
    	<div class="style_changer_text">Themes:</div>
        <input type="submit" value="1" onclick="setActiveStyleSheet('style1');" />
    </div>
	<div class="form_content">
		<h1 align="center"  color:#FFFFFF> 教师登陆</h1> 
		
   <form action="Register_for_teacher_servlet" method="post">
    <fieldset>
        <legend>登录信息</legend>
        
        <div class="form-row">
            <div class="field-label"><label for="field1">您的姓名</label>:</div>
            <div class="field-widget"><input name = "xingming" type="text"  class="required" /></div>
        </div>
        
        <div class="form-row">
            <div class="field-label"><label for="field1">性 别</label>:</div>
            <div class="field-widget">
         <input name = "xingbie" type="radio"  id="field1"  value="man"  />男
  		 <input name = "xingbie"  id="field1" type="radio"value="woman"  />女</br></div>
        </div>
      
      
        <div class="form-row">
            <div class="field-label"><label for="field1">身份证号码</label>:</div>
            <div class="field-widget"><input name = "id" type="text" class="required"  /></div>
        </div>
        
        
        <div class="form-row">
            <div class="field-label"><label for="field2">教师编号</label>:</div>
            <div class="field-widget"><input name ="number" type="text"  class="required"  /></div>
        </div>
        
        <div class="form-row">
            <div class="field-label"><label for="field2">电话号码</label>:</div>
            <div class="field-widget"><input name = "phone" type="text"   class="required"  /></div>
        </div>
         
    </fieldset>
    
    <fieldset>
        <legend class="optional">登录信息</legend>
      
        
        <div class="form-row">
            <div class="field-label"><label for="field9">家属电话</label>:</div>
            <div class="field-label">
                <input name= "familyphone" type="text"  id="field9" class="optional" />		
            </div>
        </div>

        <div class="form-row">
            <div class="field-label"><label for="field10">与本人关系</label>:</div>
            <div class="field-label"><input name = "guanxi" type="text" id="field10" class="optional"  /></div>
        </div>   
        <div class="form-row">
            <div class="field-label"><label for="field10">学历</label>:</div>
            <div class="field-label"><input name = "xueli" type="text" id="field10" class="optional"  /></div>
        </div>  
        <div class="form-row">
            <div class="field-label"><label for="field10">职称</label>:</div>
            <div class="field-label"><input "zhicheng" type="text"  id="field10" class="optional"  /></div>
        </div> 
         <div class="form-row">
            <div class="field-label"><label for="field10">政治面貌</label>:</div>
            <div class="field-label"><input name = "zhengzhimianmao" type="text" id="field10" class="optional"  /></div>
        </div> 
    </fieldset>
    
    
    
    <input type="submit" class="submit" value="提 交" /> 
    </form>
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