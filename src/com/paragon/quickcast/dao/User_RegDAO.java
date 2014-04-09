package com.paragon.quickcast.dao;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.paragon.quickcast.entity.User_Reg;


@Component
public class User_RegDAO{
	// property constants
	@Resource
	private HibernateTemplate hibernateTemplate;
	private User_Reg user;
	private User_RegDAO user_regdao;
	
	/*public void add(User u){
		System.out.println("UserDao.add()");
		hibernateTemplate.save(u);
	}*/


    //登录
	//用户名或密码错误返回 "wrong",登录成功返回用户id
	public String login(String user_name,String password){
		
		String hql = "FROM User_Reg as user_reg WHERE user_reg.user_name=?";
		List list = hibernateTemplate.find(hql,user_name);
		Iterator  iter = list.iterator();
		if(iter.hasNext()){
			
			user = (User_Reg)iter.next();
		}
					
		String respon_result = null;
		Map login_request = new HashMap();
		Map data = new HashMap();
		JSONArray json = new JSONArray();
		login_request.clear();
		data.clear();
		
		
		if(user == null){
			data.put("error","danger");
			login_request.put("status", "fail");
			login_request.put("data", data);
			json.put(login_request);
			respon_result = "{\"login_report\":"+ json +"}";
	    	return respon_result;
	    }
		
		
		if(password.equals(user.getPassword())&&user_name.equals(user.getUser_name())) {
					
			data.put("user_name", user.getUser_name());
			data.put("user_id",user.getUser_id()+"");
			data.put("user_type", user.getUser_type()+"");

			login_request.put("status", "success");
			login_request.put("data", data);
		
//			
			json.put(login_request);
		
		 respon_result = "{\"login_report\":"+ json +"}";	
			return respon_result;
		}
		
		else  {
			data.put("error","danger");
			login_request.put("status", "fail");
			login_request.put("data", data);
			json.put(login_request);
			respon_result = "{\"login_report\":"+ json +"}";
			return respon_result;
			
			
			
		}		
		
	}
	
	
	
	//插入用户新注册信息；
	//以User_Reg类为传递参数；
	public String insert(User_Reg user_reg){

		
	//	User_RegDAO user_regdao = new User_RegDAO();
			hibernateTemplate.save(user_reg);
			String hql = "FROM User_Reg as user_reg WHERE user_reg.user_name=?";
			List list = hibernateTemplate.find(hql,user_reg.getUser_name());
			Iterator iter = list.iterator();
			if(iter.hasNext()){
				user = (User_Reg)iter.next();
			}
			String ss = "";
			return user.getUser_id()+ss;
		}
    
	
	//判断用户名是否重名	
	public String check_username(String username){

		user = null;
		String hql = "FROM User_Reg as user_reg WHERE user_reg.user_name=?";
		
		List list = hibernateTemplate.find(hql,username);
		Iterator iter = list.iterator();
		if(iter.hasNext()){
			
			user = (User_Reg)iter.next();
			
		}
		
		if(user==null){
         System.out.print("null");
         return "1";
		}
		else{
			System.out.print("no null");
			return "0";
		}
		
		
		
	}
	
	
	public String check_email(String email) {
		// TODO Auto-generated method stub
		user = null;
		String hql = "FROM User_Reg as user_reg WHERE user_reg.email=?";
		List list = hibernateTemplate.find(hql,email);
		Iterator iter = list.iterator();
		
        if(iter.hasNext()){
			
			user = (User_Reg)iter.next();
			
		}
		
		if(user==null){
         System.out.print("email可用");
         return "1";
		}
		else{
			System.out.print("email已存在");
			return "0";
		}
		
	}

	
	
//public User_Reg queryByUserName(String user_name){
//		
////		User_Reg user_reg = null;
////		session = this.getSession();
////		String hql = "FROM User_Reg as user_reg WHERE user_reg.user_name=?";
////		//通过Query借口查询
////		Query q = this.session.createQuery(hql);
////		q.setString(0,user_name);
////		List l = q.list();
////		Iterator iter = l.iterator();
////		if(iter.hasNext())
////		{
////			user_reg = (User_Reg)iter.next();
////		}
////		if(session.isOpen()){
////			session.close();
////		}
////		return user_reg;
//	
//	return user;
//	
//	}
//	
	
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
	

	public User_Reg getUser() {
		return user;
	}


	public void setUser(User_Reg user) {
		this.user = user;
	}


	public User_RegDAO getUser_regdao() {
		return user_regdao;
	}


	public void setUser_regdao(User_RegDAO user_regdao) {
		this.user_regdao = user_regdao;
	}
	
}
