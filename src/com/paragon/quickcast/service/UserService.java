package com.paragon.quickcast.service;

import org.springframework.stereotype.Component;

@Component
public interface UserService {
	
	public void insert(String user_name,String password,String user_type);

}
