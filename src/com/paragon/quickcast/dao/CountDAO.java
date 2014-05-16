package com.paragon.quickcast.dao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Count_Rsmhandle;
import com.paragon.quickcast.entity.Count_User;
import com.paragon.quickcast.entity.Count_WorkPlace;
import com.paragon.quickcast.entity.Etp_Info;
import com.paragon.quickcast.entity.Hunter_Info;
import com.paragon.quickcast.entity.Seeker_Info;


@Repository
public class CountDAO {
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	
	public Count_User queryBycountUserId(int id){
		
		return hibernateTemplate.get(Count_User.class, id);
		
	}
	
	//ͳ�Ƽ�������
	public Count_Rsmhandle queryByCountRsmhandleEtpId(int etp_id){
		Count_Rsmhandle count_rsmhandle = null;
		String hql = "FROM Count_Rsmhandle as count_rsmhandle WHERE count_rsmhandle.etp_id=?";
		List l = hibernateTemplate.find(hql,etp_id);
		Iterator iter = l.iterator();
		if(iter.hasNext()){
			count_rsmhandle = (Count_Rsmhandle)iter.next();	
		}	
		return count_rsmhandle;
	}
	
	public Count_WorkPlace queryByCountWorkPlaceId(int id){
		
		return hibernateTemplate.get(Count_WorkPlace.class, id);
		
	}
	
	
	public List queryByHunterGender(String gender){
		Hunter_Info info = null;
		String hql = "FROM Hunter_Info as hunter_info WHERE hunter_info.gender=?";
		List l = hibernateTemplate.find(hql,gender);
		return l;
	} 
	
	public List queryByEtpGender(String gender){
		Etp_Info info = null;
		String hql = "FROM Etp_Info as etp_info WHERE etp_info.gender=?";
		List l = hibernateTemplate.find(hql,gender);
		return l;
	} 
	
	public List queryBySeekerGender(String gender){
		Seeker_Info info = null;
		String hql = "FROM Seeker_Info as seeker_info WHERE seeker_info.gender=?";
		List l = hibernateTemplate.find(hql,gender);
		return l;
	} 
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}
