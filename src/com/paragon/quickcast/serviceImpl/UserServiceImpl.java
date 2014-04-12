package com.paragon.quickcast.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.paragon.quickcast.dao.ToJson;
import com.paragon.quickcast.dao.User_RegDAO;
import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Resource
	private User_RegDAO userregDao;
	@Resource 
	private ToJson tojson;
	
	public String insert(User_Reg user){
		//System.out.println("UserServiceImpl.add()");
		// System.out.printf("ssssssss");
		
		String id = tojson.tojson("false");
		id = userregDao.insert(user);
		return id;
	}
	
	public String login(String user_name, String password) {
		// TODO Auto-generated method stub
		
		String result = userregDao.login(user_name,password);
		return result;
	}
	
	public String check_username(String username){
		return userregDao.check_username(username);
		
	}
	
	public String check_email(String email) {
		// TODO Auto-generated method stub	
		return userregDao.check_email(email);
	}


	public User_RegDAO getUserregDao() {
		return userregDao;
	}

	public void setUserregDao(User_RegDAO userregDao) {
		this.userregDao = userregDao;
	}

	public ToJson getTojson() {
		return tojson;
	}

	public void setTojson(ToJson tojson) {
		this.tojson = tojson;
	}



	
	

}
