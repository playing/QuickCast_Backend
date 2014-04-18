package com.paragon.quickcast.dao;


import java.util.List;

import javax.annotation.Resource;


import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Etp_Info;
import com.paragon.quickcast.entity.Hunter_Info;

@Repository
public class Etp_InfoDAO{

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public boolean insert(Etp_Info etp_info){
		hibernateTemplate.save(etp_info);
		return true;
	}
	
	public boolean update(Etp_Info etp_info){
		hibernateTemplate.update(etp_info);
		return true;
	}
	
	public boolean delete(Etp_Info etp_info){
		hibernateTemplate.delete(etp_info);
    	return true;
	}
	
	public Etp_Info queryByEtpInfoId(int info_id){
		return hibernateTemplate.get(Etp_Info.class, info_id);
 	}
	
	public Etp_Info queryByEtpUserId(int user_id){
		
		String hql = "FROM Etp_Info as etp_info WHERE etp_info.user_id=?";		
 		List l = hibernateTemplate.find(hql, user_id);
 		return (Etp_Info)l.get(0);
	}
	
	public void deleteByUserId(int user_id){
		
		String hql = "FROM Etp_Info as etp_info WHERE etp_info.user_id=?";		
 		List l = hibernateTemplate.find(hql, user_id);
 		hibernateTemplate.deleteAll(l);
	}
	
	public void deleteByInfoId(int info_id){
		
		hibernateTemplate.delete(hibernateTemplate.get(Etp_Info.class, info_id));
	}
}

