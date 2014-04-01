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
	
	//插入新的个人简历；
	//以Personal_Rsm类为传递参数；
	public boolean insert(Personal_Rsm personal_rsm){
		
		//判断用户信息是否存在
	       hibernateTemplate.save(personal_rsm);
		   return true;
		   
		}
	
	//更新数据库操作
	//以Personal_Rsm类为传递参数
	public void update(Personal_Rsm personal_rsm){
		
		hibernateTemplate.update(personal_rsm);
		
				
	}
	
	//查找个人简历
	//传递参数为User_ID
	//根据User_ID找到Personal_Rsm的全部信息；
	public Personal_Rsm queryByUserId(int user_id){
		
		return hibernateTemplate.get(Personal_Rsm.class, user_id);
		
	}
	
	
	//根据rsm_id查询用户信息
	public Personal_Rsm queryByRsmId(int rsm_id){
		
		return hibernateTemplate.get(Personal_Rsm.class, rsm_id);	
		
	}
	
	//删除用户信息，但是传进来的参数是Personal_Rsm类，一般使用下面的根据User_ID执行删除；
	public void delete(Personal_Rsm personal_rsm){
		
		hibernateTemplate.delete(personal_rsm);
	}
	
	//根据user_id为参数，删除个人简历；
	public void deleteByUserId(int user_id){
		
		hibernateTemplate.delete(hibernateTemplate.get(Personal_Rsm.class, user_id));

	}
	
	//根据rsm_id为参数，删除个人简历；
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
