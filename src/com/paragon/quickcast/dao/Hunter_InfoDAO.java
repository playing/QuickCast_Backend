package com.paragon.quickcast.dao;


import com.paragon.quickcast.entity.*;



import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class Hunter_InfoDAO{
	@Resource
	private HibernateTemplate hibernateTemplate;
	public boolean insert(Hunter_Info hunter_info){
		hibernateTemplate.save(hunter_info);
		return true;
	}

    public boolean update(Hunter_Info hunter_info){
	    hibernateTemplate.update(hunter_info);
	    return true;
    }
     
     public boolean delete(int info_id){
    	 Hunter_Info hunter_info = null;
    	 hunter_info = this.queryByHunerId(info_id);
    	 hibernateTemplate.delete(hunter_info);
    	 return true;
     }
     
     public Hunter_Info queryByHunerId(int info_id){
    	Hunter_Info hunter_info = null;
 		Iterator iterator = null;
 		List l = (List)this.hibernateTemplate.find("FROM Hunter_Info as hunter_info WHERE hunter_info.info_id=?",new Integer(info_id));
 		iterator = l.iterator();
 		if(iterator.hasNext())
 		{
 			hunter_info = (Hunter_Info)iterator.next();
 		}
 		return hunter_info;
 	}
}
	/*
	//插入新的猎头信息
	//以Hunter_Info类为传递参数；
	public boolean insert(Hunter_Info hunter_info){
		
		Hunter_InfoDAO hunter_infodao = new Hunter_InfoDAO();
		session= this.getSession();
		Transaction tran = this.session.beginTransaction();
		//有transient状态变为persistent状态
		//判断用户的信息是否存在
		if (hunter_infodao.queryByUserId(hunter_info.getUser_id()) != null) return false;
		else{
			this.session.save(hunter_info);
			//提交事务
			tran.commit();
			if(session.isOpen()){
				session.close();
				return true;
			}
			else return false;
		}
	}
	
	//更新数据库操作
	//以Hunter_Info类为传递参数
	public void update(Hunter_Info hunter_info){
			session = this.getSession();
			Transaction tran = this.session.beginTransaction();
			//调用Session自带的update方法；
			this.session.update(hunter_info);
			tran.commit();
			if(session.isOpen()){
				session.close();
			}	
	}
	
	//查找用户信息
	//传递参数为User_ID
	//根据User_ID找到Hunter_Info的全部信息；
	public Hunter_Info queryByUserId(int user_id){
		
		Hunter_Info hunter_info = null;
		session = this.getSession();
		String hql = "FROM Hunter_Info as hunter_info WHERE hunter_info.user_id=?";
		//通过Query借口查询
		Query q = this.session.createQuery(hql);
		q.setInteger(0,user_id);
		List l = q.list();
		Iterator iter = l.iterator();
		if(iter.hasNext())
		{
			hunter_info = (Hunter_Info)iter.next();
		}
		if(session.isOpen()){
			session.close();
		}
		return hunter_info;
	}
	
	
	//根据信息id查询用户信息
	public Hunter_Info queryByInfoId(int info_id){
		
		Hunter_Info hunter_info = null;
		session = this.getSession();
		String hql = "FROM Hunter_Info as hunter_info WHERE hunter_info.info_id=?";
		//通过Query借口查询
		Query q = this.session.createQuery(hql);
		q.setInteger(0,info_id);
		List l = q.list();
		Iterator iter = l.iterator();
		if(iter.hasNext())
		{
			hunter_info = (Hunter_Info)iter.next();
		}
		if(session.isOpen()){
			session.close();
		}
		return hunter_info;
	}
	
	//根据cn_tname查询用户信息
	public Hunter_Info queryByCnTName(String cn_tname){
		Hunter_Info hunter_info = null;
		session = this.getSession();
		String hql = "FROM Hunter_Info as hunter_info WHERE hunter_info.cn_tname=?";
		//通过Query借口查询
		Query q = this.session.createQuery(hql);
		q.setString(0,cn_tname);
		List l = q.list();
		Iterator iter = l.iterator();
		if(iter.hasNext())
		{
			hunter_info = (Hunter_Info)iter.next();
		}
		if(session.isOpen()){
			session.close();
		}
		return hunter_info;
	}
	
	//删除用户信息，但是传进来的参数是Hunter_Info类，一般使用下面的根据User_ID执行删除；
	public void delete(Hunter_Info hunter_info){
		
		session = this.getSession();
		Transaction tran = this.session.beginTransaction();
		if(hunter_info != null){
			this.session.delete(hunter_info);
		}
		tran.commit();
		if(session.isOpen()){
			session.close();
		}
	}
	
	//根据User_ID为参数，删除用户信息；
	public void deleteByUserId(int user_id){
		
		session = this.getSession();
		String hql = "DELETE Hunter_Info WHERE user_id=?";
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
		String hql = "DELETE Hunter_Info WHERE info_id=?";
		Query q = this.session.createQuery(hql);
		//把参数设置
		q.setInteger(0,info_id);
		//执行更新语句
		q.executeUpdate();
		this.session.beginTransaction().commit();
		if(session.isOpen()){
			session.close();
		}
	}
*/

