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
	
	public void insert(User_Reg user){
		//System.out.println("UserServiceImpl.add()");
		 System.out.printf("ssssssss");
		userregDao.insert(user);
	}

	public User_RegDAO getUserregDao() {
		return userregDao;
	}

	public void setUserregDao(User_RegDAO userregDao) {
		this.userregDao = userregDao;
	}

	

}
