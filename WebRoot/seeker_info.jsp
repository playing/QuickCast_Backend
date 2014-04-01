<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
function  edit_seekerinfo(){
 var ajax_data = $("#edit_seekerinfo").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "seekerinfo.do?method=seekerinfo_insert",
        data: ajax_data,
        success: function(date) {
          alert("success");
          alert(date);
          window.location.href = "seekerinfo_object.jsp";
        }
    });
}

</script>


<title>Insert title here</title>
</head>
<body>
      <form id = "edit_seekerinfo">
           用户ID:<input type=text name="user_id"><br/>
            用户真实姓名：<input type=text name="cn_tname"/><br/>
             用户英文名：<input type=text name="eng_name"/><br/>
              电子邮箱：<input type=text name="email"/><br/>
               手机号码：<input type=text name="mobile"/><br/>
        seeker_photo:<input type=text name="seeker_photo"/><br/>
                   性别：<input type=radio name="gender" id="gender" value="男"/><label for="male">男</label>
                     <input type=radio name="gender" id="gender" value="女"/><label for="male">女</label><br/>
                   生日：<input type=text name="birthday"/><br/>
              婚姻状态：<input type=text name="narital_status"/><br/>
              教育类型：<input type=text name="edu_type"/><br/>
              开始时间：<input type=text name="start_time"/><br/>
              工作状态：<input type=text name="job_status"/><br/>
              自我介绍：<input type=text name="self_intro"/><br/>
              工作行业：<input type=text name="etp_industry"/><br/>
              工作地点：<input type=text name="work_place"/><br/>
              公司名称：<input type=text name="etp_name"/><br/>
              职位名称：<input type=text name="seeker_profession"/><br/>
          目前职业方向：<input type=text name="tech_direction"/><br/> 
          <button type = button onclick = "edit_seekerinfo()" >编辑个人信息</button>
      </form>
</body>
</html>