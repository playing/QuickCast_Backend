package com.paragon.quickcast.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paragon.quickcast.service.UserService;

@Controller
@RequestMapping("/user_reg.do")
public class UserRegController{

	@Resource
	private UserService userService;
	
	@RequestMapping(params="method=reg")
	public String reg(String user_name,String password,String user_type){
		userService.insert(user_name,password,user_type);
		return "index";
	}
	
	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
}