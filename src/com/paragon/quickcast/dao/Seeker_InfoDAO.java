package com.paragon.quickcast.dao;


import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Seeker_Info;


@Repository
public class Seeker_InfoDAO{
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	//�����µ���ְ����Ϣ��
	//��Seeker_Info��Ϊ���ݲ�����
	public boolean insert(Seeker_Info seeker_info){
		hibernateTemplate.save(seeker_info);
		return true;
	}
	
	//�޸���ְ�߸�����Ϣ����
    public boolean update(Seeker_Info seeker_info){
    	hibernateTemplate.update(seeker_info);
    	return true;
    }
    
   //ɾ��������Ϣ
    public boolean delete(int tempinfo_id){
    	Seeker_Info seeker_info = null;
    	seeker_info = this.queryByUserId(tempinfo_id);
    	hibernateTemplate.delete(seeker_info);
    	return true;
    }
    
  //�����û���Ϣ
	//���ݲ���ΪUser_ID
	//����User_ID�ҵ�Seeker_Info��ȫ����Ϣ��
	public Seeker_Info queryByUserId(int info_id){
		Seeker_Info seeker_info = null;
		Iterator iterator = null;
		List l = (List)this.hibernateTemplate.find("FROM Seeker_Info as seeker_info WHERE seeker_info.info_id=?",new Integer(info_id));
		iterator = l.iterator();
		if(iterator.hasNext())
		{
			seeker_info = (Seeker_Info)iterator.next();
		}
		return seeker_info;
	}
	
	public boolean deleteEmail(String email){
		Seeker_Info seeker_info = null;
         List<Seeker_Info> seeker = this.queryByEmail(email);
         Iterator iter = null;
         iter = seeker.iterator();
         if(iter.hasNext()){
        	 hibernateTemplate.delete((iter.next()));
         }
		return true;
	}
	public List queryByEmail(String email){
		Seeker_Info seeker_info = null;
		Iterator iterator = null;
		List l = (List)this.hibernateTemplate.find("FROM Seeker_Info as seeker_info WHERE seeker_info.email=?",new String(email));
		return l;
	}

	/*

	//����User_IDΪ������ɾ���û���Ϣ��
	public void deleteByUserId(int user_id){
		
		session = this.getSession();
		String hql = "DELETE Seeker_Info WHERE user_id=?";
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
		String hql = "DELETE Seeker_Info WHERE info_id=?";
		Query q = this.session.createQuery(hql);
		//�Ѳ�������
		q.setInteger(0,info_id);
		//ִ�и������
		q.executeUpdate();
		this.session.beginTransaction().commit();
		if(session.isOpen()){
			session.close();
		}
	}*/

}
