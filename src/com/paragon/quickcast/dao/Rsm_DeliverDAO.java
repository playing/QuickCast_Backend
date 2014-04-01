package com.paragon.quickcast.dao;


import com.paragon.quickcast.entity.*;



import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Rsm_DeliverDAO{
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
	//以Rsm_Deliver类为传递参数；
	public boolean insert(Rsm_Deliver rsm_deliver){
		
		session= this.getSession();
		Transaction tran = this.session.beginTransaction();
		//有transient状态变为persistent状态
		
			this.session.save(rsm_deliver);
			//提交事务
			tran.commit();
			if(session.isOpen()){
				session.close();
				return true;
			}
			else return false;
	}
	
	//更新数据库操作
	//以Rsm_Deliver类为传递参数
	public void update(Rsm_Deliver rsm_deliver){
			session = this.getSession();
			Transaction tran = this.session.beginTransaction();
			//调用Session自带的update方法；
			this.session.update(rsm_deliver);
			tran.commit();
			if(session.isOpen()){
				session.close();
			}	
	}
	
	//查找投递信息
	//传递参数为rsm_id
	//根据rsm_id找到Rsm_Deliver的全部信息；
	//返回List
	public List queryByRsmId(int rsm_id){
		
		session = this.getSession();
		String hql = "FROM Rsm_Deliver as rsm_deliver WHERE rsm_deliver.rsm_id=?";
		//通过Query借口查询
		Query q = this.session.createQuery(hql);
		q.setInteger(0,rsm_id);
		List l = q.list();
		if(session.isOpen()){
			session.close();
		}
		return l;
	}
	
	//查找投递信息
		//传递参数为etp_id
		//根据etp_id找到Rsm_Deliver的全部信息；
		//返回List
		public List queryByEtpId(int etp_id){
			
			session = this.getSession();
			String hql = "FROM Rsm_Deliver as rsm_deliver WHERE rsm_deliver.etp_id=?";
			//通过Query借口查询
			Query q = this.session.createQuery(hql);
			q.setInteger(0,etp_id);
			List l = q.list();
			if(session.isOpen()){
				session.close();
			}
			return l;
		}
	
		//查找投递信息
		//传递参数为hunter_id
		//根据hunter_id找到Rsm_Deliver的全部信息；
		//返回List
		public List queryByHunterId(int hunter_id){
			
			session = this.getSession();
			String hql = "FROM Rsm_Deliver as rsm_deliver WHERE rsm_deliver.hunter_id=?";
			//通过Query借口查询
			Query q = this.session.createQuery(hql);
			q.setInteger(0,hunter_id);
			List l = q.list();
			if(session.isOpen()){
				session.close();
			}
			return l;
		}
		
	//根据信息deliver_id查询投递信息
		public Rsm_Deliver queryByDeliverId(int deliver_id){
			
			Rsm_Deliver rsm_deliver = null;
			session = this.getSession();
			String hql = "FROM Rsm_Deliver as rsm_deliver WHERE rsm_deliver.deliver_id=?";
			//通过Query借口查询
			Query q = this.session.createQuery(hql);
			q.setInteger(0,deliver_id);
			List l = q.list();
			Iterator iter = l.iterator();
			if(iter.hasNext())
			{
				rsm_deliver = (Rsm_Deliver)iter.next();
			}
			if(session.isOpen()){
				session.close();
			}
			return rsm_deliver;
		}
		
		
		//删除简历投递信息，但是传进来的参数是Rsm_Deliver类
		public void delete(Rsm_Deliver rsm_deliver){
			
			session = this.getSession();
			Transaction tran = this.session.beginTransaction();
			if(rsm_deliver != null){
				this.session.delete(rsm_deliver);
			}
			tran.commit();
			if(session.isOpen()){
				session.close();
			}
		}
		
		//根据rsm_id为参数，删除简历投递信息
		public void deleteByRsmId(int rsm_id){
			
			session = this.getSession();
			String hql = "DELETE Rsm_Deliver WHERE rsm_id=?";
			Query q = this.session.createQuery(hql);
			//把参数设置
			q.setInteger(0,rsm_id);
			//执行更新语句
			q.executeUpdate();
			this.session.beginTransaction().commit();
			if(session.isOpen()){
				session.close();
			}
		}
		
		public void deleteByDeliverId(int deliver_id){
			
			session = this.getSession();
			String hql = "DELETE Rsm_Deliver WHERE deliver_id=?";
			Query q = this.session.createQuery(hql);
			//把参数设置
			q.setInteger(0,deliver_id);
			//执行更新语句
			q.executeUpdate();
			this.session.beginTransaction().commit();
			if(session.isOpen()){
				session.close();
			}
		}

}
