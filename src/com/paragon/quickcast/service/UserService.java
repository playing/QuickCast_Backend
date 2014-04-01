package com.paragon.quickcast.service;

import org.springframework.stereotype.Component;

import com.paragon.quickcast.entity.User_Reg;

@Component
public interface UserService {
	
	//public void insert(String user_name,String password,String user_type);
    public void insert(User_Reg user); 
    public String check_username(String username);
	
}
