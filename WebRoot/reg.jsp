<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
function  login(){
 var ajax_data = $("#login").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "user_reg.do?method=reg",
        data: ajax_data,
        success: function(date) {
          alert("success");
          alert(date);
          window.location.href = "index.jsp";
        }
    });
 

}

</script>


<title>Insert title here</title>
</head>
<body>
      <form id = "login">
           用户名：<input type=text name="user_name"/><br/>
           密  码：<input type=password name="password"/><br/>
           用户类型：<input type=text name="user_type"/><br/> 
          <button type = button onclick = "login()" >注册</button>
      </form>

</body>
</html>