package com.paragon.quickcast.dao;


import com.paragon.quickcast.entity.*;



import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Edu_ExpDAO{
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
	
	//插入用户新注册信息；
	//以Edu_Exp类为传递参数；
	public boolean insert(Edu_Exp edu_exp){
		
		session= this.getSession();
		Transaction tran = this.session.beginTransaction();
		//有transient状态变为persistent状态
		
			this.session.save(edu_exp);
			//提交事务
			tran.commit();
			if(session.isOpen()){
				session.close();
				return true;
			}
			else return false;
	}
	
	//更新数据库操作
	//以Edu_Exp类为传递参数
	public void update(Edu_Exp edu_exp){
			session = this.getSession();
			Transaction tran = this.session.beginTransaction();
			//调用Session自带的update方法；
			this.session.update(edu_exp);
			tran.commit();
			if(session.isOpen()){
				session.close();
			}	
	}
	
	//查找用户信息
	//传递参数为User_ID
	//根据User_ID找到Edu_Exp的全部信息；
	//返回List
	public List queryByUserId(int user_id){
		
		session = this.getSession();
		String hql = "FROM Edu_Exp as edu_exp WHERE edu_exp.user_id=?";
		//通过Query借口查询
		Query q = this.session.createQuery(hql);
		q.setInteger(0,user_id);
		List l = q.list();
		if(session.isOpen()){
			session.close();
		}
		return l;
	}
	
	
	//根据信息exp_id查询教育经历
		public Edu_Exp queryByExpId(int exp_id){
			
			Edu_Exp edu_exp = null;
			session = this.getSession();
			String hql = "FROM Edu_Exp as edu_exp WHERE edu_exp.exp_id=?";
			//通过Query借口查询
			Query q = this.session.createQuery(hql);
			q.setInteger(0,exp_id);
			List l = q.list();
			Iterator iter = l.iterator();
			if(iter.hasNext())
			{
				edu_exp = (Edu_Exp)iter.next();
			}
			if(session.isOpen()){
				session.close();
			}
			return edu_exp;
		}
		
		
		//删除教育经历，但是传进来的参数是Edu_Exp类，一般使用下面的根据User_ID执行删除；
		public void delete(Edu_Exp edu_exp){
			
			session = this.getSession();
			Transaction tran = this.session.beginTransaction();
			if(edu_exp != null){
				this.session.delete(edu_exp);
			}
			tran.commit();
			if(session.isOpen()){
				session.close();
			}
		}
		
		//根据User_ID为参数，删除教育经历
		public void deleteByUserId(int user_id){
			
			session = this.getSession();
			String hql = "DELETE Edu_Exp WHERE user_id=?";
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
		
		public void deleteByExpId(int exp_id){
			
			session = this.getSession();
			String hql = "DELETE Edu_Exp WHERE exp_id=?";
			Query q = this.session.createQuery(hql);
			//把参数设置
			q.setInteger(0,exp_id);
			//执行更新语句
			q.executeUpdate();
			this.session.beginTransaction().commit();
			if(session.isOpen()){
				session.close();
			}
		}

}
