package com.paragon.quickcast.dao;


import com.paragon.quickcast.entity.*;



import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Recruit_InfoDAO{
	// property constants
	private Session session = null;

	public Session getSession(){
		//��ȡhibernate.cfg.htm�����ļ���
		Configuration conn = new Configuration().configure();
		//��ȡhibernate.cfg.htm�����ļ���sessionFactory��mysql���ݿ����ϵ��Ϣ
		SessionFactory factory=conn.buildSessionFactory();
		//��������
		Session session =factory.openSession();
		return session;
	}
	
	//�����µ���ְ����Ϣ��
	//��Recruit_Info��Ϊ���ݲ�����
	public boolean insert(Recruit_Info recruit_info){
		
		Recruit_InfoDAO recruit_infodao = new Recruit_InfoDAO();
		session= this.getSession();
		Transaction tran = this.session.beginTransaction();
		//��transient״̬��Ϊpersistent״̬
		//�ж��û���Ϣ�Ƿ����
		if (recruit_infodao.queryByUserId(recruit_info.getUser_id()) != null) return false;
		else{
			this.session.save(recruit_info);
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
	//��Recruit_Info��Ϊ���ݲ���
	public void update(Recruit_Info recruit_info){
			session = this.getSession();
			Transaction tran = this.session.beginTransaction();
			//����Session�Դ���update������
			this.session.update(recruit_info);
			tran.commit();
			if(session.isOpen()){
				session.close();
			}	
	}
	
	//�����û���Ϣ
	//���ݲ���ΪUser_ID
	//����User_ID�ҵ�Recruit_Info��ȫ����Ϣ��
	public Recruit_Info queryByUserId(int user_id){
		
		Recruit_Info recruit_info = null;
		session = this.getSession();
		String hql = "FROM Recruit_Info as recruit_info WHERE recruit_info.user_id=?";
		//ͨ��Query��ڲ�ѯ
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
	
	
	//����info_id��ѯ��Ƹ��Ϣ
	public Recruit_Info queryByInfoId(int info_id){
		
		Recruit_Info recruit_info = null;
		session = this.getSession();
		String hql = "FROM Recruit_Info as recruit_info WHERE recruit_info.info_id=?";
		//ͨ��Query��ڲ�ѯ
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
	
	
	//ɾ����Ƹ��Ϣ�����Ǵ������Ĳ�����Recruit_Info�࣬һ��ʹ������ĸ���User_IDִ��ɾ����
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
	
	//����User_IDΪ������ɾ����Ƹ��Ϣ��
	public void deleteByUserId(int user_id){
		
		session = this.getSession();
		String hql = "DELETE Recruit_Info WHERE user_id=?";
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
		String hql = "DELETE Recruit_Info WHERE info_id=?";
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

}
