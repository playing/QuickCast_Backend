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
       //   window.location.href = "index.jsp";
        }
    });
 

}

function check_uname(){
     var x = document.getElementById("user_name").value;
      $.ajax({
        type: "post",
        url: "user_reg.do?method=check_uname",
        data: {user_name:x,encoding:"utf-8"},
        success: function(date) {
      //  data=decodeURI(date);
      data = decodeURIComponent(date);
      data=JSON.parse(data);
         alert(data.user[0].bed_num);
        }
    });



//     alert(x);

}

</script>


<title>Insert title here</title>
</head>
<body>
      <form id = "login">
          <input type = "radio" value = "求职者" name = "user_type">求职者
          <input type = "radio" value = "猎头" name = "user_type">猎头
          <input type = "radio" value = "企业" name = "user_type">企业<br/>
           用户名：<input type=text id = "user_name"  name="user_name" onchange = "check_uname()" /><br/>
           密  码：<input type=password name="password"/><br/>
          
          <button type = button onclick = "login()" >注册</button>
      </form>

</body>
</html>