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
		//��ȡhibernate.cfg.htm�����ļ���
		Configuration conn = new Configuration().configure();
		//��ȡhibernate.cfg.htm�����ļ���sessionFactory��mysql���ݿ����ϵ��Ϣ
		SessionFactory factory=conn.buildSessionFactory();
		//��������
		Session session =factory.openSession();
		return session;
	}
	
	//�����û���ע����Ϣ��
	//��Rsm_Deliver��Ϊ���ݲ�����
	public boolean insert(Rsm_Deliver rsm_deliver){
		
		session= this.getSession();
		Transaction tran = this.session.beginTransaction();
		//��transient״̬��Ϊpersistent״̬
		
			this.session.save(rsm_deliver);
			//�ύ����
			tran.commit();
			if(session.isOpen()){
				session.close();
				return true;
			}
			else return false;
	}
	
	//�������ݿ����
	//��Rsm_Deliver��Ϊ���ݲ���
	public void update(Rsm_Deliver rsm_deliver){
			session = this.getSession();
			Transaction tran = this.session.beginTransaction();
			//����Session�Դ���update������
			this.session.update(rsm_deliver);
			tran.commit();
			if(session.isOpen()){
				session.close();
			}	
	}
	
	//����Ͷ����Ϣ
	//���ݲ���Ϊrsm_id
	//����rsm_id�ҵ�Rsm_Deliver��ȫ����Ϣ��
	//����List
	public List queryByRsmId(int rsm_id){
		
		session = this.getSession();
		String hql = "FROM Rsm_Deliver as rsm_deliver WHERE rsm_deliver.rsm_id=?";
		//ͨ��Query��ڲ�ѯ
		Query q = this.session.createQuery(hql);
		q.setInteger(0,rsm_id);
		List l = q.list();
		if(session.isOpen()){
			session.close();
		}
		return l;
	}
	
	//����Ͷ����Ϣ
		//���ݲ���Ϊetp_id
		//����etp_id�ҵ�Rsm_Deliver��ȫ����Ϣ��
		//����List
		public List queryByEtpId(int etp_id){
			
			session = this.getSession();
			String hql = "FROM Rsm_Deliver as rsm_deliver WHERE rsm_deliver.etp_id=?";
			//ͨ��Query��ڲ�ѯ
			Query q = this.session.createQuery(hql);
			q.setInteger(0,etp_id);
			List l = q.list();
			if(session.isOpen()){
				session.close();
			}
			return l;
		}
	
		//����Ͷ����Ϣ
		//���ݲ���Ϊhunter_id
		//����hunter_id�ҵ�Rsm_Deliver��ȫ����Ϣ��
		//����List
		public List queryByHunterId(int hunter_id){
			
			session = this.getSession();
			String hql = "FROM Rsm_Deliver as rsm_deliver WHERE rsm_deliver.hunter_id=?";
			//ͨ��Query��ڲ�ѯ
			Query q = this.session.createQuery(hql);
			q.setInteger(0,hunter_id);
			List l = q.list();
			if(session.isOpen()){
				session.close();
			}
			return l;
		}
		
	//������Ϣdeliver_id��ѯͶ����Ϣ
		public Rsm_Deliver queryByDeliverId(int deliver_id){
			
			Rsm_Deliver rsm_deliver = null;
			session = this.getSession();
			String hql = "FROM Rsm_Deliver as rsm_deliver WHERE rsm_deliver.deliver_id=?";
			//ͨ��Query��ڲ�ѯ
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
		
		
		//ɾ������Ͷ����Ϣ�����Ǵ������Ĳ�����Rsm_Deliver��
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
		
		//����rsm_idΪ������ɾ������Ͷ����Ϣ
		public void deleteByRsmId(int rsm_id){
			
			session = this.getSession();
			String hql = "DELETE Rsm_Deliver WHERE rsm_id=?";
			Query q = this.session.createQuery(hql);
			//�Ѳ�������
			q.setInteger(0,rsm_id);
			//ִ�и������
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
			//�Ѳ�������
			q.setInteger(0,deliver_id);
			//ִ�и������
			q.executeUpdate();
			this.session.beginTransaction().commit();
			if(session.isOpen()){
				session.close();
			}
		}

}
