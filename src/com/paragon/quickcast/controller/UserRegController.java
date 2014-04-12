package com.paragon.quickcast.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.service.UserService;

@Controller
@RequestMapping(value = "/user_reg.do")
public class UserRegController{

	@Resource
	private UserService userService;
	private Encoding encod = new Encoding();
    
	
	//判断用户名是否已占用
	@RequestMapping(params = "method=check_uname" )
    public @ResponseBody  String check_uname(@RequestBody User_Reg user_name) {
	   			
    	 return userService.check_username(user_name.getUser_name());
    	 	
    }
	
	
	
	//注册
	@RequestMapping(params="method=reg")
	public @ResponseBody String reg(@RequestBody User_Reg user_reg){
		return userService.insert(user_reg);
		}
	
	
	
	//判断邮箱格式
	@RequestMapping(params="method=check_email")
	public @ResponseBody String check_email(@RequestBody User_Reg email){
		
		String result = userService.check_email(email.getEmail());
		return result;
	}
	
	
	
	//登录
	@RequestMapping(params="method=login")
	public @ResponseBody String login(@RequestBody User_Reg user){
		//System.out.print(user_name);
		String temp = userService.login(user.getUser_name(),user.getPassword());
       
		return temp;
	}
	
	
	
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

//	
//	User_Reg user = new User_Reg();
//	Map user_R = new HashMap();
//	user.setUser_name("asdasd");
//	user.setPassword("阿斯顿范德萨发");
//	user_R.put("facilities", user.getUser_name());
//	user_R.put("bed_num", user.getPassword());
//	JSONArray json = new JSONArray();	
//	
//	json.put(user_R);

//String respon_result = "{\"user\":"+ json +"}";	
//String ss = null;
//try {
//	ss = URLEncoder.encode(respon_result, "utf-8");
//
//	
//} catch (Exception e) {
//	// TODO: handle exception
//}
//	//System.out.print(json);
//
	
}