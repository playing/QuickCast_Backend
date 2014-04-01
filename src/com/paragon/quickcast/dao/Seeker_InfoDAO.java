package com.paragon.quickcast.dao;


import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Seeker_Info;


@Repository
public class Seeker_InfoDAO{
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	//插入新的求职者信息；
	//以Seeker_Info类为传递参数；
	public boolean insert(Seeker_Info seeker_info){
		//判断求职者部分属性是否存在
		if(seeker_info.getUser_id()==0&& seeker_info.getCn_tname()==null&&seeker_info.getEng_name()==null&&seeker_info.getEmail()==null) 
			return false;
		//保存seeker_info
		else{
		hibernateTemplate.save(seeker_info);
		return true;
	   }
	}
	
	//修改求职者个人信息功能
    public boolean update(Seeker_Info seeker_info){
    	hibernateTemplate.update(seeker_info);
    	return true;
    }
    
   //删除个人信息
    public boolean delete(int tempinfo_id){
    	Seeker_Info seeker_info = null;
    	seeker_info = this.queryByUserId(tempinfo_id);
    	hibernateTemplate.delete(seeker_info);
    	return true;
    }
    
  //查找用户信息
	//传递参数为User_ID
	//根据User_ID找到Seeker_Info的全部信息；
	public Seeker_Info queryByUserId(int info_id){
		Seeker_Info seeker_info = null;
		Iterator iterator = null;
		List l = (List)this.hibernateTemplate.find("FROM Seeker_Info as seeker_info WHERE seeker_info.info_id=?",new Integer(info_id));
		iterator = l.iterator();
		if(iterator.hasNext())
		{
			seeker_info = (Seeker_Info)iterator.next();
		}
		return seeker_info;
	}
	
	/*

	//根据User_ID为参数，删除用户信息；
	public void deleteByUserId(int user_id){
		
		session = this.getSession();
		String hql = "DELETE Seeker_Info WHERE user_id=?";
		Query q = this.session.createQuery(hql);
		//把参数设置
		q.setInteger(0,user_id);
		//执行更新语句
		q.executeUpdate();
		this.session.beginTransaction().commit();
		if(session.isOpen()){
			session.close();
		}
	}
	
	public void deleteByInfoId(int info_id){
		
		session = this.getSession();
		String hql = "DELETE Seeker_Info WHERE info_id=?";
		Query q = this.session.createQuery(hql);
		//把参数设置
		q.setInteger(0,info_id);
		//执行更新语句
		q.executeUpdate();
		this.session.beginTransaction().commit();
		if(session.isOpen()){
			session.close();
		}
	}*/

}
