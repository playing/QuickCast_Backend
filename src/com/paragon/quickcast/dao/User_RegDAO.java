package com.paragon.quickcast.dao;


import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.form.User;


@Component
public class User_RegDAO{
	// property constants
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	/*public void add(User u){
		System.out.println("UserDao.add()");
		hibernateTemplate.save(u);
	}*/

	//�����û���ע����Ϣ��
	//��User_Reg��Ϊ���ݲ�����
	public boolean insert(User_Reg user_reg){

		//�ж��û����Ƿ����
	//	User_RegDAO user_regdao = new User_RegDAO();
			hibernateTemplate.save(user_reg);
			return true;
		}
	
	
	//�������ݿ����
	//��User_Reg��Ϊ���ݲ���
	public void update(User_Reg user_reg){
			//����hibernateTemplate�Դ���update������
			hibernateTemplate.update(user_reg);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
