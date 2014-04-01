package com.paragon.quickcast.dao;


import com.paragon.quickcast.entity.*;



import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Work_ExpDAO{
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
	//��Work_Exp��Ϊ���ݲ�����
	public boolean insert(Work_Exp work_exp){
		
		session= this.getSession();
		Transaction tran = this.session.beginTransaction();
		//��transient״̬��Ϊpersistent״̬
		
			this.session.save(work_exp);
			//�ύ����
			tran.commit();
			if(session.isOpen()){
				session.close();
				return true;
			}
			else return false;
	}
	
	//�������ݿ����
	//��Work_Exp��Ϊ���ݲ���
	public void update(Work_Exp work_exp){
			session = this.getSession();
			Transaction tran = this.session.beginTransaction();
			//����Session�Դ���update������
			this.session.update(work_exp);
			tran.commit();
			if(session.isOpen()){
				session.close();
			}	
	}
	
	//�����û���Ϣ
	//���ݲ���ΪUser_ID
	//����User_ID�ҵ�Work_Exp��ȫ����Ϣ��
	//����List
	public List queryByUserId(int user_id){
		
//		Work_Exp work_exp = new Work_Exp();
		session = this.getSession();
		String hql = "FROM Work_Exp as work_exp WHERE work_exp.user_id=?";
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
		public Work_Exp queryByExpId(int exp_id){
			
			Work_Exp work_exp = null;
			session = this.getSession();
			String hql = "FROM Work_Exp as work_exp WHERE work_exp.exp_id=?";
			//ͨ��Query��ڲ�ѯ
			Query q = this.session.createQuery(hql);
			q.setInteger(0,exp_id);
			List l = q.list();
			Iterator iter = l.iterator();
			if(iter.hasNext())
			{
				work_exp = (Work_Exp)iter.next();
			}
			if(session.isOpen()){
				session.close();
			}
			return work_exp;
		}
		
		
		//ɾ���������������Ǵ������Ĳ�����Work_Exp�࣬һ��ʹ������ĸ���User_IDִ��ɾ����
		public void delete(Work_Exp work_exp){
			
			session = this.getSession();
			Transaction tran = this.session.beginTransaction();
			if(work_exp != null){
				this.session.delete(work_exp);
			}
			tran.commit();
			if(session.isOpen()){
				session.close();
			}
		}
		
		//����User_IDΪ������ɾ����������
		public void deleteByUserId(int user_id){
			
			session = this.getSession();
			String hql = "DELETE Work_Exp WHERE user_id=?";
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
			String hql = "DELETE Work_Exp WHERE exp_id=?";
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
