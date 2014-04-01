package com.paragon.quickcast.dao;


import com.paragon.quickcast.entity.*;



import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Etp_InfoDAO{
	// property constants
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
	//以Etp_Info类为传递参数；
	public boolean insert(Etp_Info etp_info){
		
		Etp_InfoDAO etp_infodao = new Etp_InfoDAO();
		session= this.getSession();
		Transaction tran = this.session.beginTransaction();
		//有transient状态变为persistent状态
		//判断用户信息是否存在
		if (etp_infodao.queryByUserId(etp_info.getUser_id()) != null) return false;
		else{
			this.session.save(etp_info);
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
	//以Etp_Info类为传递参数
	public void update(Etp_Info etp_info){
			session = this.getSession();
			Transaction tran = this.session.beginTransaction();
			//调用Session自带的update方法；
			this.session.update(etp_info);
			tran.commit();
			if(session.isOpen()){
				session.close();
			}	
	}
	
	//查找用户信息
	//传递参数为User_ID
	//根据User_ID找到Etp_Info的全部信息；
	public Etp_Info queryByUserId(int user_id){
		
		Etp_Info etp_info = null;
		session = this.getSession();
		String hql = "FROM Etp_Info as etp_info WHERE etp_info.user_id=?";
		//通过Query借口查询
		Query q = this.session.createQuery(hql);
		q.setInteger(0,user_id);
		List l = q.list();
		Iterator iter = l.iterator();
		if(iter.hasNext())
		{
			etp_info = (Etp_Info)iter.next();
		}
		if(session.isOpen()){
			session.close();
		}
		return etp_info;
	}
	
	
	//根据info_id查询用户信息
	public Etp_Info queryByInfoId(int info_id){
		
		Etp_Info etp_info = null;
		session = this.getSession();
		String hql = "FROM Etp_Info as etp_info WHERE etp_info.info_id=?";
		//通过Query借口查询
		Query q = this.session.createQuery(hql);
		q.setInteger(0,info_id);
		List l = q.list();
		Iterator iter = l.iterator();
		if(iter.hasNext())
		{
			etp_info = (Etp_Info)iter.next();
		}
		if(session.isOpen()){
			session.close();
		}
		return etp_info;
	}
	
	//根据etp_name查询用户信息
	public Etp_Info queryByEtpName(String etp_name){
		
		Etp_Info etp_info = null;
		session = this.getSession();
		String hql = "FROM Etp_Info as etp_info WHERE etp_info.etp_name=?";
		//通过Query借口查询
		Query q = this.session.createQuery(hql);
		q.setString(0,etp_name);
		List l = q.list();
		Iterator iter = l.iterator();
		if(iter.hasNext())
		{
			etp_info = (Etp_Info)iter.next();
		}
		if(session.isOpen()){
			session.close();
		}
		return etp_info;
	}
	
	//删除用户信息，但是传进来的参数是Etp_Info类，一般使用下面的根据User_ID执行删除；
	public void delete(Etp_Info etp_info){
		
		session = this.getSession();
		Transaction tran = this.session.beginTransaction();
		if(etp_info != null){
			this.session.delete(etp_info);
		}
		tran.commit();
		if(session.isOpen()){
			session.close();
		}
	}
	
	//根据User_ID为参数，删除用户信息；
	public void deleteByUserId(int user_id){
		
		session = this.getSession();
		String hql = "DELETE Etp_Info WHERE user_id=?";
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
		String hql = "DELETE Etp_Info WHERE info_id=?";
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

}
