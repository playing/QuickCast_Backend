package com.paragon.quickcast.controller;


import java.net.URLEncoder;//编码包
import java.util.*;


import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.service.UserService;

@Controller
@RequestMapping(value = "/user_reg.do")
public class UserRegController{

	@Resource
	private UserService userService;
    
	@RequestMapping(params = "method=check_uname" )
    public @ResponseBody  String check_uname(String user_name) {
	   
		
		User_Reg user = new User_Reg();
		Map user_R = new HashMap();
		user.setUser_name("asdasd");
		user.setPassword("阿斯顿范德萨发");
		user_R.put("facilities", user.getUser_name());
		user_R.put("bed_num", user.getPassword());
		JSONArray json = new JSONArray();	
		
		json.put(user_R);
	
	String respon_result = "{\"user\":"+ json +"}";	
    String ss = null;
	try {
		ss = URLEncoder.encode(respon_result, "utf-8");

		
	} catch (Exception e) {
		// TODO: handle exception
	}
		//System.out.print(json);
	
	
		
		
		
		if(userService.check_username(user_name)=="1"){
    	 //  System.out.print("OK");
    		//	System.out.printf(user_name);
    	  System.out.print(ss);
    		return ss;
    	}
    	
    	else return "false";
    	
    	
    }
	
	
	
	@RequestMapping(params="method=reg")
	public @ResponseBody String reg(User_Reg user_reg){
		userService.insert(user_reg);
		return "qweoijsodnqoeihjfasdonf";
		}
	
	
	
	
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}





	
}