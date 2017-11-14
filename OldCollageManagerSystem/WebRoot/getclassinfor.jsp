<%@ page language="java" import="java.util.*,xin.miku.hat.classbean.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="xin.miku.hat.teacherbean.*" %>
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
    
    <title>课程管理</title>
    
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
	
	<%ArrayList dateclasslist = (ArrayList)request.getAttribute("dateclasslist"); %>
    <div align="center">
    	
       <font size="10">课程管理</font>
       <div align="center">
       <table  border="1"  id="mytable" cellspacing="0" summary="The technical specifications of the Apple PowerMac G5 series">
	<tr>
		<th scope="col" >		课程名
		</th>
		<th scope="col" >
		课程id
		</th>
		<th scope="col" >
		授课教师
		</th>
		<th scope="col" >
		学时
	</th>
		<th scope="col" >
		上课时间
		</th>
		<th scope="col" >
		教室
		</th>
	</tr>
	<% for(int i=0;i<dateclasslist.size();i++){ %>
	
	<%Classbean Class = (Classbean)dateclasslist.get(i);  %>
	
	<tr>
		<td>
		<%=Class.getClassname() %>
		</td><!-- 学期名 -->
		
		<td>
		<%=Class.getClassid() %>
		</td><!-- 学期id -->
		
		<td>
		<%=Class.getTeacherid() %>
		</td><!-- 授课教师 -->
		
		<td>
		<%=Class.getXueshi() %>
		</td><!-- 学时 -->
		
		<td>
		<%=Class.getTime() %>
		</td><!-- 上课时间 -->
		
		<td>
		<%=Class.getJiaoshi() %>
		</td><!-- 教室-->
	</tr>
	</br>
	<%} %>
	</table>
    </div>
    </div>
	<div class="form_content">
    <form id="test" action="#" method="get">
    <fieldset>
        <legend>课程删除</legend>
        <div class="form-row">
        	<form action ="Delete_class_servlet" method="post">
    	
   
            <div class="field-label"><label for="field1">输入学期号:</label></div>
            <div class="field-widget"><input type="text" name="sessionid" id="field1" class="required"  /></div>
        </div>
        
        <div class="form-row">
            <div class="field-label"><label for="field2">输入课程号:</label></div>
            <div class="field-widget"><input type ="text" name="classid"  id="field2" class="required"  /></div>
        </div>
        <br />
         <br />
          <br />
        <div align="center" >
            <input type="submit" style="border-radius:8px; font-size: 20px;background:#B2DFEE;" value="删除该课程号的课">
        </div>
         </form>
        
    </fieldset>
    <fieldset>
        <legend>学生名单查询</legend>
        <div class="form-row">
        	<form action="Get_class_in_studentorder_servlet" method="post">
    
   		
    
   
            <div class="field-label"><label for="field1">输入课程号</label></div>
            <div class="field-widget"><input type="text" name="classid" id="field1" class="required"  /></div>
        </div>
        <br />
        
        <div align="center" >
            <input type="submit" style="border-radius:8px; font-size: 20px;background:#B2DFEE;" value="获取该课程的学生名单">
        </div>
         </form>
        
    </fieldset>
    <fieldset>
        <legend>课程添加</legend>
         <form action="Register_for_session_class_servlet" method="post">
      <div class="form-row">
            <div class="field-label"><label for="field4">输入学时</label>:</div>
            <div class="field-widget"><input type="text" name="xueshi" class="required" /></div>
        </div>
      
        <div class="form-row">
        	<%ArrayList dateteacherlist = (ArrayList)request.getAttribute("dateteacherlist");%>
            <div class="field-label"><label for="field6">选择老师</label>:</div>
            <div class="field-widget">
                <select name="teacherid" class="validate-selection">
                    <% for(int i=0;i<dateteacherlist.size();i++){ %>
			
			<%Teacherbean teacher = (Teacherbean)dateteacherlist.get(i);  %>
			
			<option value="<%=teacher.getNumber()%>">
				<%=teacher.getXingming() %>
			</option>
			
			<%} %>
                </select>
            </div>
        </div>
           
        <div class="form-row">
            <div class="field-label"><label for="field7">输入学期号</label>:</div>
            <div class="field-widget"><input type="text" name="sessionid" class="required validate-password" /></div>
        </div>
          
        <div class="form-row">
            <div class="field-label"><label for="field9">输入课程号</label>:</div>
            <div class="field-widget"><input type="text" name="classid" class="required validate-password-confirm" /></div>
        </div> 
      <div class="form-row">
            <div class="field-label"><label for="field9">上课时间：</label></div>
            <div class="field-widget"><input type="text" name="time" class="required validate-password-confirm" /></div>
        </div> 
        <div class="form-row">
            <div class="field-label"><label for="field9">所在教室：</label></div>
            <div class="field-widget"><input type="text" name="jiaoshi" class="required validate-password-confirm" /></div>
        </div> 
        <br />
        <br />
        <div align="center" >
            <input type="submit" style="border-radius:8px; font-size: 20px;background:#B2DFEE;" value="为所选学期添加课程">
        </div>
       </form>
    </fieldset>  
    
    <fieldset>
   <div align="center" >
           <a class="button white href="index.jsp">返回主页</a>
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