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
		//��ȡhibernate.cfg.htm�����ļ���
		Configuration conn = new Configuration().configure();
		//��ȡhibernate.cfg.htm�����ļ���sessionFactory��mysql���ݿ����ϵ��Ϣ
		SessionFactory factory=conn.buildSessionFactory();
		//��������
		Session session =factory.openSession();
		return session;
	}
	
	//�����û���ע����Ϣ��
	//��Edu_Exp��Ϊ���ݲ�����
	public boolean insert(Edu_Exp edu_exp){
		
		session= this.getSession();
		Transaction tran = this.session.beginTransaction();
		//��transient״̬��Ϊpersistent״̬
		
			this.session.save(edu_exp);
			//�ύ����
			tran.commit();
			if(session.isOpen()){
				session.close();
				return true;
			}
			else return false;
	}
	
	//�������ݿ����
	//��Edu_Exp��Ϊ���ݲ���
	public void update(Edu_Exp edu_exp){
			session = this.getSession();
			Transaction tran = this.session.beginTransaction();
			//����Session�Դ���update������
			this.session.update(edu_exp);
			tran.commit();
			if(session.isOpen()){
				session.close();
			}	
	}
	
	//�����û���Ϣ
	//���ݲ���ΪUser_ID
	//����User_ID�ҵ�Edu_Exp��ȫ����Ϣ��
	//����List
	public List queryByUserId(int user_id){
		
		session = this.getSession();
		String hql = "FROM Edu_Exp as edu_exp WHERE edu_exp.user_id=?";
		//ͨ��Query��ڲ�ѯ
		Query q = this.session.createQuery(hql);
		q.setInteger(0,user_id);
		List l = q.list();
		if(session.isOpen()){
			session.close();
		}
		return l;
	}
	
	
	//������Ϣexp_id��ѯ��������
		public Edu_Exp queryByExpId(int exp_id){
			
			Edu_Exp edu_exp = null;
			session = this.getSession();
			String hql = "FROM Edu_Exp as edu_exp WHERE edu_exp.exp_id=?";
			//ͨ��Query��ڲ�ѯ
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
		
		
		//ɾ���������������Ǵ������Ĳ�����Edu_Exp�࣬һ��ʹ������ĸ���User_IDִ��ɾ����
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
		
		//����User_IDΪ������ɾ����������
		public void deleteByUserId(int user_id){
			
			session = this.getSession();
			String hql = "DELETE Edu_Exp WHERE user_id=?";
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
		
		public void deleteByExpId(int exp_id){
			
			session = this.getSession();
			String hql = "DELETE Edu_Exp WHERE exp_id=?";
			Query q = this.session.createQuery(hql);
			//�Ѳ�������
			q.setInteger(0,exp_id);
			//ִ�и������
			q.executeUpdate();
			this.session.beginTransaction().commit();
			if(session.isOpen()){
				session.close();
			}
		}

}
