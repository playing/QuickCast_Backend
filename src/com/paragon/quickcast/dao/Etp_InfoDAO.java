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
		//��ȡhibernate.cfg.htm�����ļ���
		Configuration conn = new Configuration().configure();
		//��ȡhibernate.cfg.htm�����ļ���sessionFactory��mysql���ݿ����ϵ��Ϣ
		SessionFactory factory=conn.buildSessionFactory();
		//��������
		Session session =factory.openSession();
		return session;
	}
	
	//�����µ���ְ����Ϣ��
	//��Etp_Info��Ϊ���ݲ�����
	public boolean insert(Etp_Info etp_info){
		
		Etp_InfoDAO etp_infodao = new Etp_InfoDAO();
		session= this.getSession();
		Transaction tran = this.session.beginTransaction();
		//��transient״̬��Ϊpersistent״̬
		//�ж��û���Ϣ�Ƿ����
		if (etp_infodao.queryByUserId(etp_info.getUser_id()) != null) return false;
		else{
			this.session.save(etp_info);
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
	//��Etp_Info��Ϊ���ݲ���
	public void update(Etp_Info etp_info){
			session = this.getSession();
			Transaction tran = this.session.beginTransaction();
			//����Session�Դ���update������
			this.session.update(etp_info);
			tran.commit();
			if(session.isOpen()){
				session.close();
			}	
	}
	
	//�����û���Ϣ
	//���ݲ���ΪUser_ID
	//����User_ID�ҵ�Etp_Info��ȫ����Ϣ��
	public Etp_Info queryByUserId(int user_id){
		
		Etp_Info etp_info = null;
		session = this.getSession();
		String hql = "FROM Etp_Info as etp_info WHERE etp_info.user_id=?";
		//ͨ��Query��ڲ�ѯ
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
	
	
	//����info_id��ѯ�û���Ϣ
	public Etp_Info queryByInfoId(int info_id){
		
		Etp_Info etp_info = null;
		session = this.getSession();
		String hql = "FROM Etp_Info as etp_info WHERE etp_info.info_id=?";
		//ͨ��Query��ڲ�ѯ
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
	
	//����etp_name��ѯ�û���Ϣ
	public Etp_Info queryByEtpName(String etp_name){
		
		Etp_Info etp_info = null;
		session = this.getSession();
		String hql = "FROM Etp_Info as etp_info WHERE etp_info.etp_name=?";
		//ͨ��Query��ڲ�ѯ
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
	
	//ɾ���û���Ϣ�����Ǵ������Ĳ�����Etp_Info�࣬һ��ʹ������ĸ���User_IDִ��ɾ����
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
	
	//����User_IDΪ������ɾ���û���Ϣ��
	public void deleteByUserId(int user_id){
		
		session = this.getSession();
		String hql = "DELETE Etp_Info WHERE user_id=?";
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
		String hql = "DELETE Etp_Info WHERE info_id=?";
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
