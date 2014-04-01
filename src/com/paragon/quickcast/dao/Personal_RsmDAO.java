package com.paragon.quickcast.dao;

import javax.annotation.Resource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Personal_Rsm;


@Repository
public class Personal_RsmDAO{
	// property constants
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	//�����µĸ��˼�����
	//��Personal_Rsm��Ϊ���ݲ�����
	public boolean insert(Personal_Rsm personal_rsm){
		
		//�ж��û���Ϣ�Ƿ����
	       hibernateTemplate.save(personal_rsm);
		   return true;
		   
		}
	
	//�������ݿ����
	//��Personal_Rsm��Ϊ���ݲ���
	public void update(Personal_Rsm personal_rsm){
		
		hibernateTemplate.update(personal_rsm);
		
				
	}
	
	//���Ҹ��˼���
	//���ݲ���ΪUser_ID
	//����User_ID�ҵ�Personal_Rsm��ȫ����Ϣ��
	public Personal_Rsm queryByUserId(int user_id){
		
		return hibernateTemplate.get(Personal_Rsm.class, user_id);
		
	}
	
	
	//����rsm_id��ѯ�û���Ϣ
	public Personal_Rsm queryByRsmId(int rsm_id){
		
		return hibernateTemplate.get(Personal_Rsm.class, rsm_id);	
		
	}
	
	//ɾ���û���Ϣ�����Ǵ������Ĳ�����Personal_Rsm�࣬һ��ʹ������ĸ���User_IDִ��ɾ����
	public void delete(Personal_Rsm personal_rsm){
		
		hibernateTemplate.delete(personal_rsm);
	}
	
	//����user_idΪ������ɾ�����˼�����
	public void deleteByUserId(int user_id){
		
		hibernateTemplate.delete(hibernateTemplate.get(Personal_Rsm.class, user_id));

	}
	
	//����rsm_idΪ������ɾ�����˼�����
	public void deleteByRsmId(int rsm_id){
		
		hibernateTemplate.delete(hibernateTemplate.get(Personal_Rsm.class, rsm_id));
		
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
