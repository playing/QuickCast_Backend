<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'resume.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript">
function  add_resume(){
 var ajax_data = $("#resume").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "personal_rsm.do?method=personal_rsm",
        data: ajax_data, 
        success: function(date) {
          alert("success");
       //   window.location.href = "index.jsp";
        }
    });
 

}
</script>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    Resume
    <form id= "resume">
           
           用户编号：<input type=text name="user_id"/><br/>
           编辑时间：<input type=text name="edit_time"/><br/>
           谁看过我的简历：<input type=text name="read_status"/><br/>
           简历投递状态：<input type=text name="deliver_status"/><br/> 
           心仪行业：<input type=text name="expect_industry"/><br/> 
           心仪职位：<input type=text name="expect_job"/><br/> 
           期望的工作地点：<input type=text name="expect_place"/><br/> 
           期望薪水：<input type=text name="expect_salary"/><br/> 
           目前薪水：<input type=text name="month_salary"/><br/> 
           拿几个月薪水：<input type=text name="work_month"/><br/> 
           期望薪水：<input type=text name="expect_salary"/><br/> 
           目前薪水：<input type=text name="month_salary"/><br/>
           语言技巧：<input type=text name="language_skill"/><br/> 
           自我评价：<input type=text name="self_evaluate"/><br/>
           自我评价：<input type=text name="add_info"/><br/>     
           
          <button type = "button" onclick = "add_resume()">添加</button>
      </form>
  </body>
</html>
