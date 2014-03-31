package com.paragon.quickcast.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.service.UserService;

@Controller
@RequestMapping("/user_reg.do")
public class UserRegController{

	@Resource
	private UserService userService;

	
	@RequestMapping(params="method=reg")
	public @ResponseBody String reg(User_Reg user_reg){
		userService.insert(user_reg);
		return "asdasd";
		}
	
	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	
}