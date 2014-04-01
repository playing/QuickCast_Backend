<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
       用户真实姓名：${seeker_info.getCn_tname} <br/>
             用户英文名：${seeker_info.getEng_name} <br/>
              电子邮箱：${seeker_info.getEmail} <br/>
               手机号码：${seeker_info.getMobile} <br/>
        seeker_photo:${seeker_info.getSeeker_photo} <br/>
                   性别：${seeker_info.getGender} <br/>
                   生日：${seeker_info.getBirthday}<br/>
              婚姻状态：${seeker_info.getNarital_status}<br/>
              教育类型：${seeker_info.getEdu_type}<br/>
              开始时间：${seeker_info.getStart_time}<br/>
              工作状态：${seeker_info.getJob_status}<br/>
</body>
</html>