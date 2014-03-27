package com.paragon.quickcast.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.paragon.quickcast.dao.User_RegDAO;
import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Resource
	private User_RegDAO userregDao;
	
	public void insert(String user_name,String password,String user_type){
		//System.out.println("UserServiceImpl.add()");
		User_Reg u = new User_Reg();
		u.setUser_name(user_name);
		u.setPassword(password);
		u.setUser_type(user_type);
		
		userregDao.insert(u);
	}

	public User_RegDAO getUserregDao() {
		return userregDao;
	}

	public void setUserregDao(User_RegDAO userregDao) {
		this.userregDao = userregDao;
	}

	

}
