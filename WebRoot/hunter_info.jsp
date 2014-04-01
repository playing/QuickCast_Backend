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
           用户ID<input type=text name="user_id"/><br/>
           用户英文名<input type=text name="eng_name"/><br/>
           用户真实名<input type=text name="cn_tname"/><br/>
                     公司名称<input type=text name="etp_name"/><br/>
                     性别<input tytpe=text name="gender"><br/>
          <button type = button onclick = "edit_hunterinfo()" >编辑猎头个人信息</button>
      </form>
</body>
</html>