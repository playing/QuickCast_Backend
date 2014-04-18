package com.paragon.quickcast.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paragon.quickcast.entity.User_Reg;

@Component
public interface UserService {
	
	//public void insert(String user_name,String password,String user_type);
    public String insert(User_Reg user); 
    public String check_username(String username);
    public String check_email(String email);
    public String login(String user_name,String password);
    public User_Reg queryByUserId(int user_id);
	
}
