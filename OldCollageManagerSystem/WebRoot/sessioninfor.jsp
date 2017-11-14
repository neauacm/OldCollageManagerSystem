<%@ page language="java" import="java.util.*,xin.miku.hat.sessionbean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
	<style type="text/css">
	.demo{width:760px; margin:20px auto 0 auto; height:70px;}
.button {
	display: inline-block;
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	font: 16px/100% 'Microsoft yahei',Arial, Helvetica, sans-serif;
	padding: .5em 2em .55em;
	text-shadow: 0 1px 1px rgba(0,0,0,.3);
	-webkit-border-radius: .5em; 
	-moz-border-radius: .5em;
	border-radius: .5em;
	-webkit-box-shadow: 0 1px 2px rgba(0,0,0,.2);
	-moz-box-shadow: 0 1px 2px rgba(0,0,0,.2);
	box-shadow: 0 1px 2px rgba(0,0,0,.2);
}
.button:hover {
	text-decoration: none;
}
.button:active {
	position: relative;
	top: 1px;
}
.bigrounded {
	-webkit-border-radius: 2em;
	-moz-border-radius: 2em;
	border-radius: 2em;
}
.medium {
	font-size: 12px;
	padding: .4em 1.5em .42em;
}
.small {
	font-size: 11px;
	padding: .2em 1em .275em;
}
.white {
	color: #606060;
	border: solid 1px #b7b7b7;
	background: #fff;
	background: -webkit-gradient(linear, left top, left bottom, from(#fff), to(#ededed));
	background: -moz-linear-gradient(top,  #fff,  #ededed);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff', endColorstr='#ededed');
}
.white:hover {
	background: #ededed;
	background: -webkit-gradient(linear, left top, left bottom, from(#fff), to(#dcdcdc));
	background: -moz-linear-gradient(top,  #fff,  #dcdcdc);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff', endColorstr='#dcdcdc');
}
.white:active {
	color: #999;
	background: -webkit-gradient(linear, left top, left bottom, from(#ededed), to(#fff));
	background: -moz-linear-gradient(top,  #ededed,  #fff);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#ededed', endColorstr='#ffffff');
}</style>
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
<link title="style1" rel="stylesheet" href="style.css" type="text/css" />
</head>
<style type="text/css">
/* 表格CSS Document */

body {
 font: normal 11px auto "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
 color: #4f6b72;

}

a {
 color: #c75f3e;
}

#mytable {
 width: 500px;
 padding: 0;
 margin: 0;
}

caption {
 padding: 0 0 5px 0;
 width: 700px; 
 font: italic 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
 text-align: right;
}

th {
 font: bold 15px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
 color: #4f6b72;
 border-right: 1px solid #C1DAD7;
 border-bottom: 1px solid #C1DAD7;
 border-top: 1px solid #C1DAD7;
 letter-spacing: 2px;
 text-transform: uppercase;
 text-align: left;
 padding: 6px 6px 6px 12px;
 background: #CAE8EA url(images/bg_header.jpg) no-repeat;
}

th.nobg {
 border-top: 0;
 border-left: 0;
 border-right: 1px solid #C1DAD7;
 background: none;
}

td {
 border-right: 1px solid #C1DAD7;
 border-bottom: 1px solid #C1DAD7;
 background: #fff;
 font-size:11px;
 padding: 6px 6px 6px 12px;
 color: #4f6b72;
}


td.alt {
 background: #F5FAFA;
 color: #797268;
}

th.spec {
 border-left: 1px solid #C1DAD7;
 border-top: 0;
 background: #fff url(images/bullet1.gif) no-repeat;
 font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
}

th.specalt {
 border-left: 1px solid #C1DAD7;
 border-top: 0;
 background: #f5fafa url(images/bullet2.gif) no-repeat;
 font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
 color: #797268;
}
/*---------for IE 5.x bug*/
html>body td{ font-size:11px;}
</style>



<body>
	
    <div align="center">
    	
       <font size="10">课程管理</font>

    </div> 
	
	<div align="center">
	 <%ArrayList sessionlist  = (ArrayList)request.getAttribute("sessionlist");  %>
      <table id="mytable" cellspacing="0" summary="The technical specifications of the Apple PowerMac G5 series">
	<tr>
    	<th scope="col">学期名</th>
    	<th scope="col">学期开始时间</th>
    	<th scope="col">学期结束时间</th>
    	<th scope="col">学时</th>
    	<th scope="col">学期号码</th>
    </tr>
	
	<%for(int i=0;i<sessionlist.size();i++){ %>
	<tr>
		<%	Sessionbean Session=(Sessionbean)sessionlist.get(i); %>
    	<td>
    		<%=Session.getSessionname() %>
    	</td>
    	
    	<td>
    		<%=Session.getSessionbeginmtime() %>
    	</td>
    	
    	<td>
    		<%=Session.getSessionendtime() %>
    	</td>
    	
    	<td>
    		<%=Session.getSessiontime() %>
    	</td>
    	
    	<td>
    		<%=Session.getSessionid() %>
    	</td>
    	
    </tr>
    <%} %>
	</table>
    </div>
    </div>
	
	<div class="form_content">
  
    
    <fieldset>
        <legend>学期删除</legend>
        <div class="form-row">
		
		<form action ="Delete_session_servlet" method="post"  >
    
    	<div class="field-label"><label for="field1">输入学期号:</label></div>
        <div class="field-widget"><input type="text" name="sessionid" id="field1" class="required"  /></div>
    	
    	<div align="center" >
            <input type="submit" style="border-radius:8px; font-size: 20px;background:#B2DFEE;" value="删除该学期号的学期">
        </div>
    </form>
      
        
    </fieldset>
	
	<fieldset>
        <legend>查看该学期的课程</legend>
        <div class="form-row">
		
		<form action ="Select_session_class_infor_serlvet" method="post">
    
    	<div class="field-label"><label for="field1">输入学期号:</label></div>
        <div class="field-widget"><input type="text" name="sessionid" id="field2" class="required"  /></div>
    	<div align="center" >
            <input type="submit" style="border-radius:8px; font-size: 20px;background:#B2DFEE;" value="查看该学期的课程">
        </div>
    </form>
      
        
    </fieldset>
    

   <div align="center" >
           <a class="button white href="testcreattable.jsp">添加学期</a>
            </div> 	
        </div>
        </form>     
    </fieldset>
    </form>
    </div>
     <div align="center" >
           <font size="4">黑龙江省老干部大学东北农业大学分校</font>
            </div> 

</body>
</html>