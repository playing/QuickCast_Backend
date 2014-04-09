package com.paragon.quickcast.dao;


import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Etp_Info;
import com.paragon.quickcast.entity.Recruit_Info;


@Repository
public class Recruit_InfoDAO{
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public boolean insert(Recruit_Info recruit_info){
		hibernateTemplate.save(recruit_info);
		return true;
	}
	public boolean update(Recruit_Info recruit_info){
		hibernateTemplate.update(recruit_info);
		return true;
	}

	public Recruit_Info queryByInfoId(int info_id){
		Recruit_Info recruit_info  = null;
 		Iterator iterator = null;
 		List l = (List)this.hibernateTemplate.find("FROM Recruit_Info as recruit_info WHERE etp_info.info_id=?",new Integer(info_id));
 		iterator = l.iterator();
 		if(iterator.hasNext())
 		{
 			recruit_info = (Recruit_Info)iterator.next();
 		}
 		return recruit_info;
 	}
	public boolean delete(int info_id){
		Recruit_Info recruit_info = null;
		recruit_info = this.queryByInfoId(info_id);
		hibernateTemplate.delete(recruit_info);
		return true;
	}
}
	// property constants
	/*
	private Session session = null;

	public Session getSession(){
		//读取hibernate.cfg.htm配置文件；
		Configuration conn = new Configuration().configure();
		//读取hibernate.cfg.htm配置文件中sessionFactory与mysql数据库的联系信息
		SessionFactory factory=conn.buildSessionFactory();
		//开启事务
		Session session =factory.openSession();
		return session;
	}
	
	//插入新的求职者信息；
	//以Recruit_Info类为传递参数；
	public boolean insert(Recruit_Info recruit_info){
		
		Recruit_InfoDAO recruit_infodao = new Recruit_InfoDAO();
		session= this.getSession();
		Transaction tran = this.session.beginTransaction();
		//有transient状态变为persistent状态
		//判断用户信息是否存在
		if (recruit_infodao.queryByUserId(recruit_info.getUser_id()) != null) return false;
		else{
			this.session.save(recruit_info);
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
	//以Recruit_Info类为传递参数
	public void update(Recruit_Info recruit_info){
			session = this.getSession();
			Transaction tran = this.session.beginTransaction();
			//调用Session自带的update方法；
			this.session.update(recruit_info);
			tran.commit();
			if(session.isOpen()){
				session.close();
			}	
	}
	
	//查找用户信息
	//传递参数为User_ID
	//根据User_ID找到Recruit_Info的全部信息；
	public Recruit_Info queryByUserId(int user_id){
		
		Recruit_Info recruit_info = null;
		session = this.getSession();
		String hql = "FROM Recruit_Info as recruit_info WHERE recruit_info.user_id=?";
		//通过Query借口查询
		Query q = this.session.createQuery(hql);
		q.setInteger(0,user_id);
		List l = q.list();
		Iterator iter = l.iterator();
		if(iter.hasNext())
		{
			recruit_info = (Recruit_Info)iter.next();
		}
		if(session.isOpen()){
			session.close();
		}
		return recruit_info;
	}
	
	
	//根据info_id查询招聘信息
	public Recruit_Info queryByInfoId(int info_id){
		
		Recruit_Info recruit_info = null;
		session = this.getSession();
		String hql = "FROM Recruit_Info as recruit_info WHERE recruit_info.info_id=?";
		//通过Query借口查询
		Query q = this.session.createQuery(hql);
		q.setInteger(0,info_id);
		List l = q.list();
		Iterator iter = l.iterator();
		if(iter.hasNext())
		{
			recruit_info = (Recruit_Info)iter.next();
		}
		if(session.isOpen()){
			session.close();
		}
		return recruit_info;
	}
	
	
	//删除招聘信息，但是传进来的参数是Recruit_Info类，一般使用下面的根据User_ID执行删除；
	public void delete(Recruit_Info recruit_info){
		
		session = this.getSession();
		Transaction tran = this.session.beginTransaction();
		if(recruit_info != null){
			this.session.delete(recruit_info);
		}
		tran.commit();
		if(session.isOpen()){
			session.close();
		}
	}
	
	//根据User_ID为参数，删除招聘信息；
	public void deleteByUserId(int user_id){
		
		session = this.getSession();
		String hql = "DELETE Recruit_Info WHERE user_id=?";
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
		String hql = "DELETE Recruit_Info WHERE info_id=?";
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

}*/
