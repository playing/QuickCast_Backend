<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
function  edit_etpinfo(){
 var ajax_data = $("#edit_etpinfo").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "seekerinfo.do?method=editetpinfo",
        data: ajax_data,
        success: function(date) {
          alert("success");
          alert(date);
          window.location.href = "seekerinfo_object.jsp";
        }
    });
}
function  delete_etpinfo(){
 var ajax_data = $("#edit_etpinfo").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "seekerinfo.do?method=deleteetpinfo",
        data: ajax_data,
        success: function(date) {
          alert("success");
          alert(date);
          window.location.href = "seekerinfo_object.jsp";
        }
    });
}
function  update_etpinfo(){
 var ajax_data = $("#edit_etpinfo").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "seekerinfo.do?method=updateetpinfo",
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
      <form id = "edit_etpinfo">
      etp_id：<input type=text name="etp_id"><br/>
           用户ID:<input type=text name="user_id"><br/>
            企业名称：<input type=text name="etp_ame"/><br/>
              公司大小：<input type=text name="etp_size"/><br/>
               公司本质：<input type=text name="etp_nature"/><br/>
        公司地址:<input type=text name="etp_addr"/><br/>        
          <button type = button onclick = "edit_etpinfo()" >编辑个人信息</button><br/>
          <button type = button onclick = “delete_etpinfo()”>输入etp_id，删除公司信息</button>
          <button type = button onclick = "update_etpinfo()">输入公司信息，更新</button>
      </form>
</body>
</html>