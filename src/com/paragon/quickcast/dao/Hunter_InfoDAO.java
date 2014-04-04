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
	//�����µ���ͷ��Ϣ
	//��Hunter_Info��Ϊ���ݲ�����
	public boolean insert(Hunter_Info hunter_info){
		
		Hunter_InfoDAO hunter_infodao = new Hunter_InfoDAO();
		session= this.getSession();
		Transaction tran = this.session.beginTransaction();
		//��transient״̬��Ϊpersistent״̬
		//�ж��û�����Ϣ�Ƿ����
		if (hunter_infodao.queryByUserId(hunter_info.getUser_id()) != null) return false;
		else{
			this.session.save(hunter_info);
			//�ύ����
			tran.commit();
			if(session.isOpen()){
				session.close();
				return true;
			}
			else return false;
		}
	}
	
	//�������ݿ����
	//��Hunter_Info��Ϊ���ݲ���
	public void update(Hunter_Info hunter_info){
			session = this.getSession();
			Transaction tran = this.session.beginTransaction();
			//����Session�Դ���update������
			this.session.update(hunter_info);
			tran.commit();
			if(session.isOpen()){
				session.close();
			}	
	}
	
	//�����û���Ϣ
	//���ݲ���ΪUser_ID
	//����User_ID�ҵ�Hunter_Info��ȫ����Ϣ��
	public Hunter_Info queryByUserId(int user_id){
		
		Hunter_Info hunter_info = null;
		session = this.getSession();
		String hql = "FROM Hunter_Info as hunter_info WHERE hunter_info.user_id=?";
		//ͨ��Query��ڲ�ѯ
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
	
	
	//������Ϣid��ѯ�û���Ϣ
	public Hunter_Info queryByInfoId(int info_id){
		
		Hunter_Info hunter_info = null;
		session = this.getSession();
		String hql = "FROM Hunter_Info as hunter_info WHERE hunter_info.info_id=?";
		//ͨ��Query��ڲ�ѯ
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
	
	//����cn_tname��ѯ�û���Ϣ
	public Hunter_Info queryByCnTName(String cn_tname){
		Hunter_Info hunter_info = null;
		session = this.getSession();
		String hql = "FROM Hunter_Info as hunter_info WHERE hunter_info.cn_tname=?";
		//ͨ��Query��ڲ�ѯ
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
	
	//ɾ���û���Ϣ�����Ǵ������Ĳ�����Hunter_Info�࣬һ��ʹ������ĸ���User_IDִ��ɾ����
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
	
	//����User_IDΪ������ɾ���û���Ϣ��
	public void deleteByUserId(int user_id){
		
		session = this.getSession();
		String hql = "DELETE Hunter_Info WHERE user_id=?";
		Query q = this.session.createQuery(hql);
		//�Ѳ�������
		q.setInteger(0,user_id);
		//ִ�и������
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
		//�Ѳ�������
		q.setInteger(0,info_id);
		//ִ�и������
		q.executeUpdate();
		this.session.beginTransaction().commit();
		if(session.isOpen()){
			session.close();
		}
	}
*/

