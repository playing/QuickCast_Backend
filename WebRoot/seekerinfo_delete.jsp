<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
function  delete_seekeremail(){
 var ajax_data = $("#delete_seekerinfo").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "seekerinfo.do?method=seekeremail_delete",
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
      <form id = "delete_seekerinfo">
           email<input type=text name="email"/><br/>
          <button type = button onclick = "delete_seekeremail()" >删除email信息</button>
      </form>
</body>
</html>