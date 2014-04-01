package com.paragon.quickcast.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.dao.Personal_RsmDAO;
import com.paragon.quickcast.entity.Personal_Rsm;
import com.paragon.quickcast.service.ResumeService;

@Service
public class Personal_RsmServiceImpl implements ResumeService{
	
	@Resource
	Personal_RsmDAO personal_rsmdao = new Personal_RsmDAO();
	
	
	public boolean insert(Personal_Rsm personal_rsm){
		
		personal_rsmdao.insert(personal_rsm);
		return true;
		
	}
	
	public void update(Personal_Rsm personal_rsm){
		
		personal_rsmdao.update(personal_rsm);
	}


	public Personal_RsmDAO getPersonal_rsmdao() {
		return personal_rsmdao;
	}


	public void setPersonal_rsmdao(Personal_RsmDAO personal_rsmdao) {
		this.personal_rsmdao = personal_rsmdao;
	}
	



}