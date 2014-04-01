package com.paragon.quickcast.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.paragon.quickcast.dao.Hunter_InfoDAO;
import com.paragon.quickcast.dao.Seeker_InfoDAO;
import com.paragon.quickcast.dao.User_RegDAO;
import com.paragon.quickcast.entity.Hunter_Info;
import com.paragon.quickcast.entity.Seeker_Info;
import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.service.InformationService;

@Component
public class InformationServiceImpl implements InformationService {
	@Resource
	private Seeker_InfoDAO seeker_infodao; 
	private Hunter_InfoDAO hunter_infodao;
	public boolean insert(Seeker_Info seeker_info){
		//System.out.println("UserServiceImpl.add()");
		seeker_infodao.insert(seeker_info);
		return true;
	}
	
	//继承删除方法
	public boolean delete(int info_id){
		seeker_infodao.delete(info_id);
		return true;
	}
	
	//对猎头的操作
	public boolean insert1(Hunter_Info hunter_info){
		hunter_infodao.insert(hunter_info);
		return true;
	}
	public Seeker_InfoDAO getSeeker_infodao() {
		return seeker_infodao;
	}
	public void setSeeker_infodao(Seeker_InfoDAO seeker_infodao) {
		this.seeker_infodao = seeker_infodao;
	}
	

}
