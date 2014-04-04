<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
function  edit_hunterinfo(){
 var ajax_data = $("#edit_hunterinfo").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "seekerinfo.do?method=hunterinfo_insert",
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
      <form id = "edit_hunterinfo"> 
           用户ID<input type=text name="user_id" /><br/>
           用户英文名<input type=text name="eng_name" /><br/>
           用户真实名<input type=text name="cn_tname" /><br/>
                    公司名称<input type=text name="etp_name"/><br/>
           性别<input type=text name="gender"><br/>
           手机号码<input type=text name="mobile"><br/>
           工作电话<input type=text name="work_phone"><br/>
           猎头传真<input type=text name="hunter_fax"><br/>
           工作邮箱<input type=text name="work_email"><br/>
           工作时间<input type=text name="work_time"><br/>
           t_area<input type=text name="t_area"><br/>
           工作城市<input type=text name="work_city"><br/>
           suc_case<input type=text name="suc_case"><br/>
           etp_intro<input type=text name="etp_intro"><br/>
           business_card<input type=text name="business_card"><br/>
           certificate<input type=text name="certificate"><br/>
           check_status<input type=text name="check_status">
          <button type = button onclick = "edit_hunterinfo()" >编辑猎头个人信息</button>
      </form>
</body>
</html>