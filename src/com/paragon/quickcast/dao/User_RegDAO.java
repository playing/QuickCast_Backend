package com.paragon.quickcast.dao;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.paragon.quickcast.controller.Checker;
import com.paragon.quickcast.entity.User_Reg;

//求职者是1 雇主是2  猎头是3//

@Component
public class User_RegDAO{
	// property constants
	@Resource
	private HibernateTemplate hibernateTemplate;
	private User_Reg user;
	private User_RegDAO user_regdao;
	@Resource
	private Checker checker;
	@Resource
	private ToJson tojson;
	
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
		JSONArray json_data = new JSONArray();
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
            
            json_data.put(data);
			login_request.put("status", "success");
			login_request.put("data", json_data);
		
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
			Map data = new HashMap();
			JSONObject json = new JSONObject();
			data.put("user_id", user.getUser_id());
			try {
				json.put("login_result", data);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String ss = "";
			return json.toString();
		}
    
	
	//判断用户名是否重名	
	public String check_username(String username){

		user = null;
		String temp = "";
		String hql = "FROM User_Reg as user_reg WHERE user_reg.user_name=?";
		
		List list = hibernateTemplate.find(hql,username);
		Iterator iter = list.iterator();
		if(iter.hasNext()){
			
			user = (User_Reg)iter.next();
			
		}
		
		if(user==null){
        temp = "1";
        
		}
		else{
		temp = "0";
		
		}
		
		String result = tojson.tojson(temp);
		return result;
		
	}
	
	
	public String check_email(String email) {
		// TODO Auto-generated method stub
		user = null;
		String temp = "";
		String result = "";
		String hql = "FROM User_Reg as user_reg WHERE user_reg.email=?";
		List list = hibernateTemplate.find(hql,email);
		Iterator iter = list.iterator();
		
        if(iter.hasNext()){
			
			user = (User_Reg)iter.next();
			
		}
		//返回值0 邮箱已被注册  1邮箱可用   2邮箱格式不正确
		if(user==null){
         boolean isemail = checker.isEmail(email);
         if(isemail){
			System.out.print("email可用");
            temp="1";
         }
         else temp = "2";
		}
		else{
			System.out.print("email已存在");
			temp = "0";
		}
		result = tojson.tojson(temp);
		return result;
		
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


	public ToJson getTojson() {
		return tojson;
	}



	public void setTojson(ToJson tojson) {
		this.tojson = tojson;
	}



	public User_RegDAO getUser_regdao() {
		return user_regdao;
	}


	public void setUser_regdao(User_RegDAO user_regdao) {
		this.user_regdao = user_regdao;
	}



	public Checker getChecker() {
		return checker;
	}



	public void setChecker(Checker checker) {
		this.checker = checker;
	}




	
}
