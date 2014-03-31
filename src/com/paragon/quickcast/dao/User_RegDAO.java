package com.paragon.quickcast.dao;


import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.form.User;


@Component
public class User_RegDAO{
	// property constants
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	/*public void add(User u){
		System.out.println("UserDao.add()");
		hibernateTemplate.save(u);
	}*/

	//插入用户新注册信息；
	//以User_Reg类为传递参数；
	public boolean insert(User_Reg user_reg){

		//判断用户名是否存在
	//	User_RegDAO user_regdao = new User_RegDAO();
			hibernateTemplate.save(user_reg);
			return true;
		}
	
	
	//更新数据库操作
	//以User_Reg类为传递参数
	public void update(User_Reg user_reg){
			//调用hibernateTemplate自带的update方法；
			hibernateTemplate.update(user_reg);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
