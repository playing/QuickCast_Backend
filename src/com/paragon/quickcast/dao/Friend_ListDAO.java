package com.paragon.quickcast.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Friend_List;

@Repository
public class Friend_ListDAO{
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	//�����û���ע����Ϣ��
	//��Friend_List��Ϊ���ݲ�����
	public boolean insert(Friend_List friend_list){
		
		hibernateTemplate.save(friend_list);
		return true;
		
	}
	
	
	public void update(Friend_List friend_list){
			
		hibernateTemplate.update(friend_list);
		
	}
	
	
	public List queryByPartnerId(int partner_id){
		
		String hql = "FROM Friend_List as friend_list WHERE friend_list.partner_id=?";
		List l = hibernateTemplate.find(hql, partner_id);
		return l;
		
	}
	
	
	public List queryBySelfId(int self_id){
			
		String hql = "FROM Friend_List as friend_list WHERE friend_list.self_id=?";
		List l = hibernateTemplate.find(hql, self_id);
		return l;
			
	}
	
		
	public Friend_List queryByRltsId(int rlts_id){
			
		return hibernateTemplate.get(Friend_List.class, rlts_id);
			
	}
		

	public void delete(Friend_List friend_list){
			
		hibernateTemplate.delete(friend_list);
			
	}
		
	public void deleteByRltsId(int rlts_id){
			
		hibernateTemplate.delete(hibernateTemplate.get(Friend_List.class, rlts_id));
			
	}
		
	public void deleteByPartnerId(int partner_id){
			
		String hql = "FROM Friend_List WHERE partner_id=?";
		List l = hibernateTemplate.find(hql, partner_id);
		hibernateTemplate.deleteAll(l);
			
	}
		
	public void deleteBySelfId(int self_id){
			
		String hql = "FROM Friend_List WHERE self_id=?";
		List l = hibernateTemplate.find(hql, self_id);
		hibernateTemplate.deleteAll(l);
	}
		
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
