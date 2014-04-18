package com.paragon.quickcast.dao;


import java.util.List;

import com.paragon.quickcast.entity.*;

import javax.annotation.Resource;

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
     
     public boolean delete(Hunter_Info hunter_info){
    	 hibernateTemplate.delete(hunter_info);
    	 return true;
     }
     
     public Hunter_Info queryByHunterInfoId(int info_id){
    	 return hibernateTemplate.get(Hunter_Info.class, info_id);
 	}
     
     public Hunter_Info queryByHunterUserId(int user_id){
 		
    	String hql = "FROM Hunter_Info as hunter_info WHERE hunter_info.user_id=?";		
 		List l = hibernateTemplate.find(hql, user_id);
 		return (Hunter_Info)l.get(0);
 	}
 	
 	public void deleteByUserId(int user_id){
 		
 		String hql = "FROM Hunter_Info as hunter_info WHERE hunter_info.user_id=?";		
 		List l = hibernateTemplate.find(hql, user_id);
 		hibernateTemplate.deleteAll(l);
 	}
 	
 	public void deleteByInfoId(int info_id){
 		
 		hibernateTemplate.delete(hibernateTemplate.get(Hunter_Info.class, info_id));
 	}
}

